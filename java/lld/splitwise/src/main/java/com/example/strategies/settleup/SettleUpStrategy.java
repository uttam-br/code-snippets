package com.example.strategies.settleup;

import com.example.dto.ExpenseDTO;
import com.example.dto.ExpenseTransactionDTO;

import java.util.List;

public interface SettleUpStrategy {

    List<ExpenseTransactionDTO> settleUp(List<ExpenseDTO> expenses);

}
