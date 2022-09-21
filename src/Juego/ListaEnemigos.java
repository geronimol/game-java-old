package Juego;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ListaEnemigos {
	
	static final int CANTIDAD=15;
	private ArrayList<Enemigo> enemigos;
	
	public ListaEnemigos(){
		enemigos=new ArrayList<Enemigo>();
		AgregaEnemigos();
	}
	
	public void AgregaEnemigos(){
		for(int i=0;i<CANTIDAD;i++)
			enemigos.add(new Enemigo());
	}
	
	public void UpdateEnemigos(){
		for(int i=0;i<CANTIDAD;i++)
			enemigos.get(i).update();
	}
	
	public void RenderEnemigos(Graphics g){
		for(int i=0;i<CANTIDAD;i++)
			enemigos.get(i).render(g);
	}

	public boolean detectaColisiones(Rectangle PJ) {
		boolean detecta=false;
		for(int i=0;i<CANTIDAD;i++){
			if(PJ.intersects(enemigos.get(i).getBounds()))
				detecta=true;}
		return detecta;
	
	}

	public void setPosicion() {
		for(int i=0;i<CANTIDAD;i++)
			enemigos.get(i).setPosicion();
		
	}
	
}
