package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import gestionException.*;
import usine.*;

public class GuerrierTest {

	@Test
	public void testGuerrierConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 20, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		assertEquals("guerrier", guerrier.getNom());
		assertEquals(40, guerrier.getForce());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(20, guerrier.getIntelligence());
		assertEquals(10, guerrier.getConcentration());
		assertEquals(attaque, guerrier.obtenirCapacite(0));
		assertEquals(defense, guerrier.obtenirCapacite(1));
	}

	@Test
	public void testGuerrier_MethodeSet() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 20, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.setForce(50);
		guerrier.setIntelligence(60);
		guerrier.setDexterite(70);
		guerrier.setConcentration(80);
		guerrier.setNom("gentil");

		assertEquals("gentil", guerrier.getNom());
		assertEquals(50, guerrier.getForce());
		assertEquals(70, guerrier.getDexterite());
		assertEquals(60, guerrier.getIntelligence());
		assertEquals(80, guerrier.getConcentration());
	}

	@Test
	public void testGuerrier_AvecCaracteristiquesJusteBonnes()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 20, 20, 30);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.setForce(50);
		guerrier.setIntelligence(60);
		guerrier.setDexterite(70);
		guerrier.setConcentration(80);
		guerrier.setNom("gentil");

		assertEquals("gentil", guerrier.getNom());
		assertEquals(50, guerrier.getForce());
		assertEquals(70, guerrier.getDexterite());
		assertEquals(60, guerrier.getIntelligence());
		assertEquals(80, guerrier.getConcentration());
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void GuerrierJuste() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(25);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 39, 30, 20, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void GuerrierAvecExceptionDexterite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 21, 10, 0);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);
	}

	@Test
	public void GuerrierCaracteristiquesJuste() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 0, 0, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void GuerrierAvecExceptionIntelligence() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 10, 11, 0);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void GuerrierAvecExceptionConcentration() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 20, 0, 11);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

	}

	@Test
	public void GetCapacites() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 40, 30, 0, 5);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		ArrayList<Capacite> deuxiemeCapacites = guerrier.getCapacites();

		assertEquals(capacites, deuxiemeCapacites);
	}

	@Test
	public void LongueurCapacites() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 40, 30, 0, 5);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		assertEquals(2, guerrier.longueurCapacites());
	}

	@Test
	public void SupprimerCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 40, 30, 0, 5);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.supprimerCapacite(attaque);

		assertEquals(1, guerrier.longueurCapacites());
		assertEquals(TypeCapacite.BOUCLIER, guerrier.obtenirTypeCapacite(0));
	}

	@Test
	public void SupprimerCapaciteQueCombattantNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 40, 30, 0, 5);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.supprimerCapacite(defense);

		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(TypeCapacite.EPEE, guerrier.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.EPEE, guerrier.obtenirTypeCapacite(1));
	}

	@Test
	public void Attaquer() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 40, 30, 0, 5);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		assertEquals(0, guerrier.attaquer(1));
	}

	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_LongueurCapacitess1() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		capacites.remove(0);

		@SuppressWarnings("unused")
		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_CapacitesNull() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = null;

		@SuppressWarnings("unused")
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);
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
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);
	}
}
