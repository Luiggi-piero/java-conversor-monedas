package com.kronos.conversormonedas.principal;

import com.kronos.conversormonedas.calculos.ConversorMonedas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String menu = """
                #######################################
                Bienvenido(a) al conversor de Monedas
                
                1. Dólar >> Peso Argentino
                2. Peso Argentino >> Dólar
                3. Dólar >> Real brasileño
                4. Real brasileño >> Dólar
                5. Dólar >> Peso colombiano
                6. Peso colombiano >> Dólar
                7. Salir
                
                Eliga una opción válida: 
                #######################################
                """;
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        ConversorMonedas conversor = new ConversorMonedas();

        Map<String, String> codigos = new HashMap<>();
        codigos.put("dolar", "USD");
        codigos.put("pesos-argentinos", "ARS");
        codigos.put("real-brasilenio", "BRL");
        codigos.put("peso-colombiano", "COP");

        Double valor = 0.0;
        Double valorFinal = 0.0;


        while (opcion != 7){
            System.out.println(menu);
            opcion = lectura.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = lectura.nextDouble();
                    valorFinal = conversor.convertirMoneda(
                            codigos.get("dolar"),
                            valor,
                            codigos.get("pesos-argentinos"));

                    mostrarResultado(
                            codigos.get("dolar"),
                            valor,
                            codigos.get("pesos-argentinos"),
                            valorFinal);
                    break;
                case 2:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = lectura.nextDouble();
                    valorFinal = conversor.convertirMoneda(
                            codigos.get("pesos-argentinos"),
                            valor,
                            codigos.get("dolar"));

                    mostrarResultado(
                            codigos.get("pesos-argentinos"),
                            valor,
                            codigos.get("dolar"),
                            valorFinal);
                    break;
                case 3:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = lectura.nextDouble();
                    valorFinal = conversor.convertirMoneda(
                            codigos.get("dolar"),
                            valor,
                            codigos.get("real-brasilenio"));

                    mostrarResultado(
                            codigos.get("dolar"),
                            valor,
                            codigos.get("real-brasilenio"),
                            valorFinal);
                    break;
                case 4:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = lectura.nextDouble();
                    valorFinal = conversor.convertirMoneda(
                            codigos.get("real-brasilenio"),
                            valor,
                            codigos.get("dolar"));

                    mostrarResultado(
                            codigos.get("real-brasilenio"),
                            valor,
                            codigos.get("dolar"),
                            valorFinal);
                    break;
                case 5:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = lectura.nextDouble();
                    valorFinal = conversor.convertirMoneda(
                            codigos.get("dolar"),
                            valor,
                            codigos.get("peso-colombiano"));

                    mostrarResultado(
                            codigos.get("dolar"),
                            valor,
                            codigos.get("peso-colombiano"),
                            valorFinal);
                    break;
                case 6:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = lectura.nextDouble();
                    valorFinal = conversor.convertirMoneda(
                            codigos.get("peso-colombiano"),
                            valor,
                            codigos.get("dolar"));

                    mostrarResultado(
                            codigos.get("peso-colombiano"),
                            valor,
                            codigos.get("dolar"),
                            valorFinal);
                    break;
                case 7:
                    System.out.println("Programa terminado");
                    break;
                default:
                    System.out.println("Elija una opción válida");
            }

        }
    }

    private static void mostrarResultado(String codigoOrigen, Double valor, String codigoDestino, Double valorFinal){
        System.out.println("El valor "
                + valor + "["+ codigoOrigen +"] corresponde al valor final de "
                + valorFinal+ "["+codigoDestino+"]");
    }
}
