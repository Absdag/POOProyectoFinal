package co.udistrital.view;
import java.awt.*;
import javax.swing.*;

public class PanelModificacionPokemon extends JPanel implements ComportamientoPanel{
	
	private PanelImagen imagenPokemon;
	
	private JTextField campoNombre;
	private JLabel datosDVD;
	private JLabel datoPoder;
	
	private int danoEdicion;
	private int velocidadEdicion;
	private int defensaEdicion;
	private double poderEdicion;
	
	private JButton botonRegresar;
	private JButton botonAleatorio;
	private JButton botonGuardar;
	
	private JComboBox<String> seleccionAtaque1;
	private JComboBox<String> seleccionAtaque2;
	private JComboBox<String> seleccionAtaque3;
	private JComboBox<String> seleccionAtaque4;
	
	private JComboBox<String> seleccionTipo1;
	private JComboBox<String> seleccionTipo2;

	public PanelModificacionPokemon() {
		setLayout( new GridBagLayout());
		inicializarComponentes();
	}
	
	@Override
	public void inicializarComponentes() {
		imagenPokemon = new PanelImagen();
		
		campoNombre = new JTextField();
		datosDVD = new JLabel("DAÑO: VELOCIDAD: DEFENSA: ");
		datoPoder = new JLabel("PODER: ");
		
		botonRegresar = new JButton("VOLVER");
		botonRegresar.setActionCommand("BOTON-REGRESAR-EDICION");
		
		botonAleatorio = new JButton("ALEATORIO");
		botonAleatorio.setActionCommand("BOTON-POKEMON-ALEATORIO");
		
		botonGuardar = new JButton("GUARDAR");
		botonGuardar.setActionCommand("BOTON-GUARDAR-POKEMON");
		
		seleccionAtaque1= new JComboBox<String>();
		seleccionAtaque2 = new JComboBox<String>();
		seleccionAtaque3 = new JComboBox<String>();
		seleccionAtaque4 = new JComboBox<String>();
		seleccionAtaque1.setActionCommand("ATAQUE1-COMBOBOX");
		seleccionAtaque2.setActionCommand("ATAQUE2-COMBOBOX");
		seleccionAtaque3.setActionCommand("ATAQUE3-COMBOBOX");
		seleccionAtaque4.setActionCommand("ATAQUE4-COMBOBOX");
		
		seleccionTipo1 = new JComboBox<String>();
		seleccionTipo1.setActionCommand("TIPO1-EDICION");
		
		seleccionTipo2 = new JComboBox<String>();
		seleccionTipo2.setActionCommand("TIPO2-EDICION");
		
		GridBagConstraints limites = new GridBagConstraints();
		
		limites.fill=GridBagConstraints.BOTH;
		limites.weightx=1;
		limites.weighty=1;
		
		//Imagen del pokemon
		limites.gridx=0;
		limites.gridy=0;
		limites.gridheight=2;
		limites.gridwidth=2;
		add(imagenPokemon,limites);
		
		//tipo1 y tipo2
		limites.gridheight=1;
		limites.gridwidth=1;
		limites.gridy=2;
		add(seleccionTipo1,limites);
		limites.gridx=1;
		add(seleccionTipo2,limites);
		
		//informacionpoder
		limites.gridy=3;
		limites.gridx=0;
		limites.gridwidth=2;
		add(datoPoder,limites);
		
		//Boton regresar
		limites.gridy=4;
		limites.gridwidth=1;
		add(botonRegresar,limites);
		//Boton aleatorio
		limites.gridx=1;
		limites.gridwidth=2;
		add(botonAleatorio,limites);
		
		//Nombre
		limites.gridx=2;
		limites.gridy=0;
		add(campoNombre,limites);
		
		//Datos poder vel def
		limites.gridy=1;
		add(datosDVD,limites);
		
		//Seleccion ataques
		limites.gridwidth=1;
		limites.gridy=2;
		add(seleccionAtaque1,limites);
		limites.gridx=3;
		add(seleccionAtaque2,limites);
		limites.gridx=2;
		limites.gridy=3;
		add(seleccionAtaque3,limites);
		limites.gridx=3;
		add(seleccionAtaque4,limites);
		
		//Boton guardar
		limites.gridx=3;
		limites.gridy=4;
		add(botonGuardar,limites);
	}
	
	public void habilitarGuardar() {
		botonGuardar.setEnabled(true);
	}
	
	public void deshabilitarGuardar() {
		botonGuardar.setEnabled(false);
	}

	public void actualizarDatosDVD() {
		String temp = String.format("DAÑO: %d VELOCIDAD: %d DEFENSA: %d", danoEdicion,velocidadEdicion,defensaEdicion);
		poderEdicion =(double) (danoEdicion+velocidadEdicion+defensaEdicion)/3;
		String temp2 = String.format("PODER:   %f", poderEdicion);
		datoPoder.setText(temp2);
		datosDVD.setText(temp);
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
	 * Manages the getter of imagenPokemon
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
	 * Manages the getter of campoNombre
	 * @return the campoNombre
	 */
	public JTextField getCampoNombre() {
		return campoNombre;
	}

	/**
	 * @param campoNombre the campoNombre to set
	 */
	public void setCampoNombre(JTextField campoNombre) {
		this.campoNombre = campoNombre;
	}

	/**
	 * Manages the getter of datosDVD
	 * @return the datosDVD
	 */
	public JLabel getDatosDVD() {
		return datosDVD;
	}

	/**
	 * @param datosDVD the datosDVD to set
	 */
	public void setDatosDVD(JLabel datosDVD) {
		this.datosDVD = datosDVD;
	}

	/**
	 * Manages the getter of datoPoder
	 * @return the datoPoder
	 */
	public JLabel getDatoPoder() {
		return datoPoder;
	}

	/**
	 * @param datoPoder the datoPoder to set
	 */
	public void setDatoPoder(JLabel datoPoder) {
		this.datoPoder = datoPoder;
	}

	/**
	 * Manages the getter of danoEdicion
	 * @return the danoEdicion
	 */
	public int getDanoEdicion() {
		return danoEdicion;
	}

	/**
	 * @param danoEdicion the danoEdicion to set
	 */
	public void setDanoEdicion(int danoEdicion) {
		this.danoEdicion = danoEdicion;
	}

	/**
	 * Manages the getter of velocidadEdicion
	 * @return the velocidadEdicion
	 */
	public int getVelocidadEdicion() {
		return velocidadEdicion;
	}

	/**
	 * @param velocidadEdicion the velocidadEdicion to set
	 */
	public void setVelocidadEdicion(int velocidadEdicion) {
		this.velocidadEdicion = velocidadEdicion;
	}

	/**
	 * Manages the getter of defensaEdicion
	 * @return the defensaEdicion
	 */
	public int getDefensaEdicion() {
		return defensaEdicion;
	}

	/**
	 * @param defensaEdicion the defensaEdicion to set
	 */
	public void setDefensaEdicion(int defensaEdicion) {
		this.defensaEdicion = defensaEdicion;
	}

	/**
	 * Manages the getter of botonRegresar
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
	 * Manages the getter of botonAleatorio
	 * @return the botonAleatorio
	 */
	public JButton getBotonAleatorio() {
		return botonAleatorio;
	}

	/**
	 * @param botonAleatorio the botonAleatorio to set
	 */
	public void setBotonAleatorio(JButton botonAleatorio) {
		this.botonAleatorio = botonAleatorio;
	}

	/**
	 * Manages the getter of botonGuardar
	 * @return the botonGuardar
	 */
	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	/**
	 * @param botonGuardar the botonGuardar to set
	 */
	public void setBotonGuardar(JButton botonGuardar) {
		this.botonGuardar = botonGuardar;
	}

	/**
	 * Manages the getter of seleccionAtaque1
	 * @return the seleccionAtaque1
	 */
	public JComboBox<String> getSeleccionAtaque1() {
		return seleccionAtaque1;
	}

	/**
	 * @param seleccionAtaque1 the seleccionAtaque1 to set
	 */
	public void setSeleccionAtaque1(JComboBox<String> seleccionAtaque1) {
		this.seleccionAtaque1 = seleccionAtaque1;
	}

	/**
	 * Manages the getter of seleccionAtaque2
	 * @return the seleccionAtaque2
	 */
	public JComboBox<String> getSeleccionAtaque2() {
		return seleccionAtaque2;
	}

	/**
	 * @param seleccionAtaque2 the seleccionAtaque2 to set
	 */
	public void setSeleccionAtaque2(JComboBox<String> seleccionAtaque2) {
		this.seleccionAtaque2 = seleccionAtaque2;
	}

	/**
	 * Manages the getter of seleccionAtaque3
	 * @return the seleccionAtaque3
	 */
	public JComboBox<String> getSeleccionAtaque3() {
		return seleccionAtaque3;
	}

	/**
	 * @param seleccionAtaque3 the seleccionAtaque3 to set
	 */
	public void setSeleccionAtaque3(JComboBox<String> seleccionAtaque3) {
		this.seleccionAtaque3 = seleccionAtaque3;
	}

	/**
	 * Manages the getter of seleccionAtaque4
	 * @return the seleccionAtaque4
	 */
	public JComboBox<String> getSeleccionAtaque4() {
		return seleccionAtaque4;
	}

	/**
	 * @param seleccionAtaque4 the seleccionAtaque4 to set
	 */
	public void setSeleccionAtaque4(JComboBox<String> seleccionAtaque4) {
		this.seleccionAtaque4 = seleccionAtaque4;
	}

	/**
	 * Manages the getter of seleccionTipo1
	 * @return the seleccionTipo1
	 */
	public JComboBox<String> getSeleccionTipo1() {
		return seleccionTipo1;
	}

	/**
	 * @param seleccionTipo1 the seleccionTipo1 to set
	 */
	public void setSeleccionTipo1(JComboBox<String> seleccionTipo1) {
		this.seleccionTipo1 = seleccionTipo1;
	}

	/**
	 * Manages the getter of seleccionTipo2
	 * @return the seleccionTipo2
	 */
	public JComboBox<String> getSeleccionTipo2() {
		return seleccionTipo2;
	}

	/**
	 * @param seleccionTipo2 the seleccionTipo2 to set
	 */
	public void setSeleccionTipo2(JComboBox<String> seleccionTipo2) {
		this.seleccionTipo2 = seleccionTipo2;
	}

	/**
	 * Manages the getter of poderEdicion
	 * @return the poderEdicion
	 */
	public double getPoderEdicion() {
		return poderEdicion;
	}

	
	
}
