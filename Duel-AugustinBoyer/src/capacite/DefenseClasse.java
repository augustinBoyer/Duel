package capacite;

import Combattant.Combattant;

public abstract class DefenseClasse extends Capacite implements Riposter {

	DefenseClasse(TypeCapacite typeCapacite) {
		super(typeCapacite);
	}

	@Override
	public int puissanceCombat(Combattant combattant) {
		return this.calculerPuissanceCombat(combattant);
	}
}
