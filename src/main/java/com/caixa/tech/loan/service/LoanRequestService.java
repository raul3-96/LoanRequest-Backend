package com.caixa.tech.loan.service;

import com.caixa.tech.loan.LoanRequestMapper;
import com.caixa.tech.loan.dto.CreateLoanRequestDTO;
import com.caixa.tech.loan.model.LoanRequest;
import com.caixa.tech.loan.model.StateLoanRequestEnum;
import com.caixa.tech.loan.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Service
public class LoanRequestService {

    @Autowired
    LoanRequestRepository loanRequestRepository;

    public List<LoanRequest> getAllRequests() {
        return loanRequestRepository.findAll();
    }

    public LoanRequest getLoanRequestByOid(Long oid) {
        return filterLoanRequestByPredicate(req -> req.getOid().equals(oid)).stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Request with oid was not found:" + oid));

    }

    public List<LoanRequest> getLoanRequestsByName(String identification) {
        return filterLoanRequestByPredicate(req -> req.getIdentification().equals(identification));
    }

    public LoanRequest createLoanRequest(CreateLoanRequestDTO dto) {
        long lastId = getAllRequests().stream()
                .mapToLong(LoanRequest::getOid)
                .max()
                .orElse(0);
        LoanRequest loanRequest = LoanRequestMapper.toEntity(dto, lastId + 1);
        return loanRequestRepository.save(loanRequest);
    }

    public LoanRequest updateStateLoanRequest(Long oid, StateLoanRequestEnum newState) {
        LoanRequest loanRequest = getLoanRequestByOid(oid);
        StateLoanRequestEnum current = loanRequest.getState();

        // Allowed transitions: PENDING -> APPROVED | REJECTED or APPROVED -> CANCELLED
        if (current == StateLoanRequestEnum.PENDING &&
                (newState == StateLoanRequestEnum.APPROVED || newState == StateLoanRequestEnum.REJECTED))
            loanRequest.setState(newState);
        else if (current == StateLoanRequestEnum.APPROVED && newState == StateLoanRequestEnum.CANCELLED)
            loanRequest.setState(newState);
        else
            throw new IllegalStateException(
                    "Invalid state transition: " + current + " -> " + newState
            );

        loanRequestRepository.save(loanRequest);
        return loanRequest;
    }


    private List<LoanRequest> filterLoanRequestByPredicate (Predicate<LoanRequest> predicate){
        return this.getAllRequests()
                .stream()
                .filter(predicate)
                .toList();
    }
}
