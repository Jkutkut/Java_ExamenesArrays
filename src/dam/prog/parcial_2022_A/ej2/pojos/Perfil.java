package dam.a.ej2.pojos;

/**
 * 
 * @author Jorge Re González
 *
 */
public class Perfil {

	public static final String[] CIUDADES = {
		"Madrid",
		"Barcelona",
		"Málaga",
		"Valladolid"
	};
	public static final int STRING_MAX_LEN = 45;
	public static final int MIN_CONTACTOS = 0;
	public static final int MAX_CONTACTOS = 100000;
	
	private String nombre;
	private String puesto;
	private int ciudad;
	private int contactos;
	
	public Perfil(String nombre, String puesto, String ciudad, int contactos)
			throws InvalidContactosException, NullPointerException, InvalidStringLengthException, InvalidCiudadException {
		this.setNombre(nombre);
		this.setPuesto(puesto);
		this.setCiudad(ciudad);
		this.setContactos(contactos);
	}

	private static boolean isValidString(String str) {
		return str.length() <= STRING_MAX_LEN;
	}

	private void setNombre(String nombre) throws NullPointerException, InvalidStringLengthException {
		if (nombre == null) {
			throw new NullPointerException("El atributo nombre tiene que ser un string no nulo");
		}
		if (!isValidString(nombre)) {
			throw new InvalidStringLengthException("nombre");
		}
		this.nombre = nombre;
	}

	private void setPuesto(String puesto) throws NullPointerException, InvalidStringLengthException {
		if (puesto == null) {
			throw new NullPointerException("El atributo nombre tiene que ser un string no nulo");
		}
		if (!isValidString(puesto)) {
			throw new InvalidStringLengthException("puesto");
		}
		this.puesto = puesto;
	}

	public static boolean isValidCiudad(String ciudad) {
		for (int i = 0; i < CIUDADES.length; i++) {
			if (CIUDADES[i].equalsIgnoreCase(ciudad)) {
				return true;
			}
		}
		return false;
	}
	
	private void setCiudad(String ciudad) throws InvalidCiudadException {
		for (int i = 0; i < CIUDADES.length; i++) {
			if (CIUDADES[i].equalsIgnoreCase(ciudad)) {
				this.ciudad = i;
				return ;
			}
		}
		throw new InvalidCiudadException();
	}

	
	private static boolean isValidContactos(int contactos) {
		return contactos >= MIN_CONTACTOS && contactos <= MAX_CONTACTOS;
	}
	
	private void setContactos(int contactos) throws InvalidContactosException {
		if (!isValidContactos(contactos)) {
			throw new InvalidContactosException();
		}
		this.contactos = contactos;
	}
	
	public int getContactos() {
		return contactos;
	}
	
	public String toString() {
		return String.format(
			"Perfil:\n - Nombre: %s\n - Puesto actual: %s\n - Ciudad: %s\n - %d contactos\n",
			nombre, puesto, CIUDADES[ciudad], contactos
		);
	}
}
