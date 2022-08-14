package co.udistrital.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelCombatePokemon extends JPanel implements ComportamientoPanel{

	private PanelImagen imagenUsuario;
	private PanelImagen imagenComputadora;
	private PanelImagen imagenDecorativaComputadora;
	
	private JButton ataque1;
	private JButton ataque2;
	private JButton ataque3;
	private JButton ataque4;
	
	private JLabel datosComputadora;
	private JLabel datosUsuario;
	private JLabel historicoCombate;
	private JLabel infoTurno;
	
	private JButton botonRendirse;
	
	
	public PanelCombatePokemon() {
		setLayout(new GridBagLayout());
		inicializarComponentes();
	}
	
	@Override
	public void inicializarComponentes() {
		imagenUsuario = new PanelImagen();
		imagenComputadora = new PanelImagen();
		
		ataque1= new JButton("ATAQUE1");
		ataque1.setActionCommand("ATAQUE1-COMBATE");
		ataque2 = new JButton("ATAQUE2");
		ataque2.setActionCommand("ATAQUE2-COMBATE");
		ataque3 = new JButton("ATAQUE3");
		ataque3.setActionCommand("ATAQUE3-COMBATE");
		ataque4 = new JButton("Ataque4");
		ataque4.setActionCommand("ATAQUE4-COMBATE");
		
		datosComputadora = new JLabel("<html>RIVAL:<br>VIDA:<html>");
		datosUsuario = new JLabel("<html>USUARIO:<br>VIDA:<html>");
		infoTurno = new JLabel("TURNO DE: ");
		historicoCombate = new JLabel("HISTORICO COMBATE");
		
		botonRendirse = new JButton("RENDIRSE");
		botonRendirse.setActionCommand("BOTON-RENDIRSE-COMBATE");
		
		
		GridBagConstraints limites = new GridBagConstraints();
		
		limites.fill = GridBagConstraints.BOTH;
		limites.weightx= 1;
		limites.weighty=1;
		
		//Boton rendirse
		limites.gridx=0;
		limites.gridy=0;
		limites.gridwidth=2;
		add(botonRendirse,limites);
		
		//Imagen y dato pokemon rival
		limites.gridwidth=1;
		limites.gridy=1;
		add(imagenComputadora,limites);
		
		limites.gridx=1;
		limites.gridwidth=2;
		add(datosComputadora,limites);
		
		//Imagen y datos pokemon aliado
		
		limites.gridy=3;
		limites.gridx=2;
		limites.gridwidth=1;
		add(imagenUsuario,limites);
		
		limites.gridx=0;
		limites.gridwidth=2;
		add(datosUsuario,limites);
		
		//Informacion de la batalla
		limites.gridwidth=2;
		limites.gridheight=2;
		limites.gridy=0;
		limites.gridx=3;
		add(historicoCombate,limites);
		
		//Botones de ataque
		limites.gridheight=1;
		limites.gridwidth=1;
		limites.gridy=2;
		add(ataque1,limites);
		
		limites.gridheight=1;
		limites.gridwidth=1;
		limites.gridy=2;
		limites.gridx=4;
		add(ataque2,limites);
		
		limites.gridheight=1;
		limites.gridwidth=1;
		limites.gridy=3;
		limites.gridx=3;
		add(ataque3,limites);
		
		limites.gridheight=1;
		limites.gridwidth=1;
		limites.gridy=3;
		limites.gridx=4;
		add(ataque4,limites);
		
		//Info turno
		limites.gridx=3;
		limites.gridy=5;
		limites.gridwidth=2;
		add(infoTurno,limites);
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
	 * Manages the getter of imagenUsuario
	 * @return the imagenUsuario
	 */
	public PanelImagen getImagenUsuario() {
		return imagenUsuario;
	}

	/**
	 * @param imagenUsuario the imagenUsuario to set
	 */
	public void setImagenUsuario(PanelImagen imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}

	/**
	 * Manages the getter of imagenComputadora
	 * @return the imagenComputadora
	 */
	public PanelImagen getImagenComputadora() {
		return imagenComputadora;
	}

	/**
	 * @param imagenComputadora the imagenComputadora to set
	 */
	public void setImagenComputadora(PanelImagen imagenComputadora) {
		this.imagenComputadora = imagenComputadora;
	}

	/**
	 * Manages the getter of imagenDecorativaComputadora
	 * @return the imagenDecorativaComputadora
	 */
	public PanelImagen getImagenDecorativaComputadora() {
		return imagenDecorativaComputadora;
	}

	/**
	 * @param imagenDecorativaComputadora the imagenDecorativaComputadora to set
	 */
	public void setImagenDecorativaComputadora(PanelImagen imagenDecorativaComputadora) {
		this.imagenDecorativaComputadora = imagenDecorativaComputadora;
	}

	/**
	 * Manages the getter of ataque1
	 * @return the ataque1
	 */
	public JButton getAtaque1() {
		return ataque1;
	}

	/**
	 * @param ataque1 the ataque1 to set
	 */
	public void setAtaque1(JButton ataque1) {
		this.ataque1 = ataque1;
	}

	/**
	 * Manages the getter of ataque2
	 * @return the ataque2
	 */
	public JButton getAtaque2() {
		return ataque2;
	}

	/**
	 * @param ataque2 the ataque2 to set
	 */
	public void setAtaque2(JButton ataque2) {
		this.ataque2 = ataque2;
	}

	/**
	 * Manages the getter of ataque3
	 * @return the ataque3
	 */
	public JButton getAtaque3() {
		return ataque3;
	}

	/**
	 * @param ataque3 the ataque3 to set
	 */
	public void setAtaque3(JButton ataque3) {
		this.ataque3 = ataque3;
	}

	/**
	 * Manages the getter of ataque4
	 * @return the ataque4
	 */
	public JButton getAtaque4() {
		return ataque4;
	}

	/**
	 * @param ataque4 the ataque4 to set
	 */
	public void setAtaque4(JButton ataque4) {
		this.ataque4 = ataque4;
	}

	/**
	 * Manages the getter of datosComputadora
	 * @return the datosComputadora
	 */
	public JLabel getDatosComputadora() {
		return datosComputadora;
	}

	/**
	 * @param datosComputadora the datosComputadora to set
	 */
	public void setDatosComputadora(JLabel datosComputadora) {
		this.datosComputadora = datosComputadora;
	}

	/**
	 * Manages the getter of datosUsuario
	 * @return the datosUsuario
	 */
	public JLabel getDatosUsuario() {
		return datosUsuario;
	}

	/**
	 * @param datosUsuario the datosUsuario to set
	 */
	public void setDatosUsuario(JLabel datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

	/**
	 * Manages the getter of historicoCombate
	 * @return the historicoCombate
	 */
	public JLabel getHistoricoCombate() {
		return historicoCombate;
	}

	/**
	 * @param historicoCombate the historicoCombate to set
	 */
	public void setHistoricoCombate(JLabel historicoCombate) {
		this.historicoCombate = historicoCombate;
	}

	/**
	 * Manages the getter of infoTurno
	 * @return the infoTurno
	 */
	public JLabel getInfoTurno() {
		return infoTurno;
	}

	/**
	 * @param infoTurno the infoTurno to set
	 */
	public void setInfoTurno(JLabel infoTurno) {
		this.infoTurno = infoTurno;
	}

	/**
	 * Manages the getter of botonRendirse
	 * @return the botonRendirse
	 */
	public JButton getBotonRendirse() {
		return botonRendirse;
	}

	/**
	 * @param botonRendirse the botonRendirse to set
	 */
	public void setBotonRendirse(JButton botonRendirse) {
		this.botonRendirse = botonRendirse;
	}
	
}
