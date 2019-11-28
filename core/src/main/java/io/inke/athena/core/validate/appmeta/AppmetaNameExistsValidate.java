package io.inke.athena.core.validate.appmeta;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AppmetaNameExistsValidator.class)
public @interface AppmetaNameExistsValidate {

    String message() default "appmeta name exists, please try other";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
