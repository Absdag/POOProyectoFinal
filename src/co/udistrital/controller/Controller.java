package co.udistrital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.udistrital.model.*;
import co.udistrital.view.*;

public class Controller implements ActionListener{
	
	private ArchivosPokemon inventarioPokemon;
	private AtaquesPokemon controlAtaques;
	private Combate manejadorCombate;
	private VentanaPrincipal ventana;
	
	//PARA PRUEBAS
	private TESTConsola consola;
	
	public Controller() {
		inventarioPokemon = new ArchivosPokemon();
		controlAtaques = new AtaquesPokemon();
		manejadorCombate = new Combate();
		ventana = new VentanaPrincipal();
		consola = new TESTConsola();
		asignarOyentes();
		iniciarPrograma();
	}
	
	//Para comparacion de null a existente se usa ==
//	for(int i=0;i<15;i++) {
//		if(!(inventarioPokemon.obtenerListaPokemon()[i]==null)) {
//			consola.mostrarMensaje("Pokemon "+(i+1)+" existe!");
//		}
//		else {
//			consola.mostrarMensaje("Pokemon "+(i+1)+" no existe ");
//		}
//	}
	public void iniciarPrograma() {
		
	}
	
	public void asignarOyentes() {
		//ActionListener del menu principal
		ventana.getMenuPrincipal().getBotonInventario().addActionListener(this);
		ventana.getMenuPrincipal().getBotonCombate().addActionListener(this);
		ventana.getMenuPrincipal().getBotonSalir().addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch(comando){
		case "BOTON-INVENTARIO-POKEMON":
			ventana.getMenuPrincipal().deshabilitarPanel();
			ventana.getInventario().habilitarPanel();
			break;
		case "BOTON-INVENTARIO-COMBATE":
			ventana.getMenuPrincipal().deshabilitarPanel();
			ventana.getInventarioCombate().habilitarPanel();
			break;
		case "BOTON-SALIR-PROGRAMA":
			ventana.salirPrograma();
			break;
		}
	}
}
