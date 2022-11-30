package ar.edu.unlu.poo.easygame.vista;

import ar.edu.unlu.poo.easygame.modelo.IJuego;
import ar.edu.unlu.poo.easygame.modelo.Jugador;

import java.util.List;

import ar.edu.unlu.poo.easygame.controlador.Controlador;

public interface IVista {
   public void iniciar();
   public void mostrarTablero();
   public void mostrarMenuJugada();
   public void mostrarMenuPrincipal();
   public void terminar();  
   public void mostrarManoJugador(Jugador jugador);
   public void setControlador(Controlador controlador);
   public void menuCargaJugadores(); 
   
   }
