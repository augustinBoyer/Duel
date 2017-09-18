package Combattant;

import java.util.ArrayList;

import capacite.Capacite;
import gestionException.*;

public class Magicien extends Combattant {
	public Magicien(Caracteristique caracteristique, ArrayList<Capacite> capacites)
			throws ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionLorsqueCaracteristiquesIncorrectes {

		super(caracteristique, capacites);

		if (this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getIntelligence(), Math.max(caracteristique.getDexterite(), caracteristique.getForce())
				+ 15)
				|| this.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique.getConcentration(),
						Math.max(caracteristique.getDexterite(), caracteristique.getForce())
								+ 15)) {
			throw new ExceptionLorsqueCaracteristiquesIncorrectes("Les caractéristiques du magicien sont incorrectes");
		}
	}

}
