package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import Combattant.TypeCombattant;
import capacite.*;
import gestionException.ExceptionCombattantNull;
import gestionException.ExceptionLorsqueCapaciteInferieureADeuxOuNull;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;
import gestionException.ExceptionLorsqueCaracteristiqueNull;
import gestionException.ExceptionLorsqueCaracteristiquesIncorrectes;
import gestionException.ExceptionNomVide;
import usine.*;

public class SoinTest {

	@Test
	public void ObjetConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		Soin soin = SoinUsine.CreerCapacite(25);

		assertEquals(25, soin.getEfficacite());
		assertTrue(soin instanceof Soin);
	}

	@Test
	public void ObtenirPointCombat() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionCombattantNull {
		Soin soin = SoinUsine.CreerCapacite(20);
		Soin autreSoin = SoinUsine.CreerCapacite(40);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soin, autreSoin);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(4, soin.guerir(elfe));
		assertEquals(8, autreSoin.guerir(elfe));
	}

	@Test
	public void ObtenirPointCombatQuePersonnageNePossedePas() throws ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Soin soin = SoinUsine.CreerCapacite(20);
		Soin autreSoin = SoinUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soin, soin);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreSoin.guerir(elfe));
	}

	@Test
	public void ObtenirPointCombatPotentiel() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
			ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Soin soin = SoinUsine.CreerCapacite(20);
		Soin autreSoin = SoinUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soin, soin);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(10, autreSoin.obtenirPuissancePotentielle(elfe));
	}

	@Test
	public void ObtenirPointCombatPotentielQuePersonnageNePossedePas()
			throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
			ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Soin soin = SoinUsine.CreerCapacite(20);
		Soin autreSoin = SoinUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soin, autreSoin);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(10, autreSoin.guerir(elfe));
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void SoinTropPuissant() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
			ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull {

		@SuppressWarnings("unused")
		Soin soin = SoinUsine.CreerCapacite(101);
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void SoinPasAssezPuissant() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
			ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull {

		@SuppressWarnings("unused")
		Soin soin = SoinUsine.CreerCapacite(19);
	}

}
