package io.inke.athena.core.customized.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorExceptionInfo {

    private String errorTime; // start time
    private String errorUrl; // request path
    private String errorType; // error type
    private String errorStackTrace; // error stack info
    private int errorStatusCode; // error code
    private String errorReasonPhrase; // error reason

}
