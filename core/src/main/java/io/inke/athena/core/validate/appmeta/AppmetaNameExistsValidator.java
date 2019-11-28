package io.inke.athena.core.validate.appmeta;

import io.inke.athena.common.response.ResponseCommon;
import io.inke.athena.support.model.AppmetaModel;
import io.inke.athena.support.service.AppmetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AppmetaNameExistsValidator implements ConstraintValidator<AppmetaNameExistsValidate, String> {

    @Autowired
    private AppmetaService appmetaService;

    @Override
    public void initialize(AppmetaNameExistsValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String source, ConstraintValidatorContext constraintValidatorContext) {
        ResponseCommon<AppmetaModel> model = this.appmetaService.getByName(source);
        return ObjectUtils.isEmpty(model.getDetail()) ? Boolean.TRUE : Boolean.FALSE;
    }

}
