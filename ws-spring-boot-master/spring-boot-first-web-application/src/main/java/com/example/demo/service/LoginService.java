package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userId, String psd) {
		
		return userId.equalsIgnoreCase("roman") && psd.equalsIgnoreCase("1234567");
	}
}
