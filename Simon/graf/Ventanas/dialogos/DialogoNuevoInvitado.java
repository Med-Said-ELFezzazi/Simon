package dialogos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialogoNuevoInvitado extends JDialog{

	private JTextField txtNombre;
	private VentanaInvitados owner;
	
	public DialogoNuevoInvitado(VentanaInvitados owner) {
		super(owner);
		this.owner = owner;
		
		setModal(false);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.yellow);
		this.getContentPane().add(txtNombre,"Center");//si no pones nada se añade en la zona centro
		
		eventos();
		
		setSize(200,100);
		setVisible(true);
	}
	//Metodo eventos
	private void eventos() {
		txtNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!owner.aniadeInvitado(txtNombre.getText()))
					JOptionPane.showMessageDialog(null, "Ya existe");
				else {
					dispose();
				}
			}
		});
	}
}
