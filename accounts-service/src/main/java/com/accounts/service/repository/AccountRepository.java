package com.accounts.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.service.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
