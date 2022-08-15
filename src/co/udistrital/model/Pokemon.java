package co.udistrital.model;

/**
 * Clase de Pokemon, donde manejara todos los datos necesarios para un objeto tipo Pokemon en la ejeccicion del programa.
 * @author Santiago
 *
 */
public class Pokemon {
	
	private String nombre;
	private String tipo1;
	private String tipo2;
	private String ataques[];
	
	private int daño;
	private int velocidad;
	private int defensa;
	
	private double poder;
	
	/**
	 * Constructor base que permite crear una instancia de Pokemon para manejar sus metodos
	 */
	public Pokemon() {
		
	}
	
	/**
	 * Constructor normal de pokemon, crea un objeto tipo Pokemon con los datos usuales<br>
	 * @param nombre String no nulo que indica el nombre del Pokemon
	 * @param tipo1 String no nulo que indica el tipo1 del Pokemon, debe ser entre los existentes
	 * @param tipo2 String que PUEDE ser nulo, indica el segundo tipo, si no tiene sera null
	 * @param ataques Array de 4 ataques que fueron seleccionados para el pokemon
	 * @param daño entero con el daño
	 * @param velocidad entero con la velocidad
	 * @param defensa entero con la defensa
	 * 
	 * <b>POST</b> Se tendra un Pokemon creado, el constructor llamara el propio metodod {@link #recalcularPoder()} para el manejo de poder
	 */
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
		recalcularPoder();
	}
	/**
	 * Este metodo se encarga de tomar los valores determinados en daño, velocidad y defensa para recalcular el poder, en caso de que se haya alterado en el archivo
	 */
	public void recalcularPoder() {
		this.poder =(double) (daño+velocidad+defensa)/3;
	}
	
	/**
	 * Este metodo es encargado de tomar ek tipo del ataque y frente al pokemon determinar su debilidad asociada para futura multiplicacion de daño<br>
	 * <b>PRE</b> tipoDelAtaque existe y es un string no nulo <br>
	 * <b>POST</b> Se obtiene un entero con el tipo de debilidad
	 * @param tipoDelAtaque String no nulo con un valor dentro de los tipos de pokemon
	 * @return 0 en caso de nomal, 1 en caso de de ser debil, 2 en caso de ser fuerte
	 */
	//Es codigo fuerte el manejo de las debilidades de los pokemon
	public int esDebil(String tipoDelAtaque) {
		int debilidadTemporal=0;
		switch(tipo1) {
		case "fuego":
			if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("roca")) {
				debilidadTemporal++;
			}
			else if(tipoDelAtaque.equals("planta")) {
				debilidadTemporal--;
			}
			break;
		case "agua":
			if(tipoDelAtaque.equals("electrico")|| tipoDelAtaque.equals("planta")) {
				debilidadTemporal++;
			}
			else if(tipoDelAtaque.equals("fuego")||tipoDelAtaque.equals("roca")) {
				debilidadTemporal--;
			}
			break;
		case "volador":
			if(tipoDelAtaque.equals("electrico")|| tipoDelAtaque.equals("roca")) {
				debilidadTemporal++;
			}
			else if(tipoDelAtaque.equals("planta")) {
				debilidadTemporal--;
			}
			break;
		case "electrico":
			//No tiene debilidades con los tipos asignados, calculando fortalezas
			if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("volador")) {
				debilidadTemporal--;
			}
			break;
		case "planta":
			if(tipoDelAtaque.equals("fuegoo")|| tipoDelAtaque.equals("volador")) {
				debilidadTemporal--;
			}
			else if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("Roca")) {
				debilidadTemporal--;
			}
			break;
		case "roca":
			if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("planta")) {
				debilidadTemporal++;
			}
			else if(tipoDelAtaque.equals("fuego")||tipoDelAtaque.equals("volador")) {
				debilidadTemporal--;
			}
			break;
		default:
			break;
		}
		if(tipo2!=null) {
			switch(tipo2) {
			case "fuego":
				if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("roca")) {
					debilidadTemporal++;
				}
				else if(tipoDelAtaque.equals("planta")) {
					debilidadTemporal--;
				}
				break;
			case "agua":
				if(tipoDelAtaque.equals("electrico")|| tipoDelAtaque.equals("planta")) {
					debilidadTemporal++;
				}
				else if(tipoDelAtaque.equals("fuego")||tipoDelAtaque.equals("roca")) {
					debilidadTemporal--;
				}
				break;
			case "volador":
				if(tipoDelAtaque.equals("electrico")|| tipoDelAtaque.equals("roca")) {
					debilidadTemporal++;
				}
				else if(tipoDelAtaque.equals("planta")) {
					debilidadTemporal--;
				}
				break;
			case "electrico":
				//No tiene debilidades con los tipos asignados, calculando fortalezas
				if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("volador")) {
					debilidadTemporal--;
				}
				break;
			case "planta":
				if(tipoDelAtaque.equals("fuegoo")|| tipoDelAtaque.equals("volador")) {
					debilidadTemporal--;
				}
				else if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("Roca")) {
					debilidadTemporal--;
				}
				break;
			case "roca":
				if(tipoDelAtaque.equals("agua")|| tipoDelAtaque.equals("planta")) {
					debilidadTemporal++;
				}
				else if(tipoDelAtaque.equals("fuego")||tipoDelAtaque.equals("volador")) {
					debilidadTemporal--;
				}
				break;
			default:
				break;
			}
		}
		//menor a 0 es que es debil, mayor a 0 es que es fuerte
		if(debilidadTemporal<0) {
			return 1;
		}
		else if(debilidadTemporal>0) {
			return 2;
		}
		else {
			return 0;
		}
	}

	/**
	 * Getter usual
	 * @return el nombre asignado
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setter usual
	 * @param nombre String no nulo con el nombre a cambiar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Getter usual
	 * @return obtiene el tipo1
	 */
	public String getTipo1() {
		return tipo1;
	}
	/**
	 * Setter usual
	 * @param tipo1 String no nulo con el tipo1
	 */
	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}
	/**
	 * Getter usual
	 * @return obtiene el tipo2
	 */
	public String getTipo2() {
		return tipo2;
	}
	/**
	 * Setter usual para modificacon post-creacion
	 * @param tipo2 String para cambio del tipo2, puede ser nulo
	 */
	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}
	/**
	 * Getter usual
	 * @return Array de los ataques
	 */
	public String[] getAtaques() {
		return ataques;
	}
	/**
	 *  Setter usual para modificacon post-creacion
	 * @param ataques Array largo 4 con los ataques
	 */
	public void setAtaques(String[] ataques) {
		this.ataques = ataques;
	}
	/**
	 * Getter usual
	 * @return entero de Daño
	 */
	public int getDaño() {
		recalcularPoder();
		return daño;
	}
	/**
	 * Setter usual para el daño<br>
	 * invocara {@link #recalcularPoder()}
	 * @param daño entero a cambiar
	 */
	public void setDaño(int daño) {
		recalcularPoder();
		this.daño = daño;
	}
	/**
	 * Getter usual
	 * @return entero velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * Setter usual para velocidad<br>
	 * invocara {@link #recalcularPoder()}
	 * @param velocidad entero a cambiar
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	/**
	 * Getter usual
	 * @return entero defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/**
	 * Setter usual para defensa<br>
	 * invocara {@link #recalcularPoder()}
	 * @param defensa entero a cambiar
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	/**
	 * Getter usual <br>
	 * invocara {@link #recalcularPoder()} para confirmar calculos correctos.
	 * @return double del poder
	 */
	public double getPoder() {
		recalcularPoder();
		return poder;
	}
	
}
