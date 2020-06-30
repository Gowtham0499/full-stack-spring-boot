package com.location.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.location.app.entities.Location;
import com.location.app.services.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@RequestMapping("/showCreate")
	public String showCreateLocationPage() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap model) {
		Location savedLocation = locationService.saveLocation(location);
		String msg = "Location saved with id:" + savedLocation.getId();
		model.addAttribute("msg", msg);
		return "createLocation";
	}

}
