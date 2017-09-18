package gestionException;

public class ExceptionCombattantNull extends RuntimeException {

	private static final long serialVersionUID = -875779394519738296L;

	public ExceptionCombattantNull(String annonce) {
		new Exception(annonce);
	}

}
