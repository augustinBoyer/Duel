package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import gestionException.ExceptionCombattantNull;
import gestionException.ExceptionLorsqueCapaciteInferieureADeuxOuNull;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;
import gestionException.ExceptionLorsqueCaracteristiqueNull;
import gestionException.ExceptionLorsqueCaracteristiquesIncorrectes;
import gestionException.ExceptionNomVide;
import usine.*;

public class DefenseMagiqueTest {

	@Test
	public void ObjetConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		DefenseMagique defenseMagique = DefenseMagiqueUsine.CreerCapacite(25);

		assertEquals(25, defenseMagique.getEfficacite());
		assertTrue(defenseMagique instanceof DefenseMagique);
	}

	@Test
	public void ObtenirPointCombat() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		DefenseMagique autreDefense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, autreDefense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(18, defense.puissanceCombat(ELFE));
		assertEquals(45, autreDefense.puissanceCombat(ELFE));
	}

	@Test
	public void ObtenirPointCombatQuePersonnageNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		DefenseMagique defenseMagique = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, defenseMagique.puissanceCombat(ELFE));
	}

	@Test
	public void ObtenirPointCombatPotentiel() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		DefenseMagique autreDefense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(45, autreDefense.obtenirPuissancePotentielle(ELFE));
	}

	@Test
	public void ObtenirPointCombatPotentielQuePersonnageNePossedePas()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		DefenseMagique defenseMagique = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, defenseMagique.puissanceCombat(ELFE));
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void DefenseMagiqueTropPuissant()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull {

		@SuppressWarnings("unused")
		DefenseMagique defenseMagique = DefenseMagiqueUsine.CreerCapacite(101);
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void DefenseMagiquePasAssezPuissant() throws Exception {

		@SuppressWarnings("unused")
		DefenseMagique defenseMagique = DefenseMagiqueUsine.CreerCapacite(19);
	}

}
