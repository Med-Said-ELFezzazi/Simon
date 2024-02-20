package empresa;

public class Empresa {
	
	
	private String nombre;
	private double beneficio;
	
	///////
	private Trabajador duenio;		
	private Trabajador gerente;
	
	
	public Empresa(String nombre, double beneficio, Trabajador duenio) {		//todos atributos menos gerente
		this.nombre = nombre;
		this.beneficio = beneficio;
		this.duenio = duenio;
	}		

	
	public void contratarGerente(Trabajador trabajador) {
		// controlar si ya hay gerente
		if (this.gerente != null) {
			System.out.println("Ya tenemos gerente!");
		}else {
			this.gerente = trabajador;		//asignar trabajador a gerente de empresa	
			System.out.println("gerente contrado.");
		}
	}
	
	
	public void trabajar() {
		//controlar movil y existencia del trabajadores
		this.duenio.trabajar();
		this.gerente.trabajar();
		
		this.beneficio += 100;
		
	}


	@Override
	public String toString() {
		// controlar gerente existe
		return "Empresa nombre= " + nombre + ", beneficio=" + beneficio + ", duenio=" + duenio + ", gerente=" + gerente+" Datos trabjadores: ";
	}


	
	

}
