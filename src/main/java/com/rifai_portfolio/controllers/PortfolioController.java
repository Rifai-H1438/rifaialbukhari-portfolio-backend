package com.rifai_portfolio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rifai_portfolio.models.Portfolio;
import com.rifai_portfolio.dto.PortfolioDTO;
import com.rifai_portfolio.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "*")
public class PortfolioController {

    private final PortfolioService portfolioService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // ✅ Get portfolio (return parsed JSON as DTO)
    @GetMapping(produces = "application/json")
    public PortfolioDTO getPortfolio() {
        try {
            Portfolio portfolio = portfolioService.getPortfolio();
            if (portfolio == null || portfolio.getData() == null) {
                return null;
            }
            return objectMapper.readValue(portfolio.getData(), PortfolioDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ Save or update portfolio (accept JSON DTO and save as string)
    @PostMapping
    public Portfolio saveOrUpdatePortfolio(@RequestBody PortfolioDTO portfolioDTO) {
        try {
            String json = objectMapper.writeValueAsString(portfolioDTO);
            Portfolio portfolio = new Portfolio();
            portfolio.setData(json);
            return portfolioService.saveOrUpdatePortfolio(portfolio);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
