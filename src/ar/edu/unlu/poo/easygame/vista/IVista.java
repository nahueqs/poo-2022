package ar.edu.unlu.poo.easygame.vista;

import ar.edu.unlu.poo.easygame.modelo.IJuego;
import ar.edu.unlu.poo.easygame.controlador.Controlador;

public interface IVista {
   public void iniciar();
   public void mostrarTablero(IJuego tablero);
   public void mostrarMenuJugada();
   public void mostrarMenuPrincipal();
   public void mostrarMenuJugador();
   public void mostrarMenuCargaJugadores();
   public void mostrarManoJugador();
   public void setControlador(Controlador controlador);
	
   
   }
