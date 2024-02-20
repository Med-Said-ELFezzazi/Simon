package eventos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sumador extends JFrame implements ActionListener{
	
	private JTextField txtNum1, txtNum2;
	private JButton botSumar, botRestar;
	private JTextArea txtTodas;
	private JLabel lblRtdo;
	
	//CONSTRUCTOR
	public Sumador() {
		dibujar();
		tratarEventos();
		setSize(400,400);
		setVisible(true);
	}
	
	//Metodo tratarEventos
	private void tratarEventos() {
		
		botSumar.addActionListener(this);
		botRestar.addActionListener(this);
		
		this.addMouseListener(new EscuchaClicVentana());
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por sumar/restar");
			}
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	//Metodo dibujar
	private void dibujar() {
		
		this.setLayout(new FlowLayout());
		
		txtNum1 = new JTextField(6);
		this.getContentPane().add(txtNum1);
		
		botSumar = new JButton("+");
		this.getContentPane().add(botSumar);
		
		botRestar = new JButton("-");
		this.getContentPane().add(botRestar);
		
		txtNum2 = new JTextField(6);
		this.getContentPane().add(txtNum2);
		
		this.getContentPane().add(new JLabel("="));
		
		lblRtdo = new JLabel();
		this.getContentPane().add(lblRtdo);
		
		txtTodas = new JTextArea(5,30);
		txtTodas.setEditable(false);
		this.getContentPane().add(txtTodas);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Aqui viene cuando se pincha el boton "+"
		float rtdo = 0;
		String str="";
		try {
			float num1 = Float.parseFloat(txtNum1.getText());
			float num2 = Float.parseFloat(txtNum2.getText());
			
			if(e.getSource()==botSumar)
				rtdo = num1 + num2;
			if(e.getSource()==botRestar)
				rtdo = num1 - num2;
			if(e.getSource()==botSumar)
				str = num1+" + "+num2+" = "+rtdo;
			if(e.getSource()==botRestar)
				str = num1+" - "+num2+" = "+rtdo;
			lblRtdo.setText(rtdo+"");
			txtTodas.append(str+"\n");
		}
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Debes introducir dos números");
			txtNum1.setText("");
			txtNum2.setText("");
			lblRtdo.setText("");
		}
	}
	//Clase EscuchaClicVentana
	class EscuchaClicVentana implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				try {
					PrintWriter pw = new PrintWriter("operaciones.txt");
					pw.print(txtTodas.getText());
					pw.close();
					JOptionPane.showMessageDialog(null, "Fichero creado");
					txtNum1.setText("");
					txtNum2.setText("");
					lblRtdo.setText("");
				} 
				catch (FileNotFoundException e1) {
				}
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	//Main 
	public static void main(String[] args) {
		new Sumador();
	}
}
