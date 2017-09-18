package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import gestionException.*;
import usine.*;

public class MagicienTest {

	@Test
	public void MagicienConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 10, 10, 30, 30);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals("elfe", mage.getNom());
		assertEquals(10, mage.getForce());
		assertEquals(10, mage.getDexterite());
		assertEquals(30, mage.getIntelligence());
		assertEquals(30, mage.getConcentration());
		assertEquals(attaque, mage.obtenirCapacite(0));
		assertEquals(defense, mage.obtenirCapacite(1));

	}
	
	@Test
	public void MagicienCaracteristiquesJuste() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 0, 0, 15, 15);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);
	}

	@Test
	public void Magicien_MethodeSet() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 40, 30);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.setForce(50);
		mage.setIntelligence(60);
		mage.setDexterite(70);
		mage.setConcentration(80);
		mage.setNom("gentil");

		assertEquals("gentil", mage.getNom());
		assertEquals(50, mage.getForce());
		assertEquals(70, mage.getDexterite());
		assertEquals(60, mage.getIntelligence());
		assertEquals(80, mage.getConcentration());
		assertFalse(mage.getCapituler());
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void MagicienAvecException_ForceTropGrande() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 16, 15, 30, 31);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void MagicienAvecException_ConcentrationTropGrande()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 15, 16, 31, 30);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

	}

	@Test
	public void GetCapacites() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 10, 0, 30, 35);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		ArrayList<Capacite> deuxiemeCapacites = mage.getCapacites();

		assertEquals(capacites, deuxiemeCapacites);
	}

	@Test
	public void LongueurCapacites() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 10, 0, 30, 35);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(2, mage.longueurCapacites());
	}

	@Test
	public void SupprimerCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 10, 0, 30, 35);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.supprimerCapacite(attaque);

		assertEquals(1, mage.longueurCapacites());
		assertEquals(TypeCapacite.BOUCLIER, mage.obtenirTypeCapacite(0));
	}

	@Test
	public void SupprimerCapaciteQueCombattantNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 10, 0, 30, 35);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.supprimerCapacite(defense);

		assertEquals(2, mage.longueurCapacites());
		assertEquals(TypeCapacite.EPEE, mage.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.EPEE, mage.obtenirTypeCapacite(1));
	}

	@Test
	public void Attaquer() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 10, 0, 30, 35);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(2, mage.attaquer(0));
	}

	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_LongueurCapacites() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		capacites.remove(0);

		@SuppressWarnings("unused")
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);
	}

	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_CapacitesNull()
			throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = null;

		@SuppressWarnings("unused")
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueNull.class)
	public void ElfeAvecException_CaracteristiquesNull() throws ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull, ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = null;

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);
	}
}
