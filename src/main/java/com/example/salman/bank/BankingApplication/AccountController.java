package com.example.salman.bank.BankingApplication;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/deposit/{userId}")
    public String deposit(@PathVariable Long userId, @RequestParam double amount) {
        return accountService.deposit(userId, amount);
    }

    @PostMapping("/withdraw/{userId}")
    public String withdraw(@PathVariable Long userId, @RequestParam double amount) {
        return accountService.withdraw(userId, amount);
    }
}

