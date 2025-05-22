package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Guerrero;

public class GuerreroTest {
	
	static Guerrero guerrero;
	
	@BeforeEach
	public void crearGuerrero() {
		guerrero = new Guerrero("Juan", 100);
	}
	
	@Test
	public void guerreroAtacaOtro() {
		Guerrero otro = new Guerrero("Otro", 100);
		int vida = otro.getVida() - 5;
		guerrero.atacar(otro);
		assertEquals(otro.getVida(), vida);
	}
	
	@Test
	public void muereGuerrero() {
		guerrero.setVida(0);
		assertEquals(guerrero.muerto(), true);
	}
	
	@Test
	public void resetearGuerrero() {
		guerrero.setPociones(2);
	}
	

	@Test
	public void curarGuerrero() {
	    guerrero.setVidaInicial(100);
	    guerrero.setVida(50);       
	    guerrero.setPociones(1);     
	    
	    guerrero.curar();            

	    assertEquals(100, guerrero.getVida());
	    assertEquals(0, guerrero.getPociones());
	}
	
	@Test
	public void morir() {
		guerrero.setVida(0);
		assertEquals(guerrero.muerto(), true);
	}
	
	
}
