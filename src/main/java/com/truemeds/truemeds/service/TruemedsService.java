package com.truemeds.truemeds.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.truemeds.truemeds.model.FinalOutput;
import com.truemeds.truemeds.model.InputDetails;
import com.truemeds.truemeds.repository.TruemedsDaoOperations;

@Service
public class TruemedsService {
	private static final Logger log = LoggerFactory.getLogger(TruemedsService.class);

	@Autowired
	TruemedsDaoOperations truemedsDaoOperations;

	public List<FinalOutput> runAssignment(int id) {
		log.debug("Start of runAssignment(id)");
		List<InputDetails> inputDetails = truemedsDaoOperations.retrieveAllData();

		FinalOutput finalOutput = removeDumplicatesFromString(inputDetails.get(id).getInput_string());
		
		truemedsDaoOperations.saveData(finalOutput);
		
		return truemedsDaoOperations.retrieveFinalOutput();
	}

	public FinalOutput removeDumplicatesFromString(String inputString) {
		FinalOutput finalOutput = new FinalOutput();
		AtomicInteger atomicInteger = new AtomicInteger();
		Set<Character> chars = new HashSet<>();
		StringBuilder output = new StringBuilder(inputString.length());
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			if (chars.add(ch)) {
				output.append(ch);
				atomicInteger.getAndIncrement();
			}
		}
		
		finalOutput.setCount(atomicInteger.get());
		finalOutput.setOutput(output.toString().replaceAll("\\s", ""));
		finalOutput.setNameDate("Narender_Flora_" + new Date().toString());
		return finalOutput;

	}

	public List<FinalOutput> runAssignment() {
		return null;
	}

}
