package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Mago;

public class MagoTest {
	
	static Mago mago;
	
	@BeforeEach
	public void crearMago() {
		mago = new Mago("Jaime", 50);
		mago.setVidaInicial(100);
		mago.setMagia(2);
	}
	
	@Test
	public void magoAtacaOtro() {
		  Mago defensor = new Mago("Defensor", 100);

		  mago.setAtaque(20);
		  defensor.setDefensa(5);

		  mago.atacar(defensor);

		  int vidaEsperada = 100 - (20 - 5);
		  assertEquals(vidaEsperada, defensor.getVida());
		  assertEquals(mago.getMagia(), 1);
		  mago.atacar(defensor);
		  mago.atacar(defensor);
		  assertEquals(mago.getAtaque(), 5);
		  
	}
	
	@Test
	public void magoNoAtaca() {
	    Mago defensor = new Mago("Defensor", 100);

	    mago.setAtaque(5);
	    defensor.setDefensa(10);

	    mago.atacar(defensor);

	    assertEquals(100, defensor.getVida()); 
	    
	}
	
	@Test
	public void magoMuere() {
		mago.setVida(0);
		assertEquals(mago.muerto(), true);
	}
	
	@Test
	public void magoNoMuere() {
		assertEquals(mago.muerto(), false);
	}
	
	@Test
	public void resetearMago() {
		mago.setMagia(10);
	}
	
	@Test
	public void curarMago() {
	    mago.curar();
	    assertEquals(mago.getVida(), 70);
	    mago.setVida(110);
		mago.curar();
		assertEquals(mago.getVida(), 110);
	}

	@Test
	public void magoNoCuraMagia() {
		mago.setMagia(0);
		mago.curar();
		assertEquals(mago.getVida(), 50);
	}
	
	@Test
	public void resetear() {
		mago.setMagia(1);
		mago.resetear();
		assertEquals(10, mago.getMagia());
	}
	
}
