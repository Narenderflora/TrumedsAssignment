package com.truemeds.truemeds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.truemeds.truemeds.model.FinalOutput;
import com.truemeds.truemeds.service.TruemedsService;

@RestController
@RequestMapping("/assignment")
public class TruemedsController {
	
	private static final Logger log= LoggerFactory.getLogger(TruemedsController.class);

	@Autowired
	TruemedsService  truemedsService;
	
	@GetMapping(value = "/{id}")
	public List<FinalOutput> runAssignment(@PathVariable(value = "id") int id) {
		log.debug("Start of TruemedsController.runAssignment() for input id : {}",id);
		
		List<FinalOutput> finalOutputs = truemedsService.runAssignment(id);
		return finalOutputs;
		
	}
}
