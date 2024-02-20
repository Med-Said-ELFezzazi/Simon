package dialogos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPpal extends JFrame implements ActionListener{
	
	private JLabel lblSaludo;//Hola "nombre variable"!
	private JButton botCambio;
	private DialogoNombreModal dialogo;
	
	
	//Constructor
	public VentanaPpal() {
		
		lblSaludo = new JLabel("Hola DESCONOCIDO!");
		lblSaludo.setPreferredSize(new Dimension(0,100));
		botCambio = new JButton("CAMBIAR NOMBRE");
		
		this.getContentPane().add(lblSaludo,"North");
		this.getContentPane().add(botCambio,"Center");
		dialogo = new DialogoNombreModal(this);
		
		eventos();
		
		setSize(300,300);
		setVisible(true);
	}
	//Metodo eventos
	private void eventos() {
		botCambio.addActionListener(this);
	}
	//Metodo cambiarSaludo
		public void cambiarSaludo(String nombre) {
			lblSaludo.setText(nombre);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		dialogo.vaciarNombre();
		dialogo.setVisible(true);
		
		//En espera...de que el diálogo
	}
	//main
	public static void main(String[] args) {
		new VentanaPpal();
	}
}
