package com.budgetflow.demo.Entity;

import com.budgetflow.demo.Entity.enums.InvestmentType;
import com.budgetflow.demo.Entity.enums.ReccurenceFrequency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "investments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvestmentType investmentType;

    @Column(name = "initial_amount", nullable = false)
    private BigDecimal initialAmount;

    @Column(name = "current_value", nullable = false)
    private BigDecimal currentValue;

    @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
