package eje2_continuacion;

public class DatosPresonales {
	
	protected String nombre_ave;
	protected String nombre_owner;

	public DatosPresonales(String nombre_ave, String nombre_owner) {
		this.nombre_ave = nombre_ave;
		this.nombre_owner = nombre_owner;
	}

	public String getNombre_ave() {
		return nombre_ave;
	}

	public void setNombre_ave(String nombre_ave) {
		this.nombre_ave = nombre_ave;
	}

	public String getNombre_owner() {
		return nombre_owner;
	}

	public void setNombre_owner(String nombre_owner) {
		this.nombre_owner = nombre_owner;
	}
	
	

}
