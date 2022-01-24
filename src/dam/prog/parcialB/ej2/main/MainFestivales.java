package dam.prog.parcialB.ej2.main;

import java.util.Arrays;

import dam.prog.parcialB.ej2.scanner.SuperScanner;
import dam.prog.parcialB.ej2.pojo.Festival;
import dam.prog.parcialB.ej2.pojo.InvalidCartelException;
import dam.prog.parcialB.ej2.pojo.InvalidMesException;

/**
 * 2. Un alumno de la UEM quiere almacenar los festivales de música europeos a los que le gustaría asistir en el 2021.
 * <br>
 * Se debe crear un programa que:
 * <li>solicite la cantidad de festivales que se van a almacenar
 * <li>para cada festival solicite la siguiente información: 
 * nombre (por ej: Tomorrowland),
 * ciudad (por ej: Boom),
 * cartel (por ej: Martin Garrix, David Guetta, Dimitri Vegas & Like Mike, Marshmello, Amelie Lens, Adam Beyer,
 *  Eric Prydz, NERVO),
 * mes (del 1 al 12).
 * <br>
 * <li> muestre los festivales almacenados en el array
 * <li> indique cuántos festivales hay en los meses Julio y Agosto.
 * <br>
 * Comprobación de datos con excepciones:
 * <li> la cantidad debe ser un entero positivo
 * <li> el cartel no tenga menos de 30 caracteres.
 * <li> El mes debe ser un valor entero entre 1 y 12.
 * <br>
 * No olvidar:
 * <li> Nombrar a los elementos (clases, métodos, variables, constantes...) correctamente.
 * <li> No crear variables dentro de bucles.
 * <li> Cerrar el Scanner.
 * <li> Entregar el código sin errores y si puede ser sin warnings (Salvo en las excepciones propias).
 * <li> Probar el programa para comprobar que funciona.
 * 
 * @author "Jkutkut -- Jorge Re"
 *
 */
public class MainFestivales {
	
	private static SuperScanner sc;
	
	/**
	 * Meses que nos interesa recoger a la hora de realizar la búsqueda.
	 * Al usar un array, la selección de meses puede ser más compleja.
	 */
	private static final int[] MESES_SELECCIONADOS = {7, 8};
	
	public static void main(String[] args) {
		sc = new SuperScanner(System.in);
		
		Festival[] festivales = solicitaFestivales();
		
		mostrarFestivales(festivales);
		
		printFestivalesEnMeses(festivales, MESES_SELECCIONADOS);
		
		sc.close();
	}
	
	private static Festival[] solicitaFestivales() {
		String nombre, ciudad, cartel;
		int mes, i;
		
		int n = sc.getNatural("Cantidad de festivales a almacenar:");
		Festival[] festivales = new Festival[n];
		
		for (i = 0; i < festivales.length; i++) {
			System.out.println("Introduce los datos del " + (i + 1) + "º festival:");
			nombre = sc.getString("- Nombre: ");
			ciudad = sc.getString("- Ciudad: ");
			mes = sc.getIntInRange("- Número de mes: ", Festival.MES_MIN, Festival.MES_MAX);
			cartel = sc.getString("- Cartel:\n", 0, Festival.CARTEL_MAX_LEN);
			System.out.println("\n");
			
			try {
				festivales[i] = new Festival(nombre, ciudad, mes, cartel);
			}
			catch (InvalidCartelException | InvalidMesException e) {
				System.out.println(e.getMessage() + "\n");
				i--; // Para que repita esta iteración
			}
		}
		return festivales;
	}
	
	private static void mostrarFestivales(Festival[] festivales) {
		if (festivales.length == 0) {
			System.out.println("No hay festivales introducidos");
			return;
		}
		System.out.println("Los festivales almacenados son:");
		for (int i = 0; i < festivales.length; i++) {
			System.out.println(festivales[i]);
		}
		
	}

	private static void printFestivalesEnMeses(Festival[] festivales, int[] meses) {
		if (festivales.length == 0) {
			System.out.println("Puesto que no hay ningún festival, no se ha encontrado ninguno en los meses " +
								Arrays.toString(meses));
			return;
		}
		boolean found = false;
		System.out.println("Buscando festivales en los meses " + Arrays.toString(meses));
		for (int i = 0, j; i < meses.length; i++) { // Para que aparezcan ordenados por meses y luego por orden de entrada
			for (j = 0; j < festivales.length; j++) {
				if (festivales[j].getMes() == meses[i]) {
					System.out.println(festivales[j]);
					found = true;
				}
			}
		}
		if (!found) {
			System.out.println("No se ha encontrado ninguno.");
		}
		
	}

	
}
