package Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class oyenteTeclado implements KeyListener {
	
	juego juego1;
	boolean Lpressed,Rpressed,Upressed,Dpressed;
	
	public oyenteTeclado(juego juego){
		juego1=juego;
	}

	@Override
	public void keyPressed(KeyEvent evento) {
		if(evento.getKeyCode()==KeyEvent.VK_LEFT){
			Lpressed=true;
			juego1.getPersonaje().moverIzq();}
		if(evento.getKeyCode()==KeyEvent.VK_RIGHT){
			Rpressed=true;
			juego1.getPersonaje().moverDer();}
		if(evento.getKeyCode()==KeyEvent.VK_UP){
			Upressed=true;
			juego1.getPersonaje().moverArriba();}
		if(evento.getKeyCode()==KeyEvent.VK_DOWN){
			Dpressed=true;
			juego1.getPersonaje().moverAbajo();}

	}

	@Override
	public void keyReleased(KeyEvent evento) {
		if(evento.getKeyCode()==KeyEvent.VK_LEFT){
			Lpressed=false;
			if(Rpressed)
				juego1.getPersonaje().moverDer();
			else
				juego1.getPersonaje().noMoverX();}
		
		if(evento.getKeyCode()==KeyEvent.VK_RIGHT){
			Rpressed=false;
			if(Lpressed)
				juego1.getPersonaje().moverIzq();
			else
				juego1.getPersonaje().noMoverX();}
		
		if(evento.getKeyCode()==KeyEvent.VK_UP){
			Upressed=false;
			if(Dpressed)
				juego1.getPersonaje().moverAbajo();
			else
				juego1.getPersonaje().noMoverY();}
		
		if(evento.getKeyCode()==KeyEvent.VK_DOWN){
			Dpressed=false;
			if(Upressed)
				juego1.getPersonaje().moverArriba();
			else
				juego1.getPersonaje().noMoverY();}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
