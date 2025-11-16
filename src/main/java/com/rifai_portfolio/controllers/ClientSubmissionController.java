package com.rifai_portfolio.controllers;

import com.rifai_portfolio.models.ClientSubmission;
import com.rifai_portfolio.respositories.ClientSubmissionRepository;
import com.rifai_portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client-submissions")
@CrossOrigin(origins = "*")
public class ClientSubmissionController {

    @Autowired
    private ClientSubmissionRepository repository;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ClientSubmission submitClient(@RequestBody ClientSubmission submission) {
        // Save in DB
        ClientSubmission saved = repository.save(submission);

        // Send email notification
        emailService.sendClientSubmissionMail(
                "rifaibukharilpt31@gmail.com", // Replace with your email
                submission.getName(),
                submission.getEmail(),
                submission.getDescription()
        );

        return saved;
    }

    @GetMapping(produces = "application/json")
    public Iterable<ClientSubmission> getAll() {
        return repository.findAll();
    }
}
