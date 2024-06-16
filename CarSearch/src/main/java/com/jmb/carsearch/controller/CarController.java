package com.jmb.carsearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jmb.carsearch.dto.SearchDTO;
import com.jmb.carsearch.model.Car;
import com.jmb.carsearch.service.CarService;
import com.jmb.carsearch.utility.SearchUtilities;

@SessionAttributes("cars")
@Controller
public class CarController {
	
	@Autowired
	private CarService service;
	
	@Autowired
	private DownloadController download;
	
	@GetMapping({"/","/search"})
	public String searchPage(Model model) {
		SearchDTO searchDTO = new SearchDTO();
		model.addAttribute("searchDto",searchDTO);
		return "search";
	}
	
	@PostMapping("/process-search")
	public String processSearch(SearchDTO searchDTO, Model model) {
		List<Car> cars = new ArrayList<>();
		String searchText = searchDTO.getSearchText();
		if (SearchUtilities.isNumeric(searchText)) {
			cars = service.findCarsByLenghtWeightVelocity(searchText);
		} else {
			cars = service.findCarsByNameColor(searchText);
		}
		model.addAttribute("cars",cars);
		model.addAttribute("searchDto",searchDTO);
		return "search_results";
	}
	
	@PostMapping("/download-results")
	public ResponseEntity<List<Car>> downloadResults(@ModelAttribute("cars") List<Car> cars) {
		return download.produceXML(cars);
	}
}
