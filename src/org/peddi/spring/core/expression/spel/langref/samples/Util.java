package org.peddi.spring.core.expression.spel.langref.samples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Util {
	
	public String regularExpression = "^-?\\d+(\\.\\d{2})?$";

	
	public static List<Inventor> getInventors(){
		List<Inventor> inventors = new ArrayList<>();
		
		Inventor tesla = new Inventor(
				"Nikola Tesla",
				 LocalDate.of(1856,7,9),
				"Serbian");
		tesla.setPlaceOfBirth(new PlaceOfBirth("Serbia", "Serbia"));
		tesla.setInventions(new String[] { "Tesla", "Gravity","Inducton" });
		inventors.add(tesla);
		
		Inventor pupin = new Inventor(
				"Mihajlo Pupin",
				LocalDate.of(1956, 8, 19),
				"America");
		pupin.setPlaceOfBirth(new PlaceOfBirth("Idvor", "America"));
		pupin.setInventions(new String[] {"SurfaceTension", "Bulb", "Motor"});
		inventors.add(pupin);
		
		return inventors;
	}
	
	public static Society getSociety() {
		
		Society soc = new Society();
		soc.setName("IEEE Society");
		soc.getMembers().addAll(getInventors());
		soc.getOfficers().put(Society.President, getInventors().get(1));
		soc.getOfficers().put(Society.Advisors, getInventors() );
		
		return soc;
	}
	
	public static String reverseString(String input) {
		int len = input.length();
		StringBuilder result = new StringBuilder(len);
		
		char[] dataIn = input.toCharArray();
		
		for(int i = len-1; i>=0; i--) {
			result.append(dataIn[i]);
		}
		
		
		return result.toString();
	}

}
