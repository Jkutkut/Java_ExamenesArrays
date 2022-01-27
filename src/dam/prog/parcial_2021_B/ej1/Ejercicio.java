package dam.prog.parcialB.ej1;

import java.util.Random;
import java.util.Scanner;

/**
 * Dada una matriz de dimensión n x m elementos numéricos de tipo entero, Desarrollar un programa que:
 * <li>Solicite las dimensiones por teclado.
 * <li>Rellene la matriz de manera aleatoria con valores que sean múltiplos de 5 e impares entre 5 y 200.
 * <li>Muestre la matriz por consola.
 * <li>Indique qué filas suman menos de n*25
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
	
	private static final int M_VECES = 25;
	
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
				"Las filas de la matriz que suman menos de n * " + M_VECES +
				" (" + n + " * " + M_VECES + " = " + (n * M_VECES) + ") son:"
		);
		printFilasSuma(matriz, M_VECES * m);
	}

	/**
	 * Rellena la matriz dada con valores entre 5 y 200, siendo estos valores impares y múltiplos de 5.
	 * <br>
	 * Para generar números múltiplos de 5 en el intervalo, es suficiente con calcular r aleatorio
	 * en el intervalo [1, 40] y multiplicarlo por 5.
	 * <br>
	 * De esta manera, basta con restar una unidad a todo valor par del intervalo [5, 200].
	 * <br>
	 * Este método garantiza que, si r se genera de manera aleatoriamente uniforme en el intervalo,
	 * los valores generados también.
	 * 
	 * @param matriz - Matriz a rellenar
	 */
	private static void randomFill(int[][] matriz) {
		Random r = new Random();
		
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = 0; j < matriz[i].length; j++) {
//				matriz[i][j] = (r.nextInt(40) + 1) * 5;
//				if (matriz[i][j] % 2 == 0) {
//					matriz[i][j] -= 5;
//				}
				matriz[i][j] = r.nextInt(20) * 10 + 5;
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
			if (sumaFila < threshold) {
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
