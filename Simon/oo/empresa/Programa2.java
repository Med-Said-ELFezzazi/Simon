package empresa;

public class Programa2 {
	
	public static void main(String[] args) {
		
		Telefonomovil tele1 = new Telefonomovil("+34 111 111 111", 50);
		
		Trabajador t1 = new Trabajador("11111V", "Andres", 175, 75, 1000, tele1);
		
		Empresa emp1 = new Empresa("Fagor", 100000.50 , null);
		
		
		System.out.println(emp1.toString());
		emp1.contratarGerente(t1);
		
		System.out.println(emp1.toString());
		
		emp1.trabajar();
		emp1.trabajar();
		
		System.out.println(emp1.toString());

	}

}
