package ar.edu.unlu.poo.easygame.modelo;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.poo.easygame.controlador.Controlador;
import ar.edu.unlu.poo.easygame.observer.Observable;
import ar.edu.unlu.poo.easygame.observer.Observador;

public class Juego implements Observable, IJuego {   
   private MazoMesa mazo; 
   private MazoDescendente mazoDesc; 
   private MazoAscendente mazoAsc; 
   private Jugador siguienteTurno;
   private Controlador controlador; 
   private List<Jugador> jugadores;  
   private List<Observador> observadores;
   private EstadosDeJuego estado;
   
   public Juego() {
	   mazo = new MazoMesa();
	   mazoAsc = new MazoAscendente();
	   mazoDesc = new MazoDescendente();
	   jugadores = new ArrayList<Jugador>();
	   observadores = new ArrayList<>();
	   estado = EstadosDeJuego.CREADO;
   }
   
   
   public void setJugadores(String ... params) {
	   if ((params.length > 0) && (params.length <= 5)) {
		   for (int i=0;i< params.length;i++) {
			   jugadores.add(new Jugador(params[i]));
		   }
	   }
   }
   
   public void terminar() {

   }
   
   public void setControlador(Controlador controlador) {
       this.controlador = controlador;
   }

   @Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}

	@Override
	public void agregarObservador(Observador observador) {
			this.observadores.add(observador);
	}

	@Override
	public void iniciar() {
		estado = EstadosDeJuego.INICIADO;
		mazo.llenar();
		mazo.mezclar();
		for (Jugador j : jugadores) {
			j.recibirCartas(mazo.quitarUltimaCarta(), mazo.quitarUltimaCarta());
		}
		while ((estado != EstadosDeJuego.VICTORIA)&&(estado != EstadosDeJuego.DERROTA)){
			for (Jugador j : jugadores) {
				
			}
		}
		
	}

	@Override
	public Eventos hacerJugada(Jugador jugador, Carta carta, GrupoCartas mazo) {
		setSiguienteTurno(jugador);
		Eventos aux;
		
		return null;
	}

	public void setSiguienteTurno(Jugador jugador) {
		if (jugador.getId() < 4) { 
			siguienteTurno = jugadores.get(jugador.getId()+1);
			} else { 
				siguienteTurno = jugadores.get(0);
			}
	}

}
		

