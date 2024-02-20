package Ventanas1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;


import javax.swing.JFrame;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Ejercicio2.Pato;

public class Ejercicio2 extends JFrame {

	private JButton btnGuardar;
	private JList <Pato> listPatos;
	private JCheckBox [] cbxComidas;
	
	public Ejercicio2() {
		super("Alimenta A Tus Patos");
		this.setLayout(null);
		dibujar();
		
		setVisible(true);
		setSize(1400,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	public void dibujar() {
		this.setLayout(null);
		
		//LISTA
		listPatos=new JList<Pato>(new Pato[] {
			new Pato("Donald", 80),	
			new Pato("Lucas", 50),
			new Pato("Roger", 180),
			new Pato("Daisy", 70)
			});
		
		listPatos.setBounds(100, 100, 250, 250);
		this.getContentPane().add(listPatos);
		listPatos.setBackground(Color.pink);
		
		//PANEL SCROLL
		JScrollPane scrollPanel=new JScrollPane(listPatos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setLocation(100, 100);
		scrollPanel.setSize(250, 250);
		this.getContentPane().add(scrollPanel);
		
		
		//BOTÓN GUARDAR
		btnGuardar=new JButton("GUARDAR");
		btnGuardar.setBounds(100, 400, 250, 80);
		this.getContentPane().add(btnGuardar);
		
		//PANEL CHECKBOX
		JPanel panelCheckBox=new JPanel();
		panelCheckBox.setLayout(null);
		int y = 100;
		cbxComidas = new JCheckBox[comidas("comidas.txt").length];
		for(int i = 0; i< comidas("comidas.txt").length && comidas("comidas.txt")[i]!=null; i++) {
			cbxComidas[i] = new JCheckBox(comidas("comidas.txt")[i]);
			cbxComidas[i].setBounds(600, y, 400, 40);
			y+=80;
			panelCheckBox.add(cbxComidas[i]);
		}
		panelCheckBox.setBounds(600, 100, 400, 500);
		this.getContentPane().add(panelCheckBox);
		
		
		
		
		
		
	}
	//FICHERO CON COMIDAS
	private String[] comidas(String nomFich) {
		String[] comidas = new String[100];
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomFich));
			String linea = br.readLine();
			int i = 0;
			while(linea!=null) {
				comidas[i] = linea;
				linea = br.readLine();
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido abrir el fichero "+nomFich);
		}catch (IOException e) {
			System.out.println("No se ha podido leer el fichero "+nomFich);
		}
		return comidas;
	}
	public static void main(String[] args) {
		new Ejercicio2();
		
	}
		
	
}
