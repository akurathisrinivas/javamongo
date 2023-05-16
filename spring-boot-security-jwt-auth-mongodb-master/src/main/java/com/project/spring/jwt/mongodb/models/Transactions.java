package com.project.spring.jwt.mongodb.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.spring.jwt.dto.*;

@Document(collection = "domestic_transactions")
public class Transactions {
	
	@Id
	//@MongoId
	private ObjectId _id;
	
	@NotBlank(message = "Account number not be empty")
    @Size(min = 8, max = 8)
	private String account_number;
	
	@NotBlank(message = "Account type not be empty")
	@Size(max = 2)
	private String account_type;
	
	@NotBlank(message = "Sort code not be empty")
	@Size(max = 6)
	private String sort_code;
	
	private LocalDateTime   account_opened_on;
	
	@JsonProperty("transactions_list")
	private List<Transactions_list> transactions_list;
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getSort_code() {
		return sort_code;
	}

	public void setSort_code(String sort_code) {
		this.sort_code = sort_code;
	}

	public LocalDateTime getAccount_opened_on() {
		return account_opened_on;
	}

	public void setAccount_opened_on(LocalDateTime account_opened_on) {
		this.account_opened_on = account_opened_on;
	}

	/*
	 * public List<Transactions_list> getTransactions() { return transactions_list;
	 * }
	 * 
	 * public void setTransactions(List<Transactions_list> transactions_list) {
	 * this.transactions_list = transactions_list; }
	 */

	

}
