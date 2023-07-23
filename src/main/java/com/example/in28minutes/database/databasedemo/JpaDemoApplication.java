package com.example.in28minutes.database.databasedemo;

import com.example.in28minutes.database.databasedemo.entity.Person;
import com.example.in28minutes.database.databasedemo.jdbc.PersonJdbcDAO;
import com.example.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {


	 private Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);
	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		logger.info("\nAll users in database are : {} ",personJpaRepository.findAll());


		logger.info("\nUser ID(10004) : {} ",personJpaRepository.findByID(10004));

		//we will ignore id as hibernate will do it.
		logger.info("Inserting 10007 -> {}",
				personJpaRepository.insert(new Person(10009,"Baburao", "chawl", new Date())));

		logger.info("Updating 10005 -> {}",
				personJpaRepository.update(new Person(10005, "saurabh", "nashik", new Date())));



		personJpaRepository.deleteById(10009);


	}
}
