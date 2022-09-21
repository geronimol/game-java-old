package Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class item {
	
	public static final int BORDE=25,ANCHO=70,LARGO=70,POSX=700,POSY=700,VELOCIDAD=4;
	public static final String ITEM="manzana.gif";
	private int x,y,velocidad=VELOCIDAD;
	
	public item(){
		x=POSX;
		y=POSY;
	}
	
	public void render(Graphics g){
		Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage (ITEM);
        g.drawImage (imagen, x, y,ANCHO,LARGO, null );
	}
	
	public void update(){
		x-=velocidad;
		y+=velocidad;
		
		if(x>juego.ANCHO-BORDE)
			x=BORDE;
		if(x<BORDE)
			x=juego.ANCHO-BORDE;
		if(y>juego.LARGO-BORDE)
			y=BORDE;
		if(y<BORDE)
			y=juego.LARGO-BORDE;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,ANCHO,LARGO);
	}

	public void setPosicion() {
		x=POSX;
		y=POSY;
		velocidad=VELOCIDAD;
	}
	
	public void detieneItem() {
		x=-10;
		y=-10;
		velocidad=0;
	}
}
