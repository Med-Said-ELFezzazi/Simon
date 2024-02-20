package ordenarArray;

import java.util.Arrays;
import java.util.Collections;

public class OrdenarArray {
	
	
	public static int[] odenarArray(int[] ar1) {
		int[] arr1Fin = new int[ar1.length];

		// Copiar elementos de ar1 a arr1Fin
		for (int i = 0; i < ar1.length; i++) {
		    arr1Fin[i] = ar1[i];
		}

		// Ordenar arr1Fin en orden ascendente
		for (int i = 0; i < arr1Fin.length - 1; i++) {
		    // Encontrar el índice del mínimo elemento
		    int indexMin = i;
		    for (int j = i + 1; j < arr1Fin.length; j++) {
		        if (arr1Fin[j] < arr1Fin[indexMin]) {
		            indexMin = j;
		        }
		    }

		    // Intercambiar el mínimo con el primer elemento no ordenado
		    int temp = arr1Fin[indexMin];
		    arr1Fin[indexMin] = arr1Fin[i];
		    arr1Fin[i] = temp;
		}
		
		return arr1Fin;
	}
	
	
	
	public static int[] odenarArray2(int[] ar1) {
		// Copiar el array original para no modificarlo
        int[] arr1Fin = Arrays.copyOf(ar1, ar1.length);
        
        // Ordenar el array copiado en orden ascendente
        Arrays.sort(arr1Fin);	
        
        // PARA Ordenar el array copiado en orden Descendente
        //Arrays.sort(arr1Fin, Collections.reverseOrder());
        
        return ar1;
	}
	
	
	public static void main(String[] args) {
		int[] array = {22,2,3,4,9,99,100};
		int[] arrayOrdenado = odenarArray(array);
		
		for (int n : arrayOrdenado) {
			System.out.print("\t"+n);
		}
		
		
		System.out.println("2 metodo");
		int[] arrayOrdenado2 = odenarArray(array);
		
		for (int n : arrayOrdenado2) {
			System.out.print("\t"+n);
		}
	}

}
