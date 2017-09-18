package gestionException;

public class ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect extends Exception {

	private static final long serialVersionUID = 818246692798881056L;

	public ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect()
	{
		new Exception("La somme des caractéristique de la capacité est inférieure à 20 ou supérieure à 100");
	}
}
