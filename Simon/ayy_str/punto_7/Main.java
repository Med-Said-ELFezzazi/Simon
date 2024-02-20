package punto_7;

import java.util.Arrays;

import paquete.Consola;

public class Main {
	
	static void carga(int tamanio) {	
		int[] array = new int[tamanio];
		System.out.println("Introduce numero: ");
		int num = Consola.leeInt();
		array[0] = num;
		int cont = 0;
		for (int i=1; i<array.length; i++) {
			num = Consola.leeInt();
			while (num <= array[cont]) {
				System.out.println("deberia introducir un numero mayor que el enterior:");
				num = Consola.leeInt();
			}
			array[i] = num;
			cont++;
		}
		System.out.print("array cargada exitosamente");
	}
	
	
	//Array mix de dos arrays ordenado ASC
	static int[] crea(int[] ar1, int[] ar2) {
		//Tamaño total del array de vuelta
		int tamanioTotal = ar1.length + ar2.length;
		int[] arrMix = new int[tamanioTotal];
		//ordinar los 2 arrays
		// Array 1
		int[] arr1Fin = new int[ar1.length];
		Arrays.sort(arr1Fin);			//ordenar
		// Array2
		int[] arr2Fin = new int[ar2.length];
		Arrays.sort(arr2Fin);

		// Mizclar los dos
		// Juntar los datos todos en desordenados en el arrayMix
		for (int i=0; i<ar1.length; i++) {
			arrMix[i] = ar1[i];
		}
		int count=0;
		for (int i=ar1.length; i<arrMix.length; i++) {
			arrMix[i] = ar2[count];
			count++;
		}
		//ordenar y devolver
		Arrays.sort(arrMix);
		return arrMix;
	}

	public static void main(String[] args) {
		
		//carga(4);

		int[] ar1 = {3, 89, 90, 200};
		int[] ar2 = {6, 8, 75, 300, 400};
		int[] mixed = crea(ar1, ar2);
		for (int n : mixed) {
			System.out.print(n);
			System.out.print("\t");
		}


		
	}

}
