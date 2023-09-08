package com.example.expenses.controller;

import com.example.expenses.entity.Expense;
import com.example.expenses.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expenses")
public class ExpensesController {
    private final ExpenseService expenseService;

    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<Void> creatExpenses(@RequestBody Expense expense){
        expenseService.creatExpenses(expense);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenses(@PathVariable("id") Integer id){
        expenseService.deleteExpenses(id);
        return ResponseEntity.ok(null);
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestParam("page") Integer pageNumber,
                                                        @RequestParam ("size")Integer pageSize){
        List<Expense> expenses = expenseService.getAllExpenses(pageNumber,pageSize);
        return ResponseEntity.ok(expenses);
    }
}
