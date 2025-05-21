package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Guerrero;
import clases.Mago;

public class PruebaClases {
	
	static Guerrero guerrero;
	static Mago mago;
	
	@BeforeEach
	public void crearGuerrero() {
		guerrero = new Guerrero("Juan", 100);
	}
	
	@BeforeEach
	public void crearMago() {
		mago = new Mago("Jaime", 100);
	}
	
	@Test
	public void guerreroAtacaOtro() {
		Guerrero otro = new Guerrero("Otro", 100);
		int vida = otro.getVida() - 5;
		guerrero.atacar(otro);
		assertEquals(otro.getVida(), vida);
	}
	
	@Test
	public void magoAtacaOtro() {
		Mago otro = new Mago("Otro", 100);
		int vida = otro.getVida();
		System.out.println(vida);
		mago.atacar(otro);
		System.out.println(otro.getVida());
		assertEquals(otro.getVida(), vida);
	}
	
	@Test
	public void curar() {
		guerrero.setVida(guerrero.getVidaInicial());
		assertEquals(guerrero.getVidaInicial(), guerrero.getVida());
	}
	
	@Test
	public void testCurarConPociones() {
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
	
	@Test
	public void resetearGuerrero() {
		guerrero.setPociones(2);
	}
	
	@Test
	public void resetearMago() {
		mago.setMagia(10);
	}
	
	
	
}
