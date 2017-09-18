package capacite;

import Combattant.Combattant;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public class Soin extends SoinClasse {

	public Soin(TypeCapacite typeCapacite, int caracteristique)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		super(typeCapacite, caracteristique);
		this.verificationValiditeCaracteristiques(caracteristique);
	}

	@Override
	public int guerir(Combattant combattant) {
		int point = 0;
		if (combattant.possederCapacite(this)) {
			point = this.obtenirPuissancePotentielle(combattant);
		}
		return point;
	}

	public int obtenirPuissancePotentielle(Combattant combattant) {
		return this.calculateurPuissanceCapacite(this.getEfficacite(), combattant.getDexterite());
	}
}