package capacite;

import Combattant.Combattant;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;

public abstract class Capacite {
	protected final static int PUISSANCE_CAPACITE_DIVISE = 100;
	protected final static int PUISSANCE_MAGIE_MULTIPLIE = 3;
	protected final static int PUISSANCE_CAPACITE_INITIALE_MINIMALE = 20;
	protected final static int PUISSANCE_CAPACITE_INITIALE_MAXIMALE = 100;

	private TypeCapacite type;

	protected Capacite(TypeCapacite typeCapacite) {
		this.setTypeCapacite(typeCapacite);
	}

	public TypeCapacite getTypeCapacite() {
		return this.type;
	}

	protected void setTypeCapacite(TypeCapacite typeCapacite) {
		this.type = typeCapacite;
	}
	
	protected int calculerPuissanceCombat(Combattant combattant){
		int point = 0;
		if (combattant.possederCapacite(this)) {
			point = this.obtenirPuissancePotentielle(combattant);
		}
		return point;
	}

	protected void verificationValiditeCaracteristiques(int caracteristique)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		if (Combattant.verifierPremierNombreInferieurDeuxiemeNombre(caracteristique, this.PUISSANCE_CAPACITE_INITIALE_MINIMALE)
				|| Combattant.verifierPremierNombreInferieurDeuxiemeNombre(this.PUISSANCE_CAPACITE_INITIALE_MAXIMALE, caracteristique)) {
			throw new ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect();
		}
	}
	
	protected int calculateurPuissanceCapacite(int nombre, int nombre1){
		return nombre * nombre1 / this.PUISSANCE_CAPACITE_DIVISE;
	}

	protected abstract int obtenirPuissancePotentielle(Combattant combattant);
}
