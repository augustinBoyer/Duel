package duel;

import java.util.ArrayList;

import Combattant.Combattant;
import capacite.*;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;
import usine.*;

public abstract class AttribuerRecompenseAuVainqueur {

	private static int POINT_CAPACITE_BONUS = 20;

	public static void RecompenserVainqueur(Combattant vainqueur)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		vainqueur.choisirMeilleurBonusPourLeVainqueur(CreerNouvelleCapacitePourLeVainqueur());
	}

	private static ArrayList<Capacite> CreerNouvelleCapacitePourLeVainqueur()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		return BonusUsine.CreerBonus(EpeeUsine.CreerCapacite(POINT_CAPACITE_BONUS),
				BouclierUsine.CreerCapacite(POINT_CAPACITE_BONUS),
				AttaqueMagiqueUsine.CreerCapacite(POINT_CAPACITE_BONUS),
				DefenseMagiqueUsine.CreerCapacite(POINT_CAPACITE_BONUS), SoinUsine.CreerCapacite(POINT_CAPACITE_BONUS),
				SoinMagiqueUsine.CreerCapacite(POINT_CAPACITE_BONUS));
	}

}
