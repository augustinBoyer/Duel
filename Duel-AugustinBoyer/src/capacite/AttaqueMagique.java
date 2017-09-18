package capacite;

import Combattant.Combattant;
import gestionException.*;

public class AttaqueMagique extends AttaqueClasse {

	private int efficacite;

	public AttaqueMagique(TypeCapacite typeCapacite, int caracteristique)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		super(typeCapacite);
		this.verificationValiditeCaracteristiques(caracteristique);

		this.setEfficacite(caracteristique);
	}

	public int getEfficacite() {
		return this.efficacite;
	}

	private void setEfficacite(int efficacite) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		this.verificationValiditeCaracteristiques(efficacite);
		this.efficacite = efficacite;
	}

	public int obtenirPuissancePotentielle(Combattant combattant) {
		return this.calculateurPuissanceCapacite(this.getEfficacite(), combattant.getIntelligence()) 
				* this.PUISSANCE_MAGIE_MULTIPLIE;

	}
}
