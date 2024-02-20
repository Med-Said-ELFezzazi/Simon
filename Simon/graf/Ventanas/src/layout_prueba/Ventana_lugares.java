package layout_prueba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class Ventana_lugares extends JFrame{
	private JList listLugares;
	private JButton botVer, botAniadir, botBorrar;
	public Ventana_lugares() {
		this.setTitle("Hola");
		dibujar();
		setSize(400, 300);
		setVisible(true);
	}
	private void dibujar() {
		this.setLayout(new BorderLayout());
		//norte, etiqueta con titulo lugares visitados
		JPanel panelPrinc=new JPanel();
		panelPrinc.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lblLugares=new JLabel("Lugares visitados");
		lblLugares.setFont(new Font("Arial", Font.BOLD, 18));
		panelPrinc.add(lblLugares);
		
		
		//Añadir componentes al panel principal
		
		//Centro : lista de lugars
		listLugares=new JList(new String[] {"Paris", "New York", "Amberes", "Calcuta"});
		listLugares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLugares.setBackground(Color.yellow);
		//Sur
		JPanel panelSur=new JPanel(new GridLayout(1, 3));
		
		
		botVer=new JButton("VER");
		botVer.setPreferredSize(new Dimension(0, 100));
		botAniadir=new JButton("AÑADIR");
		botBorrar=new JButton("BORRAR");
		panelSur.add(botAniadir);
		panelSur.add(botBorrar);
		panelSur.add(botVer);
		this.getContentPane().add(lblLugares, "North");
		this.getContentPane().add(listLugares, "Center");
		this.getContentPane().add(panelSur, "South");
		
	}
	public static void main(String[] args) {
		new Ventana_lugares();
	}
}
