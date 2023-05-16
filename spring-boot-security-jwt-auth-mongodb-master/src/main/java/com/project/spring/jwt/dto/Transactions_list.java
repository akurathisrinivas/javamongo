package com.project.spring.jwt.dto;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Document("transactions_list")

@Data
public class Transactions_list {
	
	@Id 
	private String _id;
	//@Id private ObjectId _id;

    private int statement_page_number;
    private int statement_item_number;
    private String transaction_type_name;
    private Double balance;
    private Double amount;
    private LocalDateTime posted_on;
    private int serial_number;
    private String description;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private String Source;
    private boolean transaction_flag;
    
    
    
	public Transactions_list(String _id, int statement_page_number, int statement_item_number,
			String transaction_type_name,Double balance,Double amount,LocalDateTime posted_on,int serial_number
			,String description,LocalDateTime created_date,LocalDateTime updated_date,String Source,boolean transaction_flag) {
		//super();
		//this._id = _id;
		//this.statement_page_number = statement_page_number;
		//this.statement_item_number = statement_item_number;
		//this.transaction_type_name = transaction_type_name;
		this.set_id(_id);
        this.setStatement_page_number(statement_page_number);
        this.setStatement_item_number(statement_item_number);
        this.setTransaction_type_name(transaction_type_name);
        this.setBalance(balance);
        this.setAmount(amount);
        this.setDescription(description);
        this.setCreated_date(created_date);
        this.setPosted_on(posted_on);
        this.setSerial_number(serial_number);
        this.setUpdated_date(updated_date);
        this.setSource(Source);
        this.setTransaction_flag(transaction_flag);
	}

	public void set_id(String _id) {
		this._id = new ObjectId().toString();
	}
    public String get_id() {
		return _id;
	}

	public int getStatement_page_number() {
		return statement_page_number;
	}

	public void setStatement_page_number(int statement_page_number) {
		this.statement_page_number = statement_page_number;
	}

	public int getStatement_item_number() {
		return statement_item_number;
	}

	public void setStatement_item_number(int statement_item_number) {
		this.statement_item_number = statement_item_number;
	}

	public String getTransaction_type_name() {
		return transaction_type_name;
	}

	public void setTransaction_type_name(String transaction_type_name) {
		this.transaction_type_name = transaction_type_name;
	}

	

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPosted_on() {
		return posted_on;
	}

	public void setPosted_on(LocalDateTime posted_on) {
		this.posted_on = posted_on;
	}

	public int getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public LocalDateTime getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public boolean isTransaction_flag() {
		return transaction_flag;
	}

	public void setTransaction_flag(boolean transaction_flag) {
		this.transaction_flag = transaction_flag;
	}

    

	
}
