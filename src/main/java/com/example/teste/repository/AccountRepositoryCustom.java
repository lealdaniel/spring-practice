package com.example.teste.repository;

import com.example.teste.dto.GetAccountDto;
import com.example.teste.entity.Account;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AccountRepositoryCustom {

    Account findByInfo(@NotNull GetAccountDto accountDto);
}
