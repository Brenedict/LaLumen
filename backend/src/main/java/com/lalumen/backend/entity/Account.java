package com.lalumen.backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int accountId;

    private String username;

    private String passwordHash;   

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Work> works = new ArrayList<>();
    
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
