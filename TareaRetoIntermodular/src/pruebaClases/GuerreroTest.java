package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Enemigo;
import clases.Guerrero;

public class GuerreroTest {
	
	static Guerrero guerrero;
	static Enemigo enemigo;
	
	@BeforeEach
	public void crearGuerrero() {
		guerrero = new Guerrero("Juan", 50);
		guerrero.setVidaInicial(100);
		guerrero.setPociones(3);      
	}
	
	@Test
	public void muereGuerrero() {
		guerrero.setVida(0);
		assertEquals(guerrero.muerto(), true);
	}
	
	@Test
	public void noMuereGuerrero() {
		assertEquals(guerrero.muerto(), false);
	}
	
	@Test
	public void resetearPociones() {
		guerrero.setPociones(1);
		guerrero.resetear();
		assertEquals(2, guerrero.getPociones());
	}
	

	@Test
	public void guerreroAtaca() {
	    Guerrero defensor = new Guerrero("Defensor", 100);

	    guerrero.setAtaque(20);
	    defensor.setDefensa(5);

	    guerrero.atacar(defensor);

	    int vidaEsperada = 100 - (20 - 5);
	    assertEquals(vidaEsperada, defensor.getVida());
	}

	@Test
	public void guerreroNoAtaca() {
	    Guerrero defensor = new Guerrero("Defensor", 100);

	    guerrero.setAtaque(5);
	    defensor.setDefensa(10);

	    guerrero.atacar(defensor);

	    assertEquals(100, defensor.getVida()); 
	}


	@Test
	public void curarConPociones() {
	    guerrero.curar();            

	    assertEquals(100, guerrero.getVida());
	    assertEquals(2, guerrero.getPociones());
	}
	
	@Test
	public void curarSinPociones() {
	    guerrero.setPociones(0);     

	    guerrero.curar();         

	    assertEquals(50, guerrero.getVida());       
	    assertEquals(0, guerrero.getPociones());    
	}

	@Test
	public void morir() {
		guerrero.setVida(0);
		assertEquals(guerrero.muerto(), true);
	}
	
}
