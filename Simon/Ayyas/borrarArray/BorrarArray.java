package borrarArray;

public class BorrarArray {
	
	
    public static int[] eliminarDeArray(int[] arrayOriginal, int posicion) {
        if (arrayOriginal == null || posicion < 0 || posicion >= arrayOriginal.length) {
            // Retornar el array original si la posición es inválida
            return arrayOriginal;
        }

        // Crear un nuevo array con tamaño menor en 1 que el original
        int[] nuevoArray = new int[arrayOriginal.length - 1];

        for (int i = 0, j = 0; i < arrayOriginal.length; i++) {
            if (i != posicion) {
                nuevoArray[j++] = arrayOriginal[i];
            }
        }

        return nuevoArray;
    }
    
    
    public static int[] eliminarDeArray2(int[] arrayOriginal, int posicion) {// 1,2,3
    	int lengArrayOri = arrayOriginal.length;
    	// Se verifica que la posición sea válida
        if (posicion < 0 || posicion >= lengArrayOri) {
            return arrayOriginal; // Retornar el array original
        }
    	// se puede crear otro array
    	int[] newArray = new int[lengArrayOri - 1];	// pq va a ser un elemento menos
    	
        // Copiar los elementos antes de la posición a eliminar
        for (int i = 0; i < posicion; i++) {
            newArray[i] = arrayOriginal[i];
        }

        // Copiar los elementos después de la posición a eliminar
        for (int i = posicion; i < lengArrayOri - 1; i++) {
            newArray[i] = arrayOriginal[i + 1];
        }
        
        return newArray;
    }
    
    public static void main(String[] args) {
		
    	int[] arrayOrig = new int[5];
    	for (int i=0; i< arrayOrig.length; i++) {
    		arrayOrig[i] = i;
    	}
    	
    	System.out.println("Array original : ");
    	for (int n : arrayOrig) {
    		System.out.println(n);
    	}
    	
    	int[] arrayNew = eliminarDeArray2(arrayOrig, 1);

    	System.out.println("New array : ");
    	for (int num : arrayNew) {
    		System.out.println(num);
    	}
	}

}
