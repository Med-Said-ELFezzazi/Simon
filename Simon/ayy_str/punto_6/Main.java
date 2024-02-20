package punto_6;

import paquete.Consola;

public class Main {

	public static void main(String[] args) {
		
		float[] array = new float[10];
		// 99, 33, 21, 20 ,2 ...
		System.out.println("Inserta un número (float) : ");
		int cont = 0;
		float num = Consola.leeFloat();
		array[0] = num;
		for (int i=1; i< array.length; i++) {
			num = Consola.leeFloat();
			while (num > array[cont]) {
				System.out.println("el numero tiene que ser menor o igual al anterior :");
				num = Consola.leeFloat();
			}
			array[i] = num;				
			cont++;
		}

		System.out.println("Resutl");
		for (float f : array) {
			System.out.println(f);
		}
	}
}
