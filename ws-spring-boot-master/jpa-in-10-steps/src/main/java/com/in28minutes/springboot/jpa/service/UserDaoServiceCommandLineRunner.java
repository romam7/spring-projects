package com.in28minutes.springboot.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.jpa.entities.User;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		long id = userDaoService.insert(user);
		
		log.info("New user is created with id - " +  id);
	}
}
