package com.example.teste.service;

import com.example.teste.dto.CreateAccountDto;
import com.example.teste.dto.GetAccountDto;
import com.example.teste.dto.UpdateAccountDto;
import com.example.teste.entity.Account;
import com.example.teste.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    public Account getAccount(GetAccountDto accountDto) {
        return accountRepository.findByInfo(accountDto);
    }

     public Account createAccount(CreateAccountDto accountDto) {
        return accountRepository.save(accountDto.getAccountFromDto());
    }

    public Account updateAccount(Integer id, UpdateAccountDto accountDto) {
        Account account = accountRepository.findById(id).orElse(null);

        if (account != null) {
            account.setBalance(accountDto.getBalance());
            return accountRepository.save(account);
        }

        return null;
    }

    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }



}
