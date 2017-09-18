package usine;

import capacite.*;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public class AttaqueMagiqueUsine {

	public static AttaqueMagique CreerCapacite(int nombre) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return new AttaqueMagique(TypeCapacite.ATTAQUE_MAGIQUE, nombre);
	}
}
