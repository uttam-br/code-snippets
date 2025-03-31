package com.example.repository;

import com.example.models.Expense;
import com.example.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("select e from expenses e where e.group.id = ?1")
    List<Expense> findByGroup(long groupId);


}
