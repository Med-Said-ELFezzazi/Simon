package eje2_continuacion;

public class Canario extends Ave{

	private double tamanio;
	
	public Canario(String nombre_ave, String nombre_owner, char sexo, int edad, double tamanio) {
		super(nombre_ave, nombre_owner, sexo, edad);
		this.tamanio = tamanio;
	}

	
	
	/*
	public Canario(char sexo, int edad) {
		super(sexo, edad);
	}
	
	
	public Canario(char sexo, int edad, double tamanio) {
		super(sexo, edad);
		this.tamanio = tamanio;
	}*/
	
	
	protected String altura() {
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

	@Override
	public String cantar() {
	    return "Canto del canario: ¡pio pio pio!";
	}


	
	
	
	public double getTamanio() {
		return tamanio;
	}


	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}


	
	

}
