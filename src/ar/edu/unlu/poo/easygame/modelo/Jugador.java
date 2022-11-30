package ar.edu.unlu.poo.easygame.modelo;

import java.util.List;

public class Jugador {	
   private String nombre;   
   private static int cant = 0;
   private ManoJugador mano;
   private int id_jugador;
   
   public Jugador(final String name) {
	   nombre = name;
	   id_jugador = cant + 1;	   
	   mano = new ManoJugador();;
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
			  return mano.getUltimaCarta(); 	  
		  } else if (pos == 1) { 
			  return mano.getPrimeraCarta(); 		  } else return null;
	  }  
   
   public List<Carta> getListaManoJugador(){
	return mano.devolverListaCartas();
	   
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
