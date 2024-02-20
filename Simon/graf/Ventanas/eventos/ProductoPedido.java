package eventos;

import java.util.Objects;

public class ProductoPedido {
	private String nombre;
	private int ctd;
	
	public ProductoPedido(String nombre, int ctd) {
		this.nombre = nombre;
		this.ctd = ctd;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCtd() {
		return ctd;
	}
	public void setCtd(int ctd) {
		this.ctd = ctd;
	}
	@Override
	public String toString() {
		return nombre+", "+ctd+" uds.";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoPedido other = (ProductoPedido) obj;
		return Objects.equals(nombre, other.nombre);
	}
}
