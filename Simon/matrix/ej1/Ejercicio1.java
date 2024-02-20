package ej1;

import java.util.HashMap;

public class Ejercicio1 {
	
	public static void rellenar(int[][] matriz) {
		for (int fila=0; fila<matriz.length; fila++) {
			for (int columna=0; columna<matriz[0].length; columna++) {
				System.out.println("Introduce la nota de asignatura "+(columna+1)+" del alumno "+(fila+1));
				int nota = Consola.leeInt();
				// Insertar la nota
				matriz[fila][columna] = nota;
			}
		}
	}

	public static void ver (int[][] matriz) {
		for (int i=0; i<matriz.length;i++) {
			System.out.println("Alumno: "+(i+1));
			for (int j=0; j<matriz[0].length; j++) {
				System.out.println("Asignatura: "+(j+1));
				System.out.println(matriz[i][j]);
			}
		}
	}
	
	public static int numAsignatura(int[][] matriz) {
		HashMap<Integer, Integer> mapaMedias = new HashMap<>();
		int mediaMax =0;
		int sumaTotalNotas = 0;
		for (int i=0; i<matriz[0].length; i++) {
			System.out.println("Asignatura numero: "+(i+1));
			for (int j=0; j<matriz.length; j++) {
				sumaTotalNotas += matriz[j][i];				
			}
			System.out.println("la suma: "+sumaTotalNotas+" la media: "+sumaTotalNotas/matriz.length);//imprimo la suma
			if (sumaTotalNotas/matriz.length > mediaMax) {
				mediaMax = sumaTotalNotas/matriz.length;
			}
			mapaMedias.put(i+1, sumaTotalNotas/matriz.length);
			//reincio la suma para la nueva asignatura
			sumaTotalNotas =0;
		}
		System.out.println("final media alta: "+mediaMax);
		
		System.out.println("Map");
		int mediaAlta=0;
		int asignaturaMayorMEdia = 0;
		for (Integer key : mapaMedias.keySet()) {
			System.out.println("asignatura: "+key+" media: "+mapaMedias.get(key));
			if (mapaMedias.get(key)>mediaAlta) {
				asignaturaMayorMEdia = key;
			}
		}
		System.out.println("el número de la asignatura con la media más alta : "+asignaturaMayorMEdia);
		return asignaturaMayorMEdia;
	}
	
	// parte/total * 100
	public static double[] porcentajeSuspenso(int[][] matriz) {
		double[] porcen = new double[matriz.length];
		int numTotalAsigns = matriz[0].length;	//numero total de asignaturas
		int contSuspens;
		for (int fila=0; fila<matriz.length; fila++) {
			contSuspens = 0;
			for (int col=0; col<numTotalAsigns; col++) {
				if (matriz[fila][col] < 5) {		//Comrpobar nota
					contSuspens++;
				}
			}
			//Insertar en el array porcentaje
			porcen[fila] = ((double) contSuspens/numTotalAsigns) * 100;
		}
		return porcen;
	}
	
	public static int[][] otraMatriz(int[][] matriz){
		int[][] newMatriz = new int[matriz.length][4];
		int suspens, aprobado, notable, sobresaliente;
		for (int fila=0; fila<matriz.length; fila++) {
			suspens = 0;
			aprobado = 0;
			notable = 0;
			sobresaliente = 0;
			for (int col=0; col<matriz[fila].length; col++) {
				if (matriz[fila][col] < 5) {
					suspens++;
				} else if (matriz[fila][col] < 7) {
					aprobado++;
				} else if (matriz[fila][col] < 9) {
					notable++;
				} else {
					sobresaliente++;
				}
			}
			//Insertar en el nuevo matriz
			newMatriz[fila][0] = suspens;
			newMatriz[fila][1] = aprobado;
			newMatriz[fila][2] = notable;
			newMatriz[fila][3] = sobresaliente;
		}
		return newMatriz;
	}
	
	public static void main(String[] args) {
		System.out.println("inserta el número de alumnos:");
		int n = Consola.leeInt();
		
		System.out.println("inserta el número de asignaturas:");
		int m = Consola.leeInt();
		
		int[][] matriz = new int[n][m];
		//System.out.println("long "+matriz[0].length);
		rellenar(matriz);
		
		ver(matriz);
		
		//System.out.println("La media ...");
		//System.out.println(numAsignatura(matriz));
		double[] porcens = porcentajeSuspenso(matriz);
		int cont = 1;
		for (double b : porcens) {
			System.out.println("Alumno: "+cont);
			System.out.println(" "+b);
			cont++;
		}
		
		int[][] newMat = otraMatriz(matriz);
		System.out.println("new matriz:");
		for (int i=0; i<newMat.length; i++) {
			System.out.println("alumno "+(i+1));
			for (int col=0; col<newMat[i].length; col++) {
				if (col == 0) {
					System.out.println("Suspensos");
					System.out.println(newMat[i][col]);
				}
				if (col == 1) {
					System.out.println("Aprobados");
					System.out.println(newMat[i][col]);
				}
				if (col == 2) {
					System.out.println("Notables");
					System.out.println(newMat[i][col]);
				}
				if (col == 3) {
					System.out.println("Sobresalientes");
					System.out.println(newMat[i][col]);
				}
			}
		}
		
		
		
		
	}

}
