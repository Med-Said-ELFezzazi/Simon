package arrays_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import crear.Consola;

public class Descendente {
    private Float[] array; 
    //private int count; // Lleva la cuenta de la cantidad de elementos reales en el array

    public Descendente(int tamanoMaximo) {
        array = new Float[tamanoMaximo];
        //count = 0;
    }

    public void aniadeNum(float num) {
    	int count = 0;
        if (count < this.array.length) {
            array[count++] = num;			//O se puede añadir el valor y luego ordenar y ya
            Arrays.sort(array, Collections.reverseOrder());
        } else {
            System.out.println("El array está lleno. No se puede añadir más números.");
        }
    }

    public void ver() {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }
    
    //Borrar los elementos duplicados 		LO MISMO
    /*public  Float[] borrarDuplicados() {
        Set<Float> set = new LinkedHashSet<>(Arrays.asList(this.array));
        return set.toArray(new Float[0]);
    }*/
    
    // Método para eliminar duplicados y actualizar el array atributo
    public void borrarDuplicados() {
        Set<Float> set = new LinkedHashSet<>(Arrays.asList(this.array));
        // Actualiza el atributo array con un nuevo array sin duplicados
        this.array = set.toArray(new Float[0]);
        // Rellena el resto del array con null si es necesario
        if (this.array.length < this.array.length) {
            array = Arrays.copyOf(array, this.array.length);
        }
    }
    
    public void aniadeNumsArray(String nomFichero) {
        // Primero, eliminar los duplicados usando un LinkedHashSet para mantener el orden
        Set<Float> set = new LinkedHashSet<>(Arrays.asList(this.array));
        
        // Escribir los números únicos en el fichero
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichero))) {
            for (Float num : set) {
                if (num != null) {
                    writer.write(num.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void aniadeNumsRandom(int limiteInferior, int limiteSuperior, int cantidad, String nombreFichero) {
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            float randomNum = limiteInferior + rand.nextFloat() * (limiteSuperior - limiteInferior);
            aniadeNum(randomNum);
        }
        // añadir estos números al fichero especificado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero, true))) {
            int numerosGenerados = 0;
            while (numerosGenerados < cantidad) {
                float randomNum = limiteInferior + rand.nextFloat() * (limiteSuperior - limiteInferior);
                if (numerosExistentes.add(randomNum)) { // Intenta añadir el número al Set
                    writer.write(Float.toString(randomNum));
                    writer.newLine();
                    numerosGenerados++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void copiaFichero(String ficheroOrigen, String ficheroDestino) throws IOException {
        Path origenPath = Paths.get(ficheroOrigen);
        Path destinoPath = Paths.get(ficheroDestino);

        // Verificar si el archivo destino existe y preguntar al usuario qué hacer
        if (Files.exists(destinoPath)) {
            System.out.print("El archivo de destino ya existe. ¿Desea sobrescribirlo (S), añadir (A) o no hacer nada (N)? ");
            String respuesta = Consola.leeString();

            if ("N".equalsIgnoreCase(respuesta)) {
                System.out.println("No se realizará ninguna acción.");
                return;
            }

            if ("S".equalsIgnoreCase(respuesta)) {
                Files.delete(destinoPath); // Eliminar el archivo si se va a sobrescribir
            }
        }

        // Leer el archivo de origen y escribir el archivo de destino
        try (BufferedReader reader = Files.newBufferedReader(origenPath);
             BufferedWriter writer = Files.newBufferedWriter(destinoPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                // Tomar solo las líneas en posiciones impares
                if (lineNumber % 2 != 0) {
                    String[] numbers = line.split("\\s+");
                    for (String number : numbers) {
                        try {
                            int roundedNumber = Math.round(Float.parseFloat(number));
                            writer.write(Integer.toString(roundedNumber));
                            writer.write(" ");
                        } catch (NumberFormatException e) {
                            // Manejar la posibilidad de que no sea un número
                            System.out.println("El valor '" + number + "' no es un número válido y será ignorado.");
                        }
                    }
                    writer.newLine();
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    
}
