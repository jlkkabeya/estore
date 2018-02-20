package com.app.estore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.estore.model.Customer;
import com.app.estore.repository.CustomerRepository;

@SpringBootApplication
public class EstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(EstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner estore(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			Customer cust1 = new Customer();
			cust1.setAddress("Silver Spring, MD");
			cust1.setFirstName("Jack");
			cust1.setLastName("Bauer");
			cust1.setMiddleName("S");
			repository.save(cust1);
			
			Customer cust2 = new Customer();
			cust2.setAddress("Silver Spring, MD");
			cust2.setFirstName("Chloe");
			cust2.setLastName("O'Brian");
			cust2.setMiddleName("H");
			repository.save(cust2);
			
			Customer cust3 = new Customer();
			cust3.setAddress("Vancouver, BC");
			cust3.setFirstName("Nicolas");
			cust3.setLastName("Beignet");
			cust3.setMiddleName("F");
			repository.save(cust3);
			
			Customer cust4 = new Customer();
			cust4.setAddress("Kinshasa, Kinshasa");
			cust4.setFirstName("Bijoux");
			cust4.setLastName("Tshileng");
			cust4.setMiddleName("G");
			repository.save(cust4);
			
			Customer cust5 = new Customer();
			cust5.setAddress("Dallas, Texas");
			cust5.setFirstName("Colt");
			cust5.setLastName("McCoy");
			cust5.setMiddleName("S");
			repository.save(cust5);
			
			Customer cust6 = new Customer();
			cust6.setAddress("LA, CA");
			cust6.setFirstName("Michele");
			cust6.setLastName("Andrews");
			cust6.setMiddleName("D");
			repository.save(cust6);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
