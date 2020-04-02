package com.retail.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.retail.beans.ProductInformation;

@Repository
public interface ProductRepository extends MongoRepository<ProductInformation, String> {


}
