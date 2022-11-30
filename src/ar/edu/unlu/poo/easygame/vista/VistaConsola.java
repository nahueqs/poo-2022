package ar.edu.unlu.poo.easygame.vista;
import java.util.Set;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import ar.edu.unlu.poo.easygame.controlador.Controlador;
import ar.edu.unlu.poo.easygame.modelo.Eventos;
import ar.edu.unlu.poo.easygame.modelo.IJuego;
import ar.edu.unlu.poo.easygame.modelo.Jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		List lista = new ArrayList();
		while(!salir) {
			this.mostrarMenuPrincipal();
			String opcion = this.entrada.nextLine();
			switch (opcion.toLowerCase()) {
			case "a":
				controlador.iniciarJuego();
				break;
			case "b":
				menuCargaJugadores();					
				break;
			case "x":
				salir = true;
				System.out.println("Gracias por jugar");
				break;
			default:
				System.out.println("Opcion no valida.");
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
	
	
	public void menuCargaJugadores() {
		boolean salir = false;
		int cont = 0;
		List lista = new ArrayList();
		mostrarMenuIngresoJugadores();
		while(!salir) {			
			String opcion = this.entrada.nextLine();
			switch (opcion.toLowerCase()) {
			case "x":
				salir = true;
				System.out.println("Saliendo...");
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default: 
				if(opcion.length()>12) {
					System.out.println("Opcion no valida");}
				else {
					if (cont >= 5) {
						System.out.println("Maximo de jugadores alcanzado, presione enter para volver al menú principal...");
						try {
							System.in.read();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						salir = true;
					} else {
						lista.add(opcion);						
						System.out.println("Añadido, ingrese el siguiente");
						cont += 1;
					}
				}
			}
			if (lista.size()>0) { 
				controlador.setJugadores(lista);
			}
		}
	}

	public void mostrarMenuJugada() {
		mostrarTablero();
		mostrarCartasJugador();
		System.out.println("Elegi el mazo al que vas a jugar");
		System.out.println("a - mazo ascendente");
		System.out.println("b - mazo descendente");
		System.out.println("x - Salir");
		String mazo = this.entrada.nextLine();
		System.out.println("Elegi la carta que vas a jugar");
		System.out.println("a - Carta1");  
		System.out.println("b - Carta2");
		System.out.println("x - Salir");
		String carta = this.entrada.nextLine();
		controlador.hacerJugada(carta, mazo);
		
	}

	private void mostrarCartasJugador() {
		controlador.mostrarManoJugador();

	}
	
	public void mostrarMenuIngresoJugadores() {
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

	public void mostrarTablero() {
		//	controlador.
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void mostrarManoJugador(Jugador jugador) {
		// TODO Auto-generated method stub

	}

	public void terminar() {
		System.out.println("Juego terminado");

	}


}
