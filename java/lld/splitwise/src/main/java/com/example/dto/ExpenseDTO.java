package com.example.dto;

import com.example.models.Expense;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ExpenseDTO {
    private long createdBy;
    private long groupId;
    private String description;
    private double amount;
    private List<ExpenseBreakupDTO> expenseBreakups;

    public ExpenseDTO(Expense expense) {
        createdBy = expense.getCreatedBy().getId();
        groupId = expense.getGroup().getId();
        description = expense.getDescription();
        amount = expense.getTotalAmount();
        expenseBreakups = expense.getExpenseBreakups().stream().map(ExpenseBreakupDTO::new).toList();
    }
}
