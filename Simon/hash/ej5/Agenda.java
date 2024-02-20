package ej5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agenda {
	
	private HashMap<String, int[]> entradas;
	private final int MAX_ENTRADAS = 5;
	
	public Agenda(int maxEntradas) {
		this.entradas = new HashMap<String, int[]>();
		//this.MAX_ENTRADAS = maxEntradas;
	}
	
	/*void aniadeEntrada(String nombre, int[] telefonos) {
		//Iteraremos sobre hashmap 
		for (String key : this.entradas.keySet()) {
			//nombre.equals(key
			// Controlar si ya existe
			if (this.entradas.containsKey(nombre)) {
				System.out.println("su agenda dispone de los siguientes telefonos para "+key+": ");
				for (int i=0; i<this.entradas.get(key).length; i++) {
					System.out.print(this.entradas.get(key)[i] + ",");
				}
				System.out.println("Deseas sustituirlos por los nuevos (S/N)?");
				String rsp = Consola.leeString();
				if (rsp.equalsIgnoreCase("s")) {
					// Hacer el cambio, remplazar clave_key antiguo y poner en su sitio nuevo
					this.entradas.replace(nombre, telefonos);
				} else {
					// pass
					break;
				}
			} else if (this.entradas.size() >= this.MAX_ENTRADAS) {
				System.out.println("Agenda completa");				
			} else {
				// insertar directamente
				this.entradas.put(nombre, telefonos);
				System.out.println("Agenda añadida correctamente");
			}
		}
	}*/
	
	void aniadeEntrada2(String nombre, int[] telefonos) {
	    if (this.entradas.containsKey(nombre)) {
	        // El nombre ya existe, preguntar si se quiere reemplazar
	        System.out.println("El nombre ya existe en la agenda. Deseas sustituir los telefonos? (S/N)");
	        String rsp = Consola.leeString();
	        if (rsp.equalsIgnoreCase("s")) {
	            // Reemplazar los números de teléfono existentes
	            this.entradas.put(nombre, telefonos);
	            System.out.println("Telefonos actualizados correctamente.");
	        }
	        // Si la respuesta es "N", simplemente no hagas nada.
	    } else if (this.entradas.size() >= this.MAX_ENTRADAS) {
	        // La agenda está llena
	        System.out.println("La agenda está completa. No se pueden añadir más entradas.");
	    } else {
	        // El nombre no existe y hay espacio, añadir la nueva entrada
	        this.entradas.put(nombre, telefonos);
	        System.out.println("Entrada añadida correctamente a la agenda.");
	    }
	}

	
	void ver () {
		for (String key : this.entradas.keySet()) {
			System.out.println("Persona: "+key);
			for (int i=0; i<this.entradas.get(key).length; i++) {
				System.out.print(" telefonos: "+this.entradas.get(key)[i]+", ");
			}
		}
	}
	
	String buscaNombre(String nombre) {
		String strDevolver="";
		if (!this.entradas.containsKey(nombre)) {
			strDevolver = nombre+" no se encuantra en la agenda";
		} else {
			for (int tele=0; tele<this.entradas.get(nombre).length; tele++) {
				strDevolver += this.entradas.get(nombre)[tele]+", ";
				
			}			
		}
		return strDevolver;
	}

	int cuantosTelefonos(int telefono) {
		int cuantos=0;
		//int[] arrayTeles;
		ArrayList<Integer> arrayTeles = new ArrayList<>();
		int lengthArr;
		for (String key : this.entradas.keySet()) {
			lengthArr = this.entradas.get(key).length;
			for (int tele=0; tele<lengthArr; tele++) {
				// cargar el array
				arrayTeles.add(this.entradas.get(key)[tele]);
				if (arrayTeles.contains(telefono)) {
					cuantos++;
				}			
			}		
			// vaciar el array pa rellenar otra vez
			arrayTeles.clear();
		}
		return cuantos;
	}
	
	
	HashMap<Integer, ArrayList<String>> mapaTelefonos() {
	    HashMap<Integer, ArrayList<String>> newMap = new HashMap<>();
	    
	    // Iterar sobre cada entrada de la agenda
	    for (String nombre : this.entradas.keySet()) {
	        int[] telefonos = this.entradas.get(nombre);
	        
	        // Iterar sobre cada teléfono de la persona
	        for (int telefono : telefonos) {
	            // Si el teléfono ya está en el mapa, añadir el nombre a la lista existente
	            if (newMap.containsKey(telefono)) {
	                newMap.get(telefono).add(nombre);
	            } else {
	                // Si el teléfono no está en el mapa, crear una nueva lista con el nombre y ponerla en el mapa
	                ArrayList<String> listaNombres = new ArrayList<>();
	                listaNombres.add(nombre);
	                newMap.put(telefono, listaNombres);
	            }
	        }
	    }
	    
	    // Devolver el nuevo mapa
	    return newMap;
	}
	
	void iterarMap() {
		HashMap<Integer, String> map = new HashMap<>();
		for (Integer key : map.keySet()) {
			System.out.println("id: "+key+" value: "+map.get(key));
		}
		
		//Recorer el mapa2
		System.out.println("bucle 2");
		for (Map.Entry<Integer, String> itr : map.entrySet()) {
			/*int key = itr.getKey();  
			String valor = itr.getValue();*/
			System.out.println("id: "+itr.getKey()+" valor: "+itr.getValue());
		}
	}
	
	
	
	
	public static void main(String[] args) {
	        Agenda miAgenda = new Agenda(5);

	        // Añadir algunas entradas
	        miAgenda.aniadeEntrada2("Alice", new int[]{123456789});
	        miAgenda.aniadeEntrada2("Bob", new int[]{987654321});
	        miAgenda.aniadeEntrada2("Charlie", new int[]{112233445, 556677889, 643205688});
	        //miAgenda.aniadeEntrada2("Bob", new int[] {12345678});
	        miAgenda.aniadeEntrada2("Moha", new int[] {643205688});

	        // Ver la agenda
	        miAgenda.ver();

	        System.out.println();
	        // Buscar los números de Alice
	        System.out.println("Números de Alice: " + miAgenda.buscaNombre("Charlie"));

	        // Comprobar cuántos contactos tienen el número 123456789
	        System.out.println("Cantidad de contactos con el teléfono 643205688: " + miAgenda.cuantosTelefonos(643205688));

	        // Crear y mostrar el mapa de teléfonos
	        HashMap<Integer, ArrayList<String>> mapa = miAgenda.mapaTelefonos();
	        for (Integer tel : mapa.keySet()) {
	            System.out.println("Teléfono: " + tel + " - Nombres: " + mapa.get(tel));
	        }
	}

}
