package dam.prog.parcialA.ej2.pojo;

public class Lugar {
	
	public static final int MOTIVO_MAX_LEN = 150;
	public static final int PRIORIDAD_MIN = 1;
	public static final int PRIORIDAD_MAX = 10;
	
	private String ciudad;
	private String pais;
	private int prioridad;
	private String motivo;
	
	public Lugar(String ciudad, String pais, int prioridad, String motivo) throws Exception {
		this.ciudad = ciudad;
		this.pais = pais;
		
		// Estos métodos son privados ya que los requisitos no habilitan la edición en este momento.
		setPrioridad(prioridad);
		setMotivo(motivo);
	}
	
	// GETTERS
	public static boolean motivoIsValid(String motivo) {
		return motivo.length() < MOTIVO_MAX_LEN;
	}
	
	public boolean prioridadIsValid(int prioridad) {
		return prioridad >= PRIORIDAD_MIN && prioridad <= PRIORIDAD_MAX;
	}
	
//	public String getCiudad() {
//		return ciudad;
//	}
	
	public String getPais() {
		return pais;
	}
	
	public int getPrioridad() {
		return prioridad;
	}
	
//	public String getMotivo() {
//		return motivo;
//	}


	// SETTERS
	private void setMotivo(String motivo) throws Exception {
		if (!Lugar.motivoIsValid(motivo)) {
			throw new Exception("El motivo no puede tener más de " + MOTIVO_MAX_LEN + " caracteres.");
		}
		this.motivo = motivo;
	}
	
	private void setPrioridad(int prioridad) throws Exception {
		if (!prioridadIsValid(prioridad)) {
			throw new Exception(
				String.format(
					"La prioridad tiene que estar en el intervalo [%d, %d]",
					PRIORIDAD_MIN, PRIORIDAD_MAX
				)
			);
		}
		this.prioridad = prioridad;
	}
	
	public String toString() {
		return String.format(
			"\n---------\nLugar %s:\n - País: %s\n - Prioridad: %d\n - Motivo:\n%s\n---------\n",
			ciudad, pais, prioridad, motivo
		);
	}
	
}
