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
	private int cantJugadasJugadorActual;
	private List<Jugador> jugadores;  
	private List<Observador> observadores;
	private Eventos estado;
	private int turno;
	private int cartasEnJuego;

	public Juego() {
		pila = new Stack<Carta>();
		mazoAsc = new MazoAscendente();
		mazoDesc = new MazoDescendente();
		jugadores = new ArrayList<Jugador>();
		observadores = new ArrayList<>();
		estado = null;
	}

	public GrupoCartas getMazo(String tipo) {
		if (tipo.equals("a")) {
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
		if (lista.size()>2) {
			for (int i=0; i<lista.size(); i++) {
				jugadores.add(new Jugador(lista.get(i)));
			}
			System.out.println("añadidos "+ jugadores.size());
		} else {
			System.out.println("Error, deben ser al menos 2 jugadores");
			notificar(Eventos.REINICIAR);
		}
	}

	public void terminar() {
		
	}

	public void iniciarJuego() {
		estado = Eventos.JUEGO_INICIADO;
		siguienteTurno = jugadores.get(0);
		jugadorActual = siguienteTurno;
		cantJugadasJugadorActual = 0;
		turno = 1;
		llenarPila();
		mezclarPila();
		repartirTodos();
		cartasEnJuego = 50 - (jugadores.size() * 2);
		notificar(estado);
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

	private void repartirTodos() {
		for (Jugador j : jugadores) {
			j.recibirCartas(pila.pop(), pila.pop());
		}
	}
	
	public void incTurno() {
		turno += 1;
	}


	private void repartirDos() {
		jugadorActual.recibirCartas(pila.pop(), pila.pop());
	}

	private void repartirUna() {
		jugadorActual.recibirCartas(pila.pop());
	}

	public void hacerJugada(String carta, GrupoCartas mazo) {		
		Eventos auxEventos;				
		if (existeJugadaValida()){
			int aux;
			if (carta == "a") {aux = 0;} else {aux = 1;}
			if (cantJugadasJugadorActual == 1) {
				// ultima jugada
				auxEventos = mazo.addCarta(jugadorActual.jugarCarta(aux));
				if (auxEventos.equals(Eventos.JUGADA_CORRECTA)) {
					cantJugadasJugadorActual += 1;
					jugadorActual.recibirCartas(pila.pop());
					jugadorActual.recibirCartas(pila.pop());
					notificar(Eventos.FIN_TURNO);
				} else {
					notificar(Eventos.JUGADA_INCORRECTA);
				}
			} else { 
				auxEventos = mazo.addCarta(jugadorActual.jugarCarta(aux));// primera jugada del turno
				if (auxEventos.equals(Eventos.JUGADA_CORRECTA)) {
					cantJugadasJugadorActual += 1;
					notificar(Eventos.JUGADA_CORRECTA);
				} else {
					notificar(Eventos.JUGADA_INCORRECTA);
				}				
			}				
		} else if (cantJugadasJugadorActual == 1) {
			jugadorActual.recibirCartas(pila.pop());
			notificar(Eventos.FIN_TURNO);
		} else {
			notificar(Eventos.DERROTA);
		}			
	}

	private boolean existeJugadaValida() {
		boolean aux = false;
		List<Carta> lista = new ArrayList<Carta>();
		lista = jugadorActual.getListaManoJugador();
		for (Carta i:lista) {
			if (mazoAsc.recibirIntentoJugada(i).equals(Eventos.JUGADA_CORRECTA)) {
				aux = true;
			}
			if (mazoDesc.recibirIntentoJugada(i).equals(Eventos.JUGADA_CORRECTA)) {
				aux = true;
			}
		}
		return aux;
	}

	private void llenarPila() {
		for (Colores color : Colores.values()) {
			for(int j = 1;j<=10;j++) {
				pila.push(new Carta (j, color));
			}
		}
	}

	public void setSiguienteTurno() {
		if (pila.size() > 0) {
			jugadorActual = siguienteTurno;
			if (jugadorActual.getId() < 4) { 				
				siguienteTurno = jugadores.get(jugadorActual.getId()+1);
			} else { 
				siguienteTurno = jugadores.get(0);
			}
			cantJugadasJugadorActual = 0;
		} else {
			notificar(Eventos.VICTORIA);
		}
	}

	public String getCartasJugadorActual() {
		return jugadorActual.getManoJugador();
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public String getCartasMazos() {
		String aux = "";
		if (mazoAsc.cartas.size() > 0) { aux +=  "MAZO ASCENDENTE: " + mazoAsc.getUltimaCarta().toString() ;} 
		else { aux +=  "MAZO ASCENDENTE VACIO -|- " ;};
		if (mazoDesc.cartas.size() > 0) { aux +=  " MAZO DESCENDIENTE: " + mazoDesc.getUltimaCarta().toString() ;}
		else { aux +=  "MAZO DESCENDIENTE VACIO " ;};
		return aux; 
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


