package com.budgetflow.demo.Entity;

import com.budgetflow.demo.Entity.enums.BudgetGroup;
import com.budgetflow.demo.Entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BudgetGroup budgetGroup;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
