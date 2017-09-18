package usine;

import capacite.Bouclier;
import capacite.TypeCapacite;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public class BouclierUsine {
	public static Bouclier CreerCapacite(int nombre) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return new Bouclier(TypeCapacite.BOUCLIER, nombre);
	}
}
