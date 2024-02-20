package ej2;

public abstract class DuplicadorDeArchivo {

	String nombre;
	private static final String NOM_CONSTANTE = "miFichero";

	public DuplicadorDeArchivo(String nombre) {
		this.nombre = nombre;
	}
	
	
	public DuplicadorDeArchivo() {
		this.nombre = NOM_CONSTANTE;
	}
	
	public abstract boolean duplicar(String nombreDestino);


	
	
}
