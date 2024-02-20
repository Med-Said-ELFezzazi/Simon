package empresa;

public class Telefonomovil {
	
	
	private String numero;
	private int bateria;
	
	public Telefonomovil(String numero, int bateria) {
		this.numero = numero;
		this.bateria = bateria;
	}
	
	public boolean usar() {		//Devolver un boolean
		// controlar si tiene algo de bateria
		
		//boolean tieneBateria = (this.bateria > 0) ? true : false;
		if (this.bateria > 0) {
			this.bateria -= 1;			
			return true;
		}
		return false;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getBateria() {
		return bateria;
	}

	public void setBateria(int bateria) {
		this.bateria = bateria;
	}
	
	
	

}
