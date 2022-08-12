package co.udistrital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.udistrital.model.*;
import co.udistrital.view.*;

public class Controller implements ActionListener{
	
	private ArchivosPokemon inventarioPokemon;
	private AtaquesPokemon controlAtaques;
	private Combate manejadorCombate;
	private VentanaPrincipal ventanaAPP;
	
	//PARA PRUEBAS
	private TESTConsola consola;
	
	public Controller() {
		inventarioPokemon = new ArchivosPokemon();
		controlAtaques = new AtaquesPokemon();
		manejadorCombate = new Combate();
		ventanaAPP = new VentanaPrincipal();
		consola = new TESTConsola();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO LA LOGICA DEL PAQUETE
		
	}
}
