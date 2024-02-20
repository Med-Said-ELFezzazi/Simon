package empresa;

public class Trabajador extends Persona{
	
	private double dinero;
	
	
	private Telefonomovil tele ;		//nuevo atributo
	

	public Trabajador(String dni, double dinero, Telefonomovil tele) {				//Eso ha venido solo
		super(dni);
		this.tele = tele;
		this.dinero = dinero;
	}
	
	
	public Trabajador(String dni, String nombre, int altura, int peso, double dinero, Telefonomovil tele) {				
		super(dni, nombre, altura, peso);
		this.tele = tele;
		this.dinero= dinero;
	}
	
	
	
	public void ganarDinero(double dineroGanado) {
		
		this.dinero += dineroGanado;
	}
	
	public void gastarDinero(double dineroGastado) {
		// controlar los parametros
		this.dinero -= dineroGastado;
	}


	@Override
	public String toString() {
		//Telefonomovil t = new Telefonomovil("+34 123 123 123", 50);
		//this.tele.bateria 		eso funciona en el caso de que el atributo bateria esta public 
		return "Trabajador [dinero=" + this.dinero + ", datos de la persona= " + super.toString() + "]" + " la carga de bateria : "+this.tele.getBateria();			
		//return super.toString()+ " dinero : "+this.dinero;
	}
	
	

	public void trabajar() {		//DEVOLVER BOOLEAN O VOID
		// controlar la bateria del movil
		if (this.tele.usar()) {
			//trabajador usa el movil por lo tanto bateria del movil se baja
			//this.tele.usar();     	//No creo q es correcto
			
			//incrementar el dinero del trabajador
			this.dinero += 10;
			
		} else {
			System.out.println("no se puede trabajar");
		}
		
	}

}
