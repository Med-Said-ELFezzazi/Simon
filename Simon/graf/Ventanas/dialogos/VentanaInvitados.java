package dialogos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class VentanaInvitados extends JFrame implements ActionListener{

	private JList lstInvitados;
	private DefaultListModel<String> modeloInv;
	private JButton botAniadir;
	
	//Constructor
	public VentanaInvitados() {
		super("LISTA INVITADOS");
		
		//Dibujar
		modeloInv = new DefaultListModel<>();
		lstInvitados = new JList<String>(modeloInv);
		this.getContentPane().add(lstInvitados,"Center");
		
		botAniadir = new JButton("AÑADIR INVITADO");
		botAniadir.setPreferredSize(new Dimension(0,150));
		this.getContentPane().add(botAniadir,"South");
		
		//evento
		botAniadir.addActionListener(this);
		
		
		setSize(400,400);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//Al pinchar boton AÑADIR INVITADO
		DialogoNuevoInvitado d = new DialogoNuevoInvitado(this);
		
	}
	//Metodo aniadeInvitado
	public boolean aniadeInvitado(String nombre) {
		if(modeloInv.contains(nombre))
			return false;
		modeloInv.addElement(nombre);
		return true;
	}
	//main
	public static void main(String[] args) {
		new VentanaInvitados();
	}
}
