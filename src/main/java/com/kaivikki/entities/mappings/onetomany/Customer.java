package com.kaivikki.entities.mappings.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_t")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	
	private String name;
	
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	List<PhonNumber> phoneNumbers ;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PhonNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhonNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public void addPhoneNumber(PhonNumber phonNumber) {
		if(null!=phonNumber) {
			if(null==phoneNumbers) {
				phoneNumbers = new ArrayList<>();
			}
			phonNumber.setCustomer(this);
			phoneNumbers.add(phonNumber);
		}
	}
	

}
