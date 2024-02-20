package dialogos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DialogoPregunta extends JDialog{

	private VentanaTest owner;
	private Pregunta pregunta;
	
	private JRadioButton[] radRptas;
	private JButton botResponder;
	
	private boolean acertado;
	
	public DialogoPregunta(VentanaTest owner, Pregunta pregunta) {
		super(owner);
		this.owner = owner;
		this.pregunta = pregunta;
		this.setModal(true);
		
		dibujar();
		eventos();
		
		setSize(200,200);
		setVisible(true);
	}
	//Metodo dibujra
	private void dibujar() {
		this.setTitle(pregunta.getTexto());
		
		BoxLayout bl = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.setLayout(bl);
		
		radRptas = new JRadioButton[pregunta.getRptas().length];
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i<pregunta.getRptas().length; i++) {
			String rpta = pregunta.getRptas()[i];
			radRptas[i] = new JRadioButton(rpta);
			this.getContentPane().add(radRptas[i]);
			bg.add(radRptas[i]);
		}
		botResponder = new JButton("RESPONDER");
		this.getContentPane().add(botResponder);
	}
	//Metodo iRadioSelecionado
	private int iRadioSelecionado() {
		//-a si no se ha seleccionado  ninguno
		
		for(int i = 0; i<radRptas.length; i++) {
			if(radRptas[i].isSelected())
				return i;
		}
		
		return -1;
	}
	//Metodo eventos
	private void eventos() {
		botResponder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int iSel = iRadioSelecionado();
				if(iSel==1)
					JOptionPane.showMessageDialog(null, "No se ha selecionado ninguna respuesta");
				else {
					if(pregunta.getiBuena()==iSel)
						acertado = true;
					else 
						acertado = false;
					setVisible(false); //devuelve el control a ventana ppla
				}
			}
		});	
	}
	public boolean isAcertado() {
		return acertado;
	}
}
