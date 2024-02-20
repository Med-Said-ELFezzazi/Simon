package insercionArray;

import copiarArray.Consola;

public class InsercionArray {
	
	
    public static int[] insertarEnArray(int[] arrayOriginal, int elemento, int posicion) {
        // Crear un nuevo array con tamaño mayor en 1 que el original
        int[] nuevoArray = new int[arrayOriginal.length + 1];

        for (int i = 0, j = 0; i < nuevoArray.length; i++) {
            if (i == posicion) {
                nuevoArray[i] = elemento; // Insertar el nuevo elemento en la posición deseada
            } else {
                nuevoArray[i] = arrayOriginal[j];	// insertar datos del array original normal
                j++;
            }
        }
        return nuevoArray;
    }
	
    
    
    ///////
	// ese metodo machaca
	public static char[] insertarChar(char[] arr, char newCar, int posicion) {
		char[] nuevoArray = new char[arr.length + 1];
		int j=0;
		for (int i=0; i<arr.length; i++) {
			if (i == posicion) {
				nuevoArray[i] = newCar;
			} else {
				nuevoArray[i] = arr[j];
				j++;
			}
		}
		return nuevoArray;
	}
	
	// metodo q no machaca en plan modifica un car por otro
	public static char[] insertarChar2(char[] arr, char newCar, int posicion) {
		int cont =0;
		for (int i=0; i<arr.length; i++) {
			if (i == posicion-1) {
				arr[i] = newCar;
				cont++;
			}
		}
		if (cont==0) {
			System.out.println("posicion introducida invalida!");
		}
		return arr;
	}
	public static void main(String[] args) {
		
		int pos, elem, n;
		int[] tabla = new int[5];
		
		n = 5;
		
		for (int i=0; i<n; i++) {		// rellenar el array con 5 numeros
			tabla[i] = i+1;
		}
		
		System.out.println("Array original:");
		for (int j=0; j< tabla.length; j++) {
			System.out.println(tabla[j]);
		}
		//Habra que controlar si la posicion es más alta que la longitud del arrau
		int[] newArray = insertarEnArray(tabla, 99, 1);
		
		System.out.println("nuevo array :");
		for (int j=0; j<newArray.length; j++) {
			System.out.println(newArray[j]);
		}
		
		
		
		
		char[] arr = {'a', 'b', 'c'};
		
		char[] newArr = insertarChar(arr, 'z', 3);
		
		for (char c : newArr) {
			System.out.println(c);
		}
		
		System.out.println("2 metodo :");
		char[] arrayChars = {'m', 'o', 'h', 'a'};
		char[] newArr2 = insertarChar2(arrayChars, 'z', 3);
		for (char c : newArr2) {
			System.out.println(c);
		}
	}

}
