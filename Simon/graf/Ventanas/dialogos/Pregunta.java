package dialogos;

public class Pregunta {
	
	private String texto;
	private String[] rptas;
	private int iBuena;
	
	private String pista;
	
	//Constructor
	public Pregunta(String texto, String[] rptas, int iBuena) {
		this.texto = texto;
		this.rptas = rptas;
		this.iBuena = iBuena;
		this.pista = "PISTA "+this.texto;
	}
	//get/set
	public String getTexto() {
		return texto;
	}

	public String[] getRptas() {
		return rptas;
	}

	public int getiBuena() {
		return iBuena;
	}
	public String getPista() {
		return pista;
	}
}
