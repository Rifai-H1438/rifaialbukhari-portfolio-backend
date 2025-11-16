package com.rifai_portfolio.respositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<com.rifai_portfolio.models.CV, Long> {

}

