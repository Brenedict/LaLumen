package com.lalumen.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int accountId;

    private String username;

    private String passwordHash;   

    public Account() {

    }

    public Account(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public void setAccountId(int id) {
        this.accountId = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    public String getPasswordHash() {
        return passwordHash;
    }
}
