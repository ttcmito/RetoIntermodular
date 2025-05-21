package clases;

public class Mago extends Personaje implements Jugable {
	static final int FUERZA_MAGIA = 20;
	static final int FUERZA_SIN_MAGIA = 5;
	static final int DEFENSA = 5;
	static final int MAGIA = 10;
	
	private int magia;
	
	public Mago (String nombre, int vida) {
		super(vida, FUERZA_MAGIA, DEFENSA, nombre);
		magia = MAGIA;
	}
	
	//metodo implementado por interfaz Jugable
	@Override
	public void curar () {
		if (magia > 0) {
			setVida(getVida() + FUERZA_MAGIA);
			if (getVida() > getVidaInicial()) {
				setVida(getVida() - FUERZA_MAGIA);
			}
			magia --;
		}
	}
	
	@Override 
	public void atacar (Personaje otro) {
		super.atacar(otro);
		if (magia > 0) {
			magia --;
		}
		if (magia == 0) {
			setAtaque(FUERZA_SIN_MAGIA);
		} 
	}
	
	@Override
	public void resetear () {
		magia = MAGIA;
	}

	@Override
	public String toString() {
		return super.toString() + ", magia: " + magia;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}
	
}
