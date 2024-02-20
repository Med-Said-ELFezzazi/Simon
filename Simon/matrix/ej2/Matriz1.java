package ej2;

import java.util.Random;

public class Matriz1 {
	
	private int[][] matriz;
	private final int NF = 10;
	private final int NC = 7;
	
	public Matriz1() {
		this.matriz = new int[this.NF][this.NC];
	}
	
	public Matriz1(int numFilas, int numCols) {
		if (numFilas > this.NF) {
			numFilas = this.NF;
		}
		if (numCols > this.NC) {
			numCols = this.NC;
		}
		this.matriz = new int[numFilas][numCols];
		//this.cargarPorFilas();
	}
	
	public int generarNumAleatorio(int inicio, int fin) {
		Random rand = new Random();
		return inicio + rand.nextInt(fin-1); 
	}
	
	void cargarPorFilas() {
		int inicio=1;
		int fin=10;
		int numAleatorio;	
		for (int fila=0; fila<this.matriz.length; fila++) {
			for (int col=0; col<this.matriz[fila].length; col++) {
				numAleatorio = generarNumAleatorio(inicio, fin);
				//inserar datos
				this.matriz[fila][col] = numAleatorio;
			}
			//avanzamiento de 10 numeros cada vez por cada fila
			inicio += 10;
			fin += 10;		
		}
	}
	
	void ver() {
		for (int fila=0; fila<this.matriz.length; fila++) {
			System.out.println();
			for (int col=0; col<this.matriz[fila].length; col++) {
				System.out.print(this.matriz[fila][col]+"\t");
			}
		}
	}
	
	
	/*void invertirFilas() {
		int cont = 0;
		int valorTemp;
		for (int fila=0; fila<this.matriz.length; fila++) {
			for (int col=this.matriz[fila].length-1; col>=0; col--) {
				valorTemp = this.matriz[fila][col];
				//this.matriz[fila][cont] = this.matriz[fila][col];
				this.matriz[fila][cont] = valorTemp;
				cont++;
			}
		}
	}*/
	
	void invertirFilas() {
	    for (int fila = 0; fila < this.matriz.length; fila++) {
	        for (int col = 0; col < this.matriz[fila].length / 2; col++) {
	            int indiceOpuesto = this.matriz[fila].length - col - 1;
	            int valorTemp = this.matriz[fila][col];
	            this.matriz[fila][col] = this.matriz[fila][indiceOpuesto];
	            this.matriz[fila][indiceOpuesto] = valorTemp;
	        }
	    }
	}


	boolean intercambiarFilas(int n1, int n2){
		//Conseguir en q filas estan los numeros
		int numFila1 = -1;
		int numFila2 = -1;
		for (int fila = 0; fila < this.matriz.length; fila++) {
			for (int col = 0; col < this.matriz[fila].length; col++) {
				if (this.matriz[fila][col] == n1) {
					numFila1 = fila;
				}
				if (this.matriz[fila][col] == n2) {
					numFila2 = fila;
				}
			}
		}
		if (numFila1 == -1 || numFila2 == -1 || numFila1 == numFila2) {
			System.out.println("Los dos numeros estan en la misma fila o no existen");
			return false;
		} else {
			// Intercambiar
			for (int i=0; i < this.matriz[numFila1].length; i++) {
				int temp = this.matriz[numFila1][i];
				this.matriz[numFila1][i] = this.matriz[numFila2][i];
				this.matriz[numFila2][i] = temp;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		Matriz1 m = new Matriz1(3, 3);
		m.cargarPorFilas();
		m.ver();
		
		// invertir matriz
		System.out.println("Invertir matriz:");
		m.invertirFilas();
		m.ver();
		
		System.out.println();
		System.out.println("intercambio");
		System.out.println(m.intercambiarFilas(7, 14));
		m.ver();
		
	}
}
