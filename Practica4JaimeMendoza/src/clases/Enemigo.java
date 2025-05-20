package clases;

public class Enemigo extends Personaje {
	
	public Enemigo () {
		
	}
	
	public void iniciarEnemigo (String nombre) {
		setNombre(nombre);
		int randomVida = (int)(Math.random() * (100 - 20 + 1) + 20);
		setVida(randomVida);
		setVidaInicial(randomVida);
		int randomFuerza = (int)(Math.random() * (10 - 2 + 1) + 2);
		setAtaque(randomFuerza);
		int randomDefensa = (int)(Math.random() * (3 - 1 + 1) + 1);
		setDefensa(randomDefensa);
	}
	
}
