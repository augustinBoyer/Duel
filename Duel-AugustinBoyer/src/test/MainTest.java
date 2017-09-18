package test;

import org.junit.Test;

import gestionException.ExceptionCombattantNull;
import gestionException.ExceptionLorsqueCapaciteInferieureADeuxOuNull;
import gestionException.ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect;
import gestionException.ExceptionLorsqueCaracteristiqueNull;
import gestionException.ExceptionLorsqueCaracteristiquesIncorrectes;
import gestionException.ExceptionNomVide;
import main.Main;

public class MainTest {

	@Test
	public void TesterLeMain() throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide,
			ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull, ExceptionCombattantNull,
			ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		Main main = new Main();

		main.main(null);
	}

}
