package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Mago;

public class MagoTest {
	
	static Mago mago;
	
	@BeforeEach
	public void crearMago() {
		mago = new Mago("Jaime", 100);
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
	public void morir() {
		mago.setVida(0);
		assertEquals(mago.muerto(), true);
	}
	
	@Test
	public void resetearMago() {
		mago.setMagia(10);
	}
	
	@Test
	public void curarMago() {
	    mago.setVidaInicial(100);
	    mago.setVida(50);       
	    mago.setMagia(1);    
	    
	    mago.curar();            

	    assertEquals(70, mago.getVida());
	    assertEquals(0, mago.getMagia());
	}

//
//    @Test
//    public void testCurarConMagiaYNoExcedeVidaInicial() {
//    	mago.setVida(80); // +20 no excede 100
//    	mago.curar();
//        assertEquals(100, mago.getVida());
//        assertEquals(2, mago.getMagia());
//    }
//
//    @Test
//    public void testCurarConMagiaYExcedeVidaInicial() {
//    	mago.setVida(95); // +20 excede 100
//    	mago.curar();
//        assertEquals(100, mago.getVida());
//        assertEquals(2, mago.getMagia());
//    }
//
//    @Test
//    public void testCurarSinMagia() {
//    	mago.setMagia(0);
//    	mago.setVida(50);
//    	mago.curar();
//        assertEquals(50, mago.getVida());
//        assertEquals(0, mago.getMagia());
//    }
	
}
