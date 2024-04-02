package utils;

import java.util.Scanner;

public class Utils {
    Scanner scanner = new Scanner(System.in);
    public static void pulsaParaCuntinuar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una letra para volver al menu:");
        scanner.nextLine();
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public static void siguienteDato(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una letra para continuar...");
        scanner.nextLine();
    }
    public static void cargando(){
        System.out.print("Calculando");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
        System.out.println();
    }

    public static void cierraSesion(){
        System.out.print("Cerrando sesión");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
        System.out.println();
    }

    public static void apagando(){
        System.out.print("Apagando");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
        System.out.println();
    }

    public static void saliendo(){
        System.out.print("Saliendo");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
        System.out.println();
    }

    public static boolean validaEntradaNumero(String entrada){
        try {
            Integer.parseInt(entrada);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Debes introducir un número");
            return false;
        }
    }
}
