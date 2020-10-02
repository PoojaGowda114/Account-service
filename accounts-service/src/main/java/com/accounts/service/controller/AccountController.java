package com.accounts.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.service.model.Account;
import com.accounts.service.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/addAccount")
	public Account addAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	@GetMapping("/accounts")
	public List<Account> findAllAccounts() {
		return accountService.getAccounts();
	}

	@GetMapping("/accounts/{number}")
	public Account findAccountById(@PathVariable int number) {
		return accountService.getAccountById(number);
	}

	@PutMapping("/accounts/{number}")
	public Account updateAccount(@RequestBody Account account, @PathVariable int number) {
		return accountService.updateAccountById(number, account);
	}

	@DeleteMapping("/accounts/{number}")
	public String deleteAccount(@PathVariable int number) {
		return accountService.deleteAccountById(number);
	}

}
