package co.udistrital.view;

import java.awt.*;

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
		
		getContentPane().setLayout(new FlowLayout());
		
		inicializacionComponentes ();
		
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void inicializacionComponentes () {
		menuPrincipal = new PanelMenuPrincipal();
		getContentPane().add(menuPrincipal);
		menuPrincipal.habilitarPanel();
		
		inventario = new PanelSeleccionInventario();
		getContentPane().add(inventario);
		inventarioCombate = new PanelSeleccionCombate();
		getContentPane().add(inventarioCombate);
		
		edicionPokemon = new PanelModificacionPokemon();
		getContentPane().add(edicionPokemon);
		
		interfazCombate = new PanelCombatePokemon();
		getContentPane().add(interfazCombate);
		
	}
	
	public void salirPrograma() {
		this.dispose();
	}

	public PanelMenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(PanelMenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public PanelSeleccionInventario getInventario() {
		return inventario;
	}

	public void setInventario(PanelSeleccionInventario inventario) {
		this.inventario = inventario;
	}

	public PanelSeleccionCombate getInventarioCombate() {
		return inventarioCombate;
	}

	public void setInventarioCombate(PanelSeleccionCombate inventarioCombate) {
		this.inventarioCombate = inventarioCombate;
	}

	public PanelModificacionPokemon getEdicionPokemon() {
		return edicionPokemon;
	}

	public void setEdicionPokemon(PanelModificacionPokemon edicionPokemon) {
		this.edicionPokemon = edicionPokemon;
	}

	public PanelCombatePokemon getInterfazCombate() {
		return interfazCombate;
	}

	public void setInterfazCombate(PanelCombatePokemon interfazCombate) {
		this.interfazCombate = interfazCombate;
	}
	
	
}
