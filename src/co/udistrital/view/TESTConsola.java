package co.udistrital.view;
import java.util.Scanner;

public class TESTConsola {

	private Scanner consola;
	
	public TESTConsola() {
		consola = new Scanner(System.in);
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
