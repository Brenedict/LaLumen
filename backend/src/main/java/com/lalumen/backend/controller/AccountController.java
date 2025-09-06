package com.lalumen.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalumen.backend.entity.Account;
import com.lalumen.backend.entity.AccountResponseDTO;
import com.lalumen.backend.entity.LoginRequestDTO;
import com.lalumen.backend.service.AccountService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    AccountService service;

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = service.getAccounts();

        if(accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(accounts);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        Account account = service.getAccountById(id);

        if (account == null) {
            return ResponseEntity.noContent().build();    
        }

        return ResponseEntity.ok(account);
    }

    @PostMapping
    public Account postAccount(@RequestBody Account account) {
        return service.postAccount(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/auth")
    public ResponseEntity<AccountResponseDTO> handleLoginRequest(@RequestBody LoginRequestDTO credentials) {
        AccountResponseDTO response = service.handleLogin(credentials);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth/{id}")
    public ResponseEntity<AccountResponseDTO> handleAutoLoginRequest(@PathVariable("id") int accountId) {
        AccountResponseDTO response = service.handleAutoLogin(accountId);

        return ResponseEntity.ok(response);
    }

}
