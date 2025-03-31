package com.example.strategies.settleup;

import com.example.dto.ExpenseBreakupDTO;
import com.example.dto.ExpenseDTO;
import com.example.dto.ExpenseTransactionDTO;
import com.example.models.Expense;
import com.example.models.constants.ExpenseTransactionType;
import jakarta.annotation.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LeastTransactionsSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<ExpenseTransactionDTO> settleUp(List<ExpenseDTO> expenses) {

        // figure out all users' net balance.

        Map<Long, Double> usersNetBalance = new HashMap<>();

        for (ExpenseDTO expenseDTO : expenses) {
            for (ExpenseBreakupDTO expenseBreakupDTO : expenseDTO.getExpenseBreakups()) {
                double amount = expenseBreakupDTO.getAmount();
                long userId = expenseBreakupDTO.getUserId();
                if (expenseBreakupDTO.getExpenseTransactionType() == ExpenseTransactionType.HAD_PAID) {
                    usersNetBalance.put(userId, usersNetBalance.getOrDefault(userId, 0d) + amount);
                } else {
                    usersNetBalance.put(userId, usersNetBalance.getOrDefault(userId, 0d) - amount);
                }
            }
        }

        // now we have user's net balance.
        // divide into two groups, one group that has paid and other that is owned.
        // settle highest with the least once.
        // guaranteeing to settle for at-least one at each settle.

        PriorityQueue<UserExpense> maxHeap = new PriorityQueue<>((o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount()));
        PriorityQueue<UserExpense> minHeap = new PriorityQueue<>((o1, o2) -> Double.compare(o2.getAmount(), o1.getAmount()));

        for (Map.Entry<Long, Double> entry : usersNetBalance.entrySet()) {
            long userId = entry.getKey();
            double amount = entry.getValue();

            if (amount > 0) {
                maxHeap.add(new UserExpense(userId, amount));
            }
            if (amount < 0) {
                minHeap.add(new UserExpense(userId, amount));
            }
        }

        List<ExpenseTransactionDTO> transactionDTOS = new ArrayList<>();

        while (!maxHeap.isEmpty() && !minHeap.isEmpty()) {

            UserExpense maxExpense = maxHeap.poll();
            UserExpense minExpense = minHeap.poll();

            if (Math.abs(maxExpense.getAmount()) > Math.abs(minExpense.getAmount())) {
                // we can get rid of min expense by adjusting with max expense
                ExpenseTransactionDTO expenseTransactionDTO = new ExpenseTransactionDTO();
                expenseTransactionDTO.setFrom(minExpense.getUserId());
                expenseTransactionDTO.setAmount(minExpense.getAmount());
                transactionDTOS.add(expenseTransactionDTO);

                maxHeap.add(new UserExpense(maxExpense.userId, maxExpense.amount + minExpense.getAmount()));
            }
            if (Math.abs(minExpense.getAmount()) > Math.abs(maxExpense.getAmount())) {
                ExpenseTransactionDTO expenseTransactionDTO = new ExpenseTransactionDTO();
                expenseTransactionDTO.setFrom(maxExpense.getUserId());
                expenseTransactionDTO.setAmount(maxExpense.getAmount());
                transactionDTOS.add(expenseTransactionDTO);

                minHeap.add(new UserExpense(minExpense.userId, minExpense.amount + maxExpense.getAmount()));
            }

        }

        return transactionDTOS;
    }

}


@Data
@AllArgsConstructor
class UserExpense {
    long userId;
    double amount;
}