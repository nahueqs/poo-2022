package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Jugador {
	private String nombre;
	private static int cant = 0;
	private ManoJugador mano;
	private int id_jugador;

	public Jugador(final String name) {
		nombre = name;
		id_jugador = cant + 1;
		mano = new ManoJugador();
		;
	}

	public void recibirCartas(Carta c) {
		mano.addCarta(c);
	}

	public void recibirCartas(Carta c1, Carta c2) {
		mano.addCarta(c1);
		mano.addCarta(c2);
	}

	public Carta jugarCarta(int pos) {
		if (pos == 0) {
			Carta aux;
			Carta aux2;
			aux = mano.popCartaTop();
			aux2 = mano.popCartaTop();
			mano.addCarta(aux);
;			return aux2;
		} else if (pos == 1) {
			return mano.popCartaTop();
		} else
			return null;
	}

	public List<Carta> getListaManoJugador() {
		List<Carta> aux = new ArrayList<Carta>();
		Stack<Carta> auxStack = new Stack<Carta>();
		for (int i = 0;i<2;i++) {
			auxStack.push(mano.popCartaTop());
			aux.add(auxStack.peek());
		}
		for (Carta i : aux) {
			mano.addCarta(i);
		}		
		return aux;
	}

	public String getManoJugador() {
		return mano.mostrarCartas();
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getId() {
		return id_jugador;
	}

}
