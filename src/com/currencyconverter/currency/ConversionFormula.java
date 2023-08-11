/**
 * Hubo la necesidad de almacenar expresiones de fórmulas de conversión 
 * como valores en un HashMap. Dado que no se puede almacenar directamente una expresión 
 * matemática en un HashMap, una solución es usar interfaces funcionales y expresiones lambda 
 * para lograr esto.
 * 
 * Por ese motivo definimos una interfaz funcional que represente una fórmula de conversión
 * 
 * @author edmendez
 */

package com.currencyconverter.currency;

/**
 * Interface that defines the contract for the conversion formulas.
 * Classes that implement this interface must provide an implementation
 * of the conversion method that takes an input value and returns the converted value.
 */
public interface ConversionFormula {
	
	/**
	 * Performs input value conversion according to the specified conversion formula.
	 * 
	 * @param input - The value to be converted.
	 * @return - The converted value according to the conversion formula.
	 */
	double convert(double input);
}
