package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import gestionException.*;
import usine.*;

public class ElfeTest {
	@Test
	public void ELFEConstructeur() throws Exception {
		Epee epee = EpeeUsine.CreerCapacite(20);
		Bouclier bouclier = BouclierUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 21, 22, 23, 24);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, bouclier);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals("ELFE", ELFE.getNom());
		assertEquals(21, ELFE.getForce());
		assertEquals(22, ELFE.getDexterite());
		assertEquals(23, ELFE.getIntelligence());
		assertEquals(24, ELFE.getConcentration());
		assertEquals(epee, ELFE.obtenirCapacite(0));
		assertEquals(bouclier, ELFE.obtenirCapacite(1));
	}

	@Test
	public void testElfe_MethodeSet() throws Exception {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 20, 30, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		ELFE.setForce(50);
		ELFE.setIntelligence(60);
		ELFE.setDexterite(70);
		ELFE.setConcentration(80);
		ELFE.setNom("gentil");

		assertEquals("gentil", ELFE.getNom());
		assertEquals(50, ELFE.getForce());
		assertEquals(70, ELFE.getDexterite());
		assertEquals(60, ELFE.getIntelligence());
		assertEquals(80, ELFE.getConcentration());
	}

	@Test
	public void Elfe_CaracteristiqueJusteBonne() throws Exception {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test
	public void GetCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		ArrayList<Capacite> deuxiemeCapacites = ELFE.getCapacites();

		assertEquals(capacites, deuxiemeCapacites);
	}

	@Test
	public void LongueurCapacites() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(2, ELFE.longueurCapacites());
	}

	@Test
	public void SupprimerCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 20, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		ELFE.supprimerCapacite(attaque);

		assertEquals(1, ELFE.longueurCapacites());
		assertEquals(TypeCapacite.BOUCLIER, ELFE.obtenirTypeCapacite(0));
	}

	@Test
	public void SupprimerCapaciteQueCombattantNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		ELFE.supprimerCapacite(defense);

		assertEquals(2, ELFE.longueurCapacites());
		assertEquals(TypeCapacite.EPEE, ELFE.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.EPEE, ELFE.obtenirTypeCapacite(1));
	}

	@Test
	public void Attaquer() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 25);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, ELFE.attaquer(1));
	}

	@Test
	public void Elfe_SommesCaracteristiquesInferieureA100() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 25, 25, 25);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ElfeAvecException_ConcentrationTropPetite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 19);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ElfeAvecException_IntelligenceTropPetite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 19, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ElfeException_DexteriteTropPetite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 20, 19, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ElfeAvecException_ForceTropPetite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 19, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_LongueurCapacites1() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		capacites.remove(0);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_CapacitesNull() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = null;

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueNull.class)
	public void ElfeAvecException_CaracteristiquesNull() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = null;
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}
}
