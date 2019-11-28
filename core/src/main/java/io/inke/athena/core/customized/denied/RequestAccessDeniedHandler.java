package io.inke.athena.core.customized.denied;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.core.customized.error.ErrorExceptionInfo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class RequestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(403);
        ErrorExceptionInfo errorExceptionInfo = new ErrorExceptionInfo();
        errorExceptionInfo.setErrorTime(LocalDateTime.now().toString());
        errorExceptionInfo.setErrorUrl(request.getRequestURL().toString());
        errorExceptionInfo.setErrorType(request.getAuthType());
        errorExceptionInfo.setErrorStatusCode(403);
        errorExceptionInfo.setErrorReasonPhrase("Access denied");
        errorExceptionInfo.setErrorStackTrace(accessDeniedException.toString());
        errorExceptionInfo.setRemoteClient(request.getRemoteAddr());
        response.getWriter().write(new ObjectMapper().writeValueAsString(ResponseCommon.error(errorExceptionInfo)));
    }
    
}
