package com.example.teste.repository;

import com.example.teste.dto.GetAccountDto;
import com.example.teste.entity.Account;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer>, AccountRepositoryCustom {
}
