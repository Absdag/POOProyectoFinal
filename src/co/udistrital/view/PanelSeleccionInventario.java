package co.udistrital.view;

import javax.swing.*;
import java.awt.*;

public class PanelSeleccionInventario extends PanelSeleccion implements ComportamientoPanel {

	private PanelImagen imagenPokemon;
	
	private JTextField nombrePokemon;
	private JLabel tipo1Pokemon;
	private JLabel tipo2Pokemon;
	
	private JButton botonNuevoPokemon;
	private JButton botonModificarNombre;
	private JButton botonEliminarPokemon;
	
	
	public PanelSeleccionInventario() {
		super();
		setLayout(new GridBagLayout());
		setBackground(new Color(255,229,153));
		inicializarComponentes();
	}
	
	@Override
	public void inicializarComponentes() {
		imagenPokemon = new PanelImagen();
		
		nombrePokemon = new JTextField();
		tipo1Pokemon = new JLabel();
		tipo2Pokemon = new JLabel();
		
		botonNuevoPokemon = new JButton("NUEVO");
		botonEliminarPokemon = new JButton("ELIMINAR");
		botonModificarNombre = new JButton("CAMBIAR NOMBRE");
		
		botonNuevoPokemon.setActionCommand("BOTON-NUEVO-POKEMON");
		botonEliminarPokemon.setActionCommand("BOTON ELIMINAR POKEMON");
		botonModificarNombre.setActionCommand("BOTON-CAMBIO-NOMBRE");
		super.getBotonRegresar().setActionCommand("BOTON-REGRESAR-INVENTARIO");;
		
		//Organizacion en el gridbaglayout
		GridBagConstraints limites = new GridBagConstraints();
		limites.weightx=1;
		limites.weighty=1;
		limites.fill = GridBagConstraints.BOTH;
		limites.insets = new Insets(10,10,10,10);
		
		//AÑADIR LISTA
		limites.gridx=0;
		limites.gridy=0;
		limites.gridwidth =3;
		limites.gridheight=5;
		add(new JScrollPane(super.getListaPokemon()),limites);
		
		//Imagen
		limites.gridx=3;
		limites.gridwidth=1;
		limites.gridheight=2;
		add(imagenPokemon,limites);
		
		limites.weighty=0.2;
		//nombre
		limites.gridy=2;
		limites.gridheight=1;
		add(nombrePokemon,limites);
		
		limites.fill = GridBagConstraints.NONE;
		//tipo1
		limites.gridy=3;
		add(tipo1Pokemon,limites);
		//tipo2
		limites.gridy=4;
		add(tipo2Pokemon,limites);
		
		//Botones
		
		limites.weighty=0.5;
		limites.fill = GridBagConstraints.BOTH;
		limites.gridx=0;
		limites.gridy=5;
		add(super.getBotonRegresar(),limites);

		limites.gridx=1;
		add(botonNuevoPokemon,limites);
		limites.gridx=2;
		add(botonModificarNombre,limites);
		limites.gridx=3;
		add(botonEliminarPokemon,limites);
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
	 * @return the imagenPokemon
	 */
	public PanelImagen getImagenPokemon() {
		return imagenPokemon;
	}

	/**
	 * @param imagenPokemon the imagenPokemon to set
	 */
	public void setImagenPokemon(PanelImagen imagenPokemon) {
		this.imagenPokemon = imagenPokemon;
	}

	/**
	 * @return the nombrePokemon
	 */
	public JTextField getNombrePokemon() {
		return nombrePokemon;
	}

	/**
	 * @param nombrePokemon the nombrePokemon to set
	 */
	public void setNombrePokemon(JTextField nombrePokemon) {
		this.nombrePokemon = nombrePokemon;
	}

	/**
	 * @return the tipo1Pokemon
	 */
	public JLabel getTipo1Pokemon() {
		return tipo1Pokemon;
	}

	/**
	 * @param tipo1Pokemon the tipo1Pokemon to set
	 */
	public void setTipo1Pokemon(JLabel tipo1Pokemon) {
		this.tipo1Pokemon = tipo1Pokemon;
	}

	/**
	 * @return the tipo2Pokemon
	 */
	public JLabel getTipo2Pokemon() {
		return tipo2Pokemon;
	}

	/**
	 * @param tipo2Pokemon the tipo2Pokemon to set
	 */
	public void setTipo2Pokemon(JLabel tipo2Pokemon) {
		this.tipo2Pokemon = tipo2Pokemon;
	}

	/**
	 * @return the botonNuevoPokemon
	 */
	public JButton getBotonNuevoPokemon() {
		return botonNuevoPokemon;
	}

	/**
	 * @param botonNuevoPokemon the botonNuevoPokemon to set
	 */
	public void setBotonNuevoPokemon(JButton botonNuevoPokemon) {
		this.botonNuevoPokemon = botonNuevoPokemon;
	}

	/**
	 * @return the botonModificarNombre
	 */
	public JButton getBotonModificarNombre() {
		return botonModificarNombre;
	}

	/**
	 * @param botonModificarNombre the botonModificarNombre to set
	 */
	public void setBotonModificarNombre(JButton botonModificarNombre) {
		this.botonModificarNombre = botonModificarNombre;
	}

	/**
	 * @return the botonEliminarPokemon
	 */
	public JButton getBotonEliminarPokemon() {
		return botonEliminarPokemon;
	}

	/**
	 * @param botonEliminarPokemon the botonEliminarPokemon to set
	 */
	public void setBotonEliminarPokemon(JButton botonEliminarPokemon) {
		this.botonEliminarPokemon = botonEliminarPokemon;
	}
	
	

}
