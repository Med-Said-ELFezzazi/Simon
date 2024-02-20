package Tanda1;

import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio1 extends JFrame {
	private JLabel lbImagen;
	private JRadioButton[] radJornada;
	private JTextField txtNombre;
	private JComboBox<Ciclo> cmbGrado;
	private JCheckBox[] cbxTitulos;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private final static String[] JORNADA= {"Media Jornada", "Jornada Completa"};
	private final static String[] TITULOS= {"Permiso B1", "Ingles", "Euskera", "Experiencia"};
	
	public Ejercicio1() {
		dibujar();
		setSize(1350, 850);
		setTitle("Instanciar Empleo");
		setVisible(true);
		
	}
	private void dibujar() {
		this.setLayout(null);
		
		//imagen
		lbImagen=new JLabel(redim("img/fotojlabel.JPG", 265, 412));
		lbImagen.setBounds(50, 60, 350, 500);
		this.getContentPane().add(lbImagen);
		
		//nombre
		txtNombre=new JTextField("Escribe aquí tu nombre");
		txtNombre.setBounds(450, 100, 600, 40);
		this.getContentPane().add(txtNombre);
		
		//jornada
		ButtonGroup bg=new ButtonGroup();
		int x=450;
		radJornada=new JRadioButton [JORNADA.length];
		for(int i=0;i<JORNADA.length;i++) {
			radJornada[i]=new JRadioButton(JORNADA[i]);
			bg.add(radJornada[i]);
			radJornada[i].setBounds(x, 180, 280, 50);
			this.getContentPane().add(radJornada[i]);
			x=x+300;
			
		//grado
			cmbGrado=new JComboBox<Ciclo>(new Ciclo[] {
					new Ciclo("Desarrollo de Aplicaciones Web", "GS"),
					new Ciclo("Desarrollo de Aplicaciones Multiplataforma", "GS"),
					new Ciclo("Admminitracion de Sistemas Informaticos", "GS")
					});
			cmbGrado.setBounds(450, 250, 600, 30);
			this.getContentPane().add(cmbGrado);
			
		//titulos
			int x1=450;
			cbxTitulos=new JCheckBox[TITULOS.length];
			for(int j=0; j<TITULOS.length;j++) {
				cbxTitulos[j]=new JCheckBox(TITULOS[j]);
				cbxTitulos[j].setBounds(x1, 380, 150, 40);
				x1=x1+180;
				this.getContentPane().add(cbxTitulos[j]);
		//guardar y borrar
				btnGuardar=new JButton("GUARDAR");
				btnGuardar.setBounds(450, 450, 280, 60);
				this.getContentPane().add(btnGuardar);
				btnBorrar=new JButton("BORRAR");
				btnBorrar.setBounds(750, 450, 280, 60);
				this.getContentPane().add(btnBorrar);
				btnBorrar.setEnabled(false);
				
			}
		}
	
	}
	private static ImageIcon redim (String fichImag, int ancho, int alto)
	{
	            ImageIcon imIcon=new ImageIcon(fichImag);
	            Image im=imIcon.getImage();
	            Image im2= im.getScaledInstance(ancho, alto, 0);
	            return new ImageIcon(im2);
	}
	public static void main(String[] args) {
		Ejercicio1 vent=new Ejercicio1();
		vent.dibujar();
	
				
			
	}
}
