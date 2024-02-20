package eje2;

public class Piolin extends Canario{
	
	int numPeliculas;

	public Piolin(char sexo, int edad, double tamanio, int numPeliculas) {
		super(sexo, edad, tamanio);
		this.numPeliculas = numPeliculas;
	}
	
	
	
	public static void main(String[] args) {
		
		Piolin piolin1 = new Piolin('M', 2, 20, 1);
		
		Loro loro1 = new Loro('M', 3, 'N', "rojo");
		
		Canario can = new Canario('F', 2);
		
		piolin1.quienSoy();
		loro1.quienSoy();
		
		System.out.println(piolin1.altura());
		
		System.out.println(loro1.deDondeEres());
		
		System.out.println(Ave.num_aves_creadas);
	}
	

}
