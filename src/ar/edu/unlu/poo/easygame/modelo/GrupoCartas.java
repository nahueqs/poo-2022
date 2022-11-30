package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GrupoCartas {
   protected Stack<Carta> cartas;
   protected static final int maxCartasJugador = 2;
   protected static final int maxCartasMazo = 50;
  
   public GrupoCartas(){
	   cartas = new Stack<Carta>();
	   cartas.setSize(0);
   }
   
   public Carta getUltimaCarta() {
	   return cartas.lastElement();
   }
     
   public Carta quitarUltimaCarta() {
	   Carta aux = cartas.lastElement();
	   cartas.pop();
	   return aux;
   }
     
   public void mezclar() {
		int size = cartas.size();
		Random rand = new Random();
		List<Carta> a = new ArrayList<Carta>();
		for (int i = 1; i <= size;i++ ) {
			a.add(cartas.pop());
		}
		for (int i = size - 1 ; i > 0; i--) {
			int numRandom = rand.nextInt(i+1);
			Carta temp = a.get(numRandom);
			a.set(numRandom, a.get(i));
			a.set(i, temp);
		}		
		for (int i = 0; i < size; i++) {
			cartas.push(a.get(i));
		}				
				
	}

}