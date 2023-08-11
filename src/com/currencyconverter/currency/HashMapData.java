/**
 * Esta clase contiene todos los HashMaps necesarios para las conversiones, tanto para monedas 
 * como temperaturas.
 * 
 * Entre los HashMaps estan los que contienen valores importantes para su conversion, simbolos monetarios
 * y simbolos de temperatura, formulas.
 * 
 * 
 * 
 * @author edmendez
 */


package com.currencyconverter.currency;
import java.util.HashMap;

public class HashMapData {
	
	public static HashMap<String, Double> getLocalToCurrency() {
		//LOCAL CURRENCY -> CURRENCY
		HashMap<String, Double> localToCurrency = new HashMap<String, Double>();
		localToCurrency.put("Dolár", 1.00);
		localToCurrency.put("Euro", 0.89);
		localToCurrency.put("Libras Esterlinas", 0.76);
		localToCurrency.put("Yen Japonés", 138.69);
		localToCurrency.put("Won sul-coreano", 1269.33);
		return localToCurrency;
	}
	
	public static HashMap<String, Double> getCurrencyToLocal() {
		//CURRENCY -> LOCAL CURRENCY
		HashMap<String, Double> currencyToLocal = new HashMap<String, Double>();
		currencyToLocal.put("Dolár", 1.00);
		currencyToLocal.put("Euro", 1.12);
		currencyToLocal.put("Libras Esterlinas", 1.31);
		currencyToLocal.put("Yen Japonés", 0.0072);
		currencyToLocal.put("Won sul-coreano", 0.00079);
		return currencyToLocal;
	}
	
	public static HashMap<String, String> getCurrencySymbol() {
		//CURRENCY SYMBOL
		HashMap<String, String> currencySymbol = new HashMap<String, String>();
		currencySymbol.put("Dolár", "$");
		currencySymbol.put("Euro", "€");
		currencySymbol.put("Libras Esterlinas", "£");
		currencySymbol.put("Yen Japonés", "¥");
		currencySymbol.put("Won sul-coreano", "₩");
		return currencySymbol;
	}
	
	public static HashMap<String, String> getCurrency() {
		//CURRENCY SYMBOL
		HashMap<String, String> currency = new HashMap<String, String>();
		currency.put("Dolár", "Doláres");
		currency.put("Euro", "Euros");
		currency.put("Libras Esterlinas", "Libras Esterlinas");
		currency.put("Yen Japonés", "Yenes Japonés");
		currency.put("Won sul-coreano", "Won sul-coreanos");
		return currency;
	}	
	
	public static HashMap<String, ConversionFormula> getCelsius() { //celsius
		HashMap<String, ConversionFormula> celsius = new HashMap<>();
		celsius.put("Fahrenheit",temp -> (temp - 32) * 5/9);
		celsius.put("Kelvin", temp -> temp - 273.15);
		return celsius;
	}
	
	public static HashMap<String, ConversionFormula> getFahrenheit() { //fahrenheit 
		HashMap<String, ConversionFormula> fahrenheit = new HashMap<>();
		fahrenheit.put("Celsius",temp -> (temp * 9/5) + 32);
		fahrenheit.put("Kelvin", temp -> (temp - 273.15) * 9/5 + 32);
		return fahrenheit;
	}
	
	public static HashMap<String, ConversionFormula> getKelvin() { //kelvin 
		HashMap<String, ConversionFormula> kelvin = new HashMap<>();
		kelvin.put("Fahrenheit",temp -> (temp - 32) * 5/9 + 273.15);
		kelvin.put("Celsius", temp -> temp + 273.15);
		return kelvin;
	}
	
	public static HashMap<String, String> getTempSymbol() {
		HashMap<String, String> symbol = new HashMap<String, String>();
		symbol.put("Celsius", "°C");
		symbol.put("Fahrenheit", "°F");
		symbol.put("Kelvin", "K");
		return symbol;
		
	}
}
