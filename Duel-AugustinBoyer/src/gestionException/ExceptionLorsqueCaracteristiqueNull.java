package gestionException;

public class ExceptionLorsqueCaracteristiqueNull extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionLorsqueCaracteristiqueNull() {
		new Exception("Les caracteristiques ne peuvent pas être null");
	}
}
