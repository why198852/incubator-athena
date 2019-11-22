package io.inke.athena.core.customized.error.request;

import io.inke.athena.core.customized.error.ErrorExceptionInfo;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class RequestErrorExceptionBuilder implements HandlerExceptionResolver, Ordered {

    private final static String ERROR_NAME = "athena.error";

    // spring default error configuration
    private ErrorProperties errorProperties;

    public RequestErrorExceptionBuilder(ServerProperties serverProperties) {
        this.errorProperties = serverProperties.getError();
    }

    /**
     * build error info
     */
    public ErrorExceptionInfo getErrorInfo(HttpServletRequest request) {
        return getErrorInfo(request, getError(request));
    }

    /**
     * build error info
     */
    public ErrorExceptionInfo getErrorInfo(HttpServletRequest request, Throwable error) {
        ErrorExceptionInfo errorExceptionInfo = new ErrorExceptionInfo();
        errorExceptionInfo.setErrorTime(LocalDateTime.now().toString());
        errorExceptionInfo.setErrorUrl(request.getRequestURL().toString());
        errorExceptionInfo.setErrorType(error.toString());
        errorExceptionInfo.setErrorStatusCode(getHttpStatus(request).value());
        errorExceptionInfo.setErrorReasonPhrase(getHttpStatus(request).getReasonPhrase());
        errorExceptionInfo.setErrorStackTrace(getStackTraceInfo(error, isIncludeStackTrace(request)));
        return errorExceptionInfo;
    }

    /**
     * get error info from DefaultErrorAttributes
     *
     * @param request client request
     * @return throwable info
     * @see Throwable
     */
    public Throwable getError(HttpServletRequest request) {
        Throwable error = (Throwable) request.getAttribute(ERROR_NAME);
        if (error == null) {
            error = (Throwable) request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
        }
        if (error != null) {
            while (error instanceof ServletException && error.getCause() != null) {
                error = error.getCause();
            }
        } else {
            String message = (String) request.getAttribute(WebUtils.ERROR_MESSAGE_ATTRIBUTE);
            if (StringUtils.isEmpty(message)) {
                HttpStatus status = getHttpStatus(request);
                message = "Unknown Exception But " + status.value() + " " + status.getReasonPhrase();
            }
            error = new Exception(message);
        }
        return error;
    }

    /**
     * get request status
     *
     * @param request client request
     * @return http status info
     * @see HttpStatus
     */
    public HttpStatus getHttpStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
        try {
            return statusCode != null ? HttpStatus.valueOf(statusCode) : HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * get client stack trace info
     *
     * @param error client error info
     * @param flag  error symbol, if equals True return omitted
     * @return
     */
    public String getStackTraceInfo(Throwable error, boolean flag) {
        if (flag) {
            return "omitted";
        }
        StringWriter stackTrace = new StringWriter();
        error.printStackTrace(new PrintWriter(stackTrace));
        stackTrace.flush();
        return stackTrace.toString();
    }

    /**
     * determine whether the stack trace is included.
     *
     * @param request client request info
     * @return status
     * @see org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController #isIncludeStackTrace
     */
    public boolean isIncludeStackTrace(HttpServletRequest request) {
        // server.error.include-stacktrace=NEVER
        ErrorProperties.IncludeStacktrace includeStacktrace = errorProperties.getIncludeStacktrace();
        switch (includeStacktrace) {
            case ALWAYS:
                return true;
            case ON_TRACE_PARAM:
                // request param has error exception
                String parameter = request.getParameter("trace");
                return parameter != null && !"false".equals(parameter.toLowerCase());
            default:
                return false;
        }
    }

    /**
     * Provides a priority or used for sorting
     */
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // don't do anything
        return null;
    }

}
