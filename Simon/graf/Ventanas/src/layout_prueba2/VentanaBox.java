package layout_prueba2;

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

public class VentanaBox extends JFrame{
	private JButton btnGuardar;
	private JTextField txtNombre;
	private JComboBox<String> cbProf;
	private final static String[] IMAGENES= {"img1.jpg", "img2.jpg", "img3.jpg", "img4.jpg", 
			"img5.jpg", "img6.jpg", "img7.jpg", "img8.jpg", "img9.jpg", };
	
	public VentanaBox() {
		setVisible(true);
		setSize(400, 300);
		dibujar();
	}
	
	private void dibujar() {
		BoxLayout bl=new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(bl);
		
		//nombre
		JPanel pNombre=new JPanel();
		pNombre.add(new JLabel("NOMBRE"));
		txtNombre=new JTextField(15);
		
		pNombre.add(txtNombre);
		
		//profesion
		JPanel pProf=new JPanel();
		pProf.add(new JLabel("Profesion"));
		cbProf=new JComboBox<String>(new String[] {"Autonomo", "Pensionista", "Funcionario"});
		pProf.add(cbProf);
		
		
		
		//grid de imgs
		JPanel pImg=new JPanel(new GridLayout(0, 4));
		for(int i=0; i<IMAGENES.length;i++) {
			JLabel lbl=new JLabel(new ImageIcon(IMAGENES[i]));
			pImg.add(lbl);
			
		}
		pImg.setPreferredSize(new Dimension(0, 200));
		
		
		//boton guardar
		JPanel pBtn=new JPanel();
		btnGuardar=new JButton("GUARDAR");
		pBtn.add(btnGuardar);
	
		
		//añadir todo al contenedor principal
		this.getContentPane().add(pNombre);
		this.getContentPane().add(pProf);
		this.getContentPane().add(pImg);
		this.getContentPane().add(pBtn);
	}
	public static void main(String[] args) {
		
		new VentanaBox();
		
	}
}
