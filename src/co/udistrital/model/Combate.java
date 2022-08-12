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
	
	private AtaquesPokemon manejoAtaques;
	
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
		
		manejoAtaques = new AtaquesPokemon();
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
	
	public double danoRealizado(String ataqueRealizado, Pokemon victima,boolean critico) {
		double dano = 0;
		//neutro
		if(victima.esDebil(manejoAtaques.obtenerTipoDelAtaque(ataqueRealizado))==0){
			dano = manejoAtaques.obtenerDanoDelAtaque(ataqueRealizado);
		}
		//Es debil
		else if(victima.esDebil(manejoAtaques.obtenerTipoDelAtaque(ataqueRealizado))==1){
			dano = manejoAtaques.obtenerDanoDelAtaque(ataqueRealizado)*1.5;
		}
		//Es fuerte
		else if(victima.esDebil(manejoAtaques.obtenerTipoDelAtaque(ataqueRealizado))==2){
			dano = manejoAtaques.obtenerDanoDelAtaque(ataqueRealizado)*0.5;
		}
		//Multiplicador de criticos
		if(critico) {
			dano = dano *1.75;
		}
		
		return dano;
	}

	public Pokemon[] getPokemonComputadora() {
		return pokemonComputadora;
	}

	public void setPokemonComputadora(Pokemon[] pokemonComputadora) {
		this.pokemonComputadora = pokemonComputadora;
	}

	public double[] getVidaPokemonComputadora() {
		return vidaPokemonComputadora;
	}

	public void setVidaPokemonComputadora(double[] vidaPokemonComputadora) {
		this.vidaPokemonComputadora = vidaPokemonComputadora;
	}

	public int[] getIdPokemonComputadora() {
		return idPokemonComputadora;
	}

	public void setIdPokemonComputadora(int[] idPokemonComputadora) {
		this.idPokemonComputadora = idPokemonComputadora;
	}

	public Pokemon[] getPokemonUsuario() {
		return pokemonUsuario;
	}

	public void setPokemonUsuario(Pokemon[] pokemonUsuario) {
		this.pokemonUsuario = pokemonUsuario;
	}

	public double[] getVidaPokemonUsuario() {
		return vidaPokemonUsuario;
	}

	public void setVidaPokemonUsuario(double[] vidaPokemonUsuario) {
		this.vidaPokemonUsuario = vidaPokemonUsuario;
	}

	public int[] getIdPokemonUsuario() {
		return idPokemonUsuario;
	}

	public void setIdPokemonUsuario(int[] idPokemonUsuario) {
		this.idPokemonUsuario = idPokemonUsuario;
	}

	public boolean isFinPartida() {
		return finPartida;
	}

	public void setFinPartida(boolean finPartida) {
		this.finPartida = finPartida;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getEstadoFinPartida() {
		return estadoFinPartida;
	}

	public void setEstadoFinPartida(int estadoFinPartida) {
		this.estadoFinPartida = estadoFinPartida;
	}
	
}
