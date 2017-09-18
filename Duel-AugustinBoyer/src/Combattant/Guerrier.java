package Combattant;

import java.util.ArrayList;

import capacite.Capacite;
import gestionException.*;

public class Guerrier extends Combattant {
	
	private final static int CARACTERISTIQUE_GUERRIER = 10;
	
	public Guerrier(Caracteristique caracteristique, ArrayList<Capacite> capacites)
			throws ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionLorsqueCaracteristiquesIncorrectes {

		super(caracteristique, capacites);

		if (this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getForce(), caracteristique.getDexterite() + this.CARACTERISTIQUE_GUERRIER)
				|| this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getDexterite(), caracteristique.getIntelligence())
				|| this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getIntelligence() + this.CARACTERISTIQUE_GUERRIER, caracteristique.getConcentration())) {
			throw new ExceptionLorsqueCaracteristiquesIncorrectes("Les caractéristiques du guerrier sont incorrectes");
		}
	}
}
