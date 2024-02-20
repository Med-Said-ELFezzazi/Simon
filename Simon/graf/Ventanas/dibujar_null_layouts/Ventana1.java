package dibujar_null_layouts;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana1 extends JFrame{
	
	private JLabel lblTitulo;
	private JLabel lblImagen;
	private JCheckBox check1, check2, check3;
	private JButton botAceptar;
	
	//Constructor
	public Ventana1() {
		//-->El titulo de la ventana
		super("Ventana de prueba");
		this.setLayout(null); //Los componentes los dibujamos a mano
		
		//-->Dibujar componentes de la ventana
		lblTitulo = new JLabel("Dw1. Elije asignaturas"); //Paso 1: instancias la etiqueta
		lblImagen = new JLabel(new ImageIcon("eclipse_update_120.jpg"));
		
		check1 = new JCheckBox("PROG");
		check2 = new JCheckBox("ENDE");
		check3 = new JCheckBox("BBDD");
		check1.setSelected(true);
		check2.setSelected(true);
		check3.setSelected(true);
		
		botAceptar = new JButton("ACEPTAR");
		
		//-->Dar tamaño a los componentes y añadirlos a la ventana
		lblTitulo.setBounds(10, 10, 200, 30); //Paso 2: le asignas una localzacion/tamaño
		lblImagen.setBounds(200, 10, 100, 100);
		
		check1.setBounds(10,150,80,20);
		check2.setBounds(110,150,80,20);
		check3.setBounds(210,150,80,20);
		
		botAceptar.setBounds(160,200,150,40);
		
		this.getContentPane().add(lblTitulo); //Paso 3: la añadimos a la ventana
		this.getContentPane().add(lblImagen);
		this.getContentPane().add(check1);
		this.getContentPane().add(check2);
		this.getContentPane().add(check3);
		this.getContentPane().add(botAceptar);
		
		//-->Es obligatorio para poder ver la ventana
		setSize(500,500);
		setVisible(true);
	}
	
	
	//main
	public static void main(String[] args) {
		new Ventana1(); 
	}
}
