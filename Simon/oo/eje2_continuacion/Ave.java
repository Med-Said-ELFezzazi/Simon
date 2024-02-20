package eje2_continuacion;

public abstract class Ave extends DatosPresonales{
	

	private char sexo;
	private int edad;
	private DatosPresonales nombres;
	
	private static int num_aves_creadas;		//Incrementa cada vez q se crea una ave

	public Ave(String nombre_ave, String nombre_owner,char sexo, int edad) {
		super(nombre_ave, nombre_owner);
		this.nombres = nombre_ave.get+" "+nombre_owner;
		this.sexo = sexo;
		this.edad = edad;
		num_aves_creadas++;
	}

	
	
	/*	public Ave(char sexo, int edad) {
		this.sexo = sexo;
		this.edad = edad;
		num_aves_creadas++;
	}*/
	
	
	abstract String cantar();
	
	protected int numAvesCreadas() {
		return num_aves_creadas;
	}
	

	protected void quienSoy() {
		System.out.println("Sexo: "+this.sexo+" edad: "+this.edad);
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public static int getNum_aves_creadas() {
		return num_aves_creadas;
	}

	public static void setNum_aves_creadas(int num_aves_creadas) {
		Ave.num_aves_creadas = num_aves_creadas;
	}
	
	
	
}
