package dibujar_null_layouts;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana3 extends JFrame{
	
	private JTextArea txtOpinion;
	private JCheckBox[] checks;
	
	private final static String[] HOBBIES= new String[]{"Lectura","Deporte","Cine","Musica"};
	
	//constructor
	public Ventana3( String titulo) {
		super(titulo);
		this.setLayout(null);
		
		//scoll
		
		txtOpinion = new JTextArea();
		txtOpinion.setBackground(Color.cyan);
		txtOpinion.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(txtOpinion, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10,10,200,200);
		this.getContentPane().add(scroll);
		
		//Panel con checkboxes
		int x =10;
		JPanel paneChecks = new JPanel();
		paneChecks.setLayout(null);
		checks = new JCheckBox[HOBBIES.length];
		for(int i = 0; i<HOBBIES.length; i++) {
			checks[i] = new JCheckBox(HOBBIES[i]);
			checks[i].setBounds(x, 0, 100, 30);
			x+=100;
			paneChecks.add(checks[i]);
		}
		paneChecks.setBounds(10, 300, 400, 50);
		paneChecks.setBorder(BorderFactory.createTitledBorder("Elige hobbie"));
		this.getContentPane().add(paneChecks);
		
		setSize(new Dimension(500,400));
		setVisible(true);
	}
	//main
	public static void main(String[] args) {
		new Ventana3("Formulario");
	}
}
