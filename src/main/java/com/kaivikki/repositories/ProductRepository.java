package com.kaivikki.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kaivikki.entities.Product;

//public interface ProductRepository extends CrudRepository<Product, Integer>{
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
	
	// Finder method provided by JPA
	
	 List<Product> findByProductDescription(String productDescription);
	 List<Product> findByProductDescriptionLike(String productDescription);
	
	List<Product> findByProductName(String productName);
	
	List<Product> findByProductPrice(Double productPrice);
	List<Product> findByProductPriceGreaterThan(Double productPrice);
	
	List<Product> findByProductNameAndProductDescription(String productName, String productDescription);
}
