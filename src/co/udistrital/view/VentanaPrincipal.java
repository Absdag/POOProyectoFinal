package co.udistrital.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal(){
		
		setTitle("POKEMON");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		InicializacionVentana ();
		
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void InicializacionVentana () {
		
	}
}
