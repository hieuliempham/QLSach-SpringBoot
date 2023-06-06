package phamhieuliem.lab3.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import phamhieuliem.lab3.validator.ValidUsernameValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)
public @interface ValidUsername {
    String message() default "Username already exists";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload() default {};
}
