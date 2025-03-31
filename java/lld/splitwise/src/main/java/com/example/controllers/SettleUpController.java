package com.example.controllers;

import com.example.dto.ExpenseTransactionDTO;
import com.example.services.SettleUpService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/settle-up")
@AllArgsConstructor
public class SettleUpController {

    SettleUpService settleUpService;

    @GetMapping(value = "/user/{userId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> performUserSettleUp(@PathVariable long userId) {

        try {
            List<ExpenseTransactionDTO> transactions = settleUpService.settleUpUser(userId);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Something went wrong while settling user - " + e.getMessage());
        }

    }

    @GetMapping(value = "/group/{groupId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> performGroupSettleUp(@PathVariable long groupId) {

        try {
            List<ExpenseTransactionDTO> transactions = settleUpService.settleUpGroup(groupId);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Something went wrong while settling group " + e.getMessage());
        }

    }

}
