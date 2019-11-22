package io.inke.athena.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionCommon {

    private final static String ERROR_NAME = "athena.error";

    /**
     * get error info from DefaultErrorAttributes
     *
     * @param request client request
     * @return throwable info
     * @see Throwable
     */
    public static Throwable getError(HttpServletRequest request) {
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
    public static HttpStatus getHttpStatus(HttpServletRequest request) {
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
    public static String getStackTraceInfo(Throwable error, boolean flag) {
        if (flag) {
            return "omitted";
        }
        StringWriter stackTrace = new StringWriter();
        error.printStackTrace(new PrintWriter(stackTrace));
        stackTrace.flush();
        return stackTrace.toString();
    }

}
