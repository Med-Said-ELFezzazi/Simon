package paquete;

public class OpArray {
	
	private int[] arrayEnteros;
	private static final int[] arrayNumsProhibidos = {1,2,3};
	
	OpArray(){
		this.arrayEnteros = new int[arrayNumsProhibidos.length];
	}

	OpArray(int tamanio){
		this.arrayEnteros = new int[tamanio];
	}
	
	public boolean esProhibido(int num) {
		boolean rslt=false;
		for (int i=0; i<this.arrayNumsProhibidos.length; i++) {
			if (num == arrayNumsProhibidos[i]) {
				rslt= true;
			}
		}
		return rslt;
	}
	
	
	public void cargarArray() {
	    System.out.println("Inserta número, a cargar en el array (0 para terminar):");
	    boolean esProhibido;
	    
	    int num = 999; // Valor inicial para entrar al bucle
	    int cont = 0; // Índice para llevar la cuenta de las inserciones en el array
	    while (num != 0 && cont < this.arrayEnteros.length) {
	        num = Consola.leeInt(); // Se asume que leeInt() es un método que obtiene un entero de la consola
	        
	        if (num == 0) {
	            break; // Salir del bucle si el usuario ingresa '0'
	        }
	        
	        esProhibido = this.esProhibido(num); // Comprobar si el número es prohibido
	        
	        if (esProhibido) {
	            System.out.println("Número insertado prohibido!"); // Informar al usuario que el número está prohibido
	        } else {
	            this.arrayEnteros[cont] = num; // Agregar el número al array si no está prohibido
	            cont++;
	        }
	    }
	}
	
	
	public void ver() {
	    for (int n : this.arrayEnteros) {
	    	System.out.println(n);
	    }
	    
	    System.out.println("Util :");
	    for (int n : this.arrayEnteros) {
	    	if (n!=0) {
	    		System.out.println(n);	    		
	    	}
	    }
	}
	
	
	public String toString() {
		String total="";
	    for (int n : this.arrayEnteros) {
	    	if (n!=0) {
	    		total += n;	    		
	    	}
	    }
		return total;
	}
	
	// el numero primo es el q acepta solo como divisor el 1 y su mismo
	public boolean esPrimo(int numero) {	//4
	    if (numero <= 1) {
	        return false;
	    }
	    // Comprobar si el número tiene divisores aparte de 1 y él mismo
	    for (int i = 2; i < numero; i++) {
	        if (numero % i == 0) {
	            // Si encuentra un divisor, entonces el número no es primo
	            return false;
	        }
	    }
	    return true;
	}
	
	public int indicePrimo() {
		int index = -1;
		for (int i=0; i < this.arrayEnteros.length; i++) {
			if (esPrimo(this.arrayEnteros[i])) {
				index = i;
				break;	// parar pq han pedido el indice del primer primo
			}
		}
		return index;
	}

	
	public void rotar(int numRotaciones) {
	    int[] newArr = new int[this.arrayEnteros.length];
	    int len = this.arrayEnteros.length;
	    
	    // Normalizar las rotaciones en caso de que el número de rotaciones sea mayor que la longitud del array
	    numRotaciones = numRotaciones % len;
	    
	    for (int i = 0; i < len; i++) {
	        // Calcular la nueva posición con el módulo para manejar la 'vuelta' al principio del array
	        int nuevaPosicion = (i + numRotaciones) % len;
	        newArr[nuevaPosicion] = this.arrayEnteros[i];
	    }
	    
	    // Copiar los elementos rotados de nuevo en el array original
	    for (int i = 0; i < len; i++) {
	        this.arrayEnteros[i] = newArr[i];
	    }
	    
	    // Imprimir el array rotado
	    for (int n : this.arrayEnteros) {
	        System.out.print(n);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		OpArray a = new OpArray(5);
		a.cargarArray();
		//a.ver();
		System.out.println(a.toString());
		//System.out.println("indice del primo: "+a.indicePrimo());
		a.rotar(1);


	}
}
