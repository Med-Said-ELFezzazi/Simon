package ej2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicadorValidado extends DuplicadorDeArchivo {

    private static final char[] CARACTERES_IGNORADOS = {'a', 'e', 'i', 'o', 'u', ' '}; // Ejemplo: ignorar vocales y espacios

    public DuplicadorValidado(String nombre) {
        super(nombre);
    }

    public DuplicadorValidado() {
        super();
    }

    @Override
    public boolean duplicar(String nombreDestino) {
        File archivoOrigen = new File(super.nombre);
        File archivoDestino = new File(nombreDestino);

        // Verificar que el archivo origen exista y no sea el mismo que el destino
        if (!archivoOrigen.exists()) {
            System.out.println("El archivo origen no existe.");
            return false;
        }

        if (archivoOrigen.equals(archivoDestino)) {
            System.out.println("El archivo origen y destino no pueden ser el mismo.");
            return false;
        }

        try (FileReader fr = new FileReader(archivoOrigen); FileWriter fw = new FileWriter(archivoDestino)) {
            int c;
            while ((c = fr.read()) != -1) {
                if (!debeIgnorarse((char) c)) {
                    fw.write(c);
                }
            }
            return true; // Copia realizada con éxito
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Copia fallida
        }
    }

    private boolean debeIgnorarse(char caracter) {
        for (char cIgnorado : CARACTERES_IGNORADOS) {
            if (cIgnorado == caracter) {
                return true;
            }
        }
        return false;
    }
}
