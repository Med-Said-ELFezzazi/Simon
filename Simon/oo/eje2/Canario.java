package eje2;

public class Canario extends Ave{
	
	double tamanio;

	public Canario(char sexo, int edad) {
		super(sexo, edad);
	}
	
	
	public Canario(char sexo, int edad, double tamanio) {
		super(sexo, edad);
		this.tamanio = tamanio;
	}
	
	
	String altura() {
		String msg;
		
		if (this.tamanio>30) {
			msg = "Alto";
		} else if (this.tamanio<15) {
			msg= "Bajo";
		} else {
			msg = "Mediano";
		}
		
		return msg;
	}

}
