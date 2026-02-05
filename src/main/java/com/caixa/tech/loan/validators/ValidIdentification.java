package com.caixa.tech.loan.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IdentificationValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIdentification {
    String message() default "Invalid identification format.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
