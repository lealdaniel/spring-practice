package com.example.teste.dto;

import com.example.teste.entity.Account;
import lombok.Getter;

@Getter
public class CreateAccountDto {

    private String name;
    private String cpf;
    private Double balance;

    public CreateAccountDto(String name, String cpf, Double balance) {
        this.name = name;
        this.cpf = cpf;
        this.balance = balance;
    }

    public Account getAccountFromDto() {
        return new Account(name, cpf, balance);
    }

}
