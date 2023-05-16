package com.project.spring.jwt.mongodb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.spring.jwt.mongodb.models.AccountIndex;
import com.project.spring.jwt.mongodb.payload.response.MessageResponse;
import com.project.spring.jwt.mongodb.repository.AccountIndexRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/accountIndex")
public class AccountIndexController {
	
	@Autowired
    private AccountIndexRepository repo;
	
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('USER')")
    public ResponseEntity<MessageResponse> saveAccountIndex(@Valid @RequestBody AccountIndex accountData){
		
		//System.out.println(accountData.getAccount_number());
		
		/*
		 * String account_number=accountData.getAccount_number();
		 * 
		 * if ((account_number == "") ||(account_number == null) ||
		 * (account_number.length() == 0) ) { return ResponseEntity .badRequest()
		 * .body(new MessageResponse("Error: Account number not be empty")); }
		 */
		//try {
        repo.save(accountData);
        return ResponseEntity.ok(new MessageResponse("Added Successfully"));
		//}catch(DuplicateKeyException e){
			
			//return ResponseEntity.internalServerError().body(new MessageResponse(e.getMessage()));
		//}
        
        
        //return "Added Successfully";
       
    }
	
	
}
