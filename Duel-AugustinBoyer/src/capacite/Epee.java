package capacite;

import Combattant.Combattant;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public class Epee extends AttaqueClasse implements Riposter {

	private int impact;

	public Epee(TypeCapacite typeCapacite, int caracteristique)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		super(typeCapacite);

		this.setImpact(caracteristique);
	}

	private void setImpact(int impact) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		this.verificationValiditeCaracteristiques(impact);
		this.impact = impact;
	}
	
	public int getImpact() {
		return this.impact;
	}

	public int obtenirPuissancePotentielle(Combattant combattant) {
		return this.calculateurPuissanceCapacite(this.getImpact(), combattant.getForce());
	}
}
