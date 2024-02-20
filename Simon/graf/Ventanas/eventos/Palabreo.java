package eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Palabreo extends JFrame implements ActionListener{
	
	private JLabel lblNumLetras;
	private JTextField txtIntento;
	private JButton botComprobar;
	
	private JList<String> lstFallos;
	private DefaultListModel<String> modeloLista;
	
	private String palActual;
	
	//Constructor
	public Palabreo() {
		
		dibujar();
		tratarEventos();
		
		setSize(500,300);
		setVisible(true);
	}
	//Metodo tratarEventos
	private void tratarEventos() {
		
		this.addMouseListener(new EscuchadorVentana());
		
		botComprobar.addActionListener(this);
		
		txtIntento.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if (!(car>='A' && car<='Z')){
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
	}
	//Class EscuchadorVentana
	public class EscuchadorVentana implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				String palNueva = palabraRandom();
				while(palNueva.equals(palActual))
					palNueva = palabraRandom();
				palActual = palNueva;
				resetear();
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
	//Metodo resetear
	private void resetear() {
		lblNumLetras.setText(palActual.length()+" letras");
		txtIntento.setText("");
		modeloLista.removeAllElements();
	}
	//Metodo dibujar
	private void dibujar() {
		
		this.setLayout(new FlowLayout());
		
		palActual =  palabraRandom();
		lblNumLetras = new JLabel(palActual.length()+" letras");
		
		txtIntento = new JTextField(10);
		
		botComprobar = new JButton("COMPROBAR");
		
		modeloLista = new DefaultListModel<String>();
		lstFallos = new JList<String>(modeloLista);
		lstFallos.setPreferredSize(new Dimension(100,200));
		lstFallos.setBackground(Color.cyan);
		
		this.getContentPane().add(lblNumLetras);
		this.getContentPane().add(txtIntento);
		this.getContentPane().add(botComprobar);
		this.getContentPane().add(lstFallos);
		
		
	}
	//Metodo damePalabra
	private String palabraRandom() {
		final String[] PALS = new String[] {"MESSA", "PANTALLA", " SILLA"};
		
		int i = (int) (Math.random()*PALS.length);
		
		return PALS[i];
	}
	
	
	//Main
	public static void main(String[] args) {
		new Palabreo();
	}
	
	
	//Metodo actionPerformed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botComprobar) {
			if(txtIntento.getText().equals(palActual)) {
				JOptionPane.showMessageDialog(null, "Enhorabuena!");
				this.dispose(); //Cerrar ventana
			}
			else {
				modeloLista.addElement(txtIntento.getText());
				txtIntento.setText("");
			}
		}
		
	}
}
