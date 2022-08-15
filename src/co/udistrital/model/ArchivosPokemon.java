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
	private ObjectMapper objectMapper;
	
	private File archivo;
	
	/**
	 * Constructor base de ArchivosPokemon<br>
	 * <b>pre</b> Ningno, la clase funciona sin condicion previa<br>
	 * <b>post</b> Tiene configurado ahora<br>
	 */
	public ArchivosPokemon() {
		
		lista = new Pokemon[15];
		objectMapper = new ObjectMapper();
		archivo = new File("pokemonArchivo.json");
		leerArchivo();
	}
	
	/**
	 * Lectura del archivo, encargado de leer el .JSON que se manejara en el programa, en caso de no existir, creara uno<br>
	 * <b>Pre</b> N/A<br>
	 * <b>Post</b> Leido el pokemonArchivo.json, y de no existir, creada la base del mismo
	 */
	public void leerArchivo() {
		try {
			if(archivo.createNewFile()) {
				for(int i=0;i<15;i++) {
					lista[i]=null;
				}
				guardarArchivo();
			}else {
				if(!(archivo.length()==0)) {
					lista = objectMapper.readerFor(Pokemon[].class).readValue(archivo);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actualizarLargoListaReal();
	}
	
	public void actualizarLargoListaReal() {
		int temp=0;
		for(int i=0;i<15;i++) {
			if(lista[i]!=null) {
				temp++;
			}
		}
		largoLista = temp;
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
	 * <b>Pre</b> N/A<br>
	 * <b>Post</b> Modificacion del archivo con los datos del programa<br>
	 */
	public void guardarArchivo() {
		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(archivo, lista);
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
		Pokemon[] listTemp= new Pokemon[15];
		for(int i=0,k=0;i<lista.length;i++) {
			if(i==id) {
				continue;
			}
			listTemp[k] = lista[i];
			k++;
		}
		for(int i=0;i<lista.length;i++) {
			lista[i]=listTemp[i];
		}
		guardarArchivo();
		actualizarLargoListaReal();
	}
	
	public void addPokemonArchivo(Pokemon poke) {
		for(int i=0;i<15;i++) {
			if(lista[i]==null) {
				lista[i] = poke;
				break;
			}
		}
		guardarArchivo();
		actualizarLargoListaReal();
	}
	
	public int cantidadPokemonEnArchivo() {
		largoLista = lista.length;
		return largoLista;
	}
	public Pokemon[] obtenerListaPokemon() {
		return lista;
	}

	/**
	 * Manages the getter of largoLista
	 * @return the largoLista
	 */
	public int getLargoLista() {
		return largoLista;
	}

	/**
	 * @param largoLista the largoLista to set
	 */
	public void setLargoLista(int largoLista) {
		this.largoLista = largoLista;
	}
	
	

}
