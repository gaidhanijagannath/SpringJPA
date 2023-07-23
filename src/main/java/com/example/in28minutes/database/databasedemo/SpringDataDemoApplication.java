package com.example.in28minutes.database.databasedemo;

import com.example.in28minutes.database.databasedemo.entity.Person;
import com.example.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import com.example.in28minutes.database.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {


	 private Logger logger = LoggerFactory.getLogger(SpringDataDemoApplication.class);

	 @Autowired
	 PersonSpringDataRepository personSpringDataRepository; // reference variable to interface

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		logger.info("\nAll users in database are : {} ",personSpringDataRepository.findAll());

		logger.info("\nUser ID(10004) : {} ",personSpringDataRepository.findById(10004));

		logger.info("Updating 10005 -> {}",
				personSpringDataRepository.save(new Person(10009,"Raju", "golf course", new Date())));


		logger.info("Inserting new record -> {}",
				personSpringDataRepository.save(new Person("Shyam", "anuradha ka dil ", new Date())));

		logger.info("Inserting new record -> {}",
				personSpringDataRepository.save(new Person("Babu bhaiya", "swimming pool", new Date())));


		//personSpringDataRepository.deleteById(1);


	}
}
