package co.udistrital.view;

import java.awt.FlowLayout;
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
		setSize(1200,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new GridLayout(1,1));
		
		inicializacionComponentes ();
		
		setResizable(true);
		setVisible(true);
		setMinimumSize(new Dimension(600,500));
		setLocationRelativeTo(null);
	}
	
	public void inicializacionComponentes () {
		menuPrincipal = new PanelMenuPrincipal();
		habilitarMenuPrincipal();
		
		inventario = new PanelSeleccionInventario();
		
		inventarioCombate = new PanelSeleccionCombate();
		
		
		edicionPokemon = new PanelModificacionPokemon();
		
		
		interfazCombate = new PanelCombatePokemon();
		
	}
	
	public void habilitarMenuPrincipal() {
		menuPrincipal.habilitarPanel();
		getContentPane().add(menuPrincipal);
	}
	
	public void deshabilitarMenuPrincipal() {
		menuPrincipal.deshabilitarPanel();
		getContentPane().remove(menuPrincipal);
	}
	
	public void habilitarInventario() {
		inventario.habilitarPanel();
		getContentPane().add(inventario);
	}
	
	public void deshabilitarInventario() {
		inventario.deshabilitarPanel();
		getContentPane().remove(inventario);
	}
	
	public void habilitarInvCombate() {
		getContentPane().add(inventarioCombate);
		inventarioCombate.habilitarPanel();
	}
	
	public void deshabilitarInvCombate() {
		inventarioCombate.deshabilitarPanel();
		getContentPane().remove(inventarioCombate);
	}
	
	public void habilitarEdicion() {
		getContentPane().add(edicionPokemon);
		edicionPokemon.habilitarPanel();		
	}
	
	public void deshabilitarEdicion() {
		edicionPokemon.deshabilitarPanel();
		getContentPane().remove(edicionPokemon);
	}
	
	public void habilitarCombate() {
		interfazCombate.habilitarPanel();
		getContentPane().add(interfazCombate);
	}
	
	public void deshabilitarCombate() {
		interfazCombate.deshabilitarPanel();
		getContentPane().remove(interfazCombate);
	}
	
	public void salirPrograma() {
		this.dispose();
	}
	

	/**
	 * @return the menuPrincipal
	 */
	public PanelMenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	/**
	 * @param menuPrincipal the menuPrincipal to set
	 */
	public void setMenuPrincipal(PanelMenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	/**
	 * @return the inventario
	 */
	public PanelSeleccionInventario getInventario() {
		return inventario;
	}

	/**
	 * @param inventario the inventario to set
	 */
	public void setInventario(PanelSeleccionInventario inventario) {
		this.inventario = inventario;
	}

	/**
	 * @return the inventarioCombate
	 */
	public PanelSeleccionCombate getInventarioCombate() {
		return inventarioCombate;
	}

	/**
	 * @param inventarioCombate the inventarioCombate to set
	 */
	public void setInventarioCombate(PanelSeleccionCombate inventarioCombate) {
		this.inventarioCombate = inventarioCombate;
	}

	/**
	 * @return the edicionPokemon
	 */
	public PanelModificacionPokemon getEdicionPokemon() {
		return edicionPokemon;
	}

	/**
	 * @param edicionPokemon the edicionPokemon to set
	 */
	public void setEdicionPokemon(PanelModificacionPokemon edicionPokemon) {
		this.edicionPokemon = edicionPokemon;
	}

	/**
	 * @return the interfazCombate
	 */
	public PanelCombatePokemon getInterfazCombate() {
		return interfazCombate;
	}

	/**
	 * @param interfazCombate the interfazCombate to set
	 */
	public void setInterfazCombate(PanelCombatePokemon interfazCombate) {
		this.interfazCombate = interfazCombate;
	}

	
}
