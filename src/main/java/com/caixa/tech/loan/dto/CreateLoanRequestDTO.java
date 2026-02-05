package com.caixa.tech.loan.dto;

import com.caixa.tech.loan.model.CurrencyEnum;
import com.caixa.tech.loan.validators.ValidIdentification;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class CreateLoanRequestDTO {

    @NotBlank(message = "Name is required.")
    private String name;

    @NotNull(message = "Amount is required")
    @Positive
    private Double amount;

    @NotNull(message = "Currency is required.")
    private CurrencyEnum currency;

    @NotBlank(message = "Identification is required.")
    @ValidIdentification
    private String identification;
}
