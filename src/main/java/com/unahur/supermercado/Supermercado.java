/**
 @author Thiago Quitana
 **/

/*
 - Universidad Nacional de Hurligham
 - Trabajo final Introducción a Java
 - Ejercicio 2
*/

package com.unahur.supermercado;
import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Detergente detergente = crearDetergenteDesdeInput(scanner);
        Cereales cereales = crearCerealesDesdeInput(scanner);
        Vino vino = crearVinoDesdeInput(scanner);

        ArrayList<EsAlimento> productosAlimenticios = new ArrayList<>();
        productosAlimenticios.add(cereales);

        detergente.setVolumen(1.5); 
        vino.setVolumen(1.5); 
        ArrayList<EsLiquido> productosLiquidos = new ArrayList<>();
        productosLiquidos.add(detergente); 
        productosLiquidos.add(vino); 

        double sumaVolumen = 0.0;
        for (EsLiquido producto : productosLiquidos) {
            sumaVolumen += producto.getVolumen();
        }

        System.out.println("Suma total de volumen: " + sumaVolumen);

        int sumaCalorias = 0;
        for (EsAlimento producto : productosAlimenticios) {
            sumaCalorias += producto.getCalorias();
        }

        System.out.println("Suma total de calorías: " + sumaCalorias);
    }

    private static Detergente crearDetergenteDesdeInput(Scanner scanner) {
        System.out.println("Ingrese la marca del detergente:");
        String marca = scanner.nextLine();

        double precio = 0.0;

        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Ingrese el precio del detergente:");

            try {
                precio = Double.parseDouble(scanner.nextLine());
                entradaValida = true;  // Salir del bucle si la conversión es exitosa
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para el precio.");
            }
        }

        Detergente detergente = new Detergente(marca, precio);

        return detergente;
    }

    private static Cereales crearCerealesDesdeInput(Scanner scanner) {
        System.out.println("---------------------------------");
        System.out.println("Ingrese la marca de los cereales:");
        String marca = scanner.nextLine();

        double precio = 0.0;

        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Ingrese el precio de los cereales:");

            try {
                precio = Double.parseDouble(scanner.nextLine());
                entradaValida = true;  // Salir del bucle si la conversión es exitosa
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para el precio.");
            }
        }

        System.out.println("Ingrese el tipo de cereal (espelta, maíz, trigo, u otro):");
        String tipoCereal = scanner.nextLine();

        Cereales cereales = new Cereales(marca, precio, tipoCereal);

        return cereales;
    }

    private static Vino crearVinoDesdeInput(Scanner scanner) {
        System.out.println("---------------------------------");
        System.out.println("Ingrese la marca del vino:");
        String marca = scanner.nextLine();

        double precio = 0.0;
        double gradosAlcohol = 0.0;

        // Validar la entrada del usuario para el precio
        boolean entradaValidaPrecio = false;
        while (!entradaValidaPrecio) {
            System.out.println("Ingrese el precio del vino:");

            try {
                precio = Double.parseDouble(scanner.nextLine());
                entradaValidaPrecio = true;  
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para el precio.");
            }
        }

        boolean entradaValidaGrados = false;
        while (!entradaValidaGrados) {
            System.out.println("Ingrese los grados de alcohol del vino:");

            try {
                gradosAlcohol = Double.parseDouble(scanner.nextLine());
                entradaValidaGrados = true;  // Salir del bucle si la conversión es exitosa
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para los grados de alcohol.");
            }
        }

        Vino vino = new Vino(marca, "TipoVino", gradosAlcohol, precio);
        return vino;
    }
}
