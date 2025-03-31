package com.example.services;

import com.example.dto.ExpenseDTO;
import com.example.dto.ExpenseTransactionDTO;
import com.example.strategies.settleup.SettleUpStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SettleUpService {

    private SettleUpStrategy settleUpStrategy;

    private ExpenseService expenseService;

    public List<ExpenseTransactionDTO> settleUpGroup(long groupId) throws Exception {

        // get all expenses of the group.
        List<ExpenseDTO> expenseDTOS = expenseService.getExpensesByGroup(groupId);

        // trigger settle up algorithm
        return settleUpStrategy.settleUp(expenseDTOS);
    }

    public List<ExpenseTransactionDTO> settleUpUser(long userId) throws Exception {
        return null;
    }

}
