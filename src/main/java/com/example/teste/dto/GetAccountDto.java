package com.example.teste.dto;

import lombok.Getter;

public class GetAccountDto {

    private String name;
    private String cpf;

    public GetAccountDto(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}