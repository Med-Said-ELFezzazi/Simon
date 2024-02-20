package Tanda_ejercicos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Calculadora extends JFrame{
	private final static String [] NUMEROS= {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private final static String [] SISTEMAS= {"Decimal", "Bianrio", "Octal", "Hexadecimal"};
	
	public Calculadora() {
		setVisible(true);
		setSize(400, 300);
		dibujar();
		setTitle("Calculadora");
	}
	private void dibujar() {
		this.setLayout(new BorderLayout());
		
		//Centro
		JPanel pNums=new JPanel(new GridLayout(0, 3));
		for (int i=0; i<NUMEROS.length;i++) {
			JButton btn=new JButton(NUMEROS[i]);
			pNums.add(btn);
		}
		
		
		//Norte
		JPanel p0=new JPanel();
		JLabel lbl0=new JLabel("0");
		lbl0.setFont(new Font("Arial",Font.BOLD, 20));
		
		p0.add(lbl0);
		p0.setBackground(Color.gray);
		p0.setPreferredSize(new Dimension(0, 75));
		//Sur
		JPanel pSur=new JPanel(new FlowLayout());
		JButton btnsuma=new JButton("+");
		JButton btnresta=new JButton("-");
		JButton btnX=new JButton("x");
		JButton btndividir=new JButton("/");
		JButton btnigual=new JButton("=");
		btnigual.setPreferredSize(new Dimension(50, 50));
		btnsuma.setPreferredSize(new Dimension(50, 50));
		btnresta.setPreferredSize(new Dimension(50, 50));
		btndividir.setPreferredSize(new Dimension(50, 50));
		btnX.setPreferredSize(new Dimension(50, 50));
		pSur.add(btnsuma);
		pSur.add(btnresta);
		pSur.add(btnX);
		pSur.add(btndividir);
		pSur.add(btnigual);
		
		
		//Oeste
		JPanel pOeste=new JPanel();
		pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));
		ButtonGroup bg=new ButtonGroup();
		for(int i=0;i<SISTEMAS.length;i++) {
			JRadioButton rbSist=new JRadioButton(SISTEMAS[i]);
			pOeste.add(rbSist);
			bg.add(rbSist);
		}
		//añadir
		this.getContentPane().add(pNums, "Center");
		this.getContentPane().add(p0, "North");
		this.getContentPane().add(pSur, "South");
		this.getContentPane().add(pOeste, "West");
		
	}
	public static void main(String[] args) {
		new Calculadora();
	}
}
