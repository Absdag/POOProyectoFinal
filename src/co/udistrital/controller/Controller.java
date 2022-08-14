package co.udistrital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		ventana.getInventario().actualizarListaPokemon(inventarioPokemon.obtenerListaPokemon());
		ventana.getInventarioCombate().actualizarListaPokemon(inventarioPokemon.obtenerListaPokemon());
	}
	
	public void asignarOyentes() {
		//ActionListener del menu principal
		ventana.getMenuPrincipal().getBotonInventario().addActionListener(this);
		ventana.getMenuPrincipal().getBotonCombate().addActionListener(this);
		ventana.getMenuPrincipal().getBotonSalir().addActionListener(this);
		
		//Oyentes del inventario
		ventana.getInventario().getBotonNuevoPokemon().addActionListener(this);;
		ventana.getInventario().getBotonModificarNombre().addActionListener(this);;
		ventana.getInventario().getBotonEliminarPokemon().addActionListener(this);;
		ventana.getInventario().getBotonRegresar().addActionListener(this);
		
		//Oyente especial de listaPokemon de inventario
		ventana.getInventario().getListaPokemon().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selection = ventana.getInventario().getListaPokemon().getSelectedIndex();
				ventana.getInventario().getNombrePokemon().setText(inventarioPokemon.obtenerListaPokemon()[selection].getNombre());;
				ventana.getInventario().getTipo1Pokemon().setText(inventarioPokemon.obtenerListaPokemon()[selection].getTipo1());
				if(!(inventarioPokemon.obtenerListaPokemon()[selection].getTipo2()==null)) {
					ventana.getInventario().getTipo2Pokemon().setText(inventarioPokemon.obtenerListaPokemon()[selection].getTipo2());
				}
			}
		});
		
		//oyentes del inventario de combate
		ventana.getInventarioCombate().getBotonInicioCombate().addActionListener(this);
		ventana.getInventarioCombate().getBotonRegresar().addActionListener(this);;
		ventana.getInventarioCombate().getBotonRetirarCombatePoke().addActionListener(this);
		ventana.getInventarioCombate().getBotonSeleccionarPokemon().addActionListener(this);
		
		ventana.getInventarioCombate().getListaPokemon().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selection = ventana.getInventarioCombate().getListaPokemon().getSelectedIndex();
				ventana.getInventarioCombate().actualizarDatosSeleccionado(inventarioPokemon.obtenerListaPokemon()[selection]);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch(comando){
		//MENU PRINCIPAL
		case "BOTON-INVENTARIO-POKEMON":
			ventana.deshabilitarMenuPrincipal();
			ventana.habilitarInventario();
			break;
		case "BOTON-INVENTARIO-COMBATE":
			ventana.deshabilitarMenuPrincipal();
			ventana.habilitarInvCombate();
			break;
		case "BOTON-SALIR-PROGRAMA":
			ventana.salirPrograma();
			break;
			
		//INVENTARIO
		case "BOTON-NUEVO-POKEMON":
			break;
		case "BOTON-ELIMINAR-POKEMON":
			break;
		case "BOTON-CAMBIO-NOMBRE":
			break;
		case "BOTON-REGRESAR-INVENTARIO":
			ventana.deshabilitarInventario();
			ventana.habilitarMenuPrincipal();
			break;
			
		//INVENTARIO COMBATE
		case "BOTON-INICIO-COMBATE":
			break;
		case "BOTON-RETIRAR-COMBATE":
			break;
		case "BOTON-REGRESAR-MENU-COMBATE":
			ventana.deshabilitarInvCombate();
			ventana.habilitarMenuPrincipal();
			break;
		}
	}
}
