package eje2_continuacion;

public class Piolin extends Canario{
	
	private int numPeliculas;
	
	
	public Piolin(String nombre_ave, String nombre_owner, char sexo, int edad, double tamanio, int numPeliculas) {
		super(nombre_ave, nombre_owner, sexo, edad, tamanio);
		this.numPeliculas = numPeliculas;
	}




	/*
	public Piolin(char sexo, int edad, double tamanio, int numPeliculas) {
		super(sexo, edad, tamanio);
		this.numPeliculas = numPeliculas;
	}*/

	public int getNumPeliculas() {
		return numPeliculas;
	}

	public void setNumPeliculas(int numPeliculas) {
		this.numPeliculas = numPeliculas;
	}

	
	@Override
	public String cantar() {
	    // Aquí puedes definir el canto específico para Piolin.
	    return "Mi nombre es "+DatosPresonales.get+ "Pio_pio soy un piolin";
	}

	
	public static void main(String[] args) {
		
		Piolin piolin1 = new Piolin("mi piolinito","dueño es Andres", 'M', 2, 20, 1);
		
		Loro loro1 = new Loro("lorito2","dueño es Luka", 'M', 3, 'N', "rojo");
		
		//Canario can = new Canario('F', 2);
		
		piolin1.quienSoy();
		loro1.quienSoy();
		
		System.out.println(piolin1.altura());
		
		System.out.println(loro1.deDondeEres());
		
		System.out.println(Ave.getNum_aves_creadas());
		
		System.out.println("numero de aves creadas :" + piolin1.numAvesCreadas());
		
		
		System.out.println("its time to sing-------");
		
		System.out.println("el loro : "+loro1.cantar());
		System.out.println("piolin : "+piolin1.cantar());
	}
	

	
}
