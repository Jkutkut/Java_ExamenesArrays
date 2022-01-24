package dam.prog.parcialB.ej2.main;

import java.util.Scanner;

import dam.prog.parcialA.ej2.pojo.Lugar;

/**
 * 
 * 
 * @author "Jkutkut -- Jorge Re"
 *
 */
public class MainFestivales {
	
	private static Scanner sc;
	
	private static final String PAIS_SELECCIONADO = "España";
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int n = getNatural("Cantidad de festivales a almacenar: ");
		
		Lugar[] festivales = new Lugar[n];
		
		rellenaFestivales(festivales);
		
		mostrarFestivales(festivales);
		
		Lugar mejor = getFestivalesEntreFiestas(festivales, PAIS_SELECCIONADO);
		
		if (mejor != null) {
			System.out.println("El lugar con mayor prioridad es:");
			System.out.print(mejor);
		}
		else {
			System.out.println("No hay ningún festival en " + PAIS_SELECCIONADO);
		}
		
		sc.close();
	}
	
	private static void mostrarFestivales(Lugar[] festivales) {
		if (festivales.length == 0) {
			System.out.println("No hay festivales introducidos");
			return;
		}
		
		System.out.println("Los festivales almacenados son:");
		for (int i = 0; i < festivales.length; i++) {
			System.out.println(festivales[i]);
		}
		
	}

	private static Lugar getFestivalesEntreFiestas(Lugar[] lugares, String pais) {
		int posMejorCiudad = -1;
		for (int i = 0; i < lugares.length; i++) {
			if (lugares[i].getPais().toLowerCase().equals(pais.toLowerCase())) {
				if (posMejorCiudad == -1 ||
					lugares[i].getPrioridad() > lugares[posMejorCiudad].getPrioridad()) {
					posMejorCiudad = i;
				}
			}
		}
		if (posMejorCiudad == -1) {
			return null;
		}
		return lugares[posMejorCiudad];
	}

	private static void rellenaFestivales(Lugar[] lugares) {
		String ciudad, pais, motivo;
		int prioridad, i;
		
		for (i = 0; i < lugares.length; i++) {
			System.out.println("Introduce los datos del " + (i + 1) + "º lugar:");
			ciudad = getString("- Ciudad: ");
			pais = getString("- País: ");
			prioridad = getIntInRange("- Prioridad: ", Lugar.PRIORIDAD_MIN, Lugar.PRIORIDAD_MAX);
			motivo = getString("- Motivo:\n", 0, Lugar.MOTIVO_MAX_LEN);
			System.out.println("\n");
			
			try {
				lugares[i] = new Lugar(ciudad, pais, prioridad, motivo);
			}
			catch (Exception e) {
				System.out.println(e.getMessage() + "\n");
				i--; // Para que repita esta iteración
			}
		}
	}
	
	private static String getString(String question, int minLen, int maxLen) {
		String str;
		while (true) {
			System.out.print(question);
			str = sc.nextLine();
			
			if (str.length() < minLen) {
				System.out.println("La longitud mínima es de " + minLen + " caracteres\n");
			}
			else if (str.length() > maxLen) {
				System.out.println("La longitud máxima es de " + maxLen + " caracteres.\n");
			}
			else {
				return str;
			}
		}
	}
	
	private static String getString(String question) {
		System.out.print(question);
		return sc.nextLine();
	}

	private static int getInt(String question) {
		while (true) {
			try {
				System.out.print(question);
				return Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("El valor no es un número entero válido.\n");
			}
		}
	}
	
	private static int getNatural(String question) {
		int n = 0;
		boolean isNotNatural = true;
		while (isNotNatural) {
			n = getInt(question);
			
			if (n >= 0) {
				isNotNatural = false;
			}
			else {
				System.out.println("El número tiene que ser un natural -> [0, inf)\n");
			}
		}
		return n;
	}
	
	private static int getIntInRange(String question, int min, int max) {
		if (min > max) {
			int swap = min;
			min = max;
			max = swap;
		}
		
		int n = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			n = getInt(question);
			
			if (n >= min && n <= max) {
				isNotValid = false;
			}
			else {
				System.out.printf(
					"El número tiene que ser un natural en el rango [%d, %d]\n\n",
					min, max
				);
			}
		}
		return n;
	}
	
}
