package com.example.teste.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateAccountDto {
    private Double balance;

    public UpdateAccountDto(@JsonProperty("balance") Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
}
