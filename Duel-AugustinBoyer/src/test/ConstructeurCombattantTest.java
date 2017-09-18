package test;

import java.util.ArrayList;

import org.junit.Test;

import Combattant.*;
import capacite.*;
import gestionException.*;
import usine.*;

public class ConstructeurCombattantTest {

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ObjetConstructeur_ExceptionCaracteristiqueForceA18()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 18, 1, 0, 0);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ObjetConstructeur_ExceptionCaracteristiqueConcentrationA19()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 0, 0, 0, 19);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ObjetConstructeur_ToutesLesCaracteristiquesInferieuresA20()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 4, 5, 5, 5);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void ObjetConstructeur_UneCaracteristiqueA19EtLesAutresA0()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		AttaqueMagique attaque = AttaqueMagiqueUsine.CreerCapacite(20);
		DefenseMagique defense = DefenseMagiqueUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("elfe", 19, 0, 0, 0);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(attaque, defense);

		@SuppressWarnings("unused")
		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.MAGICIEN);
	}
}
