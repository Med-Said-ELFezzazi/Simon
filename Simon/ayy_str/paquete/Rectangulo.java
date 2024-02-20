package paquete;

import java.util.Random;

public class Rectangulo {
	
	private double lado1, lado2;

	public Rectangulo(double lado1, double lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	public Rectangulo() {
		Random rand = new Random();
		this.lado1 = 2 + rand.nextDouble(89); //OR 2 + (int) (Math.random() * 89);
		this.lado2 = 2 + rand.nextDouble(89);
	}
	
	public double area () {
		return this.lado1 * this.lado2;
	}

	@Override
	public String toString() {
		return "Rectangulo [lado1=" + lado1 + ", lado2=" + lado2 + "]";
	}
	
	
	
	public double getLado1() {
		return lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public static void main(String[] args) {
		Rectangulo r = new Rectangulo();
		System.out.println(r.lado1);
	}
	

}
