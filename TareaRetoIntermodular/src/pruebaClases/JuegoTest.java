package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Enemigo;
import clases.Guerrero;
import clases.Juego;
import clases.Mago;

public class JuegoTest {
	
	static Juego juego;
	
	@BeforeEach
	public void iniciarJuego() {
		juego = new Juego();
	}

	@Test
    public void testEnemigoAleatorio() {
        String enemigo = Juego.enemigoAleatorio();
        assertTrue(Arrays.asList(Juego.getSiguienteEnemigo()).contains(enemigo));
    }
	
	@Test
	public void iniciarEnemigo() {
		Enemigo enemigo = new Enemigo();
		juego.iniciarJuego(enemigo);
		enemigo.iniciarEnemigo(Juego.enemigoAleatorio());
		
		assertEquals(juego.getnRondas(), juego.getEnemigos().size());
	}
	
	@Test
	public void nuevoGuerrero() {
		Juego juego = new Juego();
		Guerrero guerrero = juego.nuevoGuerrero("Jaime");
		assertNotNull(guerrero);                                
		assertEquals("Jaime", guerrero.getNombre());          
		assertTrue(guerrero.getVida() > 100);                  
		assertTrue(guerrero.getVida() < 200);
	}
	
	@Test
	public void nuevoMago() {
		Juego juego = new Juego();
		Mago mago = juego.nuevoMago("Jaime");
		assertNotNull(mago);                                
		assertEquals("Jaime", mago.getNombre());          
		assertTrue(mago.getVida() > 50);                  
		assertTrue(mago.getVida() < 150);
	}
	
	@Test
	public void FinalJuego() {
		juego.getEnemigos().clear();
		assertEquals(juego.finalJuego(), true);
	}
	
	@Test
	public void noFinalJuego() {
		Enemigo enemigo = new Enemigo();
		juego.getEnemigos().add(enemigo);
		assertEquals(juego.finalJuego(), false);
	}
	
	@Test
	public void terminarRonda() {
		Enemigo enemigo = new Enemigo();
		enemigo.setVida(0);
		juego.getEnemigos().add(enemigo);
		
		assertEquals(juego.terminarRonda(), true);
	}
	
	@Test
	public void noTerminarRonda() {
		Enemigo enemigo = new Enemigo();
		enemigo.setVida(10);
		juego.getEnemigos().add(enemigo);
		
		assertEquals(juego.terminarRonda(), false);
	}
	
}
