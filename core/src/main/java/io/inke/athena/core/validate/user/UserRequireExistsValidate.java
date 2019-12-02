package io.inke.athena.core.validate.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserRequireExistsValidator.class)
public @interface UserRequireExistsValidate {

    String message() default "not found this user";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
