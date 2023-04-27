package com.example.digitalspring.repository;

import com.example.digitalspring.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {

}
