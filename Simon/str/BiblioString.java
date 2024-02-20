package paquete;

public class BiblioString {
	
	public static String concatenarInverso() {
		String cadena ;
		String cadenaGrande = "";
		int cont=0;
		while (cont < 10) {
	        System.out.println("Inserta cadena : ");
	        cadena = Consola.leeString();
	        cont++;
	        
	        if (cadena.equals("fin")) {
	            break;
	        }

	        cadenaGrande += cadena;
	    }
		//inversando
		String cadenaInversada = "";
		for (int i = cadenaGrande.length()-1 ; i >=0 ; i--) {
			cadenaInversada += cadenaGrande.charAt(i);
		}
		return cadenaInversada;
	}
	
	
	
	public static String sustituir(String cadena, char c1, char c2) {  //hola, o, a  -> hala
		String sustituido = "";
		int cont=0;
		for (int i = 0; i <= cadena.length()-1; i++) {
			if (c1 == cadena.charAt(i)) {
				cont++;
				sustituido += c2;
			} else {
				sustituido += cadena.charAt(i);

			}	
		}
		return sustituido+"\nnúmero de sustituición "+cont;
	}
	
	public static String eliminarCar(String str, char c) {	//hola, o    hla
		
		String strNew = "";
		
		for (int i = 0; i <= str.length()-1 ; i++) {
			if (str.charAt(i) != c) {
				strNew += str.charAt(i);
			} else {
				strNew += "";
			}
		}
		
		return strNew;
	}
	
	public static String completar$ (String str, int longitud) { // "hola", 8  -> hola$$$$
		String rslt = "";
		String dollar = "";
		int longStr = str.length();

		if (longitud<longStr) {		//<= ?!
			System.out.println("No se puede");
		} else {
			for (int i=0; i<=longitud-longStr; i++) {
				//rslt += str+"$";
				dollar += "$";
			}
			rslt += dollar;
		
		}
		return str+rslt;
	}
	
	// mayo
	public static void verPalabras(String str) {
		String rslt="";
		for (int i=0; i<=str.length()-1; i++) {

			if (str.charAt(i) == ' ') {
				rslt += "\n";
				//System.out.println("\n");
			} else {
				rslt += str.charAt(i);
			}
		}
		System.out.println(rslt.toUpperCase());
	}
	
	public static void verPalabrasAlReves(String str) {
	    String[] palabras = str.split(" ");
	    String resultado = "";

	    // Recorre el array de palabras en orden inverso y construye el resultado
	    for (int i = palabras.length - 1; i >= 0; i--) {
	        resultado += palabras[i] + (i > 0 ? " " : "");
	    }
	    System.out.println(resultado);
	}

	public static void main(String[] args) {
		verPalabrasAlReves("hola q tal");
		//eliminarCar("hola q tal", 'h');
		//System.out.println(concatenarInverso());
		//verPalabras("hola q tal");
	}
}
