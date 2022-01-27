package dam.a.ej2.pojos;

/**
 * 
 * @author Jorge Re González
 *
 */
public class InvalidContactosException extends NumberFormatException {
	public InvalidContactosException() {
		super(
			String.format(
					"El número de contactos tiene que ser un entero en el intervalo [%d, %d].",
					Perfil.MIN_CONTACTOS, Perfil.MAX_CONTACTOS
			)
		);
	}
}
