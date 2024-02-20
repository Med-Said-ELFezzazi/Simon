package dibujar_null_layouts;

public class Viaje {
	
	private String nombre;
	private int dias;
	private char transporte;//'a' avion 'b' bus 'c' crucero
	
	//Constructor
	public Viaje(String nombre, int dias, char transporte) {
		this.nombre = nombre;
		this.dias = dias;
		this.transporte = transporte;
	}
	@Override
	public String toString() {
		String str =nombre+", "+dias+" dias.";
		switch (transporte) {
			case 'a':
				str+=" Avion";
				break;
			case 'b':
				str+=" Bus";
				break;
			case 'c':
				str+=" Crucero";
				break;
		}
		return str;
	}
}
