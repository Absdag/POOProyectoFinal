package co.udistrital.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	
	//Menu principal
	private PanelMenuPrincipal menuPrincipal;
	
	//Inventarios 
	private PanelSeleccionInventario inventario;
	private PanelSeleccionCombate inventarioCombate;
	
	private PanelModificacionPokemon edicionPokemon;
	
	
	//Manejador del combate
	private PanelCombatePokemon  interfazCombate;
	

	public VentanaPrincipal(){
		
		setTitle("POKEMON");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inicializacionComponentes ();
		
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void inicializacionComponentes () {
		
	}
}
