package ar.edu.unlu.poo.easygame.modelo;

public class Carta {
   private Colores color;
   private int numero;
   public Carta() {};
   public Carta(int num, Colores color) {
	   this.color = color;
	   this.numero = num;
   }
   
   public Colores getColor() {
	return color;
   }	
	  
   public String toString() {
	   return ("["+numero+"|"+color.toString()+"]");
   }
   
   public int getNumero() {
      return numero;
	}

   }
