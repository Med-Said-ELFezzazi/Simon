package dibujar_null_layouts;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ventana2 extends JFrame{
	
	private JLabel lblTitulo;
	private JRadioButton[] radPostres;
	private JTextField txtPrecio;
	private JComboBox<String> cmbPago;
	private final static String[] POSTRES= {"flan", "Fruta","Goxua", "Tarta de manzana"};
	
	//constructor
	public Ventana2() {
		super();
		
		dibujar();
		
		setSize(400,600);
		setVisible(true);
	}
	//Metodo dibujar
	private void dibujar() {
		this.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ELIJE POSTRE");
		lblTitulo.setBounds(20,20,100,20);
		this.getContentPane().add(lblTitulo);
		
		//Radios
		
		ButtonGroup bg = new ButtonGroup();//-->No es visual, sirve para que solo se pueda selecionar una opcion de radioButton
		radPostres = new JRadioButton[POSTRES.length];
		int y =50;
		for(int i = 0; i<radPostres.length; i++) {
			radPostres[i] = new JRadioButton(POSTRES[i]);
			bg.add(radPostres[i]);
			radPostres[i].setBounds(20,y,160,20);
			this.getContentPane().add(radPostres[i]);
			y+=30;
		}
		//Precio
		txtPrecio = new JTextField("0");
		txtPrecio.setBounds(50,500,80,30);
		this.getContentPane().add(txtPrecio);
		
		//Combo con varios tipos de pago
		cmbPago = new JComboBox<String>(new String[] {"Metalico","Tarjeta","PayPal"});
		cmbPago.setBounds(200,500,150,30);
		this.getContentPane().add(cmbPago);
	}
	//main
	public static void main(String[] args) {
		new Ventana2();
	}

}
