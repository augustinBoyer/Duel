package usine;

import capacite.DefenseMagique;
import capacite.TypeCapacite;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public abstract class DefenseMagiqueUsine {

	public static DefenseMagique CreerCapacite(int nombre) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return new DefenseMagique(TypeCapacite.DEFENSE_MAGIQUE, nombre);
	}
}
