package Ejercicio2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AlimentaATusPatos extends JFrame{
	
	private Pato[] patos = new Pato[] {
			new Pato("Donald", 80),
			new Pato("Lucas", 50),
			new Pato("Roger", 180),
			new Pato("Daisy", 70)
	};
	private JList lstPatos;
	private JCheckBox[] alimentosCheck;
	private JButton botGuardar;
	
	//constructor
	public AlimentaATusPatos() {
		super("Alimenta A Tus Patos");
		this.setLayout(null);
		dibujar();
		
		setVisible(true);
		setSize(600,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	//Metodo dibujar
	private void dibujar() {
		
		//Insertra lista de patos dentro de un scroll
		lstPatos = new JList(patos);
		lstPatos.setBackground(Color.pink);
		lstPatos.setLocation(20,20);
		lstPatos.setSize(300,200);
		
		JScrollPane scroll = new JScrollPane(lstPatos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setLocation(20,20);
		scroll.setSize(200,200);
		this.getContentPane().add(scroll);
		
		//Boton guardar
		botGuardar = new JButton("GUARDAR");
		botGuardar.setBounds(20,250,200,40);
		this.getContentPane().add(botGuardar);
		
		//Panel con checkboxes
		JPanel paneChecks = new JPanel();
		paneChecks.setLayout(null);
		int y = 10;
		alimentosCheck = new JCheckBox[alimentos("comidas.txt").length];
		for(int i = 0; i< alimentos("comidas.txt").length && alimentos("Comidas.txt")[i]!=null; i++) {
			alimentosCheck[i] = new JCheckBox(alimentos("comidas.txt")[i]);
			alimentosCheck[i].setBounds(0, y, 80, 30);
			y+=40;
			paneChecks.add(alimentosCheck[i]);
		}
		paneChecks.setBounds(300, 10, 500, 500);
		this.getContentPane().add(paneChecks);
	}
	//Metodo alimentos
	private String[] alimentos(String nomFich) {
		String[] alimentos = new String[100];
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomFich));
			String linea = br.readLine();
			int i = 0;
			while(linea!=null) {
				alimentos[i] = linea;
				linea = br.readLine();
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Imposible abrir el fichero "+nomFich);
		}catch (IOException e) {
			System.out.println("Imposible leer el fichero "+nomFich);
		}
		return alimentos;
	}
	//main
	public static void main(String[] args) {
		new AlimentaATusPatos();
	}

}
