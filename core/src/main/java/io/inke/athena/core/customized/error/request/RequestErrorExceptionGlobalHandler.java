package io.inke.athena.core.customized.error.request;

import io.inke.athena.core.customized.error.ErrorExceptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * handler request error exception
 */
@ControllerAdvice
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

}
