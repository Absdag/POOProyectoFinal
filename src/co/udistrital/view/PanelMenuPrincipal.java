package co.udistrital.view;

import java.awt.*;
import javax.swing.*;

public class PanelMenuPrincipal extends JPanel implements ComportamientoPanel{
	
	private JLabel titulo;
	private JButton botonInventario; 
	private JButton botonCombate; 
	private JButton botonSalir;
	
	public PanelMenuPrincipal () {
		setLayout(new GridLayout(4 , 1));
		inicializarComponentes();
		setBackground(new Color(207,226,243));

	}

	
	@Override
	public void inicializarComponentes() {
		titulo = new JLabel("POKEMONES");
		botonInventario = new JButton("inventario");
		botonCombate = new JButton("combate");
		botonSalir = new JButton("salir");
		
		botonInventario.setActionCommand("BOTON-INVENTARIO-POKEMON");
		botonCombate.setActionCommand("BOTON-INVENTARIO-COMBATE");
		botonSalir.setActionCommand("BOTON-SALIR-PROGRAMA");
		
		add(titulo);
		add(botonInventario);
		add(botonCombate);
		add(botonSalir);
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
	 * @return the titulo
	 */
	public JLabel getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return the botonInventario
	 */
	public JButton getBotonInventario() {
		return botonInventario;
	}


	/**
	 * @param botonInventario the botonInventario to set
	 */
	public void setBotonInventario(JButton botonInventario) {
		this.botonInventario = botonInventario;
	}


	/**
	 * @return the botonCombate
	 */
	public JButton getBotonCombate() {
		return botonCombate;
	}


	/**
	 * @param botonCombate the botonCombate to set
	 */
	public void setBotonCombate(JButton botonCombate) {
		this.botonCombate = botonCombate;
	}


	/**
	 * @return the botonSalir
	 */
	public JButton getBotonSalir() {
		return botonSalir;
	}


	/**
	 * @param botonSalir the botonSalir to set
	 */
	public void setBotonSalir(JButton botonSalir) {
		this.botonSalir = botonSalir;
	}
	
	
		
}
