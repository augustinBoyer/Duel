package gestionException;

public class ExceptionNomVide extends ExceptionCombattantNull {

	private static final long serialVersionUID = -8595077716734781720L;

	public ExceptionNomVide() {
		super("Le nom ne peut pas être vide");
	}
}
