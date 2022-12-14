package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ar.edu.unlu.poo.easygame.observer.Observador;

public class MazoAscendente extends GrupoCartas {

	public Eventos recibirIntentoJugada(Carta carta) {
		// la jugada valida es que sea mayor a la carta que esta en la mesa, o que sea
		// del mismo color.
		try {
			if (carta.getNumero() <= peekCartaTop().getNumero()) { // es menor al numero en mesa
				if (carta.getColor().equals(peekCartaTop().getColor())) { // es igual al color de la mesa
					return Eventos.JUGADA_CORRECTA;
				} else {
					return Eventos.JUGADA_INCORRECTA;
				}
			}
			return Eventos.JUGADA_CORRECTA;
		} catch (Exception EmptyStackException) {
			return Eventos.JUGADA_CORRECTA;
		}
	}

	@Override
	protected Carta peekCartaTop() {
		return cartas.peek();
	}

	@Override
	protected Eventos addCarta(Carta carta) {
		Eventos aux = recibirIntentoJugada(carta);
		if (aux == Eventos.JUGADA_CORRECTA) {
			cartas.push(carta);
			return aux;
		} else {
			return aux;
		}

	}

	@Override
	protected Carta popCartaTop() {
		return cartas.pop();
	}

}
