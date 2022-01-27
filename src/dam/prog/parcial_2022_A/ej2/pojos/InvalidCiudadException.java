package dam.prog.parcial_2022_A.ej2.pojos;

import java.util.Arrays;

/**
 * 
 * @author Jorge Re Gonz�lez
 *
 */
public class InvalidCiudadException extends Exception {
	public InvalidCiudadException() {
		super("La ciudad tiene que ser una de las siguientes:\n" + Arrays.toString(Perfil.CIUDADES));
	}
}
