package dialogos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialogoNombreModal extends JDialog implements ActionListener{
	
	private JTextField txtNombre;
	private VentanaPpal owner;
	
	//Constructor
	public DialogoNombreModal(VentanaPpal owner) {
		super(owner);
		this.owner = owner;
		
		this.setModal(true);
		this.setLayout(new FlowLayout());
		
		txtNombre = new JTextField(20);
		this.getContentPane().add(new JLabel("Itroduce tu nombre"));
		this.getContentPane().add(txtNombre);
		
		eventos();
		
		pack();
		setVisible(false);
	}
	//Metodo eventos
	private void eventos() {
		
		txtNombre.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Al pulsar Return en la caja de texto
		
		if(txtNombre.getText().equals("")) 
			JOptionPane.showMessageDialog(null, "Tienes q escribir algo");
		else {
			owner.cambiarSaludo(txtNombre.getText());
			this.setVisible(false);
		}
	}
	//Metodo vaciarNombre
	public void vaciarNombre() {
		txtNombre.setText("");
	}
}
