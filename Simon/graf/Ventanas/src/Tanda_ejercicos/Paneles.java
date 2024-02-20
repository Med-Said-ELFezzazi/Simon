package Tanda_ejercicos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Paneles extends JFrame {
	private final static String[] LABELS= {"Label1", "Label2", "Label3"};
	public Paneles() {
		setVisible(true);
		setSize(400, 300);
		dibujar();
		dibujar2();
		setTitle("Paneles añadidos en BoxLayout");
		BoxLayout bl=new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(bl);
	}
	private void dibujar() {
		
		//PANEL 1
			//oeste
			JPanel p1=new JPanel(new BorderLayout());
			p1.setBorder(BorderFactory.createTitledBorder("Border Layout"));
			JPanel p1_2=new JPanel(new GridLayout(0, 1));
			p1_2.setBorder(BorderFactory.createTitledBorder("Grid Layout"));
			p1.add(p1_2, "West");
			for(int i=0; i<LABELS.length;i++) {
				JLabel lbl=new JLabel(LABELS[i]);
				lbl.setPreferredSize(new Dimension(170, 40));
				p1_2.add(lbl);
			}
			//centro
			JPanel p1_1=new JPanel(new GridLayout(0, 1));
			p1_1.setBorder(BorderFactory.createTitledBorder("Grid Layout"));
			p1.add(p1_1, "Center");
			for(int j=0; j<LABELS.length;j++) {
				JTextField txt=new JTextField();
				p1_1.add(txt);
			}
		
		
		
		
		

			
		
		
		//AÑADIR
		this.getContentPane().add(p1);
		
	}
	private void dibujar2() {
		//PANEL2
		JPanel p2=new JPanel(new BorderLayout());
		p2.setBorder(BorderFactory.createTitledBorder("Border Layout"));
		JPanel p2_1=new JPanel(new FlowLayout());
		p2_1.setBorder(BorderFactory.createTitledBorder("Flow Layout"));
		JButton btnClick=new JButton("Click Me");
		p2_1.add(btnClick);
		p2.add(p2_1, "North");
		
		JTextField txt=new JTextField("TEXTAREA:");
		
		
		p2.add(txt, "Center");
		
		
		JButton btnOk=new JButton("OK");
		
		
		
		//AÑADIR
		this.getContentPane().add(p2);
		this.getContentPane().add(btnOk);
		
	}
	public static void main(String[] args) {
		new Paneles();
	}
}
