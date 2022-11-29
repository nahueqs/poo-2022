package ar.edu.unlu.poo.easygame.vista;
import java.util.Set;

import ar.edu.unlu.poo.easygame.controlador.Controlador;

import java.util.HashSet;
import java.util.Scanner;

public class VistaConsola implements IVista {
	private Scanner entrada;	
	private Controlador controlador;

	public VistaConsola() {
		this.entrada = new Scanner(System.in);	
	}
	
	@Override
	public void iniciar() {
		boolean salir = false;
		while(!salir) {
			this.mostrarMenuPrincipal();
			String opcion = this.entrada.nextLine();
			switch (opcion.toLowerCase()) {
			case "a":
				break;
			case "x":
				salir = true;
				System.out.println("Recuerde completar sus tareas!");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	public void mostrarMenuPrincipal() {
		System.out.println("------- EASY GAME -------");
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println();
		System.out.println("Selecciona una opcion:");
		System.out.println("a - iniciar juego");
		System.out.println("b - cargar jugadores");
		System.out.println();
		System.out.println("x - Salir");
	}
	public void mostrarMenuCargaJugadores() {
		System.out.println("------- EASY GAME -------");
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println();
		System.out.println("Ingresa el nombre del jugador");
		System.out.println("para salir ingresa x");
		System.out.println();
		System.out.println();
		System.out.println("x - Salir");
	}
	
	public void mostrarMenuJugador() {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void mostrarMenuJugada() {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void mostrarTablero() {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}



	public void setControlador(Controlador controlador) {
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	
}
