package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import ar.edu.unlu.poo.easygame.observer.Observable;

public abstract class GrupoCartas {
	   protected Stack<Carta> cartas;
   public static final int maxCartasJugador = 2;
   public static final int maxCartasMazo = 50;
  
   public GrupoCartas(){
	   cartas = new Stack<Carta>();
	   cartas.setSize(0);
   }
   
   protected abstract Eventos recibirIntentoJugada(Carta carta);
   protected abstract Carta getUltimaCarta();
   protected abstract Eventos addCarta(Carta carta); 
}