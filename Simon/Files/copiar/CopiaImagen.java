package copiar;

import java.io.*;
import java.nio.file.*;

public class CopiaImagen {

    // Método para copiar la imagen byte a byte.
    public static void copiarImagenByteAByte(String nombreArchivo) throws IOException {
        InputStream in = new FileInputStream(nombreArchivo);
        OutputStream out = new FileOutputStream(nombreArchivo.replace(".jpg", "_CPY.jpg"));
        
        int byteLeido;
        while ((byteLeido = in.read()) != -1) {
            out.write(byteLeido);
        }
        in.close();
        out.close();
    }

    // Método para copiar la imagen en bloques de N bytes.
    public static void copiarImagenPorBloques(String nombreArchivo, int tamanoBloque) throws IOException {
        InputStream in = new FileInputStream(nombreArchivo);
        OutputStream out = new FileOutputStream(nombreArchivo.replace(".jpg", "_CPY_BLK.jpg"));
        
        byte[] buffer = new byte[tamanoBloque];
        int bytesLeidos;
        while ((bytesLeidos = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesLeidos);
        }
        in.close();
        out.close();
    }

    // Método para copiar la imagen con una sola operación de lectura y de escritura.
    public static void copiarImagenConUnaOperacion(String nombreArchivo) throws IOException {
        Path origen = Paths.get(nombreArchivo);
        Path destino = Paths.get(nombreArchivo.replace(".jpg", "_CPY_ONE.jpg"));
        
        byte[] data = Files.readAllBytes(origen);
        Files.write(destino, data);
    }

    public static void main(String[] args) {
        try {
            String nombreArchivo = "logo.jpg"; // nombre de imagen.
            copiarImagenByteAByte(nombreArchivo);
            copiarImagenPorBloques(nombreArchivo, 512);
            copiarImagenConUnaOperacion(nombreArchivo);
            
            // Verificar que los archivos copiados tienen el mismo tamaño que el original.
            long originalSize = new File(nombreArchivo).length();
            long cpySize = new File(nombreArchivo.replace(".jpg", "_CPY.jpg")).length();
            long cpyBlkSize = new File(nombreArchivo.replace(".jpg", "_CPY_BLK.jpg")).length();
            long cpyOneSize = new File(nombreArchivo.replace(".jpg", "_CPY_ONE.jpg")).length();
            
            System.out.println("Original size: " + originalSize);
            System.out.println("Byte-by-byte copy size: " + cpySize);
            System.out.println("Block copy size: " + cpyBlkSize);
            System.out.println("Single operation copy size: " + cpyOneSize);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
