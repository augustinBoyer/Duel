package infirmerie;

import Combattant.*;
import capacite.*;
import gestionException.ExceptionCombattantNull;

public class Infirmerie {

	public static void Soigner(Combattant combattant) {

		if (combattant == null) {
			throw new ExceptionCombattantNull("Le combattant ne peut être null");
		}
		combattant.setPointsDeVie(combattant.getPointsDeVie() + chercherSoin(combattant));
	}

	private static int chercherSoin(Combattant combattant) {
		int point = 0;
		for (Capacite capacite : combattant.getCapacites()) {
			if (capacite instanceof SoinClasse) {
				point = utiliserSoin(combattant, (SoinClasse) capacite);
				break;
			}
		}
		return point;
	}

	private static int utiliserSoin(Combattant combattant, SoinClasse capacite) {
		int point = ((SoinClasse) capacite).guerir(combattant);
		combattant.supprimerCapacite(capacite);
		return point;
	}
}
