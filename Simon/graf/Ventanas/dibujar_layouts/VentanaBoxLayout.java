package dibujar_layouts;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaBoxLayout extends JFrame{
	private JTextField txtNombre;
	private JComboBox cmbProfs;
	private final static String[] IMGS = {"attribcr.jpg", "bg.jpg","eclipse_update_120.jpg","udshfui.jpg","w_128x52.jpg","websheet_anatomy.jpg","attribcr.jpg", "bg.jpg","eclipse_update_120.jpg","udshfui.jpg","w_128x52.jpg","websheet_anatomy.jpg"};
	private JButton botGuardar;
	
	//Constructor
	public VentanaBoxLayout() {
		
		dibujar();
		
		//setSize(500,500);
		pack();
		setVisible(true);
	}
	//Metodo dibujar
	private void dibujar() {
		BoxLayout bl = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(bl);
		
		//Nombre + txtField_nombre
		JPanel panNombre = new JPanel();  //FlowLayout centrado por defecto
		panNombre.add(new JLabel("NOMBRE"));
		txtNombre = new JTextField();
		panNombre.add(txtNombre);
		
		//Profesion + combo_profesion
		JPanel panProfesion = new JPanel();  //FlowLayout centrado por defecto
		panProfesion.add(new JLabel("PROFESIONES"));
		cmbProfs = new JComboBox<String>(new String[] {"Autonomo", "Pensionista", "Funcionario"});
		panProfesion.add(cmbProfs);
		
		//Grid con imagenes
		JPanel panImgs = new JPanel(new GridLayout(0,4));
		for(int i = 0; i<IMGS.length; i++) {
			JLabel lbl = new JLabel(new ImageIcon("img\\"+IMGS[i]));
			panImgs.add(lbl);
		}
		panImgs.setPreferredSize(new Dimension(0, 150));
		
		//Boton
		botGuardar = new JButton("GUARDAR");
		
		//AÑADIR TODO AL CONTENEDOR PRINCIPAL
		this.getContentPane().add(panNombre);
		this.getContentPane().add(panProfesion);
		this.getContentPane().add(panImgs);
		this.getContentPane().add(botGuardar);
		
	}
	//main
	public static void main(String[] args) {
		new VentanaBoxLayout();
	}

}
