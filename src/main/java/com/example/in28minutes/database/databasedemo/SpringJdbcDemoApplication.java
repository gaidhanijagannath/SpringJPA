package com.example.in28minutes.database.databasedemo;

import com.example.in28minutes.database.databasedemo.entity.Person;
import com.example.in28minutes.database.databasedemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {


	 private Logger logger = LoggerFactory.getLogger(SpringJdbcDemoApplication.class);
	@Autowired
	PersonJdbcDAO personJdbcDAO ;


	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("\nAll users in database are : {} ",personJdbcDAO.finAll());
		logger.info("\nUser ID(10003) : {} ",personJdbcDAO.finByID(10003));
		logger.info("\nDeleting User : Number of rows affected {} ",personJdbcDAO.deleteByID(10003));

		logger.info("Inserting 10005 -> {}",
				personJdbcDAO.insert(new Person(10005, "Tara", "Berlin", new Date())));

		logger.info("Updating 10005 -> {}",
				personJdbcDAO.update(new Person(10005, "Peter", "Amsterdam", new Date())));

	}
}
