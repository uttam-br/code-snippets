package com.example.controllers;

import com.example.dto.ExpenseDTO;
import com.example.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/expenses")
@AllArgsConstructor
public class ExpenseController {

    ExpenseService expenseService;

    @PostMapping(value = {"", "/"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addExpense(@RequestBody ExpenseDTO addExpenseRequest) {
        try {
            ExpenseDTO expense = expenseService.addExpense(addExpenseRequest);
            return ResponseEntity.ok(expense);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{expenseId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getExpense(@PathVariable long expenseId) {
        System.out.println("getExpense : " + expenseId);

        try {
            ExpenseDTO expenseDTO = expenseService.getExpense(expenseId);
            return ResponseEntity.ok(expenseDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Something went wrong... " + e.getMessage());
        }
    }

}
