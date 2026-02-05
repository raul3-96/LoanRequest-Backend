package com.caixa.tech.loan;

import com.caixa.tech.loan.dto.CreateLoanRequestDTO;
import com.caixa.tech.loan.model.LoanRequest;
import com.caixa.tech.loan.model.StateRequestEnum;

import java.util.Date;

public class RequestMapper {
    public static LoanRequest toEntity(CreateLoanRequestDTO dto, Long oid) {
        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setOid(oid);
        loanRequest.setName(dto.getName());
        loanRequest.setAmount(dto.getAmount());
        loanRequest.setCurrency(dto.getCurrency());
        loanRequest.setIdentification(dto.getIdentification());
        loanRequest.setEntryDate(new Date());
        loanRequest.setState(StateRequestEnum.PENDING);
        return loanRequest;
    }
}
