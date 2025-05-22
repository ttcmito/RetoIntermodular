package pruebaClases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Enemigo;

public class EnemigoTest {

 static Enemigo enemigo;
 
 @BeforeEach
 public void crearenemigo () {
	 enemigo = new Enemigo();
	 enemigo.iniciarEnemigo("Lolo");
 }
// @Test
// public IniciarEnemigoComprobar() {
//	 assertEquals("Lolo" , enemigo.getNombre());
//	 
// }
}
