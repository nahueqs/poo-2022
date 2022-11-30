import ar.edu.unlu.poo.easygame.modelo.Juego;
import ar.edu.unlu.poo.easygame.controlador.Controlador;
import ar.edu.unlu.poo.easygame.vista.VistaConsola;

public class easyGame {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Juego modelo = new Juego();
		VistaConsola vista = new VistaConsola();
		Controlador controlador = new Controlador(modelo, vista);
		vista.iniciarJuego();
		
	}

}
