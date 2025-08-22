package com.lalumen.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalumen.backend.entity.Account;
import com.lalumen.backend.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    @GetMapping
    public List<Account> getAccounts() {
        return service.getAccounts();
    }
    

    @PostMapping
    public Account postAccount(@RequestBody Account account) {
        return service.postAccount(account);
    }

}
