package eje1;

public class Vaca {

	private String colorPelo;
	private int edad;
	protected String nombre;
    private static int contadorVacas = 0; // Contador estático de instancias

	
	public Vaca(){
        contadorVacas++; 
        System.out.println("Se ha creado la vaca " + contadorVacas);
	}

	public Vaca(String colorPelo, int edad, String nombre) {
		this.colorPelo = colorPelo;
		this.edad = edad;
		this.nombre = nombre;
        contadorVacas++; 
        System.out.println("Se ha creado la vaca " + contadorVacas);
	}

	public Vaca(String colorPelo, int edad) {
		this.colorPelo = colorPelo;
		this.edad = edad;
        contadorVacas++;
        System.out.println("Se ha creado la vaca " + contadorVacas);
	}
	
	
	
	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String muu() {
		String muu = "Muu... mi nombre "+this.nombre+" y mi color de pelo es "+this.colorPelo;
		return muu;
	}
	
	public String compararEdad(Vaca vaca2) {
		String strFinal;
		
		if (this.edad>vaca2.edad) {
			strFinal = "La vaca "+this.nombre+" es más vieja que la vaca "+vaca2.nombre;
		}else if (this.edad<vaca2.edad) {
			strFinal = "La vaca "+vaca2.nombre+" es más vieja que la vaca "+this.nombre;
		} else {
			return "las dos vacas tiene la misma edad";
		}
		
		return strFinal;
		
	}
	
}
