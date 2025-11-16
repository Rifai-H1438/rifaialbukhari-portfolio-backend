package com.rifai_portfolio.respositories;

import com.rifai_portfolio.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    }

