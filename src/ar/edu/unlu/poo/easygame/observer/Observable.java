package ar.edu.unlu.poo.easygame.observer;

public interface Observable {
	public void notificar(Object evento);
	
	public void agregarObservador(Observador observador);
   
   }
