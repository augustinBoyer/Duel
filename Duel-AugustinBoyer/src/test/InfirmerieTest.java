package test;

import static org.junit.Assert.*;

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
import infirmerie.*;
import usine.*;

public class InfirmerieTest {

	@Test
	public void testInfirmerie_SoinMagique_ResultatAttendu_PointDeVie_105()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {

		DefenseMagique attaque = DefenseMagiqueUsine.CreerCapacite(20);
		SoinMagique sante = SoinMagiqueUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 20, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, sante);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		Infirmerie.Soigner(guerrier);

		assertEquals(1, guerrier.longueurCapacites());

		assertEquals(105, guerrier.getPointsDeVie());
		assertTrue(guerrier.obtenirCapacite(0) instanceof DefenseMagique);
	}

	@Test
	public void testInfirmerie_Soin_ResultatAttendu130() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		DefenseMagique attaque = DefenseMagiqueUsine.CreerCapacite(20);
		Soin sante = SoinUsine.CreerCapacite(100);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 20, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, sante);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		Infirmerie.Soigner(guerrier);

		assertEquals(130, guerrier.getPointsDeVie());
		assertEquals(1, guerrier.longueurCapacites());
	}

	@Test
	public void testInfirmerieMaximumDePointDeVie_TroisSoins()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		Soin sante = SoinUsine.CreerCapacite(100);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 50, 40, 10, 0);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(sante, sante);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.ajouterCapacite(sante);
		Infirmerie.Soigner(guerrier);
		Infirmerie.Soigner(guerrier);
		Infirmerie.Soigner(guerrier);

		assertEquals(200, guerrier.getPointsDeVie());
		assertEquals(0, guerrier.longueurCapacites());
	}

	@Test
	public void testInfirmerieDePointDeVie_DeuxSoins_MaisPasDeDexterite_SoinsSupprimés_MaisPasDePointDeVieGagnées()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		Soin sante = SoinUsine.CreerCapacite(100);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 0, 0, 80, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(sante, sante);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		Infirmerie.Soigner(mage);
		Infirmerie.Soigner(mage);

		assertEquals(100, mage.getPointsDeVie());
		assertEquals(0, mage.longueurCapacites());
	}

	@Test
	public void testInfirmerieDePointDeVie_DeuxSoinsMagiques_MaisPasDIntelligence_SoinsMagiquesSupprimés_MaisPasDePointDeVieGagnées()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		SoinMagique sante = SoinMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 0, 0);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(sante, sante);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		Infirmerie.Soigner(guerrier);
		Infirmerie.Soigner(guerrier);

		assertEquals(130, guerrier.getPointsDeVie());
		assertEquals(0, guerrier.longueurCapacites());
	}

	@Test
	public void testInfirmerieMaximumDePointDeVie_DeuxSoinsMagiquesMaximumDePointDeVieAtteint()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		SoinMagique sante = SoinMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 0, 0, 80, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(sante, sante);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);
		Infirmerie.Soigner(mage);
		Infirmerie.Soigner(mage);

		assertEquals(200, mage.getPointsDeVie());
		assertEquals(0, mage.longueurCapacites());
	}

	@Test
	public void testInfirmerie_PasDePotionDeSoin_RienNeSePasse() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		DefenseMagique attaque = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(100, ELFE.getPointsDeVie());
		Infirmerie.Soigner(ELFE);

		assertEquals(100, ELFE.getPointsDeVie());
		assertEquals(2, ELFE.longueurCapacites());
	}

	@Test
	public void testInfirmerie_EnvoyerUnCombattantSansCapacite_RienNeSePasse()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		DefenseMagique attaque = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(100, elfe.getPointsDeVie());
		elfe.supprimerCapacite(attaque);
		elfe.supprimerCapacite(attaque);
		Infirmerie.Soigner(elfe);

		assertEquals(100, elfe.getPointsDeVie());
		assertEquals(0, elfe.longueurCapacites());
	}

	@Test(expected = ExceptionCombattantNull.class)
	public void testInfirmerie_EnvoyerUnCombattantNull_RienNeSePasse()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {

		Combattant elfe = null;
		Infirmerie.Soigner(elfe);
		
	}
}
