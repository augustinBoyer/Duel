package usine;

import java.util.ArrayList;

import capacite.*;
import gestionException.*;

public abstract class CapaciteUsine {

	public static ArrayList<Capacite> CreerCapacites(Capacite premiereCapacite, Capacite deuxiemeCapacite)
			throws ExceptionLorsqueCaracteristiquesIncorrectes, ExceptionNomVide {

		ArrayList<Capacite> capacites = new ArrayList<Capacite>();
		capacites.add(premiereCapacite);
		capacites.add(deuxiemeCapacite);

		return capacites;
	}
}
