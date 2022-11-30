package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ar.edu.unlu.poo.easygame.observer.Observador;

public class MazoDescendente extends GrupoCartas {

	public Eventos recibirIntentoJugada(Carta carta) {
		try {
			if (peekCartaTop() == null) {
				return Eventos.JUGADA_CORRECTA;
			} else {
				// la jugada valida es que sea menor a la carta que esta en la mesa, o que sea
				// del mismo color.
				if (carta.getNumero() >= peekCartaTop().getNumero()) { // es mayor al numero en mesa
					if (carta.getColor().equals(peekCartaTop().getColor())) { // es igual al color de la mesa
						return Eventos.JUGADA_CORRECTA;
					} else {
						return Eventos.JUGADA_INCORRECTA;
					}
				}
				return Eventos.JUGADA_CORRECTA;
			}
		} catch (Exception EmptyStackException) {
			return Eventos.JUGADA_CORRECTA;
		}
	}

	public Eventos addCarta(Carta carta) {
		if (recibirIntentoJugada(carta) == Eventos.JUGADA_CORRECTA) {
			cartas.push(carta);
			return recibirIntentoJugada(carta);
		} else {
			return recibirIntentoJugada(carta);
		}

	}

	@Override
	protected Carta peekCartaTop() {
		return cartas.peek();

	}

	@Override
	protected Carta popCartaTop() {
		return cartas.pop();
	}

}
