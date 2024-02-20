package eje1OtroPaquete;

import eje1.Vaca;

public class Principal {

	public static void main(String[] args) {
		
		
		Vaca miVaca1 = new Vaca();
		Vaca miVaca2 = new Vaca("Blonde", 23, "Vakita");
		Vaca miVaca3 = new Vaca("Rojo", 20);
		
		System.out.println(miVaca1.muu());
		System.out.println(miVaca2.muu());
		System.out.println(miVaca3.muu());

		System.out.println(miVaca2.compararEdad(miVaca3));
		
		
		int newEdad = miVaca2.getEdad()+1;
		miVaca2.setEdad(newEdad);
		
		System.out.println("nuevo edad vaca2 : "+miVaca2.getEdad());
	}
}
