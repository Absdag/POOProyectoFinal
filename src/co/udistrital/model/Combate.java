package co.udistrital.model;
import java.util.Random;

public class Combate {
	
	private Pokemon pokemonComputadora[];
	private double vidaPokemonComputadora[];
	private int idPokemonComputadora[];
	
	private Pokemon pokemonUsuario[];
	private double vidaPokemonUsuario[];
	private int idPokemonUsuario[];
	
	private boolean finPartida;
	private int turno;
	private int estadoFinPartida;
	
	public Combate() {
		pokemonComputadora = new Pokemon[5];
		vidaPokemonComputadora = new double[5];
		idPokemonComputadora = new int[5];
		
		pokemonUsuario = new Pokemon[5];
		vidaPokemonUsuario = new double[5];
		idPokemonUsuario = new int[5];
		
		finPartida = false;
		turno = 0;
		estadoFinPartida = 0;
	}
	
	public void reiniciarDatos() {
		for(int i=0;i<5;i++) {
			vidaPokemonUsuario[i]=100;
			vidaPokemonComputadora[i]=100;
		}
	}
	
	public void seleccionPokemonDelUsuario(Pokemon lista[],int idPokemon[]) {
		pokemonUsuario = lista;
		idPokemonUsuario = idPokemon;
	}
	
	public int[] seleccionComputadora() {
		Random rand = new Random();
		int temp;
		for(int i=0;i<5;i++) {
			do {
				temp = rand.nextInt((5)+1);
			}while(temp==idPokemonUsuario[0]||temp==idPokemonUsuario[1]||temp==idPokemonUsuario[2]||temp==idPokemonUsuario[3]||temp==idPokemonUsuario[4]);
			idPokemonComputadora[i] = temp;
		}
		return idPokemonComputadora;
	}
	
	public void inicioCombate() {
		reiniciarDatos();
	}
}
