package com.rifai_portfolio.service;


import com.rifai_portfolio.models.Portfolio;
import com.rifai_portfolio.respositories.PortfolioRepository;
import org.springframework.stereotype.Service;


import java.util.List;

    @Service
    public class PortfolioService {
        private final PortfolioRepository portfolioRepository;

        public PortfolioService(PortfolioRepository portfolioRepository) {
            this.portfolioRepository = portfolioRepository;
        }

        // Get the first portfolio record
        public Portfolio getPortfolio() {
            List<Portfolio> list = portfolioRepository.findAll();
            if (list.isEmpty()) return null;
            return list.get(0);  // always return the first (and only) record
        }

        // Save or update
        public Portfolio saveOrUpdatePortfolio(Portfolio portfolio) {
            Portfolio existing = getPortfolio();  // check if record exists
            if (existing != null) {
                // Update the existing record instead of creating new
                portfolio.setId(existing.getId());
            }
            return portfolioRepository.save(portfolio);
        }
    }

