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

public class AttaqueMagiqueTest {

	@Test
	public void ObjetConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		Capacite attaque = AttaqueMagiqueUsine.CreerCapacite(20);

		assertEquals(20, ((AttaqueMagique) attaque).getEfficacite());
		assertTrue(attaque instanceof AttaqueMagique);
		assertEquals(TypeCapacite.ATTAQUE_MAGIQUE, attaque.getTypeCapacite());
	}

	@Test
	public void ObtenirPointCombat() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique autreAttaque = AttaqueMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, autreAttaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(18, attaque.puissanceCombat(elfe));
		assertEquals(45, autreAttaque.puissanceCombat(elfe));
	}

	@Test
	public void ObtenirPointCombatQuePersonnageNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique autreAttaque = AttaqueMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreAttaque.puissanceCombat(elfe));
	}

	@Test
	public void ObtenirPointCombatPotentiel() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique autreAttaque = AttaqueMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(45, autreAttaque.obtenirPuissancePotentielle(elfe));
	}

	@Test
	public void ObtenirPointCombatPotentielQuePersonnageNePossedePas()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique autreAttaque = AttaqueMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreAttaque.puissanceCombat(elfe));
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void AttaqueMagiqueTropPuissant() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		@SuppressWarnings("unused")
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(101);
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void AttaqueMagiquePasAssezPuissant() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		@SuppressWarnings("unused")
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(19);
	}
}
