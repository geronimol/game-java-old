package Juego;

public class monster extends Enemigo{
	
	public monster(){
		super.ENEMY="pacman.PNG";
		super.VELOCIDAD=10;
		super.ANCHO=40;
		super.LARGO=40;
		super.BORDE=25;
		
	}
	
	public void update(){
		x+=VELOCIDAD;
		y+=1;
		if(x>juego.ANCHO-BORDE)
			x=BORDE;
		if(x<BORDE)
			x=juego.ANCHO-BORDE;
		if(y>juego.LARGO-BORDE)
			y=BORDE;
		if(y<BORDE)
			y=juego.LARGO-BORDE;
	}
	

}
