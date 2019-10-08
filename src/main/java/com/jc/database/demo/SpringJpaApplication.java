package com.jc.database.demo;

import com.jc.database.demo.entity.Person;
import com.jc.database.demo.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("all persons -> {}",personRepository.findAll());
		logger.info("person with id 101 -> {}",personRepository.findById(101));
		personRepository.deleteById(104);
		logger.info("insert new person ->{}",personRepository.insert(
		        new Person(104,"Naresh","Banagalore",new Date())));
		logger.info("update -> {}",personRepository.update(new Person(101,"Jc","hyderabad",new Date())));
	}
}
