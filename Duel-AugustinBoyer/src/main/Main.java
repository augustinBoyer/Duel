package main;

import java.util.ArrayList;

import Combattant.*;
import capacite.*;
import duel.*;
import gestionException.ExceptionCombattantNull;
import gestionException.ExceptionLorsqueCapaciteInferieureADeuxOuNull;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;
import gestionException.ExceptionLorsqueCaracteristiqueNull;
import gestionException.ExceptionLorsqueCaracteristiquesIncorrectes;
import gestionException.ExceptionNomVide;
import infirmerie.Infirmerie;
import usine.*;

public class Main {

	public static void main(String[] args) throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
			ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull,
			ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		AttaqueMagique attaqueMagique = AttaqueMagiqueUsine.CreerCapacite(48);
		Soin soin = SoinUsine.CreerCapacite(35);
		SoinMagique soinMagique = SoinMagiqueUsine.CreerCapacite(24);
		
		Caracteristique listeElfe = CaracteristiqueUsine.CreerCaracteristique("Gandalf", 20, 20, 25, 30);
		ArrayList<Capacite> capacitesElfe = CapaciteUsine.CreerCapacites(attaqueMagique, soinMagique);
		
		Combattant elfe = CombattantUsine.CreerCombattant(listeElfe, capacitesElfe, TypeCombattant.ELFE);

		Caracteristique listeGuerrier = CaracteristiqueUsine.CreerCaracteristique("Gandalf", 30, 20, 15, 15);
		ArrayList<Capacite> capacitesGuerrier = CapaciteUsine.CreerCapacites(attaqueMagique, soinMagique);
		
		Combattant guerrier = CombattantUsine.CreerCombattant(listeGuerrier, capacitesGuerrier, TypeCombattant.GUERRIER);
		
		Duel combat = DuelUsine.CreerCombat(elfe, guerrier);
		
		Caracteristique listeMagicien = CaracteristiqueUsine.CreerCaracteristique("Gandalf", 5, 10, 35, 45);
		ArrayList<Capacite> capacitesMagicien = CapaciteUsine.CreerCapacites(attaqueMagique, soinMagique);
		
		Combattant mage = CombattantUsine.CreerCombattant(listeMagicien, capacitesMagicien, TypeCombattant.MAGICIEN);
		combat.setIndexAttaque(0);
		combat.setIndexRiposte(0);

		combat.combattre();
		
		guerrier.ajouterCapacite(soinMagique);
		
		Infirmerie.Soigner(guerrier);
		
		elfe.ajouterCapacite(soin);
		
		Infirmerie.Soigner(elfe);
		
		Duel deuxiemeCombat = DuelUsine.CreerCombat(elfe, guerrier);
		deuxiemeCombat.setIndexAttaque(0);
		deuxiemeCombat.setIndexRiposte(1);
		
		deuxiemeCombat.combattre();
		
		Duel troisiemeCombat = DuelUsine.CreerCombat(elfe, mage);
		troisiemeCombat.setIndexAttaque(0);
		troisiemeCombat.setIndexRiposte(1);
		troisiemeCombat.combattre();
		
		troisiemeCombat.setIndexAttaque(0);
		troisiemeCombat.setIndexRiposte(0);
		troisiemeCombat.combattre();
		
		Duel quatriemeCombat = DuelUsine.CreerCombat(mage, guerrier);
		quatriemeCombat.setIndexAttaque(0);
		quatriemeCombat.setIndexRiposte(1);
		quatriemeCombat.combattre();
		
		Duel cinquiemeCombat = DuelUsine.CreerCombat(guerrier, mage);
		cinquiemeCombat.setIndexAttaque(0);
		cinquiemeCombat.setIndexRiposte(1);
		cinquiemeCombat.combattre();
		
		Duel sixiemeCombat = DuelUsine.CreerCombat(elfe, guerrier);
		sixiemeCombat.setIndexAttaque(2);
		sixiemeCombat.setIndexRiposte(0);
		sixiemeCombat.combattre();
	}
}
