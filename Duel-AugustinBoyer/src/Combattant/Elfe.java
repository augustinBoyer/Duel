package Combattant;

import capacite.Capacite;
import gestionException.*;

import java.util.ArrayList;

public class Elfe extends Combattant {

	private final static int CARACTERISTIQUE_MINIMALE = 20;

	public Elfe(Caracteristique caracteristique, ArrayList<Capacite> capacites)
			throws ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionLorsqueCaracteristiquesIncorrectes {

		super(caracteristique, capacites);

		if (this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getForce(), CARACTERISTIQUE_MINIMALE)
				|| this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getDexterite(), CARACTERISTIQUE_MINIMALE)
				|| this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getConcentration(), CARACTERISTIQUE_MINIMALE)
				|| this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getIntelligence(), CARACTERISTIQUE_MINIMALE)) {
			throw new ExceptionLorsqueCaracteristiquesIncorrectes("Une des caractéristiques de l'elfe est inférieure à "
					+ this.CARACTERISTIQUE_MINIMALE);
		}

	}
}
