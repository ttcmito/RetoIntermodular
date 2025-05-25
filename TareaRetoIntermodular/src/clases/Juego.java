package clases;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
	static String[] nombreEnemigos = {"Mr Evil", "Scarface", "Nightmare"};
	
	private ArrayList<Enemigo>enemigos;
	private Personaje jugador;
	private int nRondas;
	private int ronda;
	
	public Juego () {
		enemigos = new ArrayList<>();
	}
	
	public static String enemigoAleatorio () {
		Random random = new Random ();
		int indiceAleatorio = random.nextInt(nombreEnemigos.length);
		String enemigoAleatorio = nombreEnemigos[indiceAleatorio];
		return enemigoAleatorio;
	}

	public void iniciarJuego (Enemigo enemigo) {
		
		if (enemigos.isEmpty()) {
			for (int i = 0; i < nRondas; i++)  {
				enemigo.iniciarEnemigo(enemigoAleatorio());
				enemigos.add(enemigo);
				setRonda(0);
			}
		}
	}
	
	//metodo hecho para test de enemigo Aleatorio
	public static String[] getSiguienteEnemigo () {
		return nombreEnemigos;
	}
	
	public void getSiguiente () {
		enemigos.get(0);
	}
	
	public boolean terminarRonda () {
		if (enemigos.get(0).muerto()) {
			enemigos.remove(0);
			return true;
		}
		return false;
	}
	
	
	public Guerrero nuevoGuerrero (String nombre) {
		int randomVida = (int)(Math.random() * (200 - 100 + 1) + 100);
		Guerrero guerrero = new Guerrero (nombre, randomVida);
		jugador = guerrero;
		return (Guerrero)jugador;
	}
	
	public Mago nuevoMago (String nombre) {
		int randomVida = (int)(Math.random() * (150 - 50 + 1) + 50);
		Mago mago = new Mago (nombre, randomVida);
		jugador = mago;
		return (Mago)jugador;
	}
	
	public boolean finalJuego () {
		if (enemigos.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public Personaje getJugador() {
		return jugador;
	}
	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}
	public int getnRondas() {
		return nRondas;
	}
	public void setnRondas(int nRondas) {
		this.nRondas = nRondas;
	}
	public int getRonda() {
		return ronda;
	}
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}
	
}
