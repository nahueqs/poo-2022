package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import ar.edu.unlu.poo.easygame.observer.Observador;

public class ManoJugador extends GrupoCartas {

	public Eventos addCarta(Carta carta) {
		if (recibirIntentoJugada(carta) == Eventos.JUGADA_CORRECTA) {
			cartas.push(carta);
			return recibirIntentoJugada(carta);
		} else {
			return recibirIntentoJugada(carta);
		}
	}

	public void llenar(Carta c1, Carta c2) {
		if (cartas.size() == 0) {
			cartas.push(c1);
			cartas.push(c2);
		}
	}

	public String mostrarCartas() {
		Carta c1, c2;
		c1 = popCartaTop();
		c2 = popCartaTop();
		if (c1 == null) {
			return "No tienes cartas";
		} else if (c2 == null) {			
			cartas.push(c1);
			return "Tu unica carta es: " + "1->" + c1.toString();
		} else {
			cartas.push(c1);
			cartas.push(c2);
			return "Tus cartas son: " + "1->" + c1.toString() + " 2->" + c2.toString();
		}
	}

	@Override
	protected Carta popCartaTop() {
		try { return cartas.pop();}
		catch (Exception e) { return null;}
	}
	
	protected Carta popCartaBottom() {
		Carta aux, aux2;
		aux = cartas.pop();
		aux2 = cartas.pop();
		cartas.push(aux);
;		try { return aux2;}
		catch (Exception e) { return null;}
	}

	@Override
	protected Carta peekCartaTop() {
		Carta aux, aux2;
		aux = cartas.pop();
		aux2 = cartas.peek();
		cartas.push(aux);
		try { return aux2;}
		catch (Exception e) { return null;}
	}
	
	protected Carta peekCartaBottom() {
		try { return cartas.peek();}
		catch (Exception e) { return null;}
	}

	@Override
	protected Eventos recibirIntentoJugada(Carta carta) {
		if (cartas.size() < maxCartasJugador) {
			return Eventos.JUGADA_CORRECTA;
		} else {
			return Eventos.JUGADA_INCORRECTA;
		}
	}

}
