package clases;

public class Personaje {
	private int vida;
	private int vidaInicial;
	private int ataque;
	private int defensa;
	private String nombre;
	
	public Personaje () {
		
	}
	
	public Personaje(int vida, int ataque, int defensa, String nombre) {
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.nombre = nombre;
		vidaInicial = vida;
	}
	
	public void atacar (Personaje otro) {
		int dmg = (this.ataque - otro.defensa) < 0 ? 0 : (this.ataque - otro.defensa);
		otro.vida -= dmg;
		System.out.println("Le han quitado a " + otro.getNombre() + " " + dmg + " de vida ");
	}

	public void curar () {
		
	}
	
	public void resetear () {
		vida = vidaInicial;
	}
	
	public boolean muerto () {
		if (vida <= 0) {
			return true;
		} else {
			return false;
		}
		//return vida <= 0;
	}
	
	@Override
	public String toString() {
		return " => " + nombre + ", vida: " + vida + " / " + vidaInicial;
	}

	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getVidaInicial() {
		return vidaInicial;
	}
	public void setVidaInicial(int vidaInicial) {
		this.vidaInicial = vidaInicial;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
