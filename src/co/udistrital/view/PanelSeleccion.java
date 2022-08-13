package co.udistrital.view;
import co.udistrital.model.*;
import java.awt.*;
import javax.swing.*;

public class PanelSeleccion extends JPanel {
	
	private JButton botonRegresar;
	
	private JList listaPokemon;
	
	public void actualizarDatosSeleccionado(Pokemon pokemon) {
		
	}

	/**
	 * @return the botonRegresar
	 */
	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	/**
	 * @param botonRegresar the botonRegresar to set
	 */
	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
	}

	/**
	 * @return the listaPokemon
	 */
	public JList getListaPokemon() {
		return listaPokemon;
	}

	/**
	 * @param listaPokemon the listaPokemon to set
	 */
	public void setListaPokemon(JList listaPokemon) {
		this.listaPokemon = listaPokemon;
	}
	
}
