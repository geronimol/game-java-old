package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class juego extends JFrame implements Runnable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ANCHO=1280,LARGO=720;
	private int Vidas=99999;
	Personaje Pj;
	boss Jefe;
	ListaEnemigos Enem;
	monster monstruo;
	item Manzana;
	
	boolean condicion;
	Thread ThreadPrincipal;
	
	public juego(){
		this.setTitle("Mi primer juego");
		this.setBounds(300,200,ANCHO,LARGO);
		this.setVisible(true);
		this.setResizable(false);
		this.setIgnoreRepaint(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.addWindowListener(new oyenteventana(this));
		this.addKeyListener(new oyenteTeclado(this));
		this.addMouseMotionListener(new oyenteMouseMovimiento(this));
		this.addMouseListener(new oyenteMouse(this));
		
		Pj= new Personaje();
		Jefe= new boss();
		Enem= new ListaEnemigos();
		monstruo=new monster();
		Manzana=new item();
		
		ThreadPrincipal=new Thread(this);
		ThreadPrincipal.start();
	}
	
	public static void main(String[] args){
		Sonido.BACK.loop();
		@SuppressWarnings("unused")
		juego JUEGO=new juego();
	}
	
	//Gameloop
	public void run() {
		condicion=true;
		while(condicion){
			update();
			paint(this.getGraphics());
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {}
		}
		
		
		System.exit(ABORT);
		
		
		
	}

	public void update() {
		Pj.update();
		Jefe.update();
		Enem.UpdateEnemigos();
		monstruo.update();
		Manzana.update();
		
		//Colision con jefe
		if(colisionJefe()){
			Sonido.BACK.stop();
			Sonido.BOCADO.play();
			JOptionPane.showMessageDialog(this, "Ganaste kpo!","Has ganado, muy bien 10",2);
			reiniciarJuego();
		}
		
		//Colision con enemigo
		if(Enem.detectaColisiones(Pj.getBounds()) || (monstruo.getBounds().intersects(Pj.getBounds()))){
			Sonido.BACK.stop();
			Sonido.RISAS.play();
			JOptionPane.showMessageDialog(this, "Game over!", "Juego terminado", 0);
			Vidas--;
			if(Vidas>0){
				if(JOptionPane.showConfirmDialog(null,"Quedan "+Vidas+" vidas, continuar?","Fin del juego",JOptionPane.YES_NO_OPTION)== JOptionPane.NO_OPTION)
					terminarjuego();
				else
					reiniciarJuego();}
			else
				System.exit(0);
		}
		
		//Colision con manzana
		if(Pj.getBounds().intersects(Manzana.getBounds())){
			Pj.aumentaCapacidad();
			Manzana.detieneItem();
		}
			
			
		
	}

	private void reiniciarJuego() {
		Sonido.RISAS.stop();
		Sonido.BACK.loop();
		Pj.setPosicion();
		Jefe.setPosicion();
		Enem.setPosicion();
		monstruo.setPosicion();
		Manzana.setPosicion();
		} 

	public boolean colisionJefe() {
		return Pj.getBounds().intersects(Jefe.getBounds());
	}

	public void paint(Graphics g) {
		
		if(g!=null){
			
			Toolkit.getDefaultToolkit().sync();
			//DIBUJO FONDO NEGRO
			g.setColor(Color.black);
			g.fillRect(0,0, ANCHO, LARGO);
			
			//DIBUJO FONDO
			Toolkit t = Toolkit.getDefaultToolkit ();
	        Image imagen = t.getImage ("fondo.gif");
	        g.drawImage (imagen, 300, 150, null);
	   
	        //DIBUJO VIDAS
	        g.setColor(Color.WHITE);
	        g.drawString("Vidas: "+Vidas, 600, 140);
	        //Toolkit.getDefaultToolkit().sync();
	        //RENDERS
			Pj.render(g);
			//Toolkit.getDefaultToolkit().sync();
			Jefe.render(g);
			//Toolkit.getDefaultToolkit().sync();
			Enem.RenderEnemigos(g);
			//Toolkit.getDefaultToolkit().sync();
			monstruo.render(g);
			//Toolkit.getDefaultToolkit().sync();
			Manzana.render(g);
			Toolkit.getDefaultToolkit().sync();
			
			g.dispose();
			}
		
	}

	public void terminarjuego() {
		condicion=false;
	}

	public Personaje getPersonaje() {
		return Pj;
	}
	
	public Enemigo getJefe(){
		return Jefe;
	}
	
}