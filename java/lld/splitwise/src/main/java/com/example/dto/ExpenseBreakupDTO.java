package com.example.dto;

import com.example.models.ExpenseBreakup;
import com.example.models.constants.ExpenseTransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExpenseBreakupDTO {

    private double amount;
    private long userId;
    private ExpenseTransactionType expenseTransactionType;

    public ExpenseBreakupDTO(ExpenseBreakup expenseBreakup) {
        this.amount = expenseBreakup.getAmount();
        this.userId = expenseBreakup.getUser().getId();
        expenseTransactionType = expenseBreakup.getType();
    }
}
