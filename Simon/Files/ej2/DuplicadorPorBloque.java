package ej2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicadorPorBloque extends DuplicadorDeArchivo {

    public DuplicadorPorBloque(String nombre) {
        super(nombre);
    }

    public DuplicadorPorBloque() {
        super();
    }

    @Override
    public boolean duplicar(String nombreDestino) {    // Ahora devuelve booleano
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

        // Definir el tamaño del bloque a leer y escribir
        final int TAMANIO_BLOQUE = 20;
        char[] buffer = new char[TAMANIO_BLOQUE];

        try (FileReader fr = new FileReader(archivoOrigen); FileWriter fw = new FileWriter(archivoDestino)) {
            int caracteresLeidos;
            // Leer el archivo en bloques de 20 caracteres y escribir esos bloques en el archivo destino
            while ((caracteresLeidos = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, caracteresLeidos);
            }
            return true; // Copia realizada con éxito
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Copia fallida
        }
    }
}
