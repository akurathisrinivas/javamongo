package com.project.spring.jwt.mongodb.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;



@Document(collection = "account_index")

@CompoundIndex(name = "compound_index",def = "{'account_number': 1,'account_type':1,'sort_code':1}", unique = true)
public class AccountIndex {
	@Id
	//@MongoId
	private ObjectId _id;
	
	
	@NotBlank(message = "Account number not be empty")
    @Size(min = 8, max = 8)
	private String account_number;
	
	
	private LocalDateTime   account_opened_on;
	
	@NotBlank(message = "Account type not be empty")
	@Size(max = 2)
	private String account_type;
	
	@NotBlank(message = "Sort code not be empty")
	@Size(max = 6)
	private String sort_code;
	
	@NotBlank(message = "Account status not be empty")
	private String account_status;
	
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
	public LocalDateTime getAccount_opened_on() {
		return account_opened_on;
	}
	public void setAccount_opened_on(LocalDateTime account_opened_on) {
		this.account_opened_on = account_opened_on;
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
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

}
