package dibujar_layouts;

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

public class VentanaLugares extends JFrame{
	
	private JList lstLugares;
	private JButton botVer, botAniadir, botBorrar;
	
	
	//Constructor
	public VentanaLugares() {
		this.setTitle("LUGARES VISITADOS");
		dibujar();
		
		
		setSize(400,300);
		setVisible(true);
	}
	//Metodo dibujar
	private void dibujar() {
		this.setLayout(new BorderLayout());
		
		//NORTE: Etiqueta con titulo "Lugares visitados"
		JPanel panLbl = new JPanel();
		panLbl.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lbl = new JLabel("LUGARES VISITADOS");
		lbl.setFont(new Font("Arial", Font.BOLD, 18));
		panLbl.add(lbl);
		
		//CENTRO
		lstLugares = new JList(new String [] {"Paris", "New York", "Amberes", "Calcuta"});
		lstLugares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstLugares.setBackground(new Color(0.9f, 0.3f, 0.5f));
		
		//SUR: 3 Botones
		
		JPanel panSur = new JPanel(new GridLayout(1,3));
		
		botVer = new JButton("VER");
		botAniadir = new JButton("AÑADIR");
		botBorrar = new JButton("BORRAR");
		
		botVer.setPreferredSize(new Dimension(0,100));//setSize cuando hagamos nullLayout, pero para layout tiene que ser así
		
		panSur.add(botVer);
		panSur.add(botAniadir);
		panSur.add(botBorrar);
		
		//añadir componentes al panel principal
		this.getContentPane().add(panLbl, "North");
		this.getContentPane().add(lstLugares, "Center");
		this.getContentPane().add(panSur, "South");
		
	}
	//main
	public static void main(String[] args) {
		new VentanaLugares();
	}

}
