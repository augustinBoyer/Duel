package usine;

import capacite.*;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public abstract class SoinMagiqueUsine {

	public static SoinMagique CreerCapacite(int nombre) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return new SoinMagique(TypeCapacite.SOIN_MAGIQUE, nombre);
	}
}
