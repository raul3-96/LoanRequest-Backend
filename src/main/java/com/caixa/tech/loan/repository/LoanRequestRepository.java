package com.caixa.tech.loan.repository;

import com.caixa.tech.loan.model.LoanRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Repository
public class LoanRequestRepository {

    private final List<LoanRequest> loanRequests;

    public LoanRequestRepository(@Value("${mock.path}") Resource json) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = json.getInputStream()) {
            this.loanRequests = mapper.readValue(inputStream, new TypeReference<List<LoanRequest>>() {});
        } catch (IOException e) {
            throw new IllegalStateException("Cannot load data from JSON mock.", e);
        }
    }

    public List<LoanRequest> findAll() {
        return List.copyOf(loanRequests);
    }

    public LoanRequest save(LoanRequest loanRequest) {
        ListIterator<LoanRequest> iterator = loanRequests.listIterator();

        while (iterator.hasNext()) {
            LoanRequest existing = iterator.next();
            if (existing.getOid().equals(loanRequest.getOid())) {
                iterator.set(loanRequest);
                return loanRequest;
            }
        }

        loanRequests.add(loanRequest);
        return loanRequest;
    }
}
