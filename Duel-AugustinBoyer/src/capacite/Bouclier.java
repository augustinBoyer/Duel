package capacite;

import Combattant.Combattant;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public class Bouclier extends DefenseClasse implements Riposter {

	private int protection;

	public Bouclier(TypeCapacite typeCapacite, int caracteristique)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		super(typeCapacite);
		this.verificationValiditeCaracteristiques(caracteristique);

		this.setProtection(caracteristique);
	}

	private void setProtection(int protection) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		this.verificationValiditeCaracteristiques(protection);
		this.protection = protection;
	}
	
	public int getProtection() {
		return this.protection;
	}

	public int obtenirPuissancePotentielle(Combattant combattant) {
		return this.calculateurPuissanceCapacite(this.getProtection(), combattant.getForce());
	}
}
