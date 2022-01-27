package dam.prog.parcial_2022_A.ej2.pojos;

/**
 * 
 * @author Jorge Re Gonz�lez
 *
 */
public class InvalidContactosException extends NumberFormatException {
	public InvalidContactosException() {
		super(
			String.format(
					"El n�mero de contactos tiene que ser un entero en el intervalo [%d, %d].",
					Perfil.MIN_CONTACTOS, Perfil.MAX_CONTACTOS
			)
		);
	}
}
