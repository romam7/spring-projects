package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	// @ResponseBody
	public String showLoginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	// @ResponseBody
	/*
	 * El parámetro nombre, debe tener el mismo nombre que el input en el login 
	 */
	public String showWelcomePage(ModelMap model, @RequestParam String nombre, @RequestParam String password) {
		
		if (!service.validateUser(nombre, password)) {
			model.put("errorMessage", "Credenciales incorrectas");
			return "login";
		}
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("password", password);
		return "welcome";
	}
	
	/**
	 * @param model is used to pass data to our JSP 
	 */
	public String hello(@RequestParam String nombre, ModelMap model) {
		System.out.println(nombre);
		model.addAttribute("name", nombre);
		// return "Helo World";
		return "login";
	}
}
