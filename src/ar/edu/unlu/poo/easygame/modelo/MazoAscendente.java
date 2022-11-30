package ar.edu.unlu.poo.easygame.modelo;

import java.util.Stack;

import ar.edu.unlu.poo.easygame.observer.Observador;

public class MazoAscendente extends GrupoCartas {
	
	public Eventos recibirIntentoJugada(Carta carta) {
		// la jugada valida es que sea mayor a la carta que esta en la mesa, o que sea del mismo color.
		if (carta.getNumero() <= getUltimaCarta().getNumero()) { // es menor al numero en mesa
			if (carta.getColor().equals(getUltimaCarta().getColor())){ // es igual al color de la mesa
				return Eventos.JUGADA_CORRECTA;
			} else {
				return Eventos.JUGADA_INCORRECTA;
			} 		
		}
		return Eventos.JUGADA_CORRECTA;
	}
	
	
	public void mezclar() {
		
	}

	@Override
	protected Carta getUltimaCarta() {
		return cartas.peek();
	}

	@Override
	protected Eventos addCarta(Carta carta) {
		if (recibirIntentoJugada(carta) == Eventos.JUGADA_CORRECTA) {
			cartas.add(carta);
			return recibirIntentoJugada(carta);
		} else {
			return recibirIntentoJugada(carta);
		}
		
	}

}
