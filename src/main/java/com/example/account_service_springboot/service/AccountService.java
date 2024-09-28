package com.example.account_service_springboot.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.account_service_springboot.entity.Account;
import com.example.account_service_springboot.repo.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public BigDecimal getAccountBalance(Long accountId) {
        Account account = getAccountById(accountId);
        return account.getBalance();
    }

    public Account updateAccountBalance(Long accountId, BigDecimal newBalance) {
        return accountRepository.findById(accountId)
                .map(account -> {
                    account.setBalance(newBalance);
                    return accountRepository.save(account);
                })
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public boolean validateAccount(Long accountId) {
        return accountRepository.existsById(accountId);
    }

	public Account createNewAccount(Account account) {		
		return accountRepository.save(account);
	}
}
