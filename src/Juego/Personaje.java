package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Personaje  {
	
	public static final int POSX=600,POSY=350,ANCHO=20,LARGO=25,VELOCIDAD=1;
	public static final String PJ="clau.jpg";
	private int x, y,vx,vy,BORDE=25,velocidad=VELOCIDAD,ancho=ANCHO,largo=LARGO;
	
	public Personaje(){
		x=POSX;
		y=POSY;
		vx=0;
		vy=0;
	}
	
	public void render(Graphics g){
		Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage (PJ);
        g.drawImage (imagen, x, y,ancho,largo, null );
	}
	
	public void update(){
		x+=vx;
		y+=vy;
		if(x>juego.ANCHO-BORDE)
			x=BORDE;
		if(x<BORDE)
			x=juego.ANCHO-BORDE;
		if(y>juego.LARGO-BORDE)
			y=BORDE;
		if(y<BORDE)
			y=juego.LARGO-BORDE;
		
	}

	public void moverIzq() {
		vx=-velocidad;
	}
	
	public void moverDer() {
		vx= velocidad;
	}
	
	public void moverArriba() {
		vy=- velocidad;
	}
	
	public void moverAbajo() {
		vy= velocidad;
	}

	public void noMoverX() {
		vx=0;
	}
	
	public void noMoverY(){
		vy=0;
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,ancho,largo);
	}

	public void setPosicion() {
		x=POSX;
		y=POSY;
		vx=0;
		vy=0;
		velocidad=VELOCIDAD;
		ancho=ANCHO;
		largo=LARGO;
	}
	
	public void aumentaCapacidad(){
		velocidad+=6;
		ancho*=2;
		largo*=2;
	}
}
