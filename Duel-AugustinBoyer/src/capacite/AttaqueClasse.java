package capacite;

import Combattant.Combattant;

public abstract class AttaqueClasse extends Capacite implements Riposter {

	protected AttaqueClasse(TypeCapacite typeCapacite) {
		super(typeCapacite);
	}

	@Override
	public int puissanceCombat(Combattant combattant) {
		return this.calculerPuissanceCombat(combattant);
	}
}
