package com.kaivikki.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kaivikki.documents.MProduct;

public interface MProductRepository extends MongoRepository<MProduct, String> {

}
