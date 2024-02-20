package dialogos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaTest extends JFrame{
	
	private JLabel[] lblsTextos;
	private JButton[] bots;
	private JLabel[] lblsAciertos;
	
	
	private final static Pregunta[] PREGS = new Pregunta[] {
			new Pregunta("2+2",new String[] {"4","2","1"},0),
			new Pregunta("Capital de Ukrania",new String[] {"Moscu","Kiev"},1),
			new Pregunta("2/2",new String[] {"4","2","1"},2),
			new Pregunta("2*2",new String[] {"4","2","1"},0)
			};
	
	private VentanaTest yo;
	
	//constructor
	public VentanaTest() {
		this.yo = this;
		
		dibujar();
		eventos();
		
		pack();
		setVisible(true);
	}
	//Metodo dibujar
	private void dibujar() {
		this.setLayout(new GridLayout(0,3));
		
		lblsTextos = new JLabel[PREGS.length];
		bots = new JButton[PREGS.length];
		lblsAciertos = new JLabel[PREGS.length];
		
		for(int i = 0; i<PREGS.length; i++) {
			lblsTextos[i] = new JLabel(PREGS[i].getTexto());
			bots[i] = new JButton("RESPONDER");
			lblsAciertos[i] = new JLabel("Sin responder");
			
			this.getContentPane().add(lblsTextos[i]);
			this.getContentPane().add(bots[i]);
			this.getContentPane().add(lblsAciertos[i]);
		}
		
	}
	//Metodo eventos
	private void eventos() {
		for(int i = 0; i<bots.length; i++) {
			bots[i].addActionListener(new Escuchadorboton(i));
		}
		
		
		
		for(int i = 0; i<lblsTextos.length; i++) {
			lblsTextos[i].addMouseListener(new EscuchaBotonDerechoPregunta(PREGS[i]));
		}
	}
	//Class Escuchadorboton
	class Escuchadorboton implements ActionListener{
		private int iPregunta;
		
		Escuchadorboton(int iPregunta){
			this.iPregunta = iPregunta;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//Se ha pinchado un boton 
			
			DialogoPregunta d = new DialogoPregunta(yo, PREGS[iPregunta]);
			//Colgada la ventana ppal hasta que se vuelva del diálogo
			if(d.isAcertado()) {
				lblsAciertos[iPregunta].setText("ACERTADO");
				bots[iPregunta].setEnabled(false);
			}
		}
	}
	//main
	public static void main(String[] args) {
		new VentanaTest();
	}

}
