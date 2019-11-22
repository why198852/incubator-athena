package io.inke.athena.core.customized.error.request;

import io.inke.athena.common.exception.ExceptionCommon;
import io.inke.athena.core.customized.error.ErrorExceptionInfo;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class RequestErrorExceptionBuilder implements HandlerExceptionResolver, Ordered {

    // spring default error configuration
    private ErrorProperties errorProperties;

    public RequestErrorExceptionBuilder(ServerProperties serverProperties) {
        this.errorProperties = serverProperties.getError();
    }

    /**
     * build error info
     */
    public ErrorExceptionInfo getErrorInfo(HttpServletRequest request) {
        return getErrorInfo(request, ExceptionCommon.getError(request));
    }

    /**
     * build error info
     */
    public ErrorExceptionInfo getErrorInfo(HttpServletRequest request, Throwable error) {
        ErrorExceptionInfo errorExceptionInfo = new ErrorExceptionInfo();
        errorExceptionInfo.setErrorTime(LocalDateTime.now().toString());
        errorExceptionInfo.setErrorUrl(request.getRequestURL().toString());
        errorExceptionInfo.setErrorType(ExceptionCommon.getHttpStatus(request).getReasonPhrase());
        errorExceptionInfo.setErrorStatusCode(ExceptionCommon.getHttpStatus(request).value());
        errorExceptionInfo.setErrorReasonPhrase(error.toString());
        errorExceptionInfo.setErrorStackTrace(ExceptionCommon.getStackTraceInfo(error, isIncludeStackTrace(request)));
        errorExceptionInfo.setRemoteClient(request.getRemoteAddr());
        return errorExceptionInfo;
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
