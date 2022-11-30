package ar.edu.unlu.poo.easygame.modelo;

public class MazoAscendente extends GrupoCartas {
	
	public Eventos recibirCarta(Carta carta) {
		// la jugada valida es que sea mayor a la carta que esta en la mesa, o que sea del mismo color.
		if (carta.getNumero() <= this.getUltimaCarta().getNumero()) { // es menor al numero en mesa
			if (carta.getColor().equals(getUltimaCarta().getColor())){ // es igual al color de la mesa
				this.
				return Eventos.JUGADA_CORRECTA;
			} else {
				return Eventos.JUGADA_INCORRECTA;
			} 		
		}
		return Eventos.JUGADA_CORRECTA;
	}
	
	
	public void mezclar() {
		
	}
}
