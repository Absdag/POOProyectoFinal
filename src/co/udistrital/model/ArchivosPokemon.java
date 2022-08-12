package co.udistrital.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Esta clase maneja el inventario, lectura y escritura de archvios manejados en JSON
 */
public class ArchivosPokemon {
	
	private int largoLista;
	private Pokemon lista[];
	private Pokemon listaTemp[];
	private ObjectMapper objectMapper;
	
	/**
	 * Constructor base de ArchivosPokemon<br>
	 * <b>pre</b> Ningno, la clase funciona sin condicion previa<br>
	 * <b>post</b> Tiene configurado ahora<br>
	 */
	public ArchivosPokemon() {
		
		lista = new Pokemon[15];
		listaTemp = new Pokemon[15];
		objectMapper = new ObjectMapper();
		leerArchivo();
	}
	
	/**
	 * Lectura del archivo, encargado de leer el .JSON que se manejara en el programa<br>
	 * <b>Pre</b> N/A<br>
	 * <b>Post</b> Leido el pokemonArchivo.json, y de no existir, creada la base del mismo
	 */
	public void leerArchivo() {
		try {
			lista = objectMapper.readerFor(Pokemon[].class).readValue(new File("pokemonArchivo.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		largoLista = lista.length;
	}
	
	
	//Guarda el archivo en formato JSON y una forma legible, el guardado es estandar como:
//	{
//		  "nombre" : "J",
//		  "tipo1" : "",
//		  "tipo2" : "",
//		  "ataques" : [ "" ],
//		  "daño" : XX,
//		  "velocidad" : XX,
//		  "defensa" : XX,
//		  "poder" : XX.XX
//		}
//	Asi son guardados en el archivo, el poder debe ser calculado antes de guardar el pokemon
	
	/**
	 * Maneja el guardado del archivo "pokemonArchivo.json"<br>
	 * <b>Pre</b> Existencia del archivo<br>
	 * <b>Post</b> Modificacion del archivo con los datos del programa<br>
	 */
	public void guardarArchivo() {
		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("pokemonArchivo.json"), lista);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Eliminacion de un pokemon especificio
	 * <b>Pre</b> Existencia del pokemon en la base de datos
	 * <b>Post</b> Eliminacion del pokemon de la base de datos e invocacion interna de {@link #guardarArchivo()}
	 * @param id Numero del pokemon en la lista, id!=null id &#x3C; 15
	 */
	public void eliminarPokemonArchivo(int id) {
		if(id>0){
			System.arraycopy(lista, 0, listaTemp, 0, id);
		}
		if(listaTemp.length>1) {
			System.arraycopy(lista, id+1, listaTemp, id, listaTemp.length-1);
		}
		lista = listaTemp.clone();
	}
	
	public int cantidadPokemonEnArchivo() {
		largoLista = lista.length;
		return largoLista;
	}
	public Pokemon[] obtenerListaPokemon() {
		return lista;
	}
	

}
