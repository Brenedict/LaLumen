package com.lalumen.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponseDTO {
    private int id;
    private String username;

    public AccountResponseDTO(int id, String username) {
        this.id = id;
        this.username = username;
    }
}
