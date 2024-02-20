package comprision_decompresion;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import crear.Consola;

public class Compresion {

    // Método para comprimir un archivo
    public static void comprimir(String nomFichOriginal) throws IOException {
        Path path = Paths.get(nomFichOriginal);
        byte[] data = Files.readAllBytes(path);
        
        try (FileOutputStream fos = new FileOutputStream(nomFichOriginal + ".cmp");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            
            for (int i = 0; i < data.length; ) {
                byte currentByte = data[i];
                int count = 1;
                while (++i < data.length && data[i] == currentByte) {
                    count++;
                }
                bos.write(currentByte);
                bos.write(count);
            }
        }
    }

    // Método para descomprimir un archivo
    public static void descomprimir(String nomFichComprimido) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dónde desea descomprimir el archivo?: ");
        String destino = Consola.leeString();
        
        Path path = Paths.get(nomFichComprimido);
        byte[] data = Files.readAllBytes(path);
        
        try (FileOutputStream fos = new FileOutputStream(destino);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            
            for (int i = 0; i < data.length; i += 2) {
                byte b = data[i];
                int count = Byte.toUnsignedInt(data[i + 1]);
                for (int j = 0; j < count; j++) {
                    bos.write(b);
                }
            }
        }
    }

    // Método para crear un archivo binario aleatorio
    public static void crearBinarioAleatorio(String nomFich) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(nomFich);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            
            for (int i = 0; i < 5; i++) {
                byte randomByte = (byte) ThreadLocalRandom.current().nextInt(1, 128);
                int repetitions = ThreadLocalRandom.current().nextInt(1, 501);
                for (int j = 0; j < repetitions; j++) {
                    bos.write(randomByte);
                }
            }
        }
    }

    // Método principal para probar la compresión y descompresión
    public static void main(String[] args) {
        try {
            String originalFile = "test.bin";
            crearBinarioAleatorio(originalFile);
            comprimir(originalFile);
            descomprimir(originalFile + ".cmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
