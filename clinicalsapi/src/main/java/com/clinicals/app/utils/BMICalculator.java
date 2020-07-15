package com.clinicals.app.utils;

import java.util.List;

import com.clinicals.app.entities.ClinicalData;

public class BMICalculator {

	public static void calculateBMI(List<ClinicalData> clinicalData, ClinicalData eachEntry) {
		if (eachEntry.getComponentName().equals("hw")) {
			String[] heightAndWeight = eachEntry.getComponentValue().split("/");
			if (heightAndWeight != null && heightAndWeight.length != 0) {
				float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536f;
				float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
				ClinicalData bmiData = new ClinicalData();
				bmiData.setComponentName("bmi");
				bmiData.setComponentValue(Float.toString(bmi));
				clinicalData.add(bmiData);
			}
		}
	}

}
