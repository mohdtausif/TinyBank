package com.tausif.loan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tausif.loan.models.jpa.LoanEntity;
import com.tausif.loan.models.jpa.LoanRepository;

import jakarta.websocket.server.PathParam;

@SpringBootApplication
@RestController
public class LoanApplication {
	@Autowired
	LoanRepository loanRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

	@GetMapping("/loans")
	public List<LoanEntity> getAllLoans()
	{
		return loanRepository.findAll();
	}
	
	@GetMapping("/loans/accounts/{accountId}")
	public List<LoanEntity> getAllLoansByAccountId(@PathParam("accountId") Long accountId)
	{
		return loanRepository.findByAccountId(accountId);
	}
	
	@GetMapping("/loans/{id}")
	public LoanEntity findLoans(@PathParam("id") Long id)
	{
		return loanRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found with id="+id));
	}
	
	@PostMapping("/loans")
	public LoanEntity saveLoans(@RequestBody LoanEntity accountEntity)
	{
		return loanRepository.save(accountEntity);
	}
	
	@DeleteMapping("/loans/{id}")
	public void deleteLoans(@PathParam("id") Long id)
	{
		loanRepository.deleteById(id);
	}
}
