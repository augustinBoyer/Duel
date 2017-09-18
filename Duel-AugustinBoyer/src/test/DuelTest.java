package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import duel.*;
import gestionException.*;
import usine.*;

public class DuelTest {
	@Test
	public void DuelConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		AttaqueMagique attaqueMagique = AttaqueMagiqueUsine.CreerCapacite(30);
		Bouclier bouclier = BouclierUsine.CreerCapacite(40);
		Soin soin = SoinUsine.CreerCapacite(50);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 25, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("guerrier", 40, 30, 20, 10);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(bouclier, attaque);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(soin, attaqueMagique);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);

		Duel combat = DuelUsine.CreerCombat(elfe, guerrier);

		Combattant deuxiemeGuerrier = combat.getPersonnageRiposte();
		Combattant deuxiemeElfe = combat.getPersonnageAttaque();

		assertEquals(elfe, deuxiemeElfe);
		assertEquals(guerrier, deuxiemeGuerrier);

		assertEquals(100, deuxiemeGuerrier.getPointsDeVie());
		assertEquals(110, deuxiemeElfe.getPointsDeVie());
		assertEquals(30, deuxiemeGuerrier.getDexterite());
		assertEquals(20, deuxiemeElfe.getDexterite());
		assertEquals(20, deuxiemeGuerrier.getIntelligence());
		assertEquals(25, deuxiemeElfe.getIntelligence());
		assertEquals(40, deuxiemeGuerrier.getForce());
		assertEquals(25, deuxiemeElfe.getForce());
		assertEquals(10, deuxiemeGuerrier.getConcentration());
		assertEquals(20, deuxiemeElfe.getConcentration());
		assertEquals(2, deuxiemeGuerrier.longueurCapacites());
		assertEquals(2, deuxiemeElfe.longueurCapacites());
		assertEquals("guerrier", deuxiemeGuerrier.getNom());
		assertEquals("elfe", deuxiemeElfe.getNom());
		assertEquals(soin, deuxiemeGuerrier.obtenirCapacite(0));
		assertEquals(bouclier, deuxiemeElfe.obtenirCapacite(0));
		assertEquals(attaqueMagique, deuxiemeGuerrier.obtenirCapacite(1));
		assertEquals(attaque, deuxiemeElfe.obtenirCapacite(1));
	}

	@Test
	public void DuelAvecMagie_RiposteAvecAttaqueMagique() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 30, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 40, 30, 15, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, deuxiemeCapacites,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(elfe, guerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(96, guerrier.getPointsDeVie());
		assertEquals(100, elfe.getPointsDeVie());

	}

	@Test
	public void DuelAvecMagie_RiposteAvecDefenseMagique() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("ELFE", 30, 20, 30, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("ELFE", 40, 30, 15, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, deuxiemeCapacites,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(elfe, guerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(1);
		Duel.combattre();

		assertEquals(96, guerrier.getPointsDeVie());
		assertEquals(100, elfe.getPointsDeVie());

	}

	@Test
	public void DuelSansMagie_RiposteAvecBouclier() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(30);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 30, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 40, 30, 15, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, deuxiemeCapacites,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(1);
		Duel.combattre();

		assertEquals(104, guerrier.getPointsDeVie());
		assertEquals(100, elfe.getPointsDeVie());
	}

	@Test
	public void DuelSansMagie_RiposteAvecEpee() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(30);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 30, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 40, 30, 15, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, deuxiemeCapacites,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(elfe, guerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(105, guerrier.getPointsDeVie());
		assertEquals(98, elfe.getPointsDeVie());
	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposte_DeuxiemeGagnant_PointsDeVieAttendusDuPerdant112()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 20, 25);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 15, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacites,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, deuxiemeCapacites, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(112, guerrier.getPointsDeVie());
		assertEquals(105, elfe.getPointsDeVie());

		assertEquals(21, elfe.getDexterite());
		assertEquals(19, guerrier.getDexterite());
	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposte_DeuxiemeGagneUneCapacite()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 20, 25);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 15, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacites,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, deuxiemeCapacites, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(3, elfe.longueurCapacites());
	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposte_PremierGagneUneCapacite()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 20, 25);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("ELFE", 30, 20, 15, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacites,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, deuxiemeCapacites, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(3, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test
	public void CombattantsAvecLaMemeCapacite_CombatNeCommencePas() throws Exception {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 25);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 15, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacites,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test
	public void CombattantsAvecLaMemeCaracteristique_CombatNeCommencePas() throws Exception {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 20, 25);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristique, deuxiemeCapacites, TypeCombattant.ELFE);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposteDefense_PremierGagnant_PointsDeVieAttendusDuPerdant85()
			throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(30);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("ELFE", 30, 20, 30, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("ELFE", 40, 30, 20, 10);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, deuxiemeCapacites,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(elfe, guerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(100, elfe.getPointsDeVie());
		assertEquals(91, guerrier.getPointsDeVie());
	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposteDefense_DeuxiemeGagnant_PerdantPointsDeVieAttendusDuPerdant26()
			throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(80);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 20, 20);
		Caracteristique caracteristiqueMagicien = CaracteristiqueUsine.CreerCaracteristique("elfe", 0, 0, 40, 40);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		Combattant mage = CombattantUsine.CreerCombattant(caracteristiqueMagicien, deuxiemeCapacites,
				TypeCombattant.MAGICIEN);

		Duel Duel = DuelUsine.CreerCombat(elfe, mage);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(1);

		Duel.combattre();

		assertEquals(26, elfe.getPointsDeVie());
		assertEquals(120, mage.getPointsDeVie());

		assertEquals(1, mage.getDexterite());
		assertEquals(19, elfe.getDexterite());

	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposteDefense_PremierGagnant_PerdantAvecAptitudeForceEtDexteriteAZero()
			throws Exception {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(60);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 20, 20);
		Caracteristique caracteristiqueMagicien = CaracteristiqueUsine.CreerCaracteristique("elfe", 0, 0, 40, 40);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		Combattant mage = CombattantUsine.CreerCombattant(caracteristiqueMagicien, capacites, TypeCombattant.MAGICIEN);

		Duel Duel = DuelUsine.CreerCombat(elfe, mage);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(1);

		Duel.combattre();

		assertEquals(0, mage.getDexterite());
		assertEquals(0, mage.getForce());
	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposteDefense_PremierGagnant_PerdantAvecIntelligenceEtConcentrationAZero()
			throws Exception {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(60);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 30, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 40, 30, 0, 0);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(attaque, attaque);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(elfe, guerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(0, guerrier.getIntelligence());
		assertEquals(0, guerrier.getConcentration());
	}

	@Test
	public void EvaluerPuissanceAttaqueAvecRiposte_PremierGagne_PerdantPointsDeVieAttendusDuPerdant106_DexteriteEtForceA0()
			throws Exception {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(100);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 0, 0, 50, 40);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(attaque, attaque);
		ArrayList<Capacite> capacitesMagicien = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);
		Combattant magicien = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesMagicien,
				TypeCombattant.MAGICIEN);

		Duel Duel = DuelUsine.CreerCombat(elfe, magicien);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(120, elfe.getPointsDeVie());
		assertEquals(106, magicien.getPointsDeVie());

		assertEquals(0, magicien.getDexterite());
		assertEquals(0, magicien.getForce());

	}

	@Test
	public void PremierAttaqueSansCapaciteDAttaque_LeCombatNeCommencePas_RienNeChange() throws Exception {

		Bouclier defense = BouclierUsine.CreerCapacite(100);
		Soin soin = SoinUsine.CreerCapacite(20);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 40, 30, 0, 0);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, defense);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(soin, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		assertEquals(130, guerrier.getPointsDeVie());
		assertEquals(120, elfe.getPointsDeVie());

		assertEquals(20, elfe.getDexterite());
		assertEquals(30, guerrier.getDexterite());

	}

	@Test
	public void DeuxiemeCombattantSansCapaciteDeRiposte_LeCombatNeCommencePas_RienNeChange() throws Exception {

		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(100);
		Soin soin = SoinUsine.CreerCapacite(30);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 20, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 40, 30, 0, 0);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, defense);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, attaque);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(120, elfe.getPointsDeVie());

		assertEquals(20, elfe.getDexterite());
		assertEquals(30, guerrier.getDexterite());

	}

	@Test
	public void RecompensePerdant_LePerdantNeRecoitRien() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(25);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(100);
		Soin soin = SoinUsine.CreerCapacite(20);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 20, 20);
		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 40, 30, 20, 10);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, defense);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);
		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(2, elfe.longueurCapacites());
		assertEquals(soin, elfe.obtenirCapacite(0));
		assertEquals(defense, elfe.obtenirCapacite(1));
	}

	@Test
	public void CombattantAyantLaMemePuissance_ResultatAttendu_RienNeChangePourLeDeuxiemeGuerrier() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique deuxiemeCaracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5,
				5);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant deuxiemeGuerrier = CombattantUsine.CreerCombattant(deuxiemeCaracteristiqueGuerrier,
				deuxiemeCapacitesGuerrier, TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(guerrier, deuxiemeGuerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(110, guerrier.getPointsDeVie());

		assertEquals(50, deuxiemeGuerrier.getForce());
		assertEquals(30, deuxiemeGuerrier.getDexterite());
		assertEquals(5, deuxiemeGuerrier.getIntelligence());
		assertEquals(5, deuxiemeGuerrier.getConcentration());

		assertEquals(2, deuxiemeGuerrier.longueurCapacites());
	}

	@Test
	public void CombattantAyantLaMemePuissance_ResultatAttendu_RienNeChangePourLePremierGuerrier() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique deuxiemeCaracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5,
				5);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> deuxiemeCapacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant deuxiemeGuerrier = CombattantUsine.CreerCombattant(deuxiemeCaracteristiqueGuerrier,
				deuxiemeCapacitesGuerrier, TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(guerrier, deuxiemeGuerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(110, guerrier.getPointsDeVie());

		assertEquals(50, guerrier.getForce());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(5, guerrier.getIntelligence());
		assertEquals(5, guerrier.getConcentration());

		assertEquals(2, guerrier.longueurCapacites());
	}

	@Test
	public void VerifierDeuxiemeEquipeCapitule() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 0, 0, 50, 50);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant mage = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.MAGICIEN);

		mage.setCapituler(true);

		Duel Duel = DuelUsine.CreerCombat(guerrier, mage);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		Duel.combattre();

		assertEquals(51, guerrier.getForce());
		assertEquals(6, guerrier.getConcentration());
		assertEquals(6, guerrier.getIntelligence());
		assertEquals(31, guerrier.getDexterite());
		assertEquals(110, guerrier.getPointsDeVie());

		assertEquals(0, mage.getForce());
		assertEquals(49, mage.getConcentration());
		assertEquals(49, mage.getIntelligence());
		assertEquals(0, mage.getDexterite());
		assertEquals(100, mage.getPointsDeVie());
	}

	@Test
	public void MortPremierCombattant() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique caracteristiqueMagicien = CaracteristiqueUsine.CreerCaracteristique("elfe", 0, 0, 50, 50);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesMagicien = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant mage = CombattantUsine.CreerCombattant(caracteristiqueMagicien, capacitesMagicien,
				TypeCombattant.MAGICIEN);

		Duel Duel = DuelUsine.CreerCombat(guerrier, mage);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(0, guerrier.getPointsDeVie());
	}

	@Test
	public void MortDeuxiemeCombattant() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("guerrier", 50, 30, 5, 5);
		Caracteristique caracteristiqueMagicien = CaracteristiqueUsine.CreerCaracteristique("magicien", 0, 0, 50, 50);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesMagicien = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant mage = CombattantUsine.CreerCombattant(caracteristiqueMagicien, capacitesMagicien,
				TypeCombattant.MAGICIEN);

		Duel Duel = DuelUsine.CreerCombat(mage, guerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(0, guerrier.getPointsDeVie());
	}

	@Test
	public void MemeCombattant() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("guerrier", 50, 30, 5, 5);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);

		Duel Duel = DuelUsine.CreerCombat(guerrier, guerrier);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(30, guerrier.getDexterite());
	}

	@Test
	public void PremierIndiceTrop_CombatNeCommencePas() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("guerrier", 50, 30, 5, 5);
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("magicien", 20, 20, 25, 25);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, soin);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(2);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(110, guerrier.getPointsDeVie());
		assertEquals(110, elfe.getPointsDeVie());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(20, elfe.getDexterite());
		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test
	public void DeuxiemeIndiceTrop_CombatNeCommencePas() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 25, 25);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, soin);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(2);

		assertEquals(110, guerrier.getPointsDeVie());
		assertEquals(110, elfe.getPointsDeVie());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(20, elfe.getDexterite());
		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test
	public void PremierCombattantSansPointDeVie_CombatNeCommencePas() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 25, 25);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(attaque, soin);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);

		guerrier.setPointsDeVie(0);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(0);

		assertEquals(0, guerrier.getPointsDeVie());
		assertEquals(110, elfe.getPointsDeVie());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(20, elfe.getDexterite());
		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test
	public void DeuxiemeCombattantSansPointDeVie_CombatNeCommencePas() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 25, 25);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, soin);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);

		elfe.setPointsDeVie(0);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.setIndexRiposte(2);
		Duel.combattre();

		assertEquals(110, guerrier.getPointsDeVie());
		assertEquals(0, elfe.getPointsDeVie());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(20, elfe.getDexterite());
		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test(expected = ExceptionCombattantNull.class)
	public void PremierCombattantNull_NullException() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 25, 25);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = null;
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);

		@SuppressWarnings("unused")
		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
	}
	
	@Test(expected = ExceptionCombattantNull.class)
	public void DeuxiemeCombattantNull_NullException() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 30, 20, 20, 20);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant elfe = null;

		@SuppressWarnings("unused")
		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
	}

	@Test
	public void DeuxiemeCombattantSansInitialiserRiposte_CombatNeCommencePas() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 15, 5);
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 25, 25);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaque, defense);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, defense);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexRiposte(0);
		Duel.combattre();

		assertEquals(100, guerrier.getPointsDeVie());
		assertEquals(110, elfe.getPointsDeVie());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(20, elfe.getDexterite());
		assertEquals(2, guerrier.longueurCapacites());
		assertEquals(2, elfe.longueurCapacites());
	}

	@Test
	public void DeuxiemeCombattantSansInitialiserDeuxiemeCapacite__CombatNeCommencePas() throws Exception {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		SoinMagique soin = SoinMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueGuerrier = CaracteristiqueUsine.CreerCaracteristique("elfe", 50, 30, 5, 5);
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20, 20, 25, 25);

		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(defense, attaque);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(soin, soin);

		Combattant guerrier = CombattantUsine.CreerCombattant(caracteristiqueGuerrier, capacitesGuerrier,
				TypeCombattant.GUERRIER);
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);

		Duel Duel = DuelUsine.CreerCombat(guerrier, elfe);
		Duel.setIndexAttaque(0);
		Duel.combattre();

		assertEquals(110, guerrier.getPointsDeVie());
		assertEquals(30, guerrier.getDexterite());
		assertEquals(2, guerrier.longueurCapacites());

		assertEquals(2, elfe.longueurCapacites());
		assertEquals(20, elfe.getDexterite());
		assertEquals(110, elfe.getPointsDeVie());
	}
}
