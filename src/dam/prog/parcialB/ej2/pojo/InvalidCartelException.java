package dam.prog.parcialB.ej2.pojo;

public class InvalidCartelException extends Exception {
	public InvalidCartelException(String cartel) {
		super(
			String.format(
				"El cartel no puede tener más de %d carácteres (introducido: %d)",
				Festival.CARTEL_MAX_LEN, cartel.length()
			)
		);
	}
}
