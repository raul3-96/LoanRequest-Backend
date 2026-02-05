package com.caixa.tech.loan.controller;

import com.caixa.tech.loan.dto.CreateLoanRequestDTO;
import com.caixa.tech.loan.model.LoanRequest;
import com.caixa.tech.loan.model.StateLoanRequestEnum;
import com.caixa.tech.loan.service.LoanRequestService;
import com.caixa.tech.loan.utils.ValidatorsGeneric;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    @Autowired
    LoanRequestService loanRequestService;

    @PostMapping
    public LoanRequest createLoanRequest(@Valid @RequestBody CreateLoanRequestDTO dto) {
        ValidatorsGeneric.validateName(dto.getName());
        return loanRequestService.createLoanRequest(dto);
    }

    @GetMapping
    public List<LoanRequest> getLoanRequestByIdentification(@RequestParam String identification) {
        ValidatorsGeneric.validateIdentification(identification);
        return loanRequestService.getLoanRequestsByName(identification);
    }

    @GetMapping("/{oid}")
    public LoanRequest getLoanRequestByOid(@PathVariable Long oid) {
        return loanRequestService.getLoanRequestByOid(oid);
    }

    @PutMapping("/{oid}")
    public LoanRequest updateStateLoanRequest(@PathVariable Long oid, @RequestParam StateLoanRequestEnum state) {
        return loanRequestService.updateStateLoanRequest(oid, state);
    }
}
