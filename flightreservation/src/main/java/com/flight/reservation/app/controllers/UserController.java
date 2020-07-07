package com.flight.reservation.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.reservation.app.entities.User;
import com.flight.reservation.app.repository.UserRepository;
import com.flight.reservation.app.services.SecurityService;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	SecurityService securityService;
	
	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {
		LOGGER.info("Inside registerUser()");
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping(value = "/showLogin", method = RequestMethod.GET)
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password, ModelMap model) {
		LOGGER.info("Inside login()");
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "findFlights";
		} else {
			model.addAttribute("errmsg", "Invalid Username or Password!! Please Try Again!!");
		}
		return "login/login";
	}

}
