package ar.edu.unlu.poo.easygame.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import ar.edu.unlu.poo.easygame.controlador.Controlador;
import ar.edu.unlu.poo.easygame.observer.Observable;
import ar.edu.unlu.poo.easygame.observer.Observador;

public class Juego implements Observable {   
	private Stack<Carta> pila; 
	private MazoDescendente mazoDesc; 
	private MazoAscendente mazoAsc; 
	private Jugador siguienteTurno;
	private Jugador jugadorActual;
	private Controlador controlador; 
	private List<Jugador> jugadores;  
	private List<Observador> observadores;
	private Eventos estado;
	private Eventos estadoJugada;

	public Juego() {
		pila = new Stack<Carta>();
		mazoAsc = new MazoAscendente();
		mazoDesc = new MazoDescendente();
		jugadores = new ArrayList<Jugador>();
		observadores = new ArrayList<>();
		estado = null;
	}

	public GrupoCartas getMazo(String tipo) {
		if (tipo == "a") {
			return mazoAsc;
		} else {
			return mazoDesc;
		}
	}

	public void setJugadores(String ... params) {
		if ((params.length > 1) && (params.length <= 5)) {
			for (int i=0;i< params.length;i++) {
				jugadores.add(new Jugador(params[i]));
			}
		}
		System.out.println("añadidos "+ jugadores.size());
	}

	public void setJugadores(List<String> lista) {
		for (int i=0; i<lista.size(); i++) {
			jugadores.add(new Jugador(lista.get(i)));
		}
		System.out.println("añadidos "+ jugadores.size());
	}

	public void terminar() {

	}

	public void iniciarJuego() {
		estado = Eventos.JUEGO_INICIADO;
		siguienteTurno = jugadores.get(0);
		llenarPila();
		mezclarPila();
		repartir();
		this.notificar(estado);
	}	

	private void mezclarPila() {
		int size = pila.size();
		Random rand = new Random();
		List<Carta> a = new ArrayList<Carta>();
		for (int i = 1; i <= size;i++ ) {
			a.add(pila.pop());
		}
		for (int i = size - 1 ; i > 0; i--) {
			int numRandom = rand.nextInt(i+1);
			Carta temp = a.get(numRandom);
			a.set(numRandom, a.get(i));
			a.set(i, temp);
		}		
		for (int i = 0; i < size; i++) {
			pila.push(a.get(i));
		}								
	}

	private void repartir() {
		for (Jugador j : jugadores) {
			j.recibirCartas(pila.pop(), pila.pop());
		}
	}	

	private void repartir(Jugador jugador) {
		jugador.recibirCartas(pila.pop(), pila.pop());
	}

	private void repartir(Jugador jugador, String s) {
		jugador.recibirCartas(pila.pop());
	}

	public void hacerJugada(String carta, GrupoCartas mazo) {		
		int aux;
		if (carta == "a") {aux = 0;} 
		else {aux = 1;}
		notificar(mazo.addCarta(jugadorActual.jugarCarta(aux)));	
	}

	private void llenarPila() {
		for (Colores color : Colores.values()) {
			for(int j = 1;j<=10;j++) {
				pila.push(new Carta (j, color));
			}
		}
	}
	
	public void setSiguienteTurno() {
		if (jugadorActual.getId() < 4) { 
			siguienteTurno = jugadores.get(jugadorActual.getId()+1);
		} else { 
			siguienteTurno = jugadores.get(0);
		}
	}

	public String getCartasJugadorActual() {
		return jugadorActual.getManoJugador();
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public String getCartasMazos() {
		return "MAZO ASCENDENTE: " + mazoAsc.getUltimaCarta().toString() + "MAZO DESCENDIENTE: " + mazoDesc.getUltimaCarta().toString();
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}

	@Override
	public void agregarObservador(Observador observador) {
		this.observadores.add(observador);
	}
}


