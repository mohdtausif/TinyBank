package com.tausif.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tausif.account.models.jpa.AccountEntity;
import com.tausif.account.models.jpa.AccountRepository;

import jakarta.websocket.server.PathParam;

@SpringBootApplication
@RestController
public class AccountApplication {
	@Autowired
	AccountRepository accountRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@GetMapping("/accounts")
	public List<AccountEntity> getAllAccounts()
	{
		return accountRepository.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public AccountEntity findAccount(@PathParam("id") Long id)
	{
		return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found with id="+id));
	}
	
	@PostMapping("/accounts")
	public AccountEntity saveAccount(@RequestBody AccountEntity accountEntity)
	{
		return accountRepository.save(accountEntity);
	}
	
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathParam("id") Long id)
	{
		accountRepository.deleteById(id);
	}
}
