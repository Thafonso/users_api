package com.thafonso.user_api.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfCostrainValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfValid {

    String message() default "Invalid CPF Format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
