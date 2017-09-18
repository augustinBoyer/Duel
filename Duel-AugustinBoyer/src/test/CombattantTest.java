package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import gestionException.*;
import infirmerie.Infirmerie;
import usine.*;

public class CombattantTest {

	@Test
	public void GetCapacite()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 10, 0, 30, 35);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		ArrayList<Capacite> deuxiemeCapacites = mage.getCapacites();

		assertEquals(capacites, deuxiemeCapacites);
	}

	@Test
	public void longueurCapacites()throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Guerrier", 10, 0, 30, 35);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(2, mage.longueurCapacites());
	}

	@Test
	public void supprimerCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {
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
	public void supprimerCapaciteQueCombattantNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {
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
	public void testEvaluerpuissanceAttaque_Epee_ResultatAttandu5() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 25, 20, 25, 20);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(5, attaque.puissanceCombat(elfe));
		assertEquals(20, elfe.getDexterite());
		assertEquals(110, elfe.getPointsDeVie());
	}

	@Test
	public void testEvaluerpuissanceAttaque_Epee_ResultatAttandu0() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 0, 0, 25, 20);
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(0, attaque.puissanceCombat(mage));

	}

	@Test
	public void testEvaluerpuissanceAttaque_Bouclier_ResultatAttandu2() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);
		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
	
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(2, attaque.puissanceCombat(mage));
	}

	@Test
	public void testEvaluerpuissanceAttaque_AttaqueMagique_ResultatAttandu18() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);
		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(2, defense.puissanceCombat(mage));

	}

	@Test
	public void testlongueurCapacites_ResultatAttandu2() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(2, mage.longueurCapacites());
		assertEquals(attaque, mage.obtenirCapacite(0));
		assertEquals(attaque, mage.obtenirCapacite(1));
	}

	@Test
	public void testAjouterCapacite_ResultatAttandulongueur3() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);
		Epee epee = EpeeUsine.CreerCapacite(30);
		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.ajouterCapacite(epee);

		assertEquals(3, mage.longueurCapacites());
		assertEquals(defense, mage.obtenirCapacite(1));
		assertEquals(epee, mage.obtenirCapacite(2));
		assertEquals(attaque, mage.obtenirCapacite(0));
	}

	@Test
	public void testsupprimerCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, attaque);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.supprimerCapacite(defense);

		assertEquals(1, mage.longueurCapacites());
		assertEquals(attaque, mage.obtenirCapacite(0));
	}

	@Test
	public void testsupprimerCapacite_LeCombattantNePossedePasLaCapacite() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 20, 20, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.supprimerCapacite(defense);

		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(attaque, guerrier.obtenirCapacite(0));
		assertEquals(attaque, guerrier.obtenirCapacite(1));
	}

	@Test
	public void testAttaque() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 20, 20, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(12, attaque.puissanceCombat(guerrier));
	}

	@Test
	public void testRiposterDefense() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 30, 20, 20, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(30, defense.puissanceCombat(guerrier));
	}

	@Test
	public void testRiposterAttaque() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(2, mage.longueurCapacites());
		assertEquals(18, attaque.puissanceCombat(mage));
	}

	@Test
	public void testCapituler_Constructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(false, guerrier.getCapituler());
	}

	@Test
	public void testCapituler() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant magicien = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		magicien.setCapituler(true);

		assertTrue(magicien.getCapituler());
	}

	@Test
	public void testEvaluerpuissanceAttaque_DefenseMagique_ResultatAttendu45() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		assertEquals(45, defense.puissanceCombat(mage));
	}

	@Test
	public void TestChoisirLeMeilleurBonusPourLeVainqueur_obtenirDefenseMagique() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {
		AttaqueMagique epee = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique bouclier = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);
		Soin sante = SoinUsine.CreerCapacite(20);
		SoinMagique santeMagique = SoinMagiqueUsine.CreerCapacite(20);

		ArrayList<Capacite> liste = new ArrayList<Capacite>();

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, epee);

		liste.add(epee);
		liste.add(bouclier);
		liste.add(attaque);
		liste.add(defense);
		liste.add(sante);
		liste.add(santeMagique);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.choisirMeilleurBonusPourLeVainqueur(liste);

		assertEquals(3, mage.longueurCapacites());
		assertEquals(TypeCapacite.ATTAQUE_MAGIQUE, mage.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.ATTAQUE_MAGIQUE, mage.obtenirTypeCapacite(1));
		assertEquals(TypeCapacite.DEFENSE_MAGIQUE, mage.obtenirTypeCapacite(2));
	}

	@Test
	public void TestChoisirLeMeilleurBonusPourLeVainqueur_obtenirAttaqueMagique() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {
		Epee epee = EpeeUsine.CreerCapacite(20);
		Bouclier bouclier = BouclierUsine.CreerCapacite(20);
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);
		Soin sante = SoinUsine.CreerCapacite(20);
		SoinMagique santeMagique = SoinMagiqueUsine.CreerCapacite(20);

		ArrayList<Capacite> liste = new ArrayList<Capacite>();

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 10, 10, 30, 30);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, epee);

		liste.add(epee);
		liste.add(bouclier);
		liste.add(attaque);
		liste.add(defense);
		liste.add(sante);
		liste.add(santeMagique);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.choisirMeilleurBonusPourLeVainqueur(liste);

		assertEquals(3, mage.longueurCapacites());
		assertEquals(TypeCapacite.EPEE, mage.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.EPEE, mage.obtenirTypeCapacite(1));
		assertEquals(TypeCapacite.ATTAQUE_MAGIQUE, mage.obtenirTypeCapacite(2));
	}

	@Test
	public void TestChoisirLeMeilleurBonusPourLeVainqueur_obtenirEpee() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {
		Epee epee = EpeeUsine.CreerCapacite(100);
		Bouclier bouclier = BouclierUsine.CreerCapacite(20);
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		Soin sante = SoinUsine.CreerCapacite(20);
		SoinMagique santeMagique = SoinMagiqueUsine.CreerCapacite(20);

		ArrayList<Capacite> liste = new ArrayList<Capacite>();

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 0, 0);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, bouclier);

		liste.add(epee);
		liste.add(bouclier);
		liste.add(attaque);
		liste.add(defense);
		liste.add(sante);
		liste.add(santeMagique);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.choisirMeilleurBonusPourLeVainqueur(liste);

		assertEquals(3, guerrier.longueurCapacites());
		assertEquals(TypeCapacite.EPEE, guerrier.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.BOUCLIER, guerrier.obtenirTypeCapacite(1));
		assertEquals(TypeCapacite.EPEE, guerrier.obtenirTypeCapacite(2));
	}

	@Test
	public void TestChoisirLeMeilleurBonusPourLeVainqueur_obtenirSoin() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {
		Epee epee = EpeeUsine.CreerCapacite(20);
		AttaqueMagique bouclier = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		Soin sante = SoinUsine.CreerCapacite(100);
		SoinMagique santeMagique = SoinMagiqueUsine.CreerCapacite(20);

		ArrayList<Capacite> liste = new ArrayList<Capacite>();

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 15, 10);
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, epee);

		liste.add(epee);
		liste.add(bouclier);
		liste.add(attaque);
		liste.add(defense);
		liste.add(sante);
		liste.add(santeMagique);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.choisirMeilleurBonusPourLeVainqueur(liste);

		assertEquals(3, guerrier.longueurCapacites());
		assertEquals(TypeCapacite.EPEE, guerrier.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.EPEE, guerrier.obtenirTypeCapacite(1));
		assertEquals(TypeCapacite.SOIN, guerrier.obtenirTypeCapacite(2));
	}

	@Test
	public void TestChoisirLeMeilleurBonusPourLeVainqueur_obtenirSoinMagique() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique epee = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique bouclier = AttaqueMagiqueUsine.CreerCapacite(20);
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		Soin sante = SoinUsine.CreerCapacite(20);
		SoinMagique santeMagique = SoinMagiqueUsine.CreerCapacite(100);

		ArrayList<Capacite> liste = new ArrayList<Capacite>();
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, bouclier);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("mage", 5, 5, 40, 40);

		liste.add(epee);
		liste.add(bouclier);
		liste.add(attaque);
		liste.add(defense);
		liste.add(sante);
		liste.add(santeMagique);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		mage.choisirMeilleurBonusPourLeVainqueur(liste);

		assertEquals(3, mage.longueurCapacites());
		assertEquals(TypeCapacite.ATTAQUE_MAGIQUE, mage.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.ATTAQUE_MAGIQUE, mage.obtenirTypeCapacite(1));
		assertEquals(TypeCapacite.SOIN_MAGIQUE, mage.obtenirTypeCapacite(2));
	}

	@Test
	public void TestChoisirLeMeilleurBonusPourLeVainqueur_obtenirBouclier() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique epee = AttaqueMagiqueUsine.CreerCapacite(20);
		Bouclier bouclier = BouclierUsine.CreerCapacite(100);
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		Soin sante = SoinUsine.CreerCapacite(20);
		SoinMagique santeMagique = SoinMagiqueUsine.CreerCapacite(20);

		ArrayList<Capacite> liste = new ArrayList<Capacite>();
		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, bouclier);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("mage", 50, 30, 0, 0);

		liste.add(epee);
		liste.add(bouclier);
		liste.add(attaque);
		liste.add(defense);
		liste.add(sante);
		liste.add(santeMagique);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.GUERRIER);

		guerrier.choisirMeilleurBonusPourLeVainqueur(liste);

		assertEquals(3, guerrier.longueurCapacites());
		assertEquals(TypeCapacite.ATTAQUE_MAGIQUE, guerrier.obtenirTypeCapacite(0));
		assertEquals(TypeCapacite.BOUCLIER, guerrier.obtenirTypeCapacite(1));
		assertEquals(TypeCapacite.BOUCLIER, guerrier.obtenirTypeCapacite(2));
	}

	@Test
	public void obtenirPointCombatAvecMagiePlus() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 20, 20, 40, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, attaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(24, attaque.puissanceCombat(elfe));

	}

	@Test
	public void DepasserLaLimiteDePointsDeVie_ResultatAttenduDeDeuxCent() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("guerrier", 0, 0, 80, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(soin, soin);

		Combattant mage = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);

		Infirmerie.Soigner(mage);

		assertEquals(180, mage.getPointsDeVie());

		Infirmerie.Soigner(mage);
		
		assertEquals(PointsDeVie.MAXIMUM_POINTS_DE_VIE, mage.getPointsDeVie());
	}
	
	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_LongueurCapacitess1() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		
		capacites.remove(0);

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}
	
	@Test(expected = ExceptionLorsqueCapaciteInferieureADeuxOuNull.class)
	public void ElfeAvecException_CapacitesNull() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		capacites = null;

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}
	
	@Test(expected = ExceptionLorsqueCaracteristiqueNull.class)
	public void ElfeAvecException_CaracteristiquesNull() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
	ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		Caracteristique caracteristique = null;

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}
	
	@Test(expected = ExceptionLorsqueCaracteristiqueNull.class)
	public void ElfeAvecException_ToutNull() throws Exception {
		Caracteristique caracteristique = null;

		ArrayList<Capacite> capacites = null;

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}
}
