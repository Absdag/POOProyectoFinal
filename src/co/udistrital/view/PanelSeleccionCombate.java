package co.udistrital.view;

import javax.swing.*;
import co.udistrital.model.Pokemon;
import java.awt.*;

public class PanelSeleccionCombate extends PanelSeleccion implements ComportamientoPanel{
	
	private JLabel infoSeleccionado;
	private JList listaSeleccionados;
	private JLabel actualSeleccionado;
	
	private int[] idSeleccionados;
	
	private JButton botonInicioCombate;
	private JButton botonRetirarCombatePoke;
	private JButton botonSeleccionarPokemon;
	
	public PanelSeleccionCombate() {
		super();
		setBackground(new Color(128,215,168));
		setLayout(new GridBagLayout());
		inicializarComponentes();
	}
	
	@Override
	public void inicializarComponentes() {
		idSeleccionados= new int[5];
		infoSeleccionado = new JLabel("<html>SELECCIONADO ACTUALMENTE<br>NOMBRE:<html>");
		listaSeleccionados = new JList();
		
		botonInicioCombate = new JButton("INICIAR COMBATE");
		botonInicioCombate.setBackground(new Color(142,124,195));
		botonInicioCombate.setActionCommand("BOTON-INICIO-COMBATE");
		
		botonRetirarCombatePoke = new JButton("RETIRAR");
		botonRetirarCombatePoke.setActionCommand("BOTON-RETIRAR-COMBATE");
		
		botonSeleccionarPokemon = new JButton("SELECCIONAR");
		botonSeleccionarPokemon.setActionCommand("SELECCIONAR-PARA-COMBATE");
		super.getBotonRegresar().setActionCommand("BOTON-REGRESAR-MENU-COMBATE");
		
		GridBagConstraints limites = new GridBagConstraints();
		
		limites.weightx = 1;
		limites.weighty =1;
		limites.fill=GridBagConstraints.BOTH;
		limites.insets = new Insets(10,10,10,10);
		
		//AÑADIR LISTA
		limites.gridx=0;
		limites.gridy=0;
		limites.gridwidth =3;
		limites.gridheight=4;
		add(new JScrollPane(super.getListaPokemon()),limites);
		
		//Nombre
		limites.weighty=0.4;
		limites.gridx=3;
		limites.gridwidth=1;
		limites.gridheight=1;
		add(infoSeleccionado,limites);
		
		//Lista
		limites.weighty=1;
		limites.gridheight=2;
		limites.gridy=1;
		add(listaSeleccionados,limites);
		
		//inicio combate
		limites.gridy=4;
		limites.weighty=1;
		add(botonInicioCombate,limites);
		
		
		//Botones
		limites.weighty=0.5;
		limites.gridheight=1;
		limites.gridy=5;
		limites.gridx=0;
		add(super.getBotonRegresar(),limites);
		
		limites.gridx=1;
		add(botonRetirarCombatePoke,limites);
		limites.gridx=2;
		add(botonSeleccionarPokemon,limites);
	}
	
	public void actualizarDatosSeleccionado(Pokemon poke) {
		String temp = "<html>SELECCIONADO ACTUALMENTE<br>NOMBRE: <html>"+poke.getNombre();
		infoSeleccionado.setText(temp);
	}

	@Override
	public void deshabilitarPanel() {
		setVisible(false);
	}

	@Override
	public void habilitarPanel() {
		setVisible(true);
	}

	/**
	 * @return the infoSeleccionado
	 */
	public JLabel getInfoSeleccionado() {
		return infoSeleccionado;
	}

	/**
	 * @param infoSeleccionado the infoSeleccionado to set
	 */
	public void setInfoSeleccionado(JLabel infoSeleccionado) {
		this.infoSeleccionado = infoSeleccionado;
	}

	/**
	 * @return the listaSeleccionados
	 */
	public JList getListaSeleccionados() {
		return listaSeleccionados;
	}

	/**
	 * @param listaSeleccionados the listaSeleccionados to set
	 */
	public void setListaSeleccionados(JList listaSeleccionados) {
		this.listaSeleccionados = listaSeleccionados;
	}

	/**
	 * @return the actualSeleccionado
	 */
	public JLabel getActualSeleccionado() {
		return actualSeleccionado;
	}

	/**
	 * @param actualSeleccionado the actualSeleccionado to set
	 */
	public void setActualSeleccionado(JLabel actualSeleccionado) {
		this.actualSeleccionado = actualSeleccionado;
	}

	/**
	 * @return the idSeleccionados
	 */
	public int[] getIdSeleccionados() {
		return idSeleccionados;
	}

	/**
	 * @param idSeleccionados the idSeleccionados to set
	 */
	public void setIdSeleccionados(int[] idSeleccionados) {
		this.idSeleccionados = idSeleccionados;
	}

	/**
	 * @return the botonInicioCombate
	 */
	public JButton getBotonInicioCombate() {
		return botonInicioCombate;
	}

	/**
	 * @param botonInicioCombate the botonInicioCombate to set
	 */
	public void setBotonInicioCombate(JButton botonInicioCombate) {
		this.botonInicioCombate = botonInicioCombate;
	}

	/**
	 * @return the botonRetirarCombatePoke
	 */
	public JButton getBotonRetirarCombatePoke() {
		return botonRetirarCombatePoke;
	}

	/**
	 * @param botonRetirarCombatePoke the botonRetirarCombatePoke to set
	 */
	public void setBotonRetirarCombatePoke(JButton botonRetirarCombatePoke) {
		this.botonRetirarCombatePoke = botonRetirarCombatePoke;
	}

	/**
	 * @return the botonSeleccionarPokemon
	 */
	public JButton getBotonSeleccionarPokemon() {
		return botonSeleccionarPokemon;
	}

	/**
	 * @param botonSeleccionarPokemon the botonSeleccionarPokemon to set
	 */
	public void setBotonSeleccionarPokemon(JButton botonSeleccionarPokemon) {
		this.botonSeleccionarPokemon = botonSeleccionarPokemon;
	}

	
}
