package eje_largo;

import paquete.Consola;

public class Eje {
	
	//punto 2
	
	public static String primeraLetraMayu2(String str) {
	    if (str == null || str.isEmpty()) {
	        return str; // Retorna la cadena original si está vacía o es nula
	    }

	    char[] caracteres = str.toCharArray(); // Convierte la cadena a un array de caracteres
	    boolean encontrado = true; // Variable para identificar el inicio de una palabra

	    for (int i = 0; i < caracteres.length; i++) {
	        if (Character.isSpaceChar(caracteres[i])) { // Verifica si el caracter actual es un espacio
	            encontrado = true;
	        } else if (encontrado) {
	            caracteres[i] = Character.toUpperCase(caracteres[i]); // Convierte a mayúscula
	            encontrado = false; // Marca como encontrado para no volver a convertir hasta encontrar otro espacio
	        }
	    }

	    return new String(caracteres); // Retorna la cadena modificada
	}

	public static String primeraLetraMayu3(String str) {
	    if (str == null || str.isEmpty()) {
	        return str;
	    }
	    
	    String resultado = "";
	    boolean esPrimeraLetra = true; // Indica si estamos en la primera letra de una palabra
	    
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        
	        if (Character.isWhitespace(c)) {
	            esPrimeraLetra = true; // El siguiente caracter será la primera letra de una palabra
	            resultado += c;
	        } else if (esPrimeraLetra) {
	            resultado += Character.toUpperCase(c); // Convierte a mayúscula y añade al resultado
	            esPrimeraLetra = false;
	        } else {
	            resultado += c; // Añade el caracter tal como está si no es la primera letra de una palabra
	        }
	    }
	    
	    return resultado;
	}

	

	// punto 1
	public static double media(double[] notas) {
		double suma=0;
		for (int i=0; i<notas.length; i++) {
			suma += notas[i];
		}
		return suma/notas.length;
	}
	
	
	public static void main(String[] args) {
		// punto 1
		/*final int n =4;
		
		double[] notas = new double[n];
		
		for (int i=0; i<n; i++) {
			System.out.println("Inserta la nota: ");
			double nota = Consola.leeDouble();
			while (nota<0||nota>10) {
				System.out.println("nota invalida!");
				nota = Consola.leeDouble();
			}
			// carga array
			notas[i] = nota;	
		}
		for (int j=0; j<n; j++) {
			System.out.println(notas[j]);
		}
		System.out.println("La media de notas : "+media(notas));
		int cont_sup_media =0;
		for (int i=0; i<n; i++) {
			if (notas[i]>media(notas)) {
				cont_sup_media++;
			}
		}
		double porcen = ((double)cont_sup_media/notas.length)*100;
		System.out.println("el porcentaje de las notas q superan la media: "+porcen+" %");
		double nota_max = 0;
		int cont_veces = 0;
		for (int i=0; i<n; i++) {
			if (notas[i]>nota_max) {
				nota_max=notas[i];
				//cont_veces++;
			}
		}
		
		for (int i=0; i<n; i++) {
			if (notas[i]==nota_max) {
				cont_veces++;
			}
		}
		System.out.println("nota maxima : "+nota_max+" ha repetido: "+cont_veces+" veces");
		*/
		
		
		//punto 2
		String[] cadenas= new String[9999];
		
		System.out.println("inserta cadena:");
		
		int cont =0;
		String cadena="";
		while (!cadena.equalsIgnoreCase("quit")) {
			cadena = Consola.leeString();			
			if (!cadena.equalsIgnoreCase("quit")) {
				cadenas[cont] = cadena;
				cont ++;
			}			
		}
		System.out.println("Las cadenas en el array:");
		for (int i=0; i<cont; i++) {
			System.out.println(cadenas[i]);
		}
		
		String[] cadenasInversadas = new String[cont];
		int j=0;
		for (int i=cont-1; i>=0; i--) {
			cadenasInversadas[j] = primeraLetraMayu3(cadenas[i]);
			j++;
		}
		
		System.out.println("cadenas insertadas en orden inverso con primera letra mayu: ");
		for (String cad : cadenasInversadas) {
			System.out.println(cad);
		}
		
		int[][] multiArray = new int[10][3];
		int[][][] multiArray2 = new int[10][3][2];
		
		System.out.println("length de doublearray : "+multiArray[9].length);
	}
}
