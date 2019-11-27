package io.inke.athena.core.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserParam {

    private String userName;
    private String password;
    private String rePassword;

}
