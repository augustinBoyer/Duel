package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import duel.AttribuerRecompenseAuVainqueur;
import gestionException.*;
import usine.*;

public class FinalisationCombatTest {

	@Test
	public void FinalisationCombat_TestVaincu() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(100);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristiqueMage = CaracteristiqueUsine.CreerCaracteristique("elfe", 0, 0, 50, 50);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		Combattant autreMage = CombattantUsine.CreerCombattant(caracteristiqueMage, capacites, TypeCombattant.MAGICIEN);

		AttribuerRecompenseAuVainqueur.RecompenserVainqueur(autreMage);

		assertEquals(50, autreMage.getConcentration());
		assertEquals(0, autreMage.getDexterite());
		assertEquals(0, autreMage.getForce());
		assertEquals(50, autreMage.getIntelligence());

		assertEquals(3, autreMage.longueurCapacites());
	}
}
