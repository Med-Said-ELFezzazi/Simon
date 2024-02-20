package dialogos;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogoPista extends JDialog{

	
	
	//Constructor
	public DialogoPista(String pista) {
		setModal(false);
		//Dibujar un label con la pista en la zona centro 
		this.getContentPane().add(new JLabel(pista));
		pack();
		setVisible(true);
	}
}
