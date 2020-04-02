package com.retail.service;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.retail.beans.Product;
import com.retail.beans.ProductInformation;
import com.retail.repository.ProductImpl;
import com.retail.repository.ProductRepository;

@RestController
@Service
public class ProductService {

	@Autowired
	ProductImpl productImpl;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	ProductRepository productRepo;

	@GetMapping(value = "/products/{id}")
	public ProductInformation getProductDetails(@PathVariable Integer id) {

		String URL = "https://redsky.target.com/v2/pdp/tcin/"
				+ id
				+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		@SuppressWarnings("rawtypes")
		HttpEntity entity = new HttpEntity(httpHeaders);
		ResponseEntity<Product> response = restTemplate.exchange(URL,
				HttpMethod.GET, entity, Product.class);
		Map<String, Object> resMap = response.getBody()
				.getAdditionalProperties();
		ObjectMapper mapper = new ObjectMapper();
		Product product1 = mapper.convertValue(resMap.get("product"),
				Product.class);
		DBObject productInfo = getProductInformation(id);
		ProductInformation productInformation = new ProductInformation();
		productInformation.setId(id);
		
		Object price = productInfo.get("current_price");
		
		productInformation.setCurrent_price(price);
		productInformation.setProductTypeName(product1.getItem()
				.getProductClassification().getProductTypeName());
		return productInformation;
	}

	@PutMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String setProductInformation(
			@RequestBody ProductInformation productInformation) {
		productRepo.save(productInformation);
		return "Product Updated Successfully";
	}

	public DBObject getProductInformation(Integer id) {
		return productImpl.getById(id);
	}

}
