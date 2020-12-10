package com.example.teste.repository;

import com.example.teste.dto.GetAccountDto;
import com.example.teste.entity.Account;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public AccountRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Account findByInfo(@NotNull GetAccountDto accountDto) {
        String sql = "SELECT * FROM account WHERE name = :name AND cpf = :cpf";
        Query query = entityManager.createNativeQuery(sql, Account.class);
        @SuppressWarnings("unchecked")
        List<Account> accounts = query.setParameter("name", accountDto.getName()).setParameter("cpf", accountDto.getCpf()).getResultList();

        if (!accounts.isEmpty())
            return accounts.get(0);

        return null;

    }

}

