package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Enemigo {
	
	protected int ANCHO=30,LARGO=30, BORDE=25,POSX=20,POSY=20,VELOCIDAD=10;
	protected String ENEMY="carita.jpg";
	protected int x,y;
	
	
	public Enemigo(){
		x=POSX;
		y=POSY;
	}

	public void render(Graphics g){
		
		Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage (ENEMY);
        g.drawImage (imagen, x, y,ANCHO,LARGO, null );
	}
	
	public void update(){
		x+=aleatorio();
		y+=aleatorio();
		if(x>juego.ANCHO-BORDE)
			x=BORDE;
		if(x<BORDE)
			x=juego.ANCHO-BORDE;
		if(y>juego.LARGO-BORDE)
			y=BORDE;
		if(y<BORDE)
			y=juego.LARGO-BORDE;
	}
	

	public int aleatorio(){
		return (int) Math.round(Math.random()*(VELOCIDAD+VELOCIDAD)-VELOCIDAD);
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,ANCHO,LARGO);
	}

	public void setPosicion() {
		x=POSX;
		y=POSY;
		
	}
	
}
