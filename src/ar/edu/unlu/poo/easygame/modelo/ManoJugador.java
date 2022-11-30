package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import ar.edu.unlu.poo.easygame.observer.Observador;

public class ManoJugador extends GrupoCartas {

  public Eventos addCarta(Carta carta) {
	  if (recibirIntentoJugada(carta) == Eventos.JUGADA_CORRECTA) {
			cartas.add(carta);
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
	  String aux = null;
	  for (Carta carta : cartas) { 
		  aux += " - " + cartas.toString();
	  }
	  return aux;  
  }
	@Override
	protected Carta getUltimaCarta() {
		return cartas.pop();
	}

	protected Carta getPrimeraCarta() {
		Carta aux;
		aux = cartas.elementAt(0);
		cartas.remove(0);
		return aux;
	
	}

	@Override
	protected Eventos recibirIntentoJugada(Carta carta) {
		if (cartas.size()<maxCartasJugador) { 
			return Eventos.JUGADA_CORRECTA;
		}
		else {
			return Eventos.JUGADA_INCORRECTA;
		}	
	}

}
   
