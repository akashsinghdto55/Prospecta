package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.entity.Main;
import com.prospecta.exception.MainException;
import com.prospecta.service.MainServiceImpl;

@RestController
public class MainController {
	
	@Autowired
	private MainServiceImpl mservice;
	
	
	@GetMapping("/getTitleAndDesc/{category}")
	public ResponseEntity<List<List<String>>> GetTitleAndDesc(@PathVariable String category) throws MainException{
		
		List<List<String>> result = mservice.findByCategory(category);
		
		return new ResponseEntity<List<List<String>>>(result,HttpStatus.ACCEPTED);
		
		
	}
	
	@PostMapping("/GET/entries")
	public ResponseEntity<Main> SaveEntries(@RequestBody Main main){
		
		return new ResponseEntity<Main>(mservice.saveProject(main),HttpStatus.CREATED);
	}

}
