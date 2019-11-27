package io.inke.athena.core.param;

import io.inke.athena.core.validate.user.UserNameExistsValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserParam {

    @NotEmpty(message = "user name must not null or empty")
    @UserNameExistsValidate(message = "user name exists, please try other")
    private String userName;

    @NotEmpty(message = "user password must not null or empty")
    private String password;

    @NotEmpty(message = "user confirm password must not null or empty")
    private String rePassword;

}
