package dibujar_layouts;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PanelChecks extends JPanel{
	private String nomFich;
	private JCheckBox[] checks;
	
	//constructor
	public PanelChecks(String nomFich) {
		this.nomFich = nomFich;
		
		this.setLayout(new GridLayout(0,1));
		ArrayList<String> lst = lineasFichero();
		checks = new JCheckBox[lst.size()];
		for(int i = 0; i<checks.length; i++) {
			checks[i] = new JCheckBox(lst.get(i));
			this.add(checks[i]);
		}
	}
	//Metodo lineasFichero
	private ArrayList<String> lineasFichero(){
		ArrayList<String> lst = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomFich));
			String linea = br.readLine();
			while(linea!= null) {
				lst.add(linea);
				linea = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return lst;
	}
}
