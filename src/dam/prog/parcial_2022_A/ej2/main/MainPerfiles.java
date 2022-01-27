package dam.a.ej2.main;

import java.util.Scanner;

import dam.a.ej2.pojos.InvalidCiudadException;
import dam.a.ej2.pojos.Perfil;

/**
 * 
 * @author Jorge Re González
 *
 */
public class MainPerfiles {

	private static final int N_PERFILES = 10;
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		Perfil[] perfiles = new Perfil[N_PERFILES];
		solicitaPerfiles(perfiles);
		
		System.out.println("\n\nLos perfiles almacenados son:");
		printObjArr(perfiles);
		printMenosContactos(perfiles);
	}

	private static void printMenosContactos(Perfil[] perfiles) {
		if (perfiles == null || perfiles.length == 0) {
			System.out.println("No hay perfiles, por lo que no hay nada que buscar.");
			return ;
		}
		Perfil peor = perfiles[0];
		for (int i = 1; i < perfiles.length; i++) {
			if (peor.getContactos() > perfiles[i].getContactos()) {
				peor = perfiles[i];
			}
		}
		System.out.println("El perfil con menor número de contactos es:\n" + peor);
	}


	private static void solicitaPerfiles(Perfil[] perfiles) {
		if (perfiles == null || perfiles.length == 0) {
			return ;
		}
		String nombre, puesto, ciudad;
		int nContactos;
		
		for (int i = 0; i < perfiles.length; i++) {
			System.out.printf("Introduce los datos del %dº perfil:\n", i);
			nombre = getString(" - Nombre: ", 0, Perfil.STRING_MAX_LEN);
			puesto = getString(" - Puesto: ", 0, Perfil.STRING_MAX_LEN);
			ciudad = getCiudad(" - Ciudad: ");
			nContactos = getIntInRange(" - Contactos: ", Perfil.MIN_CONTACTOS, Perfil.MAX_CONTACTOS);
			
			try {
				perfiles[i] = new Perfil(nombre, puesto, ciudad, nContactos);
			}
			catch (Exception e) {
				System.out.println("Error inesperado:");
				System.out.println(e.getMessage());
				System.out.println("Inténtelo de nuevo");
				i--; // Para repetir esta iteración del bucle
			}
		}
	}
	
	private static void printObjArr(Perfil[] perfiles) {
		if (perfiles == null) {
			return ;
		}
		for (int i = 0; i < perfiles.length; i++) {
			System.out.println(perfiles[i]);
		}
	}


	// GETTERS
	public static String getCiudad(String question) {
		String ciudad;
		while (true) {
			try {
				ciudad = getString(question);
				if (!Perfil.isValidCiudad(ciudad)) {
					throw new InvalidCiudadException();
				}
				return ciudad;
			}
			catch (InvalidCiudadException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @param minLen - min length of String
	 * @param maxLen - max length of String
	 * @return Response given by the scanner meeting the criteria.
	 */
	public static String getString(String question, int minLen, int maxLen) {
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
	
	public static String getString(String question) {
		System.out.print(question);
		return sc.nextLine();
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
				System.out.println("El valor no es un número entero válido.\n");
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
				System.out.println("El número tiene que ser un natural -> [0, inf)\n");
			}
		}
		return n;
	}
	
	/**
	 * @param question - Question to show using System.out
	 * @param min - min value of the desired int
	 * @param max - max value of the desired int
	 * @return Integer inside the interval [min, max]
	 */
	public static int getIntInRange(String question, int min, int max) {
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
