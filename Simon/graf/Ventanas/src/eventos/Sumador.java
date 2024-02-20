package eventos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sumador extends JFrame implements ActionListener {
	private JTextField txtn1, txtn2;
	private JButton suma, resta;
	private JTextArea txtTodas;
	private JLabel lblResultado;
	public Sumador() {
		dibujar();
		tratarEventos();
		
		setSize(400, 300);
		setVisible(true);
	}
	private void dibujar() {
		this.setLayout(new FlowLayout());
		
		txtn1=new JTextField(6);
		this.getContentPane().add(txtn1);
		
		suma=new JButton("+");
		this.getContentPane().add(suma);
		
		txtn2=new JTextField(6);
		this.getContentPane().add(txtn2);
		
		this.getContentPane().add(new JLabel("="));
		
		lblResultado=new JLabel();
		this.getContentPane().add(lblResultado);
		
		txtTodas=new JTextArea(5, 30);
		this.getContentPane().add(txtTodas);
		txtTodas.setEditable(false);
	}
	private void tratarEventos() {
		suma.addActionListener(this);
		try {
		float num1=Float.parseFloat(txtn1.getText());
		float num2=Float.parseFloat(txtn2.getText());
		float resultado=num1+num2;
		lblResultado.setText(resultado+"");
		txtTodas.append(num1+"+"+num2+"="+ resultado);
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Debes introducir 2 numeros");
			txtn1.setText(" ");
			txtn2.setText(" ");
			lblResultado.setText(" ");
		}
	}
	public static void main(String[] args) {
		new Sumador();
		//se pincha el boton
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
