package programa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import clases.*;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		Juego nuevoJuego = new Juego ();
		String seguir = "";
		int eleccion = 0;
		int mayorPuntuacion = 0;
		int puntuacion;
		File archivo = new File("MejorPuntuacion.txt");
		FileWriter fw;
		
		System.out.println("¡Bienvenido!");
		
		do {
		
		puntuacion = 0;
		System.out.print("¿Cuantas rondas te gustaria jugar?: ");
		int rondas = entrada.nextInt();
		entrada.nextLine();
		nuevoJuego.setnRondas(rondas);
		
		System.out.print("Muy bien, ahora introduce tu nombre: ");
		String nombre = entrada.nextLine();
		
		do {
			
			if (archivo.exists()) {
				try {
					Scanner lector = new Scanner(archivo);
					System.out.println("---Mejor puntuacion---");
					while (lector.hasNext()) {
						System.out.print(lector.next());
					}
					System.out.println();
					System.out.println("--------------------");
					lector.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
		System.out.print("¿Qué tipo sera tu personaje? \n"
				+ "1.Mago \n"
				+ "2.Guerrero \n"
				+ "Elige: ");
		eleccion = entrada.nextInt();
		entrada.nextLine();
		
		} while (eleccion != 1 && eleccion != 2);
		
		switch (eleccion) {
		case 1:
			
			Mago jugadorMago = (Mago) nuevoJuego.nuevoMago(nombre);
			
			Enemigo enemigoMago = new Enemigo ();
			nuevoJuego.iniciarJuego(enemigoMago);
			nuevoJuego.setRonda(1);
			
			while (!nuevoJuego.finalJuego()) {
		
				System.out.println("Ronda " + nuevoJuego.getRonda() + " / " + rondas);
				System.out.println("Tu enemigo es " + enemigoMago);
				System.out.println("Tu eres " + jugadorMago);
				System.out.print("¿Qué quieres hacer? \n"
						+ "1. Atacar \n"
						+ "2. Curar \n"
						+ "Tu eleccion: ");
				int accion = entrada.nextInt();
				entrada.nextLine();
				
				if (accion == 1) {
					System.out.println("=======================================");
					System.out.println(jugadorMago.getNombre() + " ataca ");
					jugadorMago.atacar(enemigoMago);
					System.out.println(enemigoMago.getNombre() + " ataca ");
					enemigoMago.atacar(jugadorMago);
					System.out.println("=======================================");
					
					if (nuevoJuego.terminarRonda()) {
						System.out.println("Enemigo derrotado, siguiente ronda...");
						enemigoMago.iniciarEnemigo(Juego.enemigoAleatorio());
						System.out.println("=======================================");
						nuevoJuego.setRonda(nuevoJuego.getRonda() + 1);
					}
					
					if (nuevoJuego.finalJuego()) {
						System.out.println("Fin de la partida, has ganado!!!");
						System.out.println("=======================================");
					} else if (jugadorMago.muerto()) {
						System.out.println("Fin de la partida, has perdido :(");
						System.out.println("=======================================");
						break;
					}
					
				} else if (accion == 2) {
					jugadorMago.curar();
					System.out.println(jugadorMago.getNombre() + " se ha curado! ");
				}
				
			}
			
			break;
		case 2:
			
			Guerrero jugadorGuerrero = (Guerrero) nuevoJuego.nuevoGuerrero(nombre);
			
			Enemigo enemigoGuerrero = new Enemigo ();
			nuevoJuego.iniciarJuego(enemigoGuerrero);
			nuevoJuego.setRonda(1);
			
			while (!nuevoJuego.finalJuego()) {
		
				System.out.println("Ronda " + nuevoJuego.getRonda() + " / " + rondas);
				System.out.println("Tu enemigo es " + enemigoGuerrero);
				System.out.println("Tu eres " + jugadorGuerrero);
				System.out.print("¿Qué quieres hacer? \n"
						+ "1. Atacar \n"
						+ "2. Curar \n"
						+ "Tu eleccion: ");
				int accion = entrada.nextInt();
				entrada.nextLine();
				
				if (accion == 1) {
					System.out.println("=======================================");
					System.out.println(jugadorGuerrero.getNombre() + " ataca ");
					jugadorGuerrero.atacar(enemigoGuerrero);
					System.out.println(enemigoGuerrero.getNombre() + " ataca ");
					enemigoGuerrero.atacar(jugadorGuerrero);
					System.out.println("=======================================");
					
					if (nuevoJuego.terminarRonda()) {
						System.out.println("Enemigo derrotado, siguiente ronda...");
						enemigoGuerrero.iniciarEnemigo(Juego.enemigoAleatorio());
						System.out.println("=======================================");
						nuevoJuego.setRonda(nuevoJuego.getRonda() + 1);
					}
					
					if (nuevoJuego.finalJuego()) {
						System.out.println("Fin de la partida, has ganado!!!");
						System.out.println("=======================================");
					} else if (jugadorGuerrero.muerto()) {
						System.out.println("Fin de la partida, has perdido :(");
						System.out.println("=======================================");
						break;
					}
					
				} else if (accion == 2) {
					jugadorGuerrero.curar();
					System.out.println(jugadorGuerrero.getNombre() + " se ha curado! ");
				}
			}
			break;
		default:
			System.out.println("Elige una opcion correcta");
		}	
		
		try {
			puntuacion = nuevoJuego.getRonda() - 1;
			Scanner lector = new Scanner(archivo);
	
			lector.next();
			mayorPuntuacion = lector.nextInt();
			lector.close();
			
			if (mayorPuntuacion < puntuacion) {
				fw = new FileWriter(archivo);
				mayorPuntuacion = puntuacion;
				System.out.println("¡" + nombre + " ha conseguido una nueva mejor puntuacion!");
				fw.write(nombre + ": " + mayorPuntuacion);
				fw.close();
			} 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("¿Quieres volver a jugar? (S/N): ");
		seguir = entrada.nextLine().toUpperCase();
		
		} while (seguir.equals("S"));
		
		System.out.println("¡Gracias por jugar!");
		
		entrada.close();
		
	}

}
