package com.retail.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.DBObject;

@Document(collection="productInformation")
public class ProductInformation {

	@Id
	private int id;
	
	@JsonProperty("productTypeName")
	private String productTypeName;
	
	@JsonProperty("current_price")
	private Object current_price;

	public ProductInformation(DBObject findOne) {
		super();
	}

	public ProductInformation() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Object getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(Object current_price) {
		this.current_price = current_price;
	}

}

