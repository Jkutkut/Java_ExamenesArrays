package dam.prog.parcialA.ej2.main;

import java.util.Scanner;

import dam.prog.parcialA.ej2.pojo.Lugar;

/**
 * Un alumno de la UEM quiere almacenar lugares de Europa que visitar antes de los 40. 
 * Se debe crear un programa que:
 * <li>solicite la cantidad de lugares que se van a almacenar
 * para cada lugar solicite la siguiente información:
 * ciudad (por ej: Ibiza),  país (por ej: España), prioridad (del 1 al 10), motivo (por ej: Decantarse entre lo David Guettero y el hipismo del Siglo XXI, por no hablar de sus espectaculares calas y originales mercadillos)
 * <li> muestre los lugares almacenados en el array
 * <li> indique cuál es el lugar de España con mayor prioridad.
 * <br>
 * Comprobación de datos con excepciones, crear las que se necesiten:
 * <li> la cantidad debe ser un entero positivo  
 * <li> el motivo no tenga más de 150 caracteres.
 * <li> la prioridad debe ser un valor entero entre 1 y 10.
 * <br>
 * No olvidar:
 * <li> Nombrar a los elementos (clases, métodos, variables, constantes...) correctamente.
 * <li> No crear variables dentro de bucles.
 * <li> Cerrar el Scanner.
 * <li> Entregar el código sin errores y si puede ser sin warnings (Salvo en las excepciones propias).
 * <li> Probar el programa para comprobar que funciona.
 * <br>
 * @author "Jkutkut -- Jorge Re"
 *
 */
public class MainLugares {
	
	private static Scanner sc;
	
	private static final String PAIS_SELECCIONADO = "España";
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int n = getNatural("Cantidad de lugares a almacenar: ");
		
		Lugar[] lugares = new Lugar[n];
		
		rellenaLugares(lugares);
		
		Lugar mejor = getMejorLugarDelPais(lugares, PAIS_SELECCIONADO);
		
		if (mejor != null) {
			System.out.println("El lugar con mayor prioridad es:");
			System.out.print(mejor);
		}
		else {
			System.out.println("No hay ningún lugar en " + PAIS_SELECCIONADO);
		}
		
		sc.close();
		
		try {
//			Lugar p = new Lugar("c", "p", 0, "hola");
//			Lugar p = new Lugar("c", "p", 1, "jfdskljflkasjflkñasjlfjaslñfj lajf lkañdsjfa jkdfñlaj ñfjas ñdjflka djflñas djfñlakj dñflja ñdlfj dklñjf añjdñl jafñdlsjf añldj flñsadkj flñasj dñlfaj ldkfjal dñjflñkadj lfñkajdlkfjad ñjfañl jflñaj dklfjañd jflkaj flña");
			Lugar p = new Lugar("c", "p", 2, "hola");
			System.out.println(p);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static Lugar getMejorLugarDelPais(Lugar[] lugares, String pais) {
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

	private static void rellenaLugares(Lugar[] lugares) {
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
