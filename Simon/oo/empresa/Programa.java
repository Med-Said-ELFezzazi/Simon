package empresa;

public class Programa {
	
	public static void main(String[] args) {
		
		Telefonomovil tele1 = new Telefonomovil("+34 123 123 123", 90);
		
		Trabajador trabajador1 = new Trabajador("111111A", "Andres", 175, 75, 1000, tele1);
		
		
		System.out.println(trabajador1.toString());
		
		trabajador1.trabajar();
		trabajador1.trabajar();
		System.out.println(trabajador1.toString());
	}

}
