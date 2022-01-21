package dam.prog.parcialB.ej2.pojo;

public class Festival {
	
	public static final int CARTEL_MAX_LEN = 30;
	public static final int MES_MIN = 1;
	public static final int MES_MAX = 10;

	private String nombre;
	private String ciudad;
	private int mes;
	private String cartel;
	
	public Festival(String nombre, String ciudad, int mes, String cartel) throws Exception {
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
	
	public String getPais() {
		return nombre;
	}
	
	public int getMes() {
		return mes;
	}


	// SETTERS
	private void setCartel(String cartel) throws Exception {
		if (!Festival.cartelIsValid(cartel)) {
			throw new Exception("El cartel no puede tener más de " + CARTEL_MAX_LEN + " caracteres.");
		}
		this.cartel = cartel;
	}
	
	private void setMes(int mes) throws Exception {
		if (!mesIsValid(mes)) {
			throw new Exception(
				String.format(
					"El mes tiene que estar en el intervalo [%d, %d]",
					MES_MIN, MES_MAX
				)
			);
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
