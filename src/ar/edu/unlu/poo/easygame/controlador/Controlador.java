package ar.edu.unlu.poo.easygame.controlador;
import ar.edu.unlu.poo.easygame.modelo.Juego;
import ar.edu.unlu.poo.easygame.observer.Observable;
import ar.edu.unlu.poo.easygame.observer.Observador;
import ar.edu.unlu.poo.easygame.vista.VistaConsola;
import ar.edu.unlu.poo.todoapp.modelo.Eventos;

public class Controlador implements Observador {
	private Juego modelo;
	private VistaConsola vista;
	
	public Controlador (Juego modelo, VistaConsola vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
		this.modelo.agregarObservador(this);
	};
	
	
	@Override
	public void actualizar(Object evento, Observable observado) {
//		if(evento instanceof Eventos) {
//			switch((Eventos) evento) {
		
	}
  

   }
