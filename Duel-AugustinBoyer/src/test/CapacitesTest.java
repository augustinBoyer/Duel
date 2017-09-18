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
import usine.*;

public class CapacitesTest {
	@Test
	public void CreerUneArrayListCapacites() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
			ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);
		Epee epee = EpeeUsine.CreerCapacite(50);

		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);

		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(defense, epee);	
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacitesElfe, TypeCombattant.ELFE);
		
		assertEquals(2, elfe.longueurCapacites());

		DefenseMagique defenseMagique = (DefenseMagique) elfe.obtenirCapacite(0);
		
		assertEquals(defenseMagique, defense);
		assertEquals(20, defenseMagique.getEfficacite());
		assertEquals(12, defenseMagique.puissanceCombat(elfe));
		assertEquals(elfe.obtenirTypeCapacite(0), TypeCapacite.DEFENSE_MAGIQUE);
		
		Epee autreEpee = (Epee) elfe.obtenirCapacite(1);
		
		assertEquals(autreEpee, epee);
		assertEquals(50, autreEpee.getImpact());
		assertEquals(10, autreEpee.puissanceCombat(elfe));	
		assertEquals(autreEpee.getTypeCapacite(), TypeCapacite.EPEE);
	}

	@Test
	public void SupprimerCapacite() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		elfe.supprimerCapacite(attaque);

		assertEquals(1, elfe.longueurCapacites());
		assertEquals(defense, elfe.obtenirCapacite(0));
	}
	
	@Test
	public void SupprimerCapaciteQueCombattantNePossedePas() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);
		Bouclier bouclier = BouclierUsine.CreerCapacite(40);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		elfe.supprimerCapacite(bouclier);

		assertEquals(2, elfe.longueurCapacites());
		assertEquals(defense, elfe.obtenirCapacite(1));
		assertEquals(attaque, elfe.obtenirCapacite(0));
	}
	
	@Test
	public void SupprimerCapaciteNull() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		elfe.supprimerCapacite(null);

		assertEquals(2, elfe.longueurCapacites());
		assertEquals(defense, elfe.obtenirCapacite(1));
		assertEquals(attaque, elfe.obtenirCapacite(0));
	}
	
	@Test
	public void AjouterCapacite() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		elfe.ajouterCapacite(attaque);

		assertEquals(3, elfe.longueurCapacites());
		assertEquals(attaque, elfe.obtenirCapacite(0));
		assertEquals(defense, elfe.obtenirCapacite(1));
		assertEquals(attaque, elfe.obtenirCapacite(2));
	}
	
	@Test
	public void AjouterCapaciteNull() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		elfe.ajouterCapacite(null);

		assertEquals(2, elfe.longueurCapacites());
		assertEquals(attaque, elfe.obtenirCapacite(0));
		assertEquals(defense, elfe.obtenirCapacite(1));
	}
	
	@Test
	public void obtenirCapaciteDefense() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Bouclier defense = BouclierUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		Bouclier bouclier = (Bouclier) elfe.obtenirCapacite(1);

		assertEquals(defense, bouclier);
		assertTrue(elfe.obtenirCapacite(1) instanceof DefenseClasse);
	}
	
	@Test
	public void obtenirCapaciteDefense_IndexTropGrand() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee Riposte = EpeeUsine.CreerCapacite(20);
		Soin soin = SoinUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(Riposte, soin);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		Capacite epee = elfe.obtenirCapacite(50);
		
		assertEquals(null, epee);
	}
	
	@Test
	public void obtenirCapaciteDefense_IndexNegatif() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee Riposte = EpeeUsine.CreerCapacite(20);
		Soin soin = SoinUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(Riposte, soin);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		Capacite epee = elfe.obtenirCapacite(-50);
		
		assertEquals(null, epee);
	}
	
	@Test
	public void obtenirCapaciteAttaque() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Soin soin = SoinUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, soin);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);

		assertEquals(elfe.obtenirCapacite(0), attaque);
		assertTrue(elfe.obtenirCapacite(0) instanceof AttaqueClasse);
	}
	
	@Test
	public void obtenirCapaciteAttaque_IndexTropGrand() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
	ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Soin soin = SoinUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, soin);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		assertEquals(null, elfe.obtenirCapacite(50));
		assertFalse(elfe.obtenirCapacite(50) instanceof AttaqueClasse);
	}
	
	@Test
	public void obtenirCapaciteAttaque_IndexNegatif() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
	ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiqueNull, 
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee attaque = EpeeUsine.CreerCapacite(20);
		Soin soin = SoinUsine.CreerCapacite(20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, soin);
		
		Caracteristique caracteristiqueElfe = CaracteristiqueUsine.CreerCaracteristique("elfe", 20,20,20,20);
		
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristiqueElfe, capacites, TypeCombattant.ELFE);
		
		assertEquals(null, elfe.obtenirCapacite(-50));
		assertFalse(elfe.obtenirCapacite(-50) instanceof AttaqueClasse);
	}
}
