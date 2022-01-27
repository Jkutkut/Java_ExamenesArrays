package dam.prog.parcialB.ej2.pojo;

public class Festival {
	
	public static final int CARTEL_MAX_LEN = 30;
	public static final int MES_MIN = 1;
	public static final int MES_MAX = 12;

	private String nombre;
	private String ciudad;
	private int mes;
	private String cartel;
	
	public Festival(String nombre, String ciudad, int mes, String cartel)
			throws InvalidCartelException, InvalidMesException {
		this.nombre = nombre;
		this.ciudad = ciudad;
		
		// Estos métodos son privados ya que los requisitos no habilitan la edición en este momento.
		setMes(mes);
		setCartel(cartel);
	}
	
	// GETTERS
	public static boolean cartelIsValid(String motivo) {
		return motivo.length() < CARTEL_MAX_LEN;
	}
	
	public boolean mesIsValid(int prioridad) {
		return prioridad >= MES_MIN && prioridad <= MES_MAX;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getMes() {
		return mes;
	}


	// SETTERS
	private void setCartel(String cartel) throws InvalidCartelException {
		if (!Festival.cartelIsValid(cartel)) {
			throw new InvalidCartelException(cartel);
		}
		this.cartel = cartel;
	}
	
	private void setMes(int mes) throws InvalidMesException {
		if (!mesIsValid(mes)) {
			throw new InvalidMesException(mes);
		}
		this.mes = mes;
	}
	
	public String toString() {
		return String.format(
			"\n---------\nFestival %s:\n - Ciudad: %s\n - mes: %d\n - cartel:\n%s\n---------\n",
			nombre, ciudad, mes, cartel
		);
	}
	
}
