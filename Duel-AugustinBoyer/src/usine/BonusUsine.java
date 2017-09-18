package usine;

import java.util.ArrayList;

import capacite.*;

public class BonusUsine {

	public static ArrayList<Capacite> CreerBonus(Epee epee, Bouclier bouclier, AttaqueMagique attaqueMagique,
			DefenseMagique defenseMagique, Soin soin, SoinMagique soinMagique) {
		ArrayList<Capacite> bonus = new ArrayList<Capacite>();

		bonus.add(epee);
		bonus.add(bouclier);
		bonus.add(attaqueMagique);
		bonus.add(defenseMagique);
		bonus.add(soin);
		bonus.add(soinMagique);

		return bonus;
	}

}
