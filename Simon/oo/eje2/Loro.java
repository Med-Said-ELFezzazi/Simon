package eje2;

public class Loro extends Ave{

	char region;
	String color;
	
	public Loro(char sexo, int edad, char region, String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}

	
	String deDondeEres() {
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
}
