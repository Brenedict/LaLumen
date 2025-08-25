package com.lalumen.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalumen.backend.entity.Account;
import com.lalumen.backend.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public List<Account> getAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(int id) {
        Optional<Account> account = repository.findById(id);

        if(!account.isPresent()) {
            throw new RuntimeException("Account with id " + id + "not found");
        }

        return account.get();
    }

    public Account postAccount(Account account) {
        account.setAccountId(0);
        return repository.save(account);
    }

    public void deleteAccount(int id) {
        repository.deleteById(id);
    }

}
