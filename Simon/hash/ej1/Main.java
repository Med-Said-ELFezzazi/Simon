package ej1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	static void cargarArrList(ArrayList <Integer> arrLst) {
		Random rand = new Random();
		int cont = 0;
		while (cont < 5) {
			//int randomNum = -100 + rand.nextInt(99);		ESO MAL
			int min = -100;
			int max = 100;
			// Calcula la cantidad de valores posibles
			int numValores = max - min + 1; // 201 para el rango de -100 a 100
			// Genera el número aleatorio en el rango deseado
			int randomNum = rand.nextInt(numValores) + min;	// 1 + (-100)

			arrLst.add(randomNum);
			cont++;
		}
	}

	static void cargar10Divisores(int n, ArrayList<Integer> arrLst) {
	    int cont = 0;
	    for (int i = 1; cont < 10 && i <= n; i++) {
	        if (n % i == 0) {
	            arrLst.add(i);
	            cont++; // Incrementa el contador cada vez que encuentres un divisor
	        }
	    }
	}

	static void cargarAlea(ArrayList<Integer> arrLst) {
		Random rand = new Random();
		for (int i=0; i<20; i++) {
			int randomNum = rand.nextInt(41) - 20;	// (max - min + 1) + min
			while (!arrLst.contains(randomNum)) {
				arrLst.add(randomNum);
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arrList = new ArrayList<>();
		cargarArrList(arrList);
		for (Integer i : arrList) {
			System.out.println(i);
		}
		System.out.println("Borrar");
		arrList.clear();
		
		System.out.println("Cargar con divisores:");
		cargar10Divisores(48, arrList);
		for (Integer i : arrList) {
			System.out.println(i);
		}
		
		System.out.println("Borrar2");
		arrList.clear();
		
		cargarAlea(arrList);
		for (Integer i : arrList) {
			System.out.println(i);
		}
		
		
		
		
	}
}
