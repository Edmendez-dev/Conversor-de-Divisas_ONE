/**
 * Challenge Back End Java - Conversor 
 * ONE - Oracle Next Education, Alura Latam
 * 
 * Esta es la clase principal que inicia el programa de conversión de temperatura y moneda.
 * Permite al usuario realizar conversiones entre diferentes unidades de temperatura y moneda.
 * 
 * @author edmendez
 * @version 1.0
 */

import java.util.HashMap;
import javax.swing.JOptionPane;
import com.currencyconverter.currency.HashMapData;
import com.currencyconverter.currency.TemperatureMethods;
import com.currencyconverter.currency.ConversionFormula;
import com.currencyconverter.currency.CurrencyMethods;

public class Main {

	public static void main(String[] args) {

		//HashMaps
		HashMap<String, Double> localToCurrency = HashMapData.getLocalToCurrency();
		HashMap<String, Double> currencyToLocal = HashMapData.getCurrencyToLocal();
		HashMap<String, String> currencySymbol = HashMapData.getCurrencySymbol();
		HashMap<String, String> currency = HashMapData.getCurrency();
		HashMap<String, ConversionFormula> celsius = HashMapData.getCelsius();
		HashMap<String, ConversionFormula> fahrenheit = HashMapData.getFahrenheit();
		HashMap<String, ConversionFormula> kelvin = HashMapData.getKelvin();
		HashMap<String, String> tempSymbol = HashMapData.getTempSymbol();

		//MENU
		Object[] tipo_conversor = {"Conversor de Moneda", "Conversor de Temperatura"};	
		Object[] tipo_monedas = CurrencyMethods.getCombinationOfCurrency(localToCurrency, currencyToLocal);
		Object[] tipo_temperatura = TemperatureMethods.getCombination();

		//VARIABLE
		boolean seguir = true;
		boolean inputTrue = false;
		double cantidad = 0;

		while (seguir) {
			Object seleccion = JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, null, tipo_conversor, tipo_conversor[0]);
			while (!inputTrue) {
				try {
					cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que deseas convertir:"));
					inputTrue = true;
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valor no válido", "ALERTA", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if (CurrencyMethods.searchIndex(tipo_conversor, seleccion) == 0) {
				Object seleccionConversion = JOptionPane.showInputDialog(null, "Elige la moneda a la que deseas convertir tu dinero", "Moneda", JOptionPane.QUESTION_MESSAGE, null, tipo_monedas, tipo_monedas[0]);
				HashMap<String, String> conversion = CurrencyMethods.value(tipo_monedas, seleccionConversion);
				String totalCurrency = CurrencyMethods.convertion(localToCurrency, currencyToLocal, conversion, cantidad);
				JOptionPane.showMessageDialog(null, "Tienes " + currencySymbol.get(conversion.get("Destiny")) + totalCurrency + " " + currency.get(conversion.get("Destiny")),"Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}else {
				Object seleccionTemp = JOptionPane.showInputDialog(null, "Elige la temperatura que deseas convertir", "Temperatura", JOptionPane.QUESTION_MESSAGE, null, tipo_temperatura, tipo_temperatura[0]);
				HashMap<String, String> conversionTemp = TemperatureMethods.value(tipo_temperatura, seleccionTemp);
				String totalTemp = TemperatureMethods.convertion(celsius, fahrenheit, kelvin, conversionTemp, cantidad);
				JOptionPane.showMessageDialog(null, "De " + cantidad + tempSymbol.get(conversionTemp.get("Origin")) + " = " + totalTemp + tempSymbol.get(conversionTemp.get("Destiny")),"Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}
			
			int input = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION);
			if (input != 0) {
				JOptionPane.showMessageDialog(null, "Programa Terminado");
				seguir = false;
			}
			inputTrue = false;
		}
	}
}