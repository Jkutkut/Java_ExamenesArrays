package dam.prog.parcialA.ej1;

import java.util.Random;
import java.util.Scanner;

/**
 * Dada una matriz de dimensión n x m elementos numéricos de tipo entero, Desarrollar un programa que:
 * <li>Solicite las dimensiones por teclado.
 * <li>Rellene la matriz de manera aleatoria con valores que sean múltiplos de 3 y pares entre 3 y 180.
 * <li>Muestre la matriz por consola.
 * <li>Indique qué filas suman más de m*20
 * 
 * <br>
 * (Ejercicio de prueba parcial del curso 2021)
 * 
 * @author "Jkutkut -- Jorge Re"
 *
 */
public class Ejercicio {
	
	/**
	 * Cantidad de dígitos que tener en cuenta a la hora de representar la matriz
	 */
	private static final int DIGITS = 3;
	
	private static final int M_VECES = 20;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Número de filas (m) -> ");
		int m = Integer.parseInt(sc.nextLine());
		System.out.print("Número de columnas (n) -> ");
		int n = Integer.parseInt(sc.nextLine());
		sc.close();
		
		int[][] matriz = new int[m][n];
		
		randomFill(matriz);

		System.out.println("Matriz:");
		System.out.println(prettyPrint(matriz));
		
		System.out.println(
				"Las filas de la matriz que suman más de m * " + M_VECES +
				" (" + m + " * 20 = " + (m * M_VECES) + ") son:"
		);
		printFilasSuma(matriz, M_VECES * m);
	}

	/**
	 * Rellena la matriz dada con valores entre 3 y 180, siendo estos valores pares y múltiplos de 3.
	 * <br>
	 * Por esta razón, al ser pares y múltiplos de 3 => son múltiplos de 6
	 * <br>
	 * De esta manera, son números de la forma i * 6,, i pertenece al intervalo [1, 30]
	 * @param matriz - Matriz con el 
	 */
	private static void randomFill(int[][] matriz) {
		Random r = new Random();
		
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (r.nextInt(30) + 1) * 6;
			}
		}
	}
	

	public static void printFilasSuma(int arr[][], int threshold) {
		int i, j, sumaFila;
		
		for (i = 0; i < arr.length; i++) {
			sumaFila = 0;
			for (j = 0; j < arr[i].length; j++) {
				sumaFila += arr[i][j];
			}
			if (sumaFila > threshold) {
				System.out.println("  - Fila " + i + ": " + sumaFila);
			}
		}
	}
	
	public static String prettyPrint(int arr[][]) {
		String str = "";
		for (int i = 0, j; i < arr.length; i++) {
			str += "  { ";
			if (arr[i].length > 0) {
				str += String.format("%" + DIGITS + "d", arr[i][0]);
				for (j = 1; j < arr[i].length; j++) {
					str += ", " + String.format("%" + DIGITS + "d", arr[i][j]);
				}
			}
			str += " }\n";
		}
		str += "}";
		return str;
	}
}
