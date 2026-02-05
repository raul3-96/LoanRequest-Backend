package com.caixa.tech.loan.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoanRequest {

    private Long oid;
    private String name;
    private Double amount;
    private CurrencyEnum currency;
    private String identification;
    private Date entryDate;
    private StateLoanRequestEnum state = StateLoanRequestEnum.PENDING;

}