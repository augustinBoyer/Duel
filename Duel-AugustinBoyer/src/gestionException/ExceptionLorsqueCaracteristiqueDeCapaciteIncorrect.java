package gestionException;

public class ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect extends Exception {

	private static final long serialVersionUID = 818246692798881056L;

	public ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect()
	{
		new Exception("La somme des caract�ristique de la capacit� est inf�rieure � 20 ou sup�rieure � 100");
	}
}
