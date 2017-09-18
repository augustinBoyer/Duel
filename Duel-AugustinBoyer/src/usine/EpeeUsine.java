package usine;

import capacite.*;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public abstract class EpeeUsine {

	public static Epee CreerCapacite(int nombre) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return new Epee(TypeCapacite.EPEE, nombre);
	}
}
