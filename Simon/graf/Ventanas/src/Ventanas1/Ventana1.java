package Ventanas1;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ventana1 extends JFrame {
	private JLabel lblTitulo;
	private JRadioButton[] radPostres;
	private JTextField txtPrecio;
	private JComboBox<String> cmbPago;
	private final static String[] POSTRES= {"flan", "fruta", "goxua", "tarta"};
	public Ventana1() {
		dibujar();
		setSize(400, 300);
		setVisible(true);
	}
	private void dibujar() {
		this.setLayout(null);
		//Etiqueta superior
		JLabel lblTitulo=new JLabel("Elige postre");
		lblTitulo.setBounds(20, 20, 100, 20);
		this.getContentPane().add(lblTitulo);
		
		
		
		ButtonGroup bg=new ButtonGroup();
		int y=50;
		
		radPostres=new JRadioButton[POSTRES.length];
		for(int i=0; i<radPostres.length;i++) {
			radPostres[i]=new JRadioButton(POSTRES[i]);
			bg.add(radPostres[i]);
			radPostres[i].setBounds(20, y, 120, 20);
			this.getContentPane().add(radPostres[i]);
			y=y+30;
		}
		this.getContentPane().add(new JLabel("Elije postre"));
		
		txtPrecio=new JTextField();
		txtPrecio.setBounds(50, 500, 80, 30);
		this.getContentPane().add(txtPrecio);
		
		//Varios tipos de pago combo
		cmbPago=new JComboBox<String>(new String[] {"Metalico", "Tarjeta", "PayPal"});
		cmbPago.setBounds(300, 500, 150, 30);
		this.getContentPane().add(cmbPago);
		
	}
	public static void main(String[] args) {
		Ventana1 v1=new Ventana1();
		v1.dibujar();	
	}
}
