package com.kaivikki.mongo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kaivikki.documents.MProduct;
import com.kaivikki.repositories.mongo.MProductRepository;

@SpringBootTest
public class MProductRepositoryTest {
	
	@Autowired
	MProductRepository mProductRepository;
	
	@Test
	public void createProductDocumentTest() {
		MProduct productDocument = new MProduct();
		productDocument.setName("iphone");
		productDocument.setPrice(100d);
		MProduct save = mProductRepository.save(productDocument);
		assertNotNull(save);
	}

	@Test
	public void findAll() {
		List<MProduct> findAll = mProductRepository.findAll();
		findAll.stream().forEach(p->{
			System.out.println(p.toString());
		});
	}
}
