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

public class SoinMagiqueTest {

	@Test
	public void ObjetConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(25);

		assertEquals(25, soin.getEfficacite());
		assertTrue(soin instanceof SoinMagique);
		assertEquals(TypeCapacite.SOIN_MAGIQUE, soin.getTypeCapacite());
	}

	@Test
	public void GuerirTest() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(20);
		SoinMagique autreSoin = SoinMagiqueUsine.CreerCapacite(40);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soin, autreSoin);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		elfe.obtenirCapacite(0);

		assertEquals(6, soin.guerir(elfe));
		assertEquals(12, autreSoin.guerir(elfe));
	}

	@Test
	public void GuerirTest_CombattantNePossedePaslaCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		SoinMagique soinMagique = SoinMagiqueUsine.CreerCapacite(20);
		SoinMagique autreSoinMagique = SoinMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soinMagique, soinMagique);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreSoinMagique.guerir(elfe));
	}

	@Test
	public void ObtenirSoinMagiqueQuePersonnageNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		SoinMagique SoinMagique = SoinMagiqueUsine.CreerCapacite(20);
		SoinMagique autreSoinMagique = SoinMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(SoinMagique, SoinMagique);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreSoinMagique.guerir(elfe));
	}

	@Test
	public void ObtenirSoinQuePersonnageNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Soin soinMagique = SoinUsine.CreerCapacite(20);
		Soin autreSoinMagique = SoinUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soinMagique, soinMagique);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreSoinMagique.guerir(elfe));
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void SoinMagiqueTropPuissant() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		@SuppressWarnings("unused")
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(101);
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void SoinMagiquePasAssezPuissant() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		@SuppressWarnings("unused")
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(19);
	}

}
