package com.accounts.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.service.model.Account;
import com.accounts.service.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

	public Account getAccountById(int number) {
		return accountRepository.findById(number).orElse(null);
	}

	public String deleteAccountById(int number) {
		accountRepository.deleteById(number);
		return "Account removed!!" + number;
	}

	public Account updateAccountById(int Number, Account account) {
		Account existingAccount = accountRepository.findById(account.getNumber()).orElse(null);
		existingAccount.setName(account.getName());
		existingAccount.setAge(account.getAge());
		existingAccount.setMobile(account.getMobile());
		existingAccount.setEmail(account.getEmail());
		return accountRepository.save(existingAccount);
	}

}
