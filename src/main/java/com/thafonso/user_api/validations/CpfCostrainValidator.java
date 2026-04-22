package com.thafonso.user_api.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfCostrainValidator implements ConstraintValidator<CpfValid, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        return CpfValidator.isValid(cpf);
    }

}
