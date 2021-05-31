package com.in28minutes.springboot.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.jpa.entities.User;
import com.in28minutes.springboot.jpa.interfaces.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	private UserRepository userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		User id = userDaoService.save(user);
		
		log.info("New user is created with id repo - " +  id);
	}
}
