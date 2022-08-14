package co.udistrital.model;
import java.util.concurrent.ThreadLocalRandom;

public class AtaquesPokemon {
	
	private String ataques[];
	private String[] tiposPokemon;
	
	public AtaquesPokemon() {
		tiposPokemon = new String[]{"fuego","agua","volador","electrico","planta","roca"};
		ataques = new String[4];
	}
	
	public int obtenerValorEnteroAleatorio() {
		int temp;
		temp = ThreadLocalRandom.current().nextInt(10,90);
		return temp;
	}
	
	public String[] obtenerTiposDePokemon(){
		return tiposPokemon;
	}
	
	public String obtenerTiposDePokemon(int index) {
		return tiposPokemon[index];
	}
	
	public String[] obtenerAtaquesPorTipo(int index) {
		switch (index) {
		case 0:
			ataques[0]="Lanzallamas";
			ataques[1]="GiroFuego";
			ataques[2]="Bomba";
			ataques[3]="Embestida";
			break;
		case 1:
			ataques[0]="Burbuja";
			ataques[1]="Acua jet";
			ataques[2]="Hidrobomba";
			ataques[3]="Embestida";
			break;
		case 2:
			ataques[0]="Látigo de aire";
			ataques[1]="Ráfaga";
			ataques[2]="Torbellino";
			ataques[3]="Embestida";
			break;
		case 3:
			ataques[0]="Impactrueno";
			ataques[1]="Látigo";
			ataques[2]="Onda Trueno";
			ataques[3]="Embestida";
			break;
		case 4:
			ataques[0]="Hoja afilada";
			ataques[1]="Tormenta floral";
			ataques[2]="Latigazo";
			ataques[3]="Embestida";
			break;
		case 5:
			ataques[0]="Lanzarroca";
			ataques[1]="Placaje";
			ataques[2]="Terremoto";
			ataques[3]="Embestida";
			break;
		default:
			break;
		}
		return ataques;
	}
	
	public int obtenerDanoDelAtaque(String ataque) {
		int temp=0;
		if(ataque.equals("embestida")) {
			temp = 15;
		}
		else {
			temp = 25;
		}
		return temp;
	}
	
	public String obtenerTipoDelAtaque(String ataque) {
		String temp="";
		if(ataque.equals("embestida")) {
			temp = "normal";
		}
		else if(ataque.equals("Lanzallamas")||ataque.equals("GiroFuego")||ataque.equals("Bomba")){
			temp = "fuego";
		}
		else if(ataque.equals("Burbuja")||ataque.equals("AcuaJet")||ataque.equals("Hidrobomba")){
			temp = "agua";
		}
		else if(ataque.equals("Látigo de aire")||ataque.equals("Ráfaga")||ataque.equals("Torbellino")){
			temp = "volador";
		}
		else if(ataque.equals("Impactrueno")||ataque.equals("Látigo")||ataque.equals("Onda Trueno")){
			temp = "electrico";
		}
		else if(ataque.equals("Hoja afilada")||ataque.equals("Tormenta floral")||ataque.equals("Latigazo")){
			temp = "planta";
		}
		else if(ataque.equals("Lanzarroca")||ataque.equals("Placaje")||ataque.equals("Terremoto")){
			temp = "roca";
		}
		return temp;
	}
}
