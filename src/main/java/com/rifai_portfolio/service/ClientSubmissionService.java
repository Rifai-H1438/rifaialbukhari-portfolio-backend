package com.rifai_portfolio.service;

import com.rifai_portfolio.models.ClientSubmission;
import com.rifai_portfolio.respositories.ClientSubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientSubmissionService {

    private final ClientSubmissionRepository repository;

    public ClientSubmissionService(ClientSubmissionRepository repository) {
        this.repository = repository;
    }

    public ClientSubmission saveSubmission(ClientSubmission submission) {
        return repository.save(submission);
    }

    public List<ClientSubmission> getAllSubmissions() {
        return repository.findAll();
    }
}
