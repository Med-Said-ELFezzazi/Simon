package ej2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicarCar extends DuplicadorDeArchivo {

    public DuplicarCar(String nombre) {
        super(nombre);
    }

    public DuplicarCar() {
        super();
    }

    @Override
    public boolean duplicar(String nombreDestino) {
        File archivoOrigen = new File(super.nombre);
        File archivoDestino = new File(nombreDestino);

        // Verificar que el archivo origen exista.
        if (!archivoOrigen.exists()) {
            System.out.println("El archivo origen no existe.");
            return false;
        }

        // Verificar que el archivo origen y destino no sean el mismo.
        if (archivoOrigen.getAbsolutePath().equals(archivoDestino.getAbsolutePath())) {
            System.out.println("El archivo origen y destino no pueden ser el mismo.");
            return false;
        }

        try (FileReader fr = new FileReader(archivoOrigen); FileWriter fw = new FileWriter(archivoDestino)) {
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
            return true; // La copia se realizó con éxito.
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Hubo un error durante la copia.
        }
    }
}
