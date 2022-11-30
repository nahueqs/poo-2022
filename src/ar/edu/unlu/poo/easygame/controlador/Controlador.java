package ar.edu.unlu.poo.easygame.controlador;
import java.util.List;

import ar.edu.unlu.poo.easygame.modelo.Carta;
import ar.edu.unlu.poo.easygame.modelo.GrupoCartas;
import ar.edu.unlu.poo.easygame.modelo.Juego;
import ar.edu.unlu.poo.easygame.modelo.Jugador;
import ar.edu.unlu.poo.easygame.observer.Observable;
import ar.edu.unlu.poo.easygame.observer.Observador;
import ar.edu.unlu.poo.easygame.vista.VistaConsola;
import ar.edu.unlu.poo.easygame.modelo.Eventos;

public class Controlador implements Observador {
	private Juego modelo;
	private VistaConsola vista;
	
	public Controlador (Juego modelo, VistaConsola vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
		this.modelo.agregarObservador(this);
	};
	
	public void iniciarJuego() {
		modelo.iniciar();
	}
	
	public void hacerJugada(String carta, String mazo) {
		modelo.hacerJugada(carta, modelo.getMazo(mazo));		
	}
	
	public void setJugadores(List jugadores) {
		modelo.setJugadores(jugadores);
		actualizar(Eventos.JUGADORES_CARGADOS, modelo);
	}
	
	public void mostrarManoJugador() {
		System.out.println(modelo.getCartasJugadorActual());		
	}
	
	@Override
	public void actualizar(Object evento, Observable observado) {
		if(evento instanceof Eventos) {
			switch((Eventos) evento) {
			case DERROTA: {
				this.vista.terminar();
			}
			case JUEGO_INICIADO:{
				this.vista.mostrarMenuJugada();
			}
			
			case FIN_TURNO:{
				this.vista.mostrarMenuJugada();
			}
			case JUGADORES_CARGADOS:{
				this.vista.mostrarMenuPrincipal();
			}	
			
			
			}
		
		}
	}



   }
