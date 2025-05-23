package com.example.salman.bank.BankingApplication;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserId(Long userId);
}

