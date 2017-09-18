package test;

import org.junit.Test;

import Combattant.Caracteristique;
import gestionException.*;
import usine.*;

public class CaracteristiquePersonnageTest {

	@Test(expected = ExceptionNomVide.class)
	public void CaracteristiqueSansNom() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide {

		@SuppressWarnings("unused")
		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("", 30, 20, 0, 0);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void CapaciteAvecForceEtDexteriteNegatif()
			throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide {

		@SuppressWarnings("unused")
		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Excalibur", -20, -20, 60, 60);
	}

	@Test(expected = ExceptionLorsqueCaracteristiquesIncorrectes.class)
	public void CapaciteAvecIntelligenceEtConcentrationNegatif()
			throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide {

		@SuppressWarnings("unused")
		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("Excalibur", 60, 60, -60, -60);
	}
}
