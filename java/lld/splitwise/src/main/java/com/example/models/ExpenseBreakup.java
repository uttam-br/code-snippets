package com.example.models;

import com.example.models.constants.ExpenseTransactionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "expense_breakups")
public class ExpenseBreakup extends BaseEntity {

    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Expense expense;

    @Enumerated(value = EnumType.ORDINAL)
    private ExpenseTransactionType type;

}
