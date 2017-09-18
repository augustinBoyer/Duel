package capacite;

import java.util.ArrayList;

import Combattant.Combattant;

public class ChoixMeilleurBonusPourLeVainqueur {

	private Combattant combattant;

	public ChoixMeilleurBonusPourLeVainqueur(Combattant combattant) {
		this.setCombattant(combattant);
	}

	private Combattant getCombattant() {
		return this.combattant;
	}

	private void setCombattant(Combattant combattant) {
		this.combattant = combattant;
	}

	public Capacite choisirLeMeilleurBonusPourLeVainqueur(ArrayList<Capacite> bonus) {

		Capacite capacite = bonus.get(0);

		for (int i = 0; i < bonus.size(); i++) {
			capacite = this.comparerPuissanceEntreDeuxCapacites(capacite, bonus.get(i));
		}

		return capacite;
	}

	private Capacite comparerPuissanceEntreDeuxCapacites(Capacite premiereCapacite, Capacite deuxiemeCapacite) {
		Capacite capacite = premiereCapacite;

		if (Combattant.verifierPremierNombreInferieurDeuxiemeNombre(premiereCapacite.obtenirPuissancePotentielle(this.getCombattant()), 
				deuxiemeCapacite.obtenirPuissancePotentielle(this.getCombattant()))) {
			capacite = deuxiemeCapacite;
		}

		return capacite;
	}

}
