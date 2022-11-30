package ar.edu.unlu.poo.easygame.vista;
import java.util.Set;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import ar.edu.unlu.poo.easygame.controlador.Controlador;
import ar.edu.unlu.poo.easygame.modelo.Eventos;
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
	public void iniciarJuego() {
		boolean salir = false;
		List lista = new ArrayList();
		while(!salir) {
			menuPrincipal();
			String opcion = this.entrada.nextLine();
			switch (opcion.toLowerCase()) {
			case "a":
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

	public void menuPrincipal() {
		System.out.println("------- EASY GAME -------");
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println();
		System.out.println("Ingresa los jugadores:");
		System.out.println("a - cargar jugadores");
		System.out.println("x - Salir");
	}
		
	public void menuCargaJugadores() {
		boolean salir = false;
		int cont = 0;
		List<String> lista = new ArrayList<String>();
		printMenuCargaJugadores();
		while(!salir) {			
			String opcion = this.entrada.nextLine();
			switch (opcion.toLowerCase()) {
			case "x":
				System.out.println("Saliendo...presione enter");
				salir = true;
				esperar();
				break;
			case "z":
				System.out.println("Finalizado...presione enter");
				salir = true;
				esperar();
				break;
			default: 
				if((opcion.length()>12)||(opcion.equals(""))) {	System.out.println("Opcion no valida, ingrese otra vez...");}
				else {
					if (cont >= 5) {
						System.out.println("Maximo de jugadores alcanzado, presione enter para volver al menú principal...");
						esperar();
						salir = true;
					} else {
						lista.add(opcion);						
						System.out.println("Añadido, ingrese el nombre del siguiente");
						cont += 1;					
					}
				}
			}		
		}
		if (lista.size() > 0) { controlador.setJugadores(lista);}
		
	}

	public void menuHacerJugada() {
		System.out.println(controlador.mostrarCartasTablero()); 
		System.out.println(controlador.mostrarManoJugador());
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

	public void esperar() {
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void printMenuCargaJugadores() {
		System.out.println("------- EASY GAME -------");
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println();
		System.out.println("Ingresa el nombre del jugador");
		System.out.println("para finalizar la carga ingrese z, para salir ingrese x");
		System.out.println();
		System.out.println();
		System.out.println("x - Salir");
	}

	@Override
	public void terminarJuego() {
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}




}
