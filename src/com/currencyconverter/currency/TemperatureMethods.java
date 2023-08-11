/**
 * Esta clase contiene los metodos necesarios para la conversion de temperaturas.
 * 
 * @author edmendez
 */

package com.currencyconverter.currency;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class TemperatureMethods{
	
	/**
	 * Generates and returns an array of possible combinations between temperature units.
	 * Combinations consist of source and destination unit pairs, excluding identical pairs.
	 * 
	 * @return - An array of temperature unit combinations.
	 */
	public static Object[] getCombination() {
		Object[] temperature = {"Celsius", "Fahrenheit", "Kelvin"};
		Set<String> typeCombination = new LinkedHashSet<>();
		for (Object origin : temperature) {
			for (Object destiny : temperature) {
				if (!destiny.equals(origin)) typeCombination.add(origin + " a " + destiny);
			}
		}
		return typeCombination.toArray();
	}
	
	/**
	 * Creates and returns a HashMap representing a combination of source and destination units.
	 * Use the information provided to extract the units and build the HashMap.
	 * 
	 * @param option - Fix unit combination options.
	 * @param type - Type of combination selected.
	 * @return - A HashMap with the keys "Origin" and "Destiny" representing the source and destination units respectively.
	 */
	public static HashMap<String, String> value(Object[] option, Object type) {
		int index = CurrencyMethods.searchIndex(option, type);
		String optionCurrency = (String) option[index];
		String[] divideIntoParts = optionCurrency.split(" ");
		HashMap<String, String> tempHashMap = new HashMap<>();
		tempHashMap.put("Origin", divideIntoParts[0]);
		tempHashMap.put("Destiny", divideIntoParts[2]);
		return tempHashMap;
	}
	
	/**
	 * Perform a temperature conversion using the formulas and combination of units shown.
	 * Applies the corresponding formula according to the combination of temperature units and returns the formatted result.
	 * 
	 * @param celsius - HashMap that stores the conversion formulas for Celsius.
	 * @param fahrenheit - HashMap that stores the conversion formulas for Fahrenheit.
	 * @param kelvin - HashMap that stores the conversion formulas for Kelvin.
	 * @param temperatureCombination - HashMap that stores the combination of temperature units to convert.
	 * @param temperatura - The temperature to convert.
	 * @return - A formatted String representing the converted temperature.
	 */
	public static String convertion(HashMap<String, ConversionFormula> celsius, 
									HashMap<String, ConversionFormula> fahrenheit, 
									HashMap<String, ConversionFormula> kelvin, 
									HashMap<String, String> temperatureCombination,
									double temperatura) {
		DecimalFormat df = new DecimalFormat("0.00");
		ConversionFormula formula;
		if (temperatureCombination.get("Destiny").equals("Celsius")) {
			formula = celsius.get(temperatureCombination.get("Origin"));
	
		}else if (temperatureCombination.get("Destiny").equals("Fahrenheit")){
			formula = fahrenheit.get(temperatureCombination.get("Origin"));
		}else {
			formula = kelvin.get(temperatureCombination.get("Origin"));
		}
		return df.format(formula.convert(temperatura));
	}
}
