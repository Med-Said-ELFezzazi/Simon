package paquete;

import java.io.PrintStream;

public class GestorRectangulos {
	
	private Rectangulo[] array;

	public GestorRectangulos(Rectangulo[] array) {
		this.array = array;
	}
	
	public GestorRectangulos(int tamanio) {
		this.array = new Rectangulo[tamanio];
		for (int i=0; i<tamanio; i++) {
			Rectangulo rec = new Rectangulo();
			this.array[i] = rec;
		}
	}
	
	public double[] areas(){
		double[] newArr = new double[this.array.length];
		for (int i=0; i<this.array.length; i++) {
			newArr[i] = this.array[i].area();
		}
		return newArr;
	}

	public void verCuadrados() {
		for (Rectangulo r : this.array) {
			if (r.getLado1() == r.getLado2()) {
				System.out.println(r);
			}
		}
	}

	public int cuantosCabenDentro(Rectangulo r) {
		int cont = 0;
		double area_r = r.area();
		System.out.println("area "+area_r);
		for (double rec : this.areas()) {
			if (area_r == rec) {
			}
			if (area_r > rec) {
				cont++;
			}
		}
		return cont;
	}
	
	public static void main(String[] args) {
		GestorRectangulos a = new GestorRectangulos(2);
		
		for (int i=0; i<a.array.length; i++) {
			System.out.println(a.array[i]);			
		}
		
		for (int i=0; i<a.areas().length; i++) {
			System.out.println(a.areas()[i]);			
		}
		
		a.verCuadrados();
		
		Rectangulo rec = new Rectangulo(25,15);
		
		System.out.println("caben: "+a.cuantosCabenDentro(rec));
		
		
		
	}
}
