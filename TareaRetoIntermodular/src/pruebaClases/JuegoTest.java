package pruebaClases;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import clases.Juego;

public class JuegoTest {
	
	static Juego juego;

	@Test
    public void testEnemigoAleatorio() {
        String enemigo = Juego.enemigoAleatorio();

       
        assertTrue(Arrays.asList(Juego.getSiguienteEnemigo()).contains(enemigo));
        
    }
	
	
	
	
	
}
