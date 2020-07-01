package com.location.app.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.app.entities.Location;
import com.location.app.repositories.LocationRepository;
import com.location.app.services.LocationService;
import com.location.app.util.EmailUtil;
import com.location.app.util.ReportUtil;

@Controller
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/showCreate")
	public String showCreateLocationPage() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap model) {
		Location savedLocation = locationService.saveLocation(location);
		String msg = "Location saved with id:" + savedLocation.getId();
		model.addAttribute("msg", msg);
		
		//Sending Email
		emailUtil.sendEmail("your_toAddress", "Location saved", "Location saved Successfully!!");
		
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap model) {
		List<Location> allLocations = locationService.getAllLocations();
		model.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id) {
		Location location = locationService.getLocationById(id);
		locationService.deleteLocation(location);
		//Also we can getAllLocations() and set it in Model rather than redirecting
		return "redirect:displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdatePage(@RequestParam("id") int id, ModelMap model) {
		Location location = locationService.getLocationById(id);
		model.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(@ModelAttribute("location") Location location) {
		locationService.updateLocation(location);
//		Also we can getAllLocations() and set it in Model rather than redirecting
//		List<Location> allLocations = locationService.getAllLocations();
//		model.addAttribute("locations", allLocations);
//		return "displayLocations";
		return "redirect:displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		
//		which returns the real path(given in quotes) in file system of the running servlet context
		String path = servletContext.getRealPath("/");
		
		List<Object[]> typeAndTypeCount = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, typeAndTypeCount);
		return "report";
	}

}
