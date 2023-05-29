package phamhieuliem.lab3.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.Valid;
import phamhieuliem.lab3.validator.ValidCategoryIdValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidCategoryIdValidator.class)
@Documented
public @interface ValidCategoryId {
    String message() default "Invalid Category Id";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload() default {};
}
