package dam.a.ej2.pojos;

import java.util.Arrays;

/**
 * 
 * @author Jorge Re González
 *
 */
public class InvalidCiudadException extends Exception {
	public InvalidCiudadException() {
		super("La ciudad tiene que ser una de las siguientes:\n" + Arrays.toString(Perfil.CIUDADES));
	}
}
