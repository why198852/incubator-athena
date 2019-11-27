package io.inke.athena.core.validate.user;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.model.UserModel;
import io.inke.athena.support.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameExistsValidator implements ConstraintValidator<UserNameExistsValidate, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UserNameExistsValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String source, ConstraintValidatorContext constraintValidatorContext) {
        ResponseCommon<UserModel> model = this.userService.getByUserName(source);
        return ObjectUtils.isEmpty(model.getDetail()) ? Boolean.TRUE : Boolean.FALSE;
    }

}
