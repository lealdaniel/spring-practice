package com.example.teste.controller;

import com.example.teste.dto.CreateAccountDto;
import com.example.teste.dto.GetAccountDto;
import com.example.teste.dto.UpdateAccountDto;
import com.example.teste.entity.Account;
import com.example.teste.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Integer id) {
        return accountService.getAccountById(id).orElse(null);
    }

    @GetMapping
    public Account getAccount(@RequestBody GetAccountDto accountDto) {
        return accountService.getAccount(accountDto);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccountDto accountDto) {
        Account createdAccount = accountService.createAccount(accountDto);
        if (createdAccount != null)
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable("id") Integer id, @RequestBody UpdateAccountDto accountDto) {
        return accountService.updateAccount(id, accountDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Integer id) {
        accountService.deleteAccount(id);
    }
}
