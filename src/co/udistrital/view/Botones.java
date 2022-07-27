package co.udistrital.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botones extends JPanel{
	
	private JButton btn1; 
	private JButton btn2; 
	private JButton btn3;
	
	public Botones () {
	setLayout(new GridLayout(1 , 3));;
	setVisible(true);
	ConfiguracionBotones();
	
	}

	public void ConfiguracionBotones () {
	btn1 = new JButton("inventario");
	btn2 = new JButton("combate");
	btn3 = new JButton("salir");
	
	add(btn1);
	add(btn2);
	add(btn3);
		
	}
	
		
}
