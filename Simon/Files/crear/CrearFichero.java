package crear;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrearFichero {
	
	
	public static void main(String[] args) {
		
	
	    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("nums.bin"))) {
	        System.out.println("Introduzca números enteros (0 para terminar):");
	        int num;
	        while ((num = Consola.leeInt()) != 0) {
	            dos.writeInt(num);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
