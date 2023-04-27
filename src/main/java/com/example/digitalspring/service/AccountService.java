package com.example.digitalspring.service;

import com.example.digitalspring.model.Account;
import com.example.digitalspring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account create(Account account) {
        account.setIndexMassBody(calIndexMassBody(account));
        return accountRepository.save(account);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    private Double calIndexMassBody(Account account) {
        return account.getMass() / (account.getHeight() * account.getHeight());
    }


}
