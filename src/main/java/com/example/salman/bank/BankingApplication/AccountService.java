package com.example.salman.bank.BankingApplication;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public String deposit(Long userId, double amount) {
        Account account = accountRepository.findByUserId(userId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
            return "Deposit successful! New balance: " + account.getBalance();
        }
        return "Account not found!";
    }

    @Transactional
    public String withdraw(Long userId, double amount) {
        Account account = accountRepository.findByUserId(userId);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
                return "Withdrawal successful! New balance: " + account.getBalance();
            }
            return "Insufficient balance!";
        }
        return "Account not found!";
    }
}

