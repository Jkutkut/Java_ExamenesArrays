package dam.prog.parcial_2022_B.ej1;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Jorge Re Gonz�lez
 *
 */
public class Ejercicio1 {
	
	private static Scanner sc;

	public static final int MAX = 100;
	
	/**
	 * N�mero de d�gitos a reservar para cada elemento de la matriz a la hora de la representaci�n
	 */
	public static final int DIGITS = 3;
	
	private static final int SUPERIOR = 0;
	private static final int INFERIOR = 1;
	
	/**
	 * 
	 * La lógica de este ejercicio está modificada. En el ejercicio original, el tamaño de la matriz
	 * estaba basado en un número aleatorio y esta era rellenada con los valores del usuario.
	 * <br>
	 * Para crear y rellenar la lógica, se ha usado la del parcial 2022_A.ej1
	 * 
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int n = getNatural("Introduce el valor de n: ");
		
		int[][] matriz = new int[n][n];
		
		randomFill(matriz);
		
		System.out.println(prettyPrint(matriz));
		
		printSumTria(matriz);
		
		sc.close();
	}
	
	/**
	 * Muestra qu� tri�ngulo (formado por la diagonal inversa) tiene suma mayor
	 * @param matriz - Matriz cuadrada a usar
	 */
	private static void printSumTria(int[][] matriz) {
		int[] sumas = {0, 0};
		
		System.out.println("Calculando la suma de los tri�ngulos de la matriz...");
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = i + 1; j < matriz[i].length; j++) {
				sumas[SUPERIOR] += matriz[i][j];
				sumas[INFERIOR] += matriz[matriz.length - 1 - i][matriz[i].length - 1 - j];
			}
		}
		
		System.out.printf("- Tri�ngulo superior: %d\n- Tri�ngulo inferior: %d\n", sumas[SUPERIOR], sumas[INFERIOR]);
		
		System.out.print("Por tanto, ");
		if (sumas[SUPERIOR] == sumas[INFERIOR]) {
			System.out.println("los dos tri�ngulos son iguales");
		}
		else {
			System.out.printf(
				"el tri�ngulo con mayor suma es el %s\n",
				(sumas[SUPERIOR] > sumas[INFERIOR])? "superior" : "inferior"
			);
		}
	}

	private static void randomFill(int[][] matriz) {
		Random rng = new Random();
		int r;
		
		for (int i = 0, j; i < matriz.length; i++) {
			for (j = 0; j < matriz[i].length; j++) {
				do {
					r = rng.nextInt(MAX) + 1;
				} while(r % 3 == 0);
				
				matriz[i][j] = r;
			}
		}
	}
	
	/**
	 * @param question - Question to show using System.out.print
	 * @return Integer given by Scanner
	 */
	public static int getInt(String question) {
		while (true) {
			try {
				System.out.print(question);
				return Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("El valor no es un n�mero entero v�lido.\n");
			}
		}
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @return Integer greater or equal to 0
	 */
	public static int getNatural(String question) {
		int n = 0;
		boolean isNotNatural = true;
		while (isNotNatural) {
			n = getInt(question);
			
			if (n >= 0) {
				isNotNatural = false;
			}
			else {
				System.out.println("El n�mero tiene que ser un natural -> [0, inf)\n");
			}
		}
		return n;
	}
	
	/**
	 * Genera un String representando la matriz dada como argumento
	 * @param arr -- matriz
	 * @return String representando la matriz (reservando DIGITS caracteres para representar cada n�mero).
	 */
	public static String prettyPrint(int arr[][]) {
		String str = "{\n";
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
