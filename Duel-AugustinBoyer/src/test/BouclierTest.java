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

public class BouclierTest {

	@Test
	public void ObjetConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {		
		Bouclier bouclier = BouclierUsine.CreerCapacite(25);
		
		assertEquals(25, bouclier.getProtection());	
		assertTrue(bouclier instanceof Bouclier);
		assertEquals(TypeCapacite.BOUCLIER, bouclier.getTypeCapacite());
	}
	
	@Test
	public void ObtenirPointCombat() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
			Bouclier defense = BouclierUsine.CreerCapacite(20);
			
			Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);
			
			ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, defense);

			Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

			assertEquals(5, defense.puissanceCombat(elfe));
	}
	
	@Test
	public void ObtenirPointCombatQuePersonnageNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
			Bouclier bouclier = BouclierUsine.CreerCapacite(20);
			Bouclier autreAttaque = BouclierUsine.CreerCapacite(50);
			
			Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);
			
			ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(bouclier, bouclier);

			Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
			
			assertEquals(0, autreAttaque.puissanceCombat(elfe));
	}
	
	@Test
	public void ObtenirPointCombatPotentiel() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
	ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
			Bouclier bouclier = BouclierUsine.CreerCapacite(20);
			Bouclier autreAttaque = BouclierUsine.CreerCapacite(50);
			
			Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);
			
			ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(bouclier, bouclier);

			Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
			
			assertEquals(12, autreAttaque.obtenirPuissancePotentielle(elfe));
	}
	
	@Test
	public void ObtenirPointCombatPotentielQuePersonnageNePossedePas()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
			Bouclier bouclier = BouclierUsine.CreerCapacite(20);
			Bouclier autreBouclier = BouclierUsine.CreerCapacite(50);
			
			Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 25, 20, 30, 20);
			
			ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(bouclier, bouclier);

			Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
			
			assertEquals(0, autreBouclier.puissanceCombat(elfe));
	}
	
	@Test (expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void BouclierTropPuissant() throws Exception {

		@SuppressWarnings("unused")
		Bouclier bouclier = BouclierUsine.CreerCapacite(101);
	}
	
	@Test (expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void BouclierPasAssezPuissant() throws Exception {

		@SuppressWarnings("unused")
		Bouclier bouclier = BouclierUsine.CreerCapacite(19);
	}

}
