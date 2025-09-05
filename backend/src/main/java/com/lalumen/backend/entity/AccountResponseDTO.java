package com.lalumen.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponseDTO {
    private int accountId;
    private String username;

    public AccountResponseDTO(int accountId, String username) {
        this.accountId = accountId;
        this.username = username;
    }
}
