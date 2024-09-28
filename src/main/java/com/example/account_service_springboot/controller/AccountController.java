package com.example.account_service_springboot.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account_service_springboot.entity.Account;
import com.example.account_service_springboot.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.getAccountBalance(accountId), HttpStatus.OK);
    }

    @PutMapping("/{accountId}/balance")
    public ResponseEntity<Account> updateAccountBalance(@PathVariable Long accountId, @RequestBody BigDecimal newBalance) {
        return new ResponseEntity<>(accountService.updateAccountBalance(accountId, newBalance), HttpStatus.OK);
    }

    @GetMapping("/{accountId}/validate")
    public ResponseEntity<Boolean> validateAccount(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.validateAccount(accountId), HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<Account> createNewAccount(@RequestBody Account account ) {
        return new ResponseEntity<>(accountService.createNewAccount(account), HttpStatus.OK);
    }
    
    
}
