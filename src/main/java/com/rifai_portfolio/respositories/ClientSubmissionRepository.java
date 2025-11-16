package com.rifai_portfolio.respositories;


import com.rifai_portfolio.models.ClientSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSubmissionRepository extends JpaRepository<ClientSubmission, Long> {
}

