package co.udistrital.model;

public class Pokemon {
	
	private String nombre;
	private String tipo1;
	private String tipo2;
	private String ataques[];
	
	private int daño;
	private int velocidad;
	private int defensa;
	
	private double poder;
	
	public Pokemon() {
		
	}
	
	public Pokemon(String nombre, String tipo1,String tipo2,String ataques[],int daño, int velocidad, int defensa) {
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.ataques = new String[4];
		for(int i=0;i<=3;i++) {
			this.ataques[i] = ataques[i];
		}
		this.daño = daño;
		this.velocidad = velocidad;
		this.defensa = defensa;
		this.poder = (daño+velocidad+defensa)/3;
	}
	
	//TODO Revision de las debilidades
	public int esDebil(String tipo) {
		return 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo1() {
		return tipo1;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}

	public String[] getAtaques() {
		return ataques;
	}

	public void setAtaques(String[] ataques) {
		this.ataques = ataques;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public double getPoder() {
		return poder;
	}

	public void setPoder(double poder) {
		this.poder = poder;
	}
	
	
}
