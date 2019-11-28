package io.inke.athena.core.customized.error.request;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.core.customized.error.ErrorExceptionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * handler request error exception
 */
@ControllerAdvice
@Slf4j
public class RequestErrorExceptionGlobalHandler {

    @Autowired
    private RequestErrorExceptionBuilder errorInfoBuilder;

    /**
     * handler exception
     *
     * @param request client request info
     * @param error   request exception information
     * @return alert json
     * @see ErrorExceptionInfo
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Throwable error) {
        // only support rest api
        return errorInfoBuilder.getErrorInfo(request, error);
    }

    /**
     * Check the exception handling method for method parameters
     *
     * @param exception MethodArgumentNotValidException
     * @return alert json
     * @see ErrorExceptionInfo
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handlerNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        log.debug("begin resolve argument exception");
        BindingResult result = exception.getBindingResult();
        Map<String, Object> maps;
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            maps = new HashMap<>(fieldErrors.size());
            fieldErrors.forEach(error -> maps.put(error.getField(), error.getDefaultMessage()));
        } else {
            maps = Collections.EMPTY_MAP;
        }
        ErrorExceptionInfo errorExceptionInfo = new ErrorExceptionInfo();
        errorExceptionInfo.setErrorTime(LocalDateTime.now().toString());
        errorExceptionInfo.setErrorUrl(request.getRequestURL().toString());
        errorExceptionInfo.setErrorType(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorExceptionInfo.setErrorStatusCode(HttpStatus.BAD_REQUEST.value());
        errorExceptionInfo.setErrorReasonPhrase(maps);
        errorExceptionInfo.setRemoteClient(request.getRemoteAddr());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseCommon.error(errorExceptionInfo));
    }

    /**
     * Check the exception handling method for method parameters
     *
     * @param exception MethodArgumentNotValidException
     * @return alert json
     * @see ErrorExceptionInfo
     */
    @ExceptionHandler(BadCredentialsException.class)
    public Object handlerBadCredentialsException(BadCredentialsException exception, HttpServletRequest request) {
        log.debug("begin resolve argument exception");
        ErrorExceptionInfo errorExceptionInfo = new ErrorExceptionInfo();
        errorExceptionInfo.setErrorTime(LocalDateTime.now().toString());
        errorExceptionInfo.setErrorUrl(request.getRequestURL().toString());
        errorExceptionInfo.setErrorType(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorExceptionInfo.setErrorStatusCode(HttpStatus.NOT_FOUND.value());
        errorExceptionInfo.setErrorReasonPhrase(exception.getLocalizedMessage());
        errorExceptionInfo.setRemoteClient(request.getRemoteAddr());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseCommon.error(errorExceptionInfo));
    }

}
