package gestionException;

public class ExceptionLorsqueCapaciteInferieureADeuxOuNull extends Exception {

	private static final long serialVersionUID = 4220536858302284382L;

	public ExceptionLorsqueCapaciteInferieureADeuxOuNull()
	{
		new Exception("La somme des caract�ristique de la capacit� est inf�rieure � 20 ou sup�rieure � 100");
	}
}
