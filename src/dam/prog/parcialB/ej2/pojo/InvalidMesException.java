package dam.prog.parcialB.ej2.pojo;

public class InvalidMesException extends NumberFormatException {
	public InvalidMesException(int mes) {
		super(
			String.format(
				"El mes %d no es un mes en el que puedan existir festivales.\n" +
				"Estos sólo pueden ser creados en los meses [%d, %d].",
				mes, Festival.MES_MIN, Festival.MES_MAX
			)
		);
	}
}
