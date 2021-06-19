package com.truemeds.helper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.truemeds.truemeds.model.FinalOutput;

@Component
public class TruemedsHelper {

	public FinalOutput removeDumplicatesFromString(String inputString) {
		FinalOutput finalOutput = new FinalOutput();

		StringBuffer stringBuffer = new StringBuffer();
		inputString.chars().distinct().forEach(is -> stringBuffer.append(is));

		finalOutput.setOutput(stringBuffer.toString());
		finalOutput.setNameDate("Narender_Flora_" + new Date().toString());
		return finalOutput;

	}

}
