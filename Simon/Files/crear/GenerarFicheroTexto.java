package crear;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class GenerarFicheroTexto {

	
	public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("nums.bin"));
                PrintWriter pw = new PrintWriter("nums.txt")) {
               while (true) {
                   try {
                       int num = dis.readInt();
                       pw.println(num);
                   } catch (IOException e) {
                       // Fin de archivo alcanzado
                       break;
                   }
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
}
