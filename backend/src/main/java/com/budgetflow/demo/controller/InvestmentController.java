package com.budgetflow.demo.controller;

import com.budgetflow.demo.Entity.Investment;
import com.budgetflow.demo.repository.InvestmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    private final InvestmentRepository investmentRepository;

    public InvestmentController(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @GetMapping
    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Investment> getInvestmentsByUser(@PathVariable Long userId) {
        return investmentRepository.findByUserId(userId);
    }

    @PostMapping
    public Investment createInvestment(@RequestBody Investment investment) {
        return investmentRepository.save(investment);
    }

    @DeleteMapping("/{id}")
    public void deleteInvestment(@PathVariable Long id) {
        investmentRepository.deleteById(id);
    }
}