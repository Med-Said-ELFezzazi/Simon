package eje2;

public class Ave {
	
	char sexo;
	int edad;
	
	static int num_aves_creadas;		//Incrementa cada vez q se crea una ave

	public Ave(char sexo, int edad) {
		this.sexo = sexo;
		this.edad = edad;
		num_aves_creadas++;
	}
	
	int numAvesCreadas() {
		return num_aves_creadas;
	}
	

	void quienSoy() {
		System.out.println("Sexo: "+this.sexo+" edad: "+this.edad);
	}
}
