package empresa;

public class Persona {
	
	private String nombre, dni;
	private int altura, peso;
	
	
	public Persona(String dni, String nombre, int altura, int peso) {
		this.nombre = nombre;
		this.dni = dni;
		this.altura = altura;
		this.peso = peso;
	}


	public Persona(String dni) {
		this.dni = dni;
		
		this.nombre = "default";
		this.altura = 1;
		this.peso = 1;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", peso=" + peso + "]";
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	

}
