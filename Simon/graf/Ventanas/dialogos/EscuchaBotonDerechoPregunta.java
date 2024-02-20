package dialogos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EscuchaBotonDerechoPregunta extends MouseAdapter{

	private Pregunta pregunta;
	
	//Cosntructor
	public EscuchaBotonDerechoPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3) {
			new DialogoPista(pregunta.getPista());
		}	
	}
}
