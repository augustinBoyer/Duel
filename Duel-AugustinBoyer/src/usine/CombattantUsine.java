package usine;

import java.util.ArrayList;

import Combattant.*;
import capacite.Capacite;
import gestionException.*;

public abstract class CombattantUsine {

	public static Combattant CreerCombattant(Caracteristique caracteristique, ArrayList<Capacite> capacites,
			TypeCombattant type)
			throws ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionCombattantNull {
		if (type == TypeCombattant.ELFE) {
			return new Elfe(caracteristique, capacites);
		} else if (type == TypeCombattant.GUERRIER) {
			return new Guerrier(caracteristique, capacites);
		} else {
			return new Magicien(caracteristique, capacites);
		}
	}
}
