package co.udistrital.view;

import java.awt.*;
import javax.swing.*;

public class PanelMenuPrincipal extends JPanel implements ComportamientoPanel{
	
	private JButton botonInventario; 
	private JButton botonCombate; 
	private JButton botonSalir;
	
	public PanelMenuPrincipal () {
	setLayout(new GridLayout(1 , 3));;
	setVisible(true);
	ConfiguracionBotones();
	
	}

	public void ConfiguracionBotones () {
	botonInventario = new JButton("inventario");
	botonCombate = new JButton("combate");
	botonSalir = new JButton("salir");
	
	add(botonInventario);
	add(botonCombate);
	add(botonSalir);
		
	}

	@Override
	public void inivializarComponentes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deshabilitarPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void habilitarPanel() {
		// TODO Auto-generated method stub
		
	}
	
		
}
