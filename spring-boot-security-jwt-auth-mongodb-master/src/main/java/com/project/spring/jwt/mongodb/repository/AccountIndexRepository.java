package com.project.spring.jwt.mongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.project.spring.jwt.mongodb.models.AccountIndex;
import com.project.spring.jwt.mongodb.payload.response.MessageResponse;



@Repository

public class AccountIndexRepository {

	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public AccountIndex save(AccountIndex accountData) {
		
		mongoTemplate.save(accountData);
		return accountData;
	}
	
	
}
