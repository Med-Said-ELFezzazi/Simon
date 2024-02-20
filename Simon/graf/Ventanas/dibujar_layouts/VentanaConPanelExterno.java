package dibujar_layouts;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaConPanelExterno extends JFrame{
	
	private JTextArea txt;
	private JButton bot;
	
	//Constructor
	public VentanaConPanelExterno() {
		this.setLayout(new BorderLayout());
		
		txt = new JTextArea();
		txt.setLineWrap(true);
		txt.setBackground(Color.gray);
		
		bot = new JButton("GUARDAR");
		
		this.getContentPane().add(txt, "Center");
		this.getContentPane().add(bot, "South");
		this.getContentPane().add(new PanelChecks("materias.txt"), "West");
		//this.getContentPane().add(panel3Botones(), "East");
		
		setSize(400,300);
		setVisible(true);
	}
	//Metodopanel3Botones
	private JPanel panel3Botones() {
		JPanel pan = new JPanel(new GridLayout(3,1));
		pan.add(new JButton("BOTON 1"));
		pan.add(new JButton("BOTON 2"));
		pan.add(new JButton("BOTON 3"));
		return pan;
	}
	//MAIN
	public static void main(String[] args) {
		new VentanaConPanelExterno();
	}

}
