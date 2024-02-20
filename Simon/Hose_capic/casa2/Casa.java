package casa2;

public class Casa {
	
	
	private String direccion;
	private double superficie;
	private char tipo;
	
	/*
	public Casa(String direccion, double superficie, char tipo) {
		this.direccion = direccion;
		this.superficie = superficie;
		this.tipo = tipo;
	}*/
	
	public void mostrar() {		
		String tipo = (this.tipo == 'p') ? "piso" : "unifamiliares";

		System.out.println(tipo+ " en "+direccion+", superficie : "+superficie+" m2");
	}
	
	public double dameImpuesto() {
		if (this.superficie<60) {
			return 0;
		} else if (this.superficie<80) {
			return this.superficie*4.5;
		} else {
			return this.superficie*5.5;
		}
	}
	
	
	public boolean esVendible() {
		if (this.tipo == 'u' || this.superficie>100) {
			return false;
		}
		return true;
	}
	
	public boolean esSimilar(Casa casa2){
		if (this.tipo == casa2.tipo) {
			int dif = (int) (this.superficie - casa2.superficie);
			if (dif<=10 || dif>=-10) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Casa casa1 = new Casa();
		casa1.tipo='p';
		casa1.direccion="C/Rioja, 18m";
		casa1.superficie=65;
		
		Casa casa2 = new Casa();
		casa2.direccion = "C/ Alava, 5";
		casa2.superficie = 150;
		casa2.tipo = 'u';

		Casa casa3 = new Casa();
		casa3.direccion = "C/ Gorbea, 23";
		casa3.superficie = 105;
		casa3.tipo = 'p';

		casa2.mostrar();
		casa2.superficie = casa2.superficie-5;
		casa2.mostrar();
		
		
		

	}

}
