package ar.edu.unlu.poo.easygame.modelo;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.poo.easygame.controlador.Controlador;
import ar.edu.unlu.poo.easygame.observer.Observable;
import ar.edu.unlu.poo.easygame.observer.Observador;

public class Juego implements Observable, IJuego {   
   private MazoMesa pila; 
   private MazoDescendente mazoDesc; 
   private MazoAscendente mazoAsc; 
   private Jugador siguienteTurno;
   private Jugador jugadorActual;
   private Controlador controlador; 
   private List<Jugador> jugadores;  
   private List<Observador> observadores;
   private Eventos estado;
   private Eventos estadoJugada;
    
   public Juego() {
	   pila = new MazoMesa();
	   mazoAsc = new MazoAscendente();
	   mazoDesc = new MazoDescendente();
	   jugadores = new ArrayList<Jugador>();
	   observadores = new ArrayList<>();
	   estado = null;
   }
   
   public GrupoCartas getMazo(String tipo) {
	   if (tipo == "a") {
		   return mazoAsc;
	   } else {
		   return mazoDesc;
	   }
   }
      
   public void setJugadores(String ... params) {
	   if ((params.length > 1) && (params.length <= 5)) {
		   for (int i=0;i< params.length;i++) {
			   jugadores.add(new Jugador(params[i]));
		   }
	   }
   }
   
   public void setJugadores(List<String> lista) {
	   for (int i=0; i<lista.size(); i++) {
		   jugadores.add(new Jugador(lista.get(i)));
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
		estado = Eventos.JUEGO_INICIADO;
		siguienteTurno = jugadores.get(0);
		pila.llenar();
		pila.mezclar();
		repartir();
		while ((estado != Eventos.VICTORIA)&&(estado != Eventos.DERROTA)){
			this.notificar(estado);
			
				
					
			}
		}	
		
	public void repartir() {
		for (Jugador j : jugadores) {
			j.recibirCartas(pila.quitarUltimaCarta(), pila.quitarUltimaCarta());
		}
	}	
	
	public void repartir(Jugador jugador) {
		jugador.recibirCartas(pila.quitarUltimaCarta(), pila.quitarUltimaCarta());
	}
	
	public void repartir(Jugador jugador, String s) {
		jugador.recibirCartas(pila.quitarUltimaCarta());
	}
	
	public void hacerJugada(String carta, GrupoCartas mazo) {
		setSiguienteTurno(jugadorActual);
		int aux;
		if (carta == "a") {aux = 0;
			} else {
				aux=1;
			};
		jugadorActual.hacerJugada(aux, mazo);
		//Eventos aux = Eventos.INICIO_TURNO;
		//notificar(aux);
		
	}

	public void setSiguienteTurno(Jugador jugador) {
		if (jugador.getId() < 4) { 
			siguienteTurno = jugadores.get(jugador.getId()+1);
			} else { 
				siguienteTurno = jugadores.get(0);
			}
	}

	public String getCartasJugadorActual() {
		return jugadorActual.getManoJugador();
	}
	
	public Jugador getJugadorActual() {
		return jugadorActual;
	}

}
		

