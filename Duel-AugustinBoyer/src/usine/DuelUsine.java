package usine;

import Combattant.Combattant;
import duel.Duel;
import gestionException.ExceptionCombattantNull;

public class DuelUsine {

	public static Duel CreerCombat(Combattant combattantAttaque, Combattant combattantParade)
			throws ExceptionCombattantNull {
		return new Duel(combattantAttaque, combattantParade);
	}

}
