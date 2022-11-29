package ar.edu.unlu.poo.easygame.modelo;

public class MazoDescendente extends GrupoCartas {
	
	public Eventos recibirCarta(Carta carta) {
		// la jugada valida es que sea mejor a la carta que esta en la mesa, o que sea del mismo color.
		if (carta.getNumero() >= this.getUltimaCarta().getNumero()) { // es mayor al numero en mesa
			if (carta.getColor().equals(getUltimaCarta().getColor())){ // es igual al color de la mesa
				return Eventos.JUGADA_CORRECTA;
			} else { return Eventos.JUGADA_INCORRECTA;
		} 
		return null;
		
	}
}
