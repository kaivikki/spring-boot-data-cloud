package com.kaivikki;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kaivikki.entities.Check;
import com.kaivikki.entities.CreditCard;
import com.kaivikki.repositories.PaymentRepository;

@SpringBootTest
public class PaymentRepositoryTest {
	
	@Autowired
	private PaymentRepository paymentRepository;


	@Test
	public void savePaymentSingleTableTest() {
		CreditCard creditCardPayment = new CreditCard();
		creditCardPayment.setId(1);
		creditCardPayment.setAmount(100d);
		creditCardPayment.setCardnumber("12345678");
		paymentRepository.save(creditCardPayment);
		
		Check checkPayment = new Check();
		checkPayment.setId(2);
		checkPayment.setAmount(200d);
		checkPayment.setChecknumber("ABC12345");
		paymentRepository.save(checkPayment);
	}
	
	@Test
	public void deleteAllPayment() {
		paymentRepository.deleteAll();
	}
}
