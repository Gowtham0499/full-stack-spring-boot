package com.flight.checkin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckInController {

	@RequestMapping(value = "/showStartCheckIn", method =  RequestMethod.GET)
	public String showStartCheckIn() {
		return "startCheckIn";	
	}
	
}
