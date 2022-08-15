package co.udistrital.model;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Combate {
	
	private Pokemon pokemonComputadora[];
	private double vidaPokemonComputadora[];
	private int idPokemonComputadora[];
	//Referencia ubicacion en el arreglo
	private int pokemonActualComputadora;
	
	private Pokemon pokemonUsuario[];
	private double vidaPokemonUsuario[];
	private Integer idPokemonUsuario[];
	//Referencia ubicacion en el arreglo
	private int pokemonActualUsuario;
	
	private boolean finPartida;
	private int turno;
	private int estadoFinPartida;
	
	private int random;
	
	private AtaquesPokemon manejoAtaques;
	
	public Combate() {
		pokemonComputadora = new Pokemon[5];
		vidaPokemonComputadora = new double[5];
		idPokemonComputadora = new int[5];
		
		pokemonUsuario = new Pokemon[5];
		vidaPokemonUsuario = new double[5];
		idPokemonUsuario = new Integer[5];
		
		finPartida = false;
		turno = 0;
		estadoFinPartida = 0;
		
		manejoAtaques = new AtaquesPokemon();
	}
	
	public void inicioCombate() {
		pokemonActualUsuario=0;
		pokemonActualComputadora=0;
		if(pokemonComputadora[pokemonActualComputadora].getPoder()>pokemonUsuario[pokemonActualUsuario].getPoder()) {
			turno = 1;
		}
		reiniciarDatos();
	}
	
	/**
	 * Manejador del final de la partida
	 * @return devuelve 1 en caso de victoria, 0 en caso de embate, -1 en caso de derrota
	 */
	public int getEstadoFinalPartida() {
		if(pokemonActualComputadora>5&&pokemonActualUsuario<5) {
			return 1;
		}
		else if(pokemonActualComputadora<5&&pokemonActualUsuario>5) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public int ataqueUsuario(int idAtaque,boolean critico) {
		String temp="";
		temp=pokemonUsuario[pokemonActualUsuario].getAtaques()[idAtaque];
		double danoTemp;
		danoTemp = danoRealizado(temp,pokemonComputadora[pokemonActualComputadora],critico);
		turno=1;
		if(computadoraRecibeDano(danoTemp)==1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int usuarioRecibeDano(double dano) {
		vidaPokemonUsuario[pokemonActualUsuario] = vidaPokemonUsuario[pokemonActualUsuario]-dano;
		if(vidaPokemonUsuario[pokemonActualUsuario]<0) {
			pokemonActualUsuario++;
			if(pokemonActualUsuario>5) {
				finPartida = true;
			}
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int computadoraRecibeDano(double dano) {
		vidaPokemonComputadora[pokemonActualComputadora] = vidaPokemonComputadora[pokemonActualComputadora] -dano;
		if(vidaPokemonComputadora[pokemonActualComputadora]<0) {
			pokemonActualComputadora++;
			if(pokemonActualComputadora>5) {
				finPartida = true;
			}
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int ataqueComputadora(boolean critico) {
		random = ThreadLocalRandom.current().nextInt(1,5);
		String temp="";
		switch(random) {
		case 1:
			temp =pokemonComputadora[pokemonActualComputadora].getAtaques()[0];
			break;
		case 2:
			temp =pokemonComputadora[pokemonActualComputadora].getAtaques()[1];
			break;
		case 3:
			temp =pokemonComputadora[pokemonActualComputadora].getAtaques()[2];
			break;
		case 4:
			temp =pokemonComputadora[pokemonActualComputadora].getAtaques()[3];
			break;

		}
		
		double danoTemp = danoRealizado(temp,pokemonUsuario[pokemonActualUsuario],critico);
		turno=0;
		//si el pokemon muere devuelve un 1
		if(usuarioRecibeDano(danoTemp)==1) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	public int getIndiceAtaqueComputadora() {
		return random-1;
	}
	
	public void reiniciarDatos() {
		for(int i=0;i<5;i++) {
			vidaPokemonUsuario[i]=100;
			vidaPokemonComputadora[i]=100;
		}
	}
	
	public void seleccionPokemonDelUsuario(Pokemon lista[],int idPokemon[]) {
		pokemonUsuario = lista;
		for(int i=0;i<idPokemon.length;i++) {
			idPokemonUsuario[i]=idPokemon[i];
		}
	}
	
	
	public void addIDPokemon(int id,Pokemon poke) {
		for(int i=0;i<5;i++) {
			if(idPokemonUsuario[i]==null) {
				idPokemonUsuario[i]=id;
				pokemonUsuario[i]=poke;
				break;
			}
		}
	}
	
	public void retirarIDPokemon(int id) {
		System.out.println("Retirar pokemon "+id);
		Integer[] listaTemp = new Integer[5];
		Pokemon[] pokelistaTemp = new Pokemon[5];
		for(int i=0,k=0;i<5;i++) {
			if(idPokemonUsuario[i]!=null &&idPokemonUsuario[i]==id) {
				continue;
			}
			listaTemp[k] = idPokemonUsuario[i];
			pokelistaTemp[k] = pokemonUsuario[i];
			k++;
		}
		for(int i=0;i<5;i++) {
			idPokemonUsuario[i]=listaTemp[i];
			pokemonUsuario[i]=pokelistaTemp[i];
		}
	}
	
	public int[] seleccionComputadora(int pokemonTotal) {
		Random rand = new Random();
		boolean tomoElCero=false;
		int temp;
		for(int i=0;i<5;i++) {
			do {
				temp = rand.nextInt(pokemonTotal);
				if(!(tomoElCero)&&temp==0&&temp!=idPokemonUsuario[0]&&temp!=idPokemonUsuario[1]&&temp!=idPokemonUsuario[2]&&temp!=idPokemonUsuario[3]&&temp!=idPokemonUsuario[4]) {
					tomoElCero=true;
					break;
				}
			}while(temp==idPokemonUsuario[0]||temp==idPokemonUsuario[1]||temp==idPokemonUsuario[2]||temp==idPokemonUsuario[3]||temp==idPokemonUsuario[4]
					||temp==idPokemonComputadora[0]||temp==idPokemonComputadora[1]||temp==idPokemonComputadora[2]||temp==idPokemonComputadora[3]||temp==idPokemonComputadora[4]);
			idPokemonComputadora[i] = temp;
		}
		return idPokemonComputadora;
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
		//Escala del daño con el total de poder del pokemon
		dano = dano *(victima.getPoder()/100);
		
		return dano;
	}

	/**
	 * Manages the getter of pokemonComputadora
	 * @return the pokemonComputadora
	 */
	public Pokemon[] getPokemonComputadora() {
		return pokemonComputadora;
	}

	/**
	 * @param pokemonComputadora the pokemonComputadora to set
	 */
	public void setPokemonComputadora(Pokemon[] pokemonComputadora) {
		for(int i=0;i<5;i++) {
			System.out.println(pokemonComputadora[i].getNombre()+" es nombre pokemon 1 de la computadora y su id interna es "+idPokemonComputadora[i]);
		}
		this.pokemonComputadora = pokemonComputadora;
	}

	/**
	 * Manages the getter of vidaPokemonComputadora
	 * @return the vidaPokemonComputadora
	 */
	public double[] getVidaPokemonComputadora() {
		return vidaPokemonComputadora;
	}

	/**
	 * @param vidaPokemonComputadora the vidaPokemonComputadora to set
	 */
	public void setVidaPokemonComputadora(double[] vidaPokemonComputadora) {
		this.vidaPokemonComputadora = vidaPokemonComputadora;
	}

	/**
	 * Manages the getter of idPokemonComputadora
	 * @return the idPokemonComputadora
	 */
	public int[] getIdPokemonComputadora() {
		return idPokemonComputadora;
	}

	/**
	 * @param idPokemonComputadora the idPokemonComputadora to set
	 */
	public void setIdPokemonComputadora(int[] idPokemonComputadora) {
		this.idPokemonComputadora = idPokemonComputadora;
	}

	/**
	 * Manages the getter of pokemonUsuario
	 * @return the pokemonUsuario
	 */
	public Pokemon[] getPokemonUsuario() {
		return pokemonUsuario;
	}

	/**
	 * @param pokemonUsuario the pokemonUsuario to set
	 */
	public void setPokemonUsuario(Pokemon[] pokemonUsuario) {
		this.pokemonUsuario = pokemonUsuario;
	}

	/**
	 * Manages the getter of vidaPokemonUsuario
	 * @return the vidaPokemonUsuario
	 */
	public double[] getVidaPokemonUsuario() {
		return vidaPokemonUsuario;
	}

	/**
	 * @param vidaPokemonUsuario the vidaPokemonUsuario to set
	 */
	public void setVidaPokemonUsuario(double[] vidaPokemonUsuario) {
		this.vidaPokemonUsuario = vidaPokemonUsuario;
	}

	/**
	 * Manages the getter of idPokemonUsuario
	 * @return the idPokemonUsuario
	 */
	public Integer[] getIdPokemonUsuario() {
		return idPokemonUsuario;
	}

	/**
	 * @param idPokemonUsuario the idPokemonUsuario to set
	 */
	public void setIdPokemonUsuario(Integer[] idPokemonUsuario) {
		this.idPokemonUsuario = idPokemonUsuario;
	}

	/**
	 * Manages the getter of finPartida
	 * @return the finPartida
	 */
	public boolean isFinPartida() {
		return finPartida;
	}

	/**
	 * @param finPartida the finPartida to set
	 */
	public void setFinPartida(boolean finPartida) {
		this.finPartida = finPartida;
	}

	/**
	 * Manages the getter of turno
	 * @return the turno
	 */
	public int getTurno() {
		return turno;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(int turno) {
		this.turno = turno;
	}

	/**
	 * Manages the getter of estadoFinPartida
	 * @return the estadoFinPartida
	 */
	public int getEstadoFinPartida() {
		return estadoFinPartida;
	}

	/**
	 * @param estadoFinPartida the estadoFinPartida to set
	 */
	public void setEstadoFinPartida(int estadoFinPartida) {
		this.estadoFinPartida = estadoFinPartida;
	}

	/**
	 * Manages the getter of manejoAtaques
	 * @return the manejoAtaques
	 */
	public AtaquesPokemon getManejoAtaques() {
		return manejoAtaques;
	}

	/**
	 * @param manejoAtaques the manejoAtaques to set
	 */
	public void setManejoAtaques(AtaquesPokemon manejoAtaques) {
		this.manejoAtaques = manejoAtaques;
	}

	/**
	 * Manages the getter of pokemonActualComputadora
	 * @return the pokemonActualComputadora
	 */
	public int getPokemonActualComputadora() {
		return pokemonActualComputadora;
	}

	/**
	 * Manages the getter of pokemonActualUsuario
	 * @return the pokemonActualUsuario
	 */
	public int getPokemonActualUsuario() {
		return pokemonActualUsuario;
	}
	
	
	
}
