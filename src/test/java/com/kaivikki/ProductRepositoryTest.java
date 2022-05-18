package com.kaivikki;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.kaivikki.entities.Product;
import com.kaivikki.repositories.ProductRepository;

@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EntityManager pgEntityManagerFactory;


	@Test
	public void testCreateProduct() {

		List<Product> productList = new ArrayList<>();

		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Iphone");
		product.setProductDescription("From Apple Inc");
		product.setProductPrice(50000d);

		Product product1 = new Product();
		product1.setProductId(2);
		product1.setProductName("TV");
		product1.setProductDescription("From Samsung Inc");
		product1.setProductPrice(60000d);

		Product product2 = new Product();
		product2.setProductId(3);
		product2.setProductName("Washer");
		product2.setProductDescription("From LG Inc");
		product2.setProductPrice(70000d);

		Product product3 = new Product();
		product3.setProductId(4);
		product3.setProductName("Dryer");
		product3.setProductDescription("From LG Inc");
		product3.setProductPrice(80000d);
		productList.add(product);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productRepository.saveAll(productList);
	}

	@Test
	public void testReadProduct() {
		Product product = productRepository.findById(1).get();
		assertEquals("Iphone 13", product.getProductName());
	}

	@Test
	public void testUpdateProduct() {
		Product product = productRepository.findById(1).get();
		product.setProductPrice(95000d);
		productRepository.save(product);
	}

	@Test
	public void testDeleteProduct() {
		if (productRepository.existsById(1)) {
			productRepository.deleteById(1);
		}
	}

	@Test
	public void testDeleteAllProduct() {
		productRepository.deleteAll();
	}

	@Test
	public void testFindProductByName() {
		productRepository.findByProductName("TV").forEach(p -> {
			System.out.println(p.getProductPrice());
		});
	}
	
	
	@Test
	public void tesFindAllPaging() {
		System.out.println(">>>>>>>Page 1");
		Pageable pageable = PageRequest.of(0, 2);
		
		Page<Product> result = productRepository.findAll(pageable);
		result.forEach(p->{
			System.out.println(p.getProductName());
		});
		
		System.out.println(">>>>>>>>Page 2");
		Pageable pageable1 = PageRequest.of(1, 2);
		Page<Product> result1= productRepository.findAll(pageable1);
		result1.forEach(p->{
			System.out.println(p.getProductName());
		});
	}
	
	@Test
	public void tesFindAllSorting() {
		 Sort sortByName = Sort.by(Direction.DESC,"productName");
		Iterable<Product> findAll = productRepository.findAll(sortByName);
		findAll.forEach(p->{
			System.out.println(p.getProductName());
		});
	}
	
	@Test
	public void tesFindAllPagingAndSorting() {
		System.out.println(">>>>>>>Page 1");
		PageRequest pageable = PageRequest.of(0, 2, Direction.DESC,"productName");
		
		Page<Product> result = productRepository.findAll(pageable);
		result.forEach(p->{
			System.out.println(p.getProductName());
		});
		
		System.out.println(">>>>>>>>Page 2");
		Pageable pageable1 = PageRequest.of(1, 2, Direction.DESC,"productName");
		Page<Product> result1= productRepository.findAll(pageable1);
		result1.forEach(p->{
			System.out.println(p.getProductName());
		});
	}
	
	@Test
	@Transactional
	public void testFirstLevelCache() {
		Session session = pgEntityManagerFactory.unwrap(Session.class);
		Product product = productRepository.findById(2).get();
		productRepository.findById(2).get();
		session.evict(product);
		System.out.println("After Product is evicted from session cache. New Select Query will be fired");
		productRepository.findById(2).get();
	}
}
