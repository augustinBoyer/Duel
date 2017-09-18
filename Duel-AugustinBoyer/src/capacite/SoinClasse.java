package capacite;

import Combattant.Combattant;

public abstract class SoinClasse extends Capacite {
	private int efficacite;
	
	public int getEfficacite() {
		return this.efficacite;
	}

	private void setEfficacite(int efficacite) {
		this.efficacite = efficacite;
	}
	
	protected SoinClasse(TypeCapacite typeCapacite, int caracteristique) {
		super(typeCapacite);
		this.setEfficacite(caracteristique);
	}
	
	public abstract int guerir(Combattant combattant);
}
