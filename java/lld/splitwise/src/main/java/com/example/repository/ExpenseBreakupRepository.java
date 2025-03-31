package com.example.repository;

import com.example.models.ExpenseBreakup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseBreakupRepository extends JpaRepository<ExpenseBreakup, Long> {
}
