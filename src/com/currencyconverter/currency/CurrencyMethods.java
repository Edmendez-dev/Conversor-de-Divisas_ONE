/**
 * Clase que contiene todos los metodos para la conversion de monedas.
 * 
 * @author edmendez
 */

package com.currencyconverter.currency;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class CurrencyMethods {

	/**
	 * Converts an amount of money between the local currency and a foreign currency.
	 * This method takes three maps representing exchange rates between local currency and foreign currencies,
	 * as well as a currency option that specifies the direction of the conversion. The currency option must be in one
	 * of the following formats: "From Dollar to {currency}" or "From {currency} to Dollar". If the currency option indicates a conversion
	 * from local currency to a foreign currency, the "localToCurrency" map is used to get the exchange rate and is
	 * performs the conversion. If the currency option indicates a conversion from a foreign currency to the local currency, it is used
	 * the "currencyToLocal" map to get the exchange rate and convert in reverse.
	 * 
	 * @param localToCurrency - A HashMap representing the exchange rates from local currency to foreign currencies.
	 * @param currencyToLocal - A HashMap representing the exchange rates of foreign currencies to local currency.
	 * @param currency - A HashMap containing information about the currency option and the currencies involved in the conversion.
	 * @param cantidad - The amount of money to be converted.
	 * @return - A string representing the result.
	 */
	public static String convertion(HashMap<String, Double> localToCurrency, HashMap<String, Double> currencyToLocal, HashMap<String, String> currency, double cantidad) {
		DecimalFormat df = new DecimalFormat("0.00");
		if (!currency.get("Destiny").equals("Dolár")) {
			return df.format(cantidad * localToCurrency.get(currency.get("Destiny")));
		}else {
			return df.format(cantidad * currencyToLocal.get(currency.get("Origin")));
		}
	}


	/**
	 * Converts an array of options and a type to a HashMap representing the source and destination unit.
	 * 
	 * 
	 * @param option - Array of options among which the type is searched.
	 * @param type -Type of unit to look for in the options array.
	 * @return - A HashMap with the keys "Origin" and "Destiny" representing the source and destination unit respectively.
	 */
	public static HashMap<String, String> value(Object[] option, Object type) {
		int index = searchIndex(option, type);
		String optionCurrency = (String) option[index];
		String[] divideIntoParts = optionCurrency.split(" ");

		HashMap<String, String> tempHasMap = new HashMap<String, String>();
		tempHasMap.put("Origin", divideIntoParts[1].equals("Dolár") ? "Dolár" : getKey(divideIntoParts, optionCurrency));
		tempHasMap.put("Destiny", divideIntoParts[1].equals("Dolár") ? getKey(divideIntoParts, optionCurrency) : "Dolár");
		return tempHasMap;
	}

	/**
	 * Gets the key (code) of a currency from a select array and a currency option.
	 * 
	 * This method takes a selection array and a currency option in text format. If the selection arrangement
	 * has more than 4 elements, the currency option is processed to obtain the corresponding currency key.
	 * The currency option can be in two formats: "From Dollar to {currency}" or "From {currency} to Dollar". If it's in the
	 * first format, get the key of the coin at position [1] of the selection array. If you are in the second
	 * format, get the key of the currency at position [3] of the select array.
	 * 
	 * 
	 * @param selection - A selection array containing information about the chosen currency.
	 * @param optionCurrency - A currency option in text format, representing a currency conversion.
	 * @return - The key (code) of the currency corresponding to the selected option.
	 */
	public static String getKey(String[] selection, String optionCurrency) {
		if (selection.length > 4) {
			selection = optionCurrency.split(" a ", 2);
			selection = !selection[0].equals("De Dolár") ? selection[0].split("De ", 2) : selection;
		}
		return selection[1].equals("Dolár") ? selection[3] : selection[1];
	}

	/**
	 * Searches for an element in an array and returns its index if found
	 * 
	 * @param menu - An array of objects in which to search for the item. 
	 * @param tipo - The object to search for in the array.
	 * @return - The index of the first found element equal to the searched object, or -1 if not found.
	 */
	public static int searchIndex(Object[] menu, Object tipo) {
		for (int i = 0; i < menu.length; i++) {
			if (menu[i].equals(tipo)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets a combination of currencies to convert between local and foreign currencies.
	 * 
	 * This method takes two maps representing the exchange rates between local currency and foreign currencies.
	 * Generates a list of possible combinations between local currency and foreign currencies, both to convert
	 * from local currency to foreign currency as to convert from foreign currency to local currency.
	 * Combinations are returned in an array of objects.
	 * 
	 * @param localToCurrency - A HashMap representing the exchange rates from local currency to foreign currencies.
	 * @param currencyToLocal - A HashMap representing the exchange rates of foreign currencies to local currency.
	 * @return - An array of objects containing the currency combinations available for conversion.
	 */
	public static Object[] getCombinationOfCurrency(HashMap<String, Double> localToCurrency, HashMap<String, Double> currencyToLocal) {
		Set<String> currency = new LinkedHashSet<>();

		//WE ADD TO THE VECTOR THE COMBINATION OF LOCAL CURRENCY TO CURRENCY
		for (String i : localToCurrency.keySet()) {
			String combination = "De Dolár a " + i;
			currency.add(combination);
		}

		//WE ADD TO THE VECTOR THE COMBINATION OF CURRENCY TO LOCAL CURRENCY
		for (String i : currencyToLocal.keySet()) {
			String combination ="De " + i + " a Dolár";
			currency.add(combination);
		}
		return currency.toArray();
	}
}
