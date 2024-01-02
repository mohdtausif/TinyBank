package com.tausif.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tausif.card.models.jpa.CardEntity;
import com.tausif.card.models.jpa.CardRepository;

import jakarta.websocket.server.PathParam;

@SpringBootApplication
@RestController
public class CardApplication {
	@Autowired
	CardRepository cardRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

	@GetMapping("/cards")
	public List<CardEntity> getAllCards()
	{
		return cardRepository.findAll();
	}
	
	@GetMapping("/cards/accounts/{accountId}")
	public List<CardEntity> getAllCardsByAccountId(@PathVariable("accountId") Long accountId)
	{
		return cardRepository.findByAccountId(accountId);
	}
	
	@GetMapping("/cards/{id}")
	public CardEntity findCard(@PathParam("id") Long id)
	{
		return cardRepository.findById(id).orElseThrow(()->new RuntimeException("Card not found with id="+id));
	}
	
	@PostMapping("/cards")
	public CardEntity saveCard(@RequestBody CardEntity accountEntity)
	{
		return cardRepository.save(accountEntity);
	}
	
	@DeleteMapping("/cards/{id}")
	public void deleteCard(@PathParam("id") Long id)
	{
		cardRepository.deleteById(id);
	}
}
