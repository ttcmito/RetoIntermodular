package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clases.Personaje;

public class PersonajeTest {

	static Personaje personaje;
	
	@BeforeAll
	static void iniciarPersonaje() {
	personaje = new Personaje (120, 5, 2, "Heroe") {
	};
	
	}
	
	@Test 
	void iniciarJugador() {
		assertEquals("Heroe", personaje.getNombre());
		assertEquals(120, personaje.getVida());
		assertEquals(5, personaje.getAtaque());
		assertEquals(2, personaje.getDefensa());
	}
	
	@Test 
	void atacar() {
		Personaje enemigo = new Personaje(50, 4, 3, "Ulf") {	
		};
		
		Personaje jugador = new Personaje(100, 5, 4, "Mr") {
			
		};
		
		int vidaInicial = enemigo.getVida();
		jugador.atacar(enemigo);
		
		assertEquals(vidaInicial - 2, enemigo.getVida());
		
	}
	
	@BeforeEach
	void resetear() {
		personaje.setVidaInicial(120);
		personaje.setVida(120);
	}
	
	@Test 
	void muerto() {
		assertFalse(personaje.muerto());
		assertTrue(personaje.muerto());
	}
	
	
	
}
