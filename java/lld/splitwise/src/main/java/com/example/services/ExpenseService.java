package com.example.services;

import com.example.dto.ExpenseBreakupDTO;
import com.example.dto.ExpenseDTO;
import com.example.models.Expense;
import com.example.models.ExpenseBreakup;
import com.example.models.Group;
import com.example.models.User;
import com.example.repository.ExpenseBreakupRepository;
import com.example.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final UserService userService;
    private final ExpenseRepository expenseRepository;
    private final GroupService groupService;
    private final ExpenseBreakupRepository expenseBreakupRepository;

    public ExpenseDTO addExpense(ExpenseDTO expenseRequestDTO) throws Exception {

        Expense expense = new Expense();

        User createdByUser = userService.getUser(expenseRequestDTO.getCreatedBy());
        expense.setCreatedBy(createdByUser);

        Group group = groupService.getGroup(expenseRequestDTO.getGroupId());
        expense.setGroup(group);

        expense.setDescription(expenseRequestDTO.getDescription());
        expense.setTotalAmount(expenseRequestDTO.getAmount());

        expenseRepository.save(expense);

        List<ExpenseBreakup> expenseBreakupList = new ArrayList<>();

        for (ExpenseBreakupDTO expenseBreakupDTO : expenseRequestDTO.getExpenseBreakups()) {
            ExpenseBreakup expenseBreakup = new ExpenseBreakup();

            expenseBreakup.setAmount(expenseBreakupDTO.getAmount());
            User expenseUser = userService.getUser(expenseBreakupDTO.getUserId());
            expenseBreakup.setUser(expenseUser);
            expenseBreakup.setType(expenseBreakupDTO.getExpenseTransactionType());
            expenseBreakup.setExpense(expense);

            expenseBreakupList.add(expenseBreakup);
        }

        expenseBreakupRepository.saveAll(expenseBreakupList);

        return new ExpenseDTO(expense);
    }


    public ExpenseDTO getExpense(long expenseId) throws Exception {
        Optional<Expense> expenseOptional = expenseRepository.findById(expenseId);

        if (expenseOptional.isEmpty()) {
            throw new Exception("Expense with id " + expenseId + " is not found.");
        }

        return new ExpenseDTO(expenseOptional.get());
    }

    public List<ExpenseDTO> getExpensesByGroup(long groupId) throws Exception {
        List<Expense> expensesByGroup = expenseRepository.findByGroup(groupId);

        return expensesByGroup.stream().map(ExpenseDTO::new).toList();
    }

}
