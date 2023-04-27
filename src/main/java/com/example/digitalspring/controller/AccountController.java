package com.example.digitalspring.controller;

import com.example.digitalspring.model.Account;
import com.example.digitalspring.service.AccountService;
import com.example.digitalspring.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        if (Validator.isNotNullFIO(account.getFirstname())
                || Validator.isNotNullFIO(account.getLastname())
                || Validator.isNotNullFIO(account.getSurname())) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(400));
        }

        if (Validator.validMass(account.getMass())) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(400));
        }

        if (Validator.validHeight(account.getHeight())) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(400));
        }

        if (Validator.isNotMinusZero(account.getAge())) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(400));
        }

        accountService.create(account);
        return new ResponseEntity<>(null, HttpStatus.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.getAll());
    }

}
