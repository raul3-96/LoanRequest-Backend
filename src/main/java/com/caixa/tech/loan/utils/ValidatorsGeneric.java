package com.caixa.tech.loan.utils;

import com.caixa.tech.loan.validators.IdentificationValidator;
import jakarta.validation.ValidationException;

public class ValidatorsGeneric {

    private static final String regexName = "^[\\p{L} .'-]+$";

    public static void validateName(String name) throws ValidationException {
        if(name == null || name.isBlank())
            throw new ValidationException("Name is required.");
        if(!name.matches(regexName))
            throw new ValidationException("Name format is invalid.");
    }

    private static final IdentificationValidator identificationValidator = new IdentificationValidator();

    public static void validateIdentification(String id) {
        if (!identificationValidator.isValid(id, null)) {
            throw new ValidationException("Identification format is invalid.");
        }
    }
}
