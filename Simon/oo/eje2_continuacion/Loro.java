package eje2_continuacion;

public class Loro extends Ave{
	
	private char region;
	private String color;

	public Loro(String nombre_ave, String nombre_owner, char sexo, int edad, char region, String color) {
		super(nombre_ave, nombre_owner, sexo, edad);
		this.region = region;
		this.color = color;
	}

	
	/*
	public Loro(char sexo, int edad, char region, String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}*/
	
	protected String deDondeEres() {
		String msg;
		
		if (this.region == 'N') {
			msg = "Norte";
		} else if (this.region == 'S') {
			msg = "Sur";
		} else if (this.region=='O') {
			msg = "Oeste";
		} else {
			msg = "Este";
		}
		return msg;
	}


	public char getRegion() {
		return region;
	}


	public void setRegion(char region) {
		this.region = region;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	String cantar() {
		return "Mi nombre es "+nombre_ave+" , pio_pio loro bonito";
	}
	
	
	
}
