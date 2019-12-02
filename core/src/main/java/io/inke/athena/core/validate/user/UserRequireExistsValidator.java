package io.inke.athena.core.validate.user;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.model.UserModel;
import io.inke.athena.support.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserRequireExistsValidator implements ConstraintValidator<UserRequireExistsValidate, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UserRequireExistsValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String source, ConstraintValidatorContext constraintValidatorContext) {
        ResponseCommon<UserModel> model = this.userService.getById(Long.valueOf(source));
        if (ObjectUtils.isEmpty(model.getDetail())) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
