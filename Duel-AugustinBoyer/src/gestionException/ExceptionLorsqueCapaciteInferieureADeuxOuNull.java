package gestionException;

public class ExceptionLorsqueCapaciteInferieureADeuxOuNull extends Exception {

	private static final long serialVersionUID = 4220536858302284382L;

	public ExceptionLorsqueCapaciteInferieureADeuxOuNull()
	{
		new Exception("La somme des caractéristique de la capacité est inférieure à 20 ou supérieure à 100");
	}
}
