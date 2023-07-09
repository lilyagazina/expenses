package com.example.expenses.service;

import com.example.expenses.entity.Expense;
import com.example.expenses.entity.ExpenseByCategory;
import com.example.expenses.repository.ExpenseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize);
        return expenseRepository.findAll(pageRequest).getContent();
    }

    public void creatExpenses(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpenses(Integer id) {
        expenseRepository.deleteById(id);
    }
    public List<ExpenseByCategory> getExpenseByCategory(){
        return expenseRepository.getExpenseByCategory();
    }

}
