package pezarra;

public class CuantosDigitos {
	
	
	public static int cuantosDigitos(int num) {	
		int aux=num;
		int cont_digit=0;
		while (aux>0) {
			aux /= 10;
			cont_digit++;
		}
		return cont_digit;
	}
	
	
	public static int inverso(int num) {
		
		int num_digitos = cuantosDigitos(num);
		int contador=0;
		int num_inverso=0;
		
		while (num > 0) {
			
	        int digito = num % 10; // Obtenemos el último dígito
	        num_inverso += digito * Math.pow(10, num_digitos - contador - 1);
	        
	        // para salir del bucle vamos quitando digitos, hasta que no quede ningun digito
	        num /= 10; // Eliminamos el último dígito del numero original
	        
	        // contador que va subiendo cada vez que se quita un numero, para arreglar el numero elevado
	        contador++;
		}
		return num_inverso;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(inverso(123456789));
		
		
		
	}

}

