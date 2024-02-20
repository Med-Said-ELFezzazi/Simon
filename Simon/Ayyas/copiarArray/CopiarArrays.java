package copiarArray;

public class CopiarArrays {

	public static void copiarArray(int[] origen, int[] destino) {
		for (int i=0; i<origen.length; i++) {
			destino[i] = origen[i];
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int[] origen = {1,2,3};
		int[] destino= new int[origen.length];
		
		copiarArray(origen, destino);
		
		
		for (int a : origen) {
			System.out.println(a);
		}
		
	}
}
