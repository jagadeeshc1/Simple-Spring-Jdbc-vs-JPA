package com.jc.database.demo;

import com.jc.database.demo.entity.Person;
import com.jc.database.demo.repository.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao personDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("all persons -> {}",personDao.getAllPersons());
		logger.info("person with id 101 -> {}",personDao.findById(101));
		logger.info("persons with name Naresh -> {}",personDao.findByName("Naresh"));
		logger.info("delete person 104 ->{}",personDao.deleteById(104));
		logger.info("insert new person ->{}",personDao.insert(new Person(104,"Naresh","Banagalore",new Date())));
		logger.info("update -> {}",personDao.update(new Person(101,"Jc","hyderabad",new Date())));
	}
}
