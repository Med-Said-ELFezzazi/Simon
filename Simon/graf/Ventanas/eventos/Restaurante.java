package eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Restaurante extends JFrame implements MouseListener{
	
	private JTextField txtFich;
	private JList<String> lstAlimentos;
	private DefaultListModel<String> modeloLst;
	private JButton botAniadir;
	private JList<ProductoPedido> lstPlato;
	private DefaultListModel<ProductoPedido> modeloLstPlato;
	
	//Constructor
	public Restaurante() {
		dibujar();
		tratarEventos();
		pack();
		setVisible(true);
	}
	//Metodo tratarEventos
	private void tratarEventos() {
		
		//Al hacer intro en la caja de evento
		txtFich.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File(txtFich.getText());
				if(!f.exists())
					JOptionPane.showMessageDialog(null, "Fichero no existe");
				else {
					try {
						modeloLst.clear();
						BufferedReader br = new BufferedReader(new FileReader(f));
						String linea = br.readLine();
						while(linea!=null) {
							modeloLst.addElement(linea);
							linea = br.readLine();
						}
						br.close();
					} catch (FileNotFoundException e1) {
						
					} catch (IOException e1) {
					}
				}	
			}
		});
		///////////////////
		
		
		//Al hacer doble clic en la lista, desaparece el alimento pinchado
		lstAlimentos.addMouseListener(this);
		
		
		//Al pinchar boton >> añadir al plato
		botAniadir.addActionListener(new NuevoAlimListener());
	}
	//Metodo dibujar
	private void dibujar() {
		this.setLayout(new FlowLayout());
		
		this.getContentPane().add(new JLabel("Nombre fichero"));
		
		txtFich = new JTextField();
		txtFich.setPreferredSize(new Dimension(80,20));
		this.getContentPane().add(txtFich);
		
		modeloLst = new DefaultListModel<>();
		lstAlimentos = new JList<String>(modeloLst);
		
		lstAlimentos.setPreferredSize(new Dimension(100,200));
		lstAlimentos.setBackground(Color.ORANGE);
		this.getContentPane().add(lstAlimentos);
		
		botAniadir = new JButton(">>");
		this.getContentPane().add(botAniadir);
		
		modeloLstPlato = new DefaultListModel<>();
		lstPlato = new JList<ProductoPedido>(modeloLstPlato);
		lstPlato.setBackground(Color.CYAN);
		lstPlato.setPreferredSize(new Dimension(150,200));
		this.getContentPane().add(lstPlato);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2) {
			String alimentoSele = lstAlimentos.getSelectedValue();
			modeloLst.removeElement(alimentoSele);
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
	//Class NuevoAlimListener
	class NuevoAlimListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(lstAlimentos.getSelectedValue()==null)
				JOptionPane.showMessageDialog(null, "Debes selec.....");
			else {
				String alim = lstAlimentos.getSelectedValue();
				String strUds = JOptionPane.showInputDialog("Cunatas uds de "+alim+"?");
				int uds = Integer.parseInt(strUds);
				
				ProductoPedido pp = new ProductoPedido(alim, uds);
				
				if(modeloLstPlato.contains(pp)) {
					int iPrevio = modeloLstPlato.indexOf(pp);
					ProductoPedido previo = modeloLstPlato.getElementAt(iPrevio);
					previo.setCtd(previo.getCtd()+pp.getCtd());
					
					revalidate();
					repaint();
				}
				else {
					modeloLstPlato.addElement(pp);
				}
			}
		}
		
	}
	//MAIN
	public static void main(String[] args) {
		new Restaurante();
	}
}
