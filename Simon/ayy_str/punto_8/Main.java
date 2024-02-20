package punto_8;

import java.util.Scanner;

import paquete.Consola;

public class Main {

    private static char[] array;
    private static int elementosUtiles = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar el array de tamaño fijo, por ejemplo 10
        array = new char[10];

        cargar();
        verArray();

        // Bucle para insertar caracteres
        boolean continuar = true;
        while(continuar) {
            System.out.println("¿Desea insertar otro carácter? (S/N)");
            char respuesta = scanner.next().charAt(0);
            if(respuesta == 'S' || respuesta == 's') {
                insertarCar();
            } else {
                continuar = false;
            }
        }

        verArray(); // Mostrar el array después de las inserciones
    }

    public static void cargar() {
        do {
            System.out.println("Introduce un carácter:");
            char car = Consola.leeChar(); // scanner.next().charAt(0);

            if(elementosUtiles < array.length) {
                array[elementosUtiles] = car;
                elementosUtiles++;
            } else {
                System.out.println("El array está lleno. No se pueden introducir más caracteres.");
                break;
            }

            System.out.println("¿Desea introducir otro carácter? (S/N)");
        } while(scanner.next().equalsIgnoreCase("S"));
    }

    public static void verArray() {
        for(int i = 0; i < elementosUtiles; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // Salto de línea al final
    }

    public static void insertarCar() {
        if(elementosUtiles < array.length) {
            System.out.println("Introduce el carácter a insertar:");
            char car = Consola.leeChar();
            System.out.println("Introduce la posición donde insertar:");
            int posicion = Consola.leeInt();

            if(posicion < 0 || posicion > elementosUtiles) {
                System.out.println("Posición inválida.");
                return;
            }

            // Desplazar elementos hacia la derecha
            for(int i = elementosUtiles; i > posicion; i--) {
                array[i] = array[i-1];
            }

            array[posicion] = car;
            if(elementosUtiles < array.length) {
                elementosUtiles++;
            }
        } else {
            System.out.println("El array está lleno. No se pueden insertar más caracteres.");
        }
    }

}
