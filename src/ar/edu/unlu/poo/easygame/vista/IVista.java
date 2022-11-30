package ar.edu.unlu.poo.easygame.vista;

import ar.edu.unlu.poo.easygame.modelo.Jugador;

import java.util.List;

import ar.edu.unlu.poo.easygame.controlador.Controlador;

public interface IVista {
	public void iniciarJuego();

	public void menuPrincipal();

	public void menuCargaJugadores();

	public void menuHacerJugada();

	public void terminarJuego();

	public void setControlador(Controlador controlador);
}
