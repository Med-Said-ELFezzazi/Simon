package dibujar_null_layouts;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ventana4 extends JFrame{
	
	private Viaje[] VIAJES = new Viaje[] {
		new Viaje("Maldivas", 15,'c'),
		new Viaje("New York", 10,'a'),
		new Viaje("Londres", 5,'a'),
		new Viaje("Mallorca", 20,'b')
	};
	private JList lstViajes;
	private ArrayList<JLabel> lblImgs;
	
	//constructor
	public Ventana4() {
		
		String carpe = JOptionPane.showInputDialog(null,"Nombre carpeta con imagens?");
		if(carpe!= null) {
			dibujar(carpe);
			
			//Viaje vSelect = (Viaje) lstViajes.getSelectedValue();
			
			
			
			setSize(new Dimension(500,600));
			setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(null, "Debes introducir un nombre carpeta");
	}
	//Metodo dibujar
	private void dibujar(String carpe) {
		this.setLayout(null);
		
		//Lista con Objetos viaje
		lstViajes = new JList<>(VIAJES);
				//lstViajes.setSelectedIndex(0);
		lstViajes.setLocation(20,20);
		lstViajes.setSize(300,200);
		JScrollPane scroll = new JScrollPane(lstViajes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setLocation(20,20);
		scroll.setSize(200,200);
		
		
		//JPanel con imagenes de "carpe"
		JPanel panImg = new JPanel();
		panImg.setLayout(null);
		
		String[] imgs = imagenesDeCarpeta(carpe);
		lblImgs = new ArrayList<JLabel>();
		int y=0;
		for(int i = 0; i<imgs.length; i++){
			JLabel lbl = new JLabel(new ImageIcon (carpe+"/"+imgs[i]));
			lbl.setBounds(0, y, 70, 70);
			lblImgs.add(lbl);
			panImg.add(lbl);
			y+=100;
		}
		panImg.setBounds(350, 20, 200, 500);
		
		
		this.getContentPane().add(scroll);
		this.getContentPane().add(panImg);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Para que cuando cierras la ventana que se cierre y no se quede abierto
	}
	//Metodo imagenesDeCarpeta
	private String[] imagenesDeCarpeta(String carpeta) {
		File f = new File("carpeta");
		if(f.exists() && f.isDirectory()) {
			String[] entradasDir = f.list();
			return entradasDir;
		}
		else
			return null;
	}
	//main
	public static void main(String[] args) {
		new Ventana4();
	}
}
