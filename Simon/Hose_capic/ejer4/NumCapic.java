package ejer4;

public class NumCapic {
	
	private long num;
	private boolean esCapicua;

	public NumCapic() {
	}
	
	public NumCapic(long num) {
		this.num = num;
		this.esCapicua = capicua();
	}
	
	private int cantDigitos() {
		String numStr = String.valueOf(this.num);
		return numStr.length();
	}
	
	private char digitoEnPosicionN(int n) {
		String numStr = String.valueOf(this.num);
		char digito = numStr.charAt(n);
		//int digitoInteger = Integer.parseInt(digito);
		
		return digito;
	}
	
	private boolean capicua() {
		// Conversion
		String numStr = String.valueOf(this.num);
		
		String numReversed="";

		if (cantDigitos()==1) {
			return true;
		} else if (cantDigitos()==2) {
			if (digitoEnPosicionN(0)==digitoEnPosicionN(1)) {
				return true;
			}
		} else if (cantDigitos()>2) {		// ej: 5775     57575   313			
			for (int j=cantDigitos()-1; j>=0; j--) {
				numReversed += digitoEnPosicionN(j);
			}
			if (numReversed.equals(numStr)) {
				return true;
			}
		}
		return false;
		
	}
	

	public static void main(String[] args) {
		
		System.out.println("Introduce el numero 1 :");
		long num1= Consola.leeLong();
		System.out.println("Introduce el numero 2 :");
		long num2 = Consola.leeLong();
		
		NumCapic nc1 = new NumCapic(num1);
		NumCapic nc2 = new NumCapic(num2);
		
		System.out.println("El numero 1 es capicua : "+nc1.capicua());
		System.out.println("El numero 2 es capicua : "+nc2.capicua());
		
		System.out.println(nc1.esCapicua);
	}
	
	

}
