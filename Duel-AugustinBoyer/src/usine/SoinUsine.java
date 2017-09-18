package usine;

import capacite.*;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public abstract class SoinUsine {

	public static Soin CreerCapacite(int nombre) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return new Soin(TypeCapacite.SOIN, nombre);
	}
}
