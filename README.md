![Badge en Desarollo](https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green)
# Conversor de Divisas y Temperaturas

Aplicación Java para convertir entre diferentes monedas y temperaturas. Este proyecto se realizo para poner en practica
todos los temas relacionados a Backend con Java, proporcionados por [Alura Latam](https://www.aluracursos.com/) bajo el programa de educación [ONE - Oracle Next Education](https://www.oracle.com/lad/education/oracle-next-education/)


## Tabla de Contenidos

- [Descripción](#descripción)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Ejemplos](#ejemplos)
- [Error](#error)
- [Contribución](#contribución)

## Descripción

Este proyecto consiste en una aplicación Java que permite convertir entre diferentes monedas y temperaturas. 
La aplicación utiliza clases y HashMaps para manejar las conversiones y las opciones de menú.

## Requisitos

- Java JDK 8 o superior instalado en tu sistema.
- Bibliotecas externas utilizadas:
  - [Swing](https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html) - Para la interfaz gráfica.
  - Otras bibliotecas mencionadas en el código, como `com.currencyconverter.currency.HashMapData`, `com.currencyconverter.currency.TemperatureMethods`, etc.

## Instalación

1. Clona este repositorio a tu máquina local.
2. Asegúrate de tener Java JDK instalado y configurado.
3. Compila el proyecto usando el comando: `javac Main.java`.

## Uso

1. Ejecuta el programa compilado con el comando: `java Main`.
2. Selecciona el tipo de conversión que deseas realizar: Moneda o Temperatura.
3. Sigue las instrucciones en pantalla para ingresar la cantidad y las opciones de conversión.

## Ejemplos

### Conversión de Moneda :moneybag:
  
  ![Ventana principal con opciones de conversion](/assets/images/ventana_PrincipalMenu.png) ![Ventana principal del menu](/assets/images/ventana_Principal.png)
  
- En la siguiente ventana agregamos la cantidad que deseamos convertir: €120.00 Euros
  
  ![Ventana para ingresar la cantidad a convertir](/assets/images/ventana_Cantidad.png)
  
- Seguido seleccionamos la conversion que deseamos: Euro a Dolár
  
  ![Ventana con opciones a convertir](/assets/images/ventana_TiposConversion.png)

  Las posibles conversiones son:
    - Dolár a Euro
    - Dolár a Libras Esterlinas
    - Dolár a Yen Japonés
    - Dolár a Won sul-coreano
    - Euro a Dolár
    - Libras Esterlinas a Dolár
    - Yen Japonés a Dolár
    - Won sul-coreano a Dolár
      
- La siguiente ventana nos mostrara un mensaje con el valor convertido: En total €120.00 Euros equivalen a $134.40 Doláres

  ![Ventana con el valor convertido](/assets/images/ventana_Total.png)

  > Nota: Los valores equivalentes a cada moneda fueron tomados hasta la fecha de este repositorio (Agosto - 2023).
  
- En esta ventana nos preguntara si deseamos continuar

  ![Ventana que pregunta si deseamos continuar](/assets/images/ventana_DeseaSeguir.png)

    - Cancel: Terminara el programa.
    - No: Terminara el programa.
    - Yes: Regresara al [menu principal](/assets/images/ventana_Principal.png)
      
- Si seleccionamos __Cancel__ ó __No__ terminara el programa.

  ![Ventana programa terminado](/assets/images/ventana_Terminado.png)


  
### Conversion de Temperatura :thermometer:
- Seleccionamos __Conversor de Temperatura__
  
  ![Ventana principal con opcion conversor temperatura](/assets/images/ventana_PrincipalTemp.png)
  
- Agregamos la cantidad a convertir: 32°C

  ![Ventana con cantidad de temperatura a convertir](/assets/images/ventana_CantidadTemp.png)

- Elejimos el tipo de temperatura que deseamos convertir: Celsius a Fahrenheit

  ![Ventana con opciones de temperatura a convertir](/assets/images/ventana_TiposTemp.png)

  Las posibles conversiones son:
    - Celsius a Fahrenheit
    - Celsius a Kelvin
    - Fahrenheit a Celsius
    - Fahrenheit a Kelvin
    - Kelvin a Celsius
    - Kelvin a Fahrenheit
 
- Al aceptar, nos mostrara el siguiente mensaje con el valor convertido
  
  ![Ventana con la temperatura convertida](/assets/images/ventana_ResultadoTemp.png)
  
## Error

Debemos prestar atención al agregar un valor a convertir

![Ventana con cantidad de temperatura a convertir](/assets/images/ventana_CantidadTemp.png)

Debe ser valores tipo numerico (double, int), puesto si agregamos letras, nos arrojara un error.

![Ventana de error al ingresar la cantidad](/assets/images/valorNoValido.png)

## Contribución

¡Contribuciones son bienvenidas! Si tienes sugerencias, correcciones o mejoras, siéntete libre de abrir un issue o enviar un pull request.
