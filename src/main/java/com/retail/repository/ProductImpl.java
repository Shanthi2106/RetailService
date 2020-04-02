package com.retail.repository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.retail.beans.ProductInformation;

@Repository
public class ProductImpl implements Product{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private ProductRepository mongoRepo;


	public DBObject getById(Integer id) {
		MongoClient mongoClient = new MongoClient("localhost");
		DB db = mongoClient.getDB("technicalkeeda");
		DBCollection coll = db.getCollection("productInformation");
		DBObject query1 = new BasicDBObject("_id",id);
		DBObject d1 = coll.findOne(query1); 
		return d1;
	}
	
	public String setProductDetails(ProductInformation productInformation) {
		MongoClient mongoClient = new MongoClient("localhost");
		DB db = mongoClient.getDB("newdb");
		DBCollection coll = db.getCollection("productinformation");
		DBObject query1 = new BasicDBObject("productId",productInformation.getId());
		DBObject d1 = coll.findOne(query1);
		mongoRepo.save(productInformation);
		return "Saved Successfully";
	}
		

}
