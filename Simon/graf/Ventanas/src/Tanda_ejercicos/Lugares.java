package Tanda_ejercicos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Tanda1.Ciclo;

public class Lugares extends JFrame {
	private final static String[] LUGARES= {"lugares/barcelona.jpg", "lugares/baticano.jpg", "lugares/taj_mahal.jpg", "lugares/tower_bridge.jpg", "lugares/madrid.jpg","lugares/moscu.jpg","lugares/eiffel.jpg", "lugares/golden.jpg", "lugares/casa_blanca.jpg", "lugares/piramides.jpg"};
	private JComboBox<String> cmbLugares;
	public Lugares() {
		setSize(400, 300);
		
		dibujar();
		setVisible(true);
	}
	private void dibujar() {
		//Panel principal
		BorderLayout bl=new BorderLayout();
		this.setLayout(bl);
		
		//NORTE
		JPanel pNorte=new JPanel(new FlowLayout());
		JLabel lblPregunta=new JLabel("CONOCES ESTOS LUGARES?");
		pNorte.add(lblPregunta);
		
		//OESTE
		JPanel pOeste=new JPanel();
		pOeste.setLayout(new BoxLayout(pOeste, BoxLayout.Y_AXIS));
		pOeste.setPreferredSize(new Dimension(150, 300));
		JPanel p1=new JPanel(new GridLayout(0, 1));
		pOeste.add(p1);
		cmbLugares=new JComboBox<String>(LUGARES);
		JPanel p1_1=new JPanel(new FlowLayout());
		p1.add(p1_1);
		JLabel lbl2=new JLabel("Imagen seleccionada");
		p1_1.add(lbl2);
		p1_1.add(cmbLugares);
		JTextField txt=new JTextField("Escribe tu opinión");
		p1.add(txt);
		JPanel p2=new JPanel(new FlowLayout());
		JButton btn=new JButton("GUARDAR");
		p2.add(btn);
		pOeste.add(p2);
		//CENTRO
		JPanel pCentro=new JPanel(new GridLayout(0, 3));
		
		JLabel lbImagen=new JLabel(redim("img/casa_dali.JPG", 200, 125));
		pCentro.add(lbImagen);
		JLabel lbImagen2=new JLabel(redim("img/baticano.JPEG", 200, 125));
		pCentro.add(lbImagen2);
		JLabel lbImagen3=new JLabel(redim("img/taj_mahal.JPG", 200, 125));
		pCentro.add(lbImagen3);
		JLabel lbImagen4=new JLabel(redim("img/tower_bridge.JPG", 200, 125));
		pCentro.add(lbImagen4);
		JLabel lbImagen5=new JLabel(redim("img/madrid.JPG", 200, 125));
		pCentro.add(lbImagen5);
		JLabel lbImagen6=new JLabel(redim("img/moscu.JPG", 200, 125));
		pCentro.add(lbImagen6);
		JLabel lbImagen7=new JLabel(redim("img/eiffel.JPG", 200, 125));
		pCentro.add(lbImagen7);
		JLabel lbImagen8=new JLabel(redim("img/golden.JPG", 200, 125));
		pCentro.add(lbImagen8);
		JLabel lbImagen9=new JLabel(redim("img/casa_blanca.JPG", 200, 125));
		pCentro.add(lbImagen9);
		JLabel lbImagen10=new JLabel(redim("img/piramides.JPG", 200, 125));
		pCentro.add(lbImagen10);
		
		
		
		
		
		//AÑADIR
		this.getContentPane().add(pNorte, "North");
		this.getContentPane().add(pCentro, "Center");
		this.getContentPane().add(pOeste, "West");
		
	}
	private static ImageIcon redim (String fichImag, int ancho, int alto)
	{
	            ImageIcon imIcon=new ImageIcon(fichImag);
	            Image im=imIcon.getImage();
	            Image im2= im.getScaledInstance(ancho, alto, 0);
	            return new ImageIcon(im2);
	}
		
	public static void main(String[] args) {
		new Lugares();
	}
}
