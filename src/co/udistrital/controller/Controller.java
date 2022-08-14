package co.udistrital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
		actualizarListaInterfaz();
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
				if(selection>=0) {
					ventana.getInventario().getNombrePokemon().setText(inventarioPokemon.obtenerListaPokemon()[selection].getNombre());;
					ventana.getInventario().getTipo1Pokemon().setText(inventarioPokemon.obtenerListaPokemon()[selection].getTipo1());
					if(!(inventarioPokemon.obtenerListaPokemon()[selection].getTipo2()==null)) {
						ventana.getInventario().getTipo2Pokemon().setText(inventarioPokemon.obtenerListaPokemon()[selection].getTipo2());
					}
					ventana.getInventario().habilitarBotonEliminar();
				}
			}
		});
		
		//oyentes del inventario de combate
		ventana.getInventarioCombate().getBotonInicioCombate().addActionListener(this);
		ventana.getInventarioCombate().getBotonRegresar().addActionListener(this);;
		ventana.getInventarioCombate().getBotonRetirarCombatePoke().addActionListener(this);
		ventana.getInventarioCombate().getBotonSeleccionarPokemon().addActionListener(this);
		
		//Oyente especial de lista pokemon de combate
		ventana.getInventarioCombate().getListaPokemon().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selection = ventana.getInventarioCombate().getListaPokemon().getSelectedIndex();
				ventana.getInventarioCombate().actualizarDatosSeleccionado(inventarioPokemon.obtenerListaPokemon()[selection]);
			}
		});
		//Oyente especial campo del nombre inventario
		ventana.getInventario().getNombrePokemon().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				confirmarNombreEdicionInventario();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				confirmarNombreEdicionInventario();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				confirmarNombreEdicionInventario();
			}
			
		});
		
		//Oyentes edicion pokemon
		ventana.getEdicionPokemon().getBotonRegresar().addActionListener(this);
		ventana.getEdicionPokemon().getBotonGuardar().addActionListener(this);
		ventana.getEdicionPokemon().getBotonAleatorio().addActionListener(this);
		ventana.getEdicionPokemon().getSeleccionAtaque1().addActionListener(this);
		ventana.getEdicionPokemon().getSeleccionAtaque2().addActionListener(this);
		ventana.getEdicionPokemon().getSeleccionAtaque3().addActionListener(this);
		ventana.getEdicionPokemon().getSeleccionAtaque4().addActionListener(this);
		ventana.getEdicionPokemon().getSeleccionTipo1().addActionListener(this);
		ventana.getEdicionPokemon().getSeleccionTipo2().addActionListener(this);
		//Oyente especial para campo de nombre
		ventana.getEdicionPokemon().getCampoNombre().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				confirmarNombreCreacionPokemon();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				confirmarNombreCreacionPokemon();
				
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				confirmarNombreCreacionPokemon();
			}
		});
		
		//Oyentes del combate pokemon
		ventana.getInterfazCombate().getAtaque1().addActionListener(this);
		ventana.getInterfazCombate().getAtaque2().addActionListener(this);
		ventana.getInterfazCombate().getAtaque3().addActionListener(this);
		ventana.getInterfazCombate().getAtaque4().addActionListener(this);
		ventana.getInterfazCombate().getBotonRendirse().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		consola.mostrarMensaje(comando);
		switch(comando){
		//MENU PRINCIPAL
		case "BOTON-INVENTARIO-POKEMON":
			ventana.deshabilitarMenuPrincipal();
			ventana.getInventario().deshabilitarBotonEliminar();
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
			ventana.deshabilitarInventario();
			ventana.habilitarEdicion();
			ventana.getEdicionPokemon().getSeleccionTipo1().setModel(new DefaultComboBoxModel(controlAtaques.obtenerTiposDePokemon()));
			ventana.getEdicionPokemon().getSeleccionTipo2().setModel(new DefaultComboBoxModel(controlAtaques.obtenerTiposDePokemon()));
			ventana.getEdicionPokemon().deshabilitarGuardar();
			datosAleatoriosPokemonEdicion();
			break;
		case "BOTON-ELIMINAR-POKEMON":
			int selection = ventana.confirmarTarea("Desea eliminar el pokemon seleccionado?");
			if (selection==0) {
				int tempIndex;
				tempIndex = ventana.getInventario().getListaPokemon().getSelectedIndex();
				inventarioPokemon.eliminarPokemonArchivo(tempIndex);
				consola.mostrarMensaje("INDEX: "+tempIndex);
				actualizarListaInterfaz();
			}
			
			break;
		case "BOTON-CAMBIO-NOMBRE":

			break;
		case "BOTON-REGRESAR-INVENTARIO":
			ventana.deshabilitarInventario();
			ventana.habilitarMenuPrincipal();
			break;
			
		//INVENTARIO COMBATE
		case "BOTON-INICIO-COMBATE":
			ventana.deshabilitarInvCombate();
			ventana.habilitarCombate();
			break;
		case "BOTON-RETIRAR-COMBATE":
			break;
		case "BOTON-REGRESAR-MENU-COMBATE":
			ventana.deshabilitarInvCombate();
			ventana.habilitarMenuPrincipal();
			break;
		case "SELECCIONAR-PARA-COMBATE":
			break;
			
		//MODIFICACION POKEMON
		case "BOTON-REGRESAR-EDICION":
			ventana.deshabilitarEdicion();
			ventana.habilitarInventario();
			ventana.getInventario().deshabilitarBotonEliminar();
			break;
		case "BOTON-POKEMON-ALEATORIO":
			datosAleatoriosPokemonEdicion();
			break;
		case "BOTON-GUARDAR-POKEMON":
			String[] ataquesTemp = new String[4];
			String tempNombre = ventana.getEdicionPokemon().getCampoNombre().getText();
			String tempTipo1 = controlAtaques.obtenerTiposDePokemon(ventana.getEdicionPokemon().getSeleccionTipo1().getSelectedIndex());
			String tempTipo2;
			if(!tempTipo1.equals(controlAtaques.obtenerTiposDePokemon(ventana.getEdicionPokemon().getSeleccionTipo2().getSelectedIndex()))) {
				tempTipo2 = controlAtaques.obtenerTiposDePokemon(ventana.getEdicionPokemon().getSeleccionTipo2().getSelectedIndex());
			}else {
				tempTipo2 ="";
			}
			ataquesTemp[0] = ventana.getEdicionPokemon().getSeleccionAtaque1().getSelectedItem().toString();
			ataquesTemp[1] = ventana.getEdicionPokemon().getSeleccionAtaque2().getSelectedItem().toString();
			ataquesTemp[2] = ventana.getEdicionPokemon().getSeleccionAtaque3().getSelectedItem().toString();
			ataquesTemp[3] = ventana.getEdicionPokemon().getSeleccionAtaque4().getSelectedItem().toString();
			int tempDano = ventana.getEdicionPokemon().getDanoEdicion();
			int tempVel = ventana.getEdicionPokemon().getVelocidadEdicion();
			int tempDef = ventana.getEdicionPokemon().getDefensaEdicion();
			Pokemon poketemp = new Pokemon(tempNombre,tempTipo1,tempTipo2,ataquesTemp,tempDano,tempVel,tempDef);
			inventarioPokemon.addPokemonArchivo(poketemp);
			actualizarListaInterfaz();
			ventana.deshabilitarEdicion();
			ventana.habilitarInventario();
			ventana.getInventario().deshabilitarBotonEliminar();
			break;
		case "ATAQUE1-COMBOBOX":
			break;
		case "ATAQUE2-COMBOBOX":
			break;
		case "ATAQUE3-COMBOBOX":
			break;
		case "ATAQUE4-COMBOBOX":
			break;
		case "TIPO1-EDICION":
			int tempIndex = ventana.getEdicionPokemon().getSeleccionTipo1().getSelectedIndex();
			ventana.getEdicionPokemon().getSeleccionAtaque1().setModel(new DefaultComboBoxModel(controlAtaques.obtenerAtaquesPorTipo(tempIndex)));
			ventana.getEdicionPokemon().getSeleccionAtaque2().setModel(new DefaultComboBoxModel(controlAtaques.obtenerAtaquesPorTipo(tempIndex)));
			break;
		case "TIPO2-EDICION":
			int tempIndex1 = ventana.getEdicionPokemon().getSeleccionTipo2().getSelectedIndex();
			ventana.getEdicionPokemon().getSeleccionAtaque3().setModel(new DefaultComboBoxModel(controlAtaques.obtenerAtaquesPorTipo(tempIndex1)));
			ventana.getEdicionPokemon().getSeleccionAtaque4().setModel(new DefaultComboBoxModel(controlAtaques.obtenerAtaquesPorTipo(tempIndex1)));
			break;
			
		//COMBATE POKEMON
		case "ATAQUE1-COMBATE":
			break;
		case "ATAQUE2-COMBATE":
			break;
		case "ATAQUE3-COMBATE":
			break;
		case "ATAQUE4-COMBATE":
			break;
		case "BOTON-RENDIRSE-COMBATE":
			ventana.deshabilitarCombate();
			ventana.habilitarInvCombate();
			break;
		}
	}
	
	public void datosAleatoriosPokemonEdicion() {
		int tempDano,tempVel,tempDef;
		tempDano = controlAtaques.obtenerValorEnteroAleatorio();
		tempVel = controlAtaques.obtenerValorEnteroAleatorio();
		tempDef = controlAtaques.obtenerValorEnteroAleatorio();
		ventana.getEdicionPokemon().setDanoEdicion(tempDano);
		ventana.getEdicionPokemon().setVelocidadEdicion(tempVel);
		ventana.getEdicionPokemon().setDefensaEdicion(tempDef);
		ventana.getEdicionPokemon().actualizarDatosDVD();
	}
	public void confirmarNombreCreacionPokemon() {
		String temp =ventana.getEdicionPokemon().getCampoNombre().getText();
		if(temp.length()<8 || temp.length()>16) {
			ventana.getEdicionPokemon().deshabilitarGuardar();
		}
		else {
			if(nombreValido(temp)) {
				ventana.getEdicionPokemon().habilitarGuardar();
			}else {
				ventana.mostrarMensajeError("NOMBRE REPETIDO");
				ventana.getEdicionPokemon().deshabilitarGuardar();
			}
		}
	}
	public void confirmarNombreEdicionInventario() {
		String temp =ventana.getInventario().getNombrePokemon().getText();
		if(temp.length()<8 || temp.length()>16) {
			ventana.getInventario().deshabilitarBotonModificar();
		}
		else {
			ventana.getInventario().habilitarBotonModificar();
		}
	}
	
	public boolean nombreValido(String nombre) {
		boolean temp =true;
		for(int i=0;i<15;i++) {
			if(inventarioPokemon.obtenerListaPokemon()[i]!=null) {
				if(inventarioPokemon.obtenerListaPokemon()[i].getNombre().equals(nombre)) {
					temp = false;
				}
			}
		}
		return temp;
	}
	public void actualizarListaInterfaz() {
		ventana.getInventario().actualizarListaPokemon(inventarioPokemon.obtenerListaPokemon());
		ventana.getInventarioCombate().actualizarListaPokemon(inventarioPokemon.obtenerListaPokemon());
		ventana.getInventario().updateUI();
		ventana.getInventarioCombate().updateUI();
	}
}
