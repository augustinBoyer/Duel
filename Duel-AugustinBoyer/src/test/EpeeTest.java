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

public class EpeeTest {

	@Test
	public void ObjetConstructeur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		Epee epee = EpeeUsine.CreerCapacite(20);

		assertEquals(20, epee.getImpact());
		assertTrue(epee instanceof Epee);
		assertEquals(TypeCapacite.EPEE, epee.getTypeCapacite());
	}

	@Test
	public void ObtenirPointCombat() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {

		Epee epee = EpeeUsine.CreerCapacite(20);
		Epee autreEpee = EpeeUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 40, 20, 20, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, autreEpee);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		ELFE.obtenirCapacite(0);

		assertEquals(8, epee.puissanceCombat(ELFE));
		assertEquals(20, autreEpee.puissanceCombat(ELFE));
	}

	@Test
	public void ObtenirPointCombat_CombattantNePossedePaslaCapacite()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		Epee defense = EpeeUsine.CreerCapacite(20);
		Epee autreEpee = EpeeUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(defense, defense);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreEpee.puissanceCombat(ELFE));
	}

	@Test
	public void ObtenirPointCombatQuePersonnageNePossedePas() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee epee = EpeeUsine.CreerCapacite(20);
		Epee autreEpee = EpeeUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, epee);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(0, autreEpee.puissanceCombat(ELFE));
	}

	@Test
	public void ObtenirPointCombatPotentiel() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect,
			ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull,
			ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull {
		Epee epee = EpeeUsine.CreerCapacite(20);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, epee);

		Combattant ELFE = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(5, epee.obtenirPuissancePotentielle(ELFE));
	}

	@Test
	public void ObtenirPointCombatPotentielQuePersonnageNePossedePas()
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect, ExceptionLorsqueCaracteristiquesIncorrectes,
			ExceptionNomVide, ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull,
			ExceptionCombattantNull {
		Epee epee = EpeeUsine.CreerCapacite(20);
		Epee autreEpee = EpeeUsine.CreerCapacite(50);

		Caracteristique caracteristique = CaracteristiqueUsine.CreerCaracteristique("ELFE", 25, 20, 30, 20);

		ArrayList<Capacite> capacites = CapaciteUsine.CreerCapacites(epee, epee);

		Combattant elfe = CombattantUsine.CreerCombattant(caracteristique, capacites, TypeCombattant.ELFE);

		assertEquals(12, autreEpee.obtenirPuissancePotentielle(elfe));
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void EpeeTropPuissant() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		@SuppressWarnings("unused")
		Epee epee = EpeeUsine.CreerCapacite(101);
	}

	@Test(expected = ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect.class)
	public void EpeePasAssezPuissant() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		@SuppressWarnings("unused")
		Epee epee = EpeeUsine.CreerCapacite(19);
	}
}
