package usine;

import Combattant.Caracteristique;
import gestionException.*;

public class CaracteristiqueUsine {

	public static Caracteristique CreerCaracteristique(String nom, int force, int dexterite, int intelligence,
			int concentration) throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide {
		return new Caracteristique(nom, force, dexterite, intelligence, concentration);
	}
}
