package punto_9;

public class GestorBorradoArray {
	
	private int[] arr;
	private static final int N = 3; 
	
	public GestorBorradoArray() {
		this.arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i+100;
		}
	}
	
	
	public void ver () {
		for (int n : this.arr) {
			System.out.println(n);
		}
	}
	
	public void borrarPosicion(int n) {
		
	}

}
