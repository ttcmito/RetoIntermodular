package clases;

public class Guerrero extends Personaje implements Jugable {
	static final int FUERZA = 15;
	static final int DEFENSA = 10;
	static final int POCIONES = 2;
	
	private int pociones;
	
	public Guerrero (String nombre, int vida) {
		super(vida, FUERZA, DEFENSA, nombre);
		pociones = POCIONES;
	}
	
	//metodo implementado por interfaz Jugable
	@Override
	public void curar () {
		if (pociones > 0) {
			setVida(getVidaInicial());
			pociones --;
		}
	}
	
	@Override
	public void resetear () {
		pociones = POCIONES;
	}

	@Override
	public String toString() {
		return super.toString() + "; Pociones: " + pociones;
	}
	
}
