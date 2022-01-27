package dam.a.ej2.pojos;

/**
 * 
 * @author Jorge Re González
 *
 */
public class InvalidStringLengthException extends Exception {
	public InvalidStringLengthException(String strName) {
		super(
			String.format(
				"El atributo %s no puede tener más de %d caracteres.",
				strName, Perfil.STRING_MAX_LEN
			)
		);
	}
}
