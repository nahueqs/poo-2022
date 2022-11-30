package ar.edu.unlu.poo.easygame.controlador;

import java.util.List;

import ar.edu.unlu.poo.easygame.modelo.Eventos;
import ar.edu.unlu.poo.easygame.modelo.Juego;
import ar.edu.unlu.poo.easygame.observer.Observable;
import ar.edu.unlu.poo.easygame.observer.Observador;
import ar.edu.unlu.poo.easygame.vista.VistaConsola;

public class Controlador implements Observador {
	private Juego modelo;
	private VistaConsola vista;

	public Controlador(Juego modelo, VistaConsola vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
		this.modelo.agregarObservador(this);
	};

	public void iniciarJuego() {
		modelo.iniciarJuego();
	}

	public void hacerJugada(String carta, String mazo) {
		modelo.hacerJugada(carta, modelo.getMazo(mazo));
	}
	
	public void hacerSegundaJugada(String mazo) {
		modelo.hacerJugada("a", modelo.getMazo(mazo));
		
	}

	public void setJugadores(List<String> jugadores) {
		modelo.setJugadores(jugadores);
		actualizar(Eventos.JUGADORES_CARGADOS, modelo);
	}

	@Override
	public void actualizar(Object evento, Observable observado) {
		if (evento instanceof Eventos) {
			switch ((Eventos) evento) {
			case REINICIAR: {
				this.vista.iniciarJuego();
			}
			case DERROTA: {
				this.vista.terminarJuego();
			}
			case VICTORIA: {
				this.vista.terminarJuego();
			}
			case JUGADA_CORRECTA: {
				System.out.println("Jugador " + this.modelo.getJugadorActual().getNombre());
				this.vista.menuHacerJugada();
			}
			case SEGUNDA_JUGADA: {
				System.out.println("Jugador " + this.modelo.getJugadorActual().getNombre());
				this.vista.menuHacerSegundaJugada();
				
			}
			case JUGADA_INCORRECTA: {
				System.out.println("Jugador " + this.modelo.getJugadorActual().getNombre());
				System.out.println("JUGADA INCORRECTA, intente de nuevo");
				this.vista.menuHacerJugada();
			}
			case FIN_TURNO: {
				this.modelo.setSiguienteTurno();
				this.modelo.incTurno();
				System.out.println("Jugador " + this.modelo.getJugadorActual().getNombre());
				this.vista.menuHacerJugada();
			}
			case JUGADORES_CARGADOS: {
				this.modelo.iniciarJuego();
				System.out.println("Jugador " + this.modelo.getJugadorActual().getNombre());
				this.vista.menuHacerJugada();
			}
			default:
				break;
			}

		}
	}

	public String mostrarManoJugador() {
		return modelo.getCartasJugadorActual();
	}

	public String mostrarCartasTablero() {
		return modelo.getCartasMazos();
	}



}
