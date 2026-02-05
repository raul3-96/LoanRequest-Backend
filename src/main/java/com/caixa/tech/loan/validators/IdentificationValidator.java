package com.caixa.tech.loan.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificationValidator implements ConstraintValidator<ValidIdentification,String> {

    private static final String regexDNI ="^[0-9]{8}[A-Z]$";

    private static final String regexNIE ="^[XYZ][0-9]{7}[A-Z]$";

    @Override
    public boolean isValid(String v, ConstraintValidatorContext constraintValidatorContext) {
        //Format DNI or NIE
        return v.matches(regexDNI) || v.matches(regexNIE);
    }
}
