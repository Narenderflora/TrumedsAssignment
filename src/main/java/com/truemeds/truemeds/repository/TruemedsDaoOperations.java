package com.truemeds.truemeds.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.truemeds.truemeds.model.FinalOutput;
import com.truemeds.truemeds.model.InputDetails;

@Component
public class TruemedsDaoOperations {
	private static final Logger log = LoggerFactory.getLogger(TruemedsDaoOperations.class);

	@Autowired
	TruemedsJpaRepository truemedsJpaRepository;

	@Autowired
	TruemedsJpaOutputRepository truemedsJpaOutputRepository;

	@Cacheable(value = "com.truemeds.service.retrievedata", unless = "#result == null")
	public List<InputDetails> retrieveAllData() {
		List<InputDetails> inputDetails = null;
		try {
			log.debug("Start of TruemedsDaoOperations.retrieveAllData()");
			inputDetails = truemedsJpaRepository.findAll();
			if (inputDetails.isEmpty()) {
				log.error("Got empty response from database");
				return null;
			}
		} catch (Exception e) {
			log.error("Exception while fetching the data : {}", e.getMessage());
		}
		return inputDetails;
	}

	public void saveData(FinalOutput finalOutput) {
		log.debug("Start of TruemedsDaoOperations.saveData()");
		try {
			truemedsJpaOutputRepository.save(finalOutput);
		} catch (Exception e) {
			log.error("Exception while saving into");
		}
	}

	public List<FinalOutput> retrieveFinalOutput() {
		List<FinalOutput> finalOutputs = null;
		try {
			log.debug("Start of TruemedsDaoOperations.retrieveAllData()");
			finalOutputs = (List<FinalOutput>) truemedsJpaOutputRepository.findAll();
			if (finalOutputs.isEmpty()) {
				log.error("Got empty response from database");
				return null;
			}
		} catch (Exception e) {
			log.error("Exception while fetching the data : {}", e.getMessage());
		}
		return finalOutputs;

	}

}
