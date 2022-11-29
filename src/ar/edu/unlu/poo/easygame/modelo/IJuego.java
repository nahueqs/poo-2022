package ar.edu.unlu.poo.easygame.modelo;

import java.util.List;

import ar.edu.unlu.poo.easygame.controlador.Controlador;

public interface IJuego {
	public void iniciar();
	public void setControlador(Controlador controlador);
	public List<GrupoCartas> getTablero();
	public Eventos hacerJugada(Jugador jugador, Carta carta, GrupoCartas mazo);
	
}
