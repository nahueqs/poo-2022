package ar.edu.unlu.poo.easygame.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazoMesa extends GrupoCartas {

	public void repartir(Jugador jugador) {
		jugador.
	}
   
 //  public void addCarta(Carta carta) {
//	   if (cartas.size() < maxCartasMazo) { cartas.push(carta);}
 //  }
   
   public void llenar() {
	   for (Colores color : Colores.values()) {
			   for(int j = 1;j<=10;j++) {
				   cartas.push(new Carta (j, color));
			   }
		   }
	   }


	   
   }
