package com.project.spring.jwt.mongodb.repository;


import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.client.result.UpdateResult;
import com.project.spring.jwt.dto.Transactions_list;
import com.project.spring.jwt.mongodb.models.Transactions;

@Repository
public class TransactionsRepository {

	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Transactions save(Transactions transactionData) {
		
		mongoTemplate.save(transactionData);
		return transactionData;
	}
	
	public UpdateResult postTransactionById(String id,Transactions_list trns_list){
		
		ObjectId objectId = new ObjectId(id);
		//System.out.println(objectId);
		//System.out.println(groceryObjectId);
		final Query query = new Query(new Criteria().andOperator(
		        Criteria.where("_id").is(objectId)
		 ));
		//System.out.println(query);
		 
		 Update update = new Update().push("transactions_list", trns_list);
		 //System.out.println(update);
		 UpdateResult wr = mongoTemplate.updateFirst(query, update, Transactions.class);
		 		
		 return wr;
	}
	
	public List<Transactions> getTransactionsById(String id){
		Query query = new Query();
		ObjectId objectId = new ObjectId(id);
		query.addCriteria(Criteria.where("_id").is(objectId));
		return  mongoTemplate.find(query, Transactions.class);
	}
	
	public List<Transactions> getTransactionFromListById(String id,String trnsId){
		
		ObjectId objectId = new ObjectId(id);
		ObjectId trnsObjectId = new ObjectId(trnsId);
		//System.out.println(objectId);
		//System.out.println(trnsObjectId);
		final Query query = new Query(new Criteria().andOperator(
				 Criteria.where("_id").is(objectId)
			     //Criteria.where("transactions_list").elemMatch(Criteria.where("_id").is(trnsObjectId))
		));
		query.fields().include("transactions_list.$._id");
		query.addCriteria(Criteria.where("transactions_list.$._id").is(trnsObjectId));
		System.out.println(query);

		/*
		 * Criteria elementMatchCriteria =
		 * Criteria.where("transactions_list.$").elemMatch(Criteria.where("_id").is(
		 * trnsObjectId)); Query query = Query.query(elementMatchCriteria);
		 * query.fields().position("transactions_list.$", 1); try { Transactions
		 * Transactions =MongoOperations.findOne(query, Transactions.class); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		return  mongoTemplate.find(query, Transactions.class);
	}
	
	//Update Nested object with in the array of document.
	
	public UpdateResult updateTransactionItemById(String id,String trnsId,Transactions_list trns_list){
		
		ObjectId trnsObjectId = new ObjectId(trnsId);
		ObjectId objectId = new ObjectId(id);
		final Query query = new Query(new Criteria().andOperator(
		        Criteria.where("_id").is(objectId),
		       Criteria.where("transactions_list").elemMatch(Criteria.where("_id").is(trnsObjectId))
		));
		 Update update = new Update().set("transactions_list.$.statement_page_number", trns_list.getStatement_page_number());
		 update.set("transactions_list.$.transaction_type_name", trns_list.getTransaction_type_name());
		 update.set("transactions_list.$.statement_item_number", trns_list.getStatement_item_number());
		 update.set("transactions_list.$.balance", trns_list.getBalance());
		 update.set("transactions_list.$.amount", trns_list.getAmount());
		 update.set("transactions_list.$.description", trns_list.getDescription());
		 update.set("transactions_list.$.posted_on", trns_list.getPosted_on());
		 update.set("transactions_list.$.serial_number", trns_list.getSerial_number());
		 update.set("transactions_list.$.updated_date", trns_list.getUpdated_date());
		 update.set("transactions_list.$.Source", trns_list.getSource());
		 update.set("transactions_list.$.transaction_flag", trns_list.isTransaction_flag());
		 
		 
		 //System.out.println(update);
		 UpdateResult wr = mongoTemplate.updateFirst(query, update, Transactions.class);
		 		
		 return wr;
		
	}
	
	//delete Nested object with in the array of document.
	public UpdateResult deleteTransactionObjectById(String id,String trnsId,Transactions_list trns_list) {
			
				ObjectId trnsObjectId = new ObjectId(trnsId);
				ObjectId objectId = new ObjectId(id);
				//System.out.println(objectId);
				//System.out.println(groceryObjectId);
				final Query query = new Query(new Criteria().andOperator(
				        Criteria.where("_id").is(objectId)
				        //Criteria.where("groceryitems").elemMatch(Criteria.where("_id").is(groceryObjectId))
				));
				
				 System.out.println(query);
				 //Update update = new Update();
				 
				 //update.pull("groceryitems.$._id",groceryObjectId);
				 
				 //System.out.println(update);
				// UpdateResult wr = mongoTemplate.updateMulti(query, update, Person.class);
				 
				UpdateResult wr= this.mongoTemplate.updateMulti(query,
					        new Update().pull("transactions_list", Query.query(Criteria.where("_id").is(trnsObjectId))), Transactions.class);
				 
				 //System.out.println(wr.getUpsertedId());
				 return wr;
				 
			}


}
