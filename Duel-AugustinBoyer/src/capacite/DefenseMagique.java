package capacite;

import Combattant.Combattant;
import gestionException.*;

public class DefenseMagique extends DefenseClasse {

	private int efficacite;

	public DefenseMagique(TypeCapacite typeCapacite, int caracteristique)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		super(typeCapacite);
		this.verificationValiditeCaracteristiques(caracteristique);

		this.setEfficacite(caracteristique);
	}

	private void setEfficacite(int efficacite) throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		this.verificationValiditeCaracteristiques(efficacite);
		this.efficacite = efficacite;
	}
	
	public int getEfficacite() {
		return this.efficacite;
	}

	public int obtenirPuissancePotentielle(Combattant combattant) {
		return  this.calculateurPuissanceCapacite(this.getEfficacite(), combattant.getIntelligence()) 
				* this.PUISSANCE_MAGIE_MULTIPLIE;
	}
}
