package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class ManoJugador extends GrupoCartas {

  public void addCarta(Carta carta) {
	  if (cartas.size()<maxCartasJugador) {cartas.push(carta);}
  }
  
  public Carta jugarCarta(int pos) {
	  Carta aux;
	  if (pos == 0) {
		  aux = cartas.firstElement();
		  cartas.remove(0);
		  return aux; 
		  
	  } else if (pos == 1) { 
		  aux = cartas.lastElement();
		  cartas.pop();
		  return aux; 
		  
	  } else return null;
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
  		
  		
  	
  
  

}
   
