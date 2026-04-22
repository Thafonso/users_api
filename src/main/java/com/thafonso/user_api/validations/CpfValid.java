package com.thafonso.user_api.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CPFValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfValid {

    String message() default "Invalid CPF Format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
