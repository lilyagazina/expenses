package com.example.expenses.controller;

import com.example.expenses.entity.ExpenseByCategory;
import com.example.expenses.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseByCategoryController {
    private final ExpenseService expenseService;

    public ExpenseByCategoryController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses-by-categories")
    public List<ExpenseByCategory> getExpensesByCategories(){
        return expenseService.getExpenseByCategory();
    }
}
