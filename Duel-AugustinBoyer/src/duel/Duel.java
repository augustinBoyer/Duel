package duel;

import Combattant.*;
import gestionException.*;

public class Duel {

	private final static int POINT_VICTOIRE_GAGNANT = 1;
	private final static int POINT_DEFAITE_PERDANT = -1;

	private Combattant personnageAttaque;
	private Combattant personnageRiposte;

	private int comparaisonPuissance;

	private int indexRiposte;
	private int indexAttaque;

	public Duel(Combattant personnageAttaque, Combattant personnageRiposte) throws ExceptionCombattantNull {

		if (personnageAttaque == null || personnageRiposte == null) {
			throw new ExceptionCombattantNull("Le combattant ne peut être null");
		}
		this.setPersonnageAttaque(personnageAttaque);
		this.setPersonnageRiposte(personnageRiposte);
		this.setComparaisonPuissance(1);
	}

	public Combattant getPersonnageAttaque() {
		return this.personnageAttaque;
	}

	public void setPersonnageAttaque(Combattant personnage) {
		this.personnageAttaque = personnage;
	}

	public Combattant getPersonnageRiposte() {
		return this.personnageRiposte;
	}

	public void setPersonnageRiposte(Combattant personnage) {
		this.personnageRiposte = personnage;
	}

	private int getIndexRiposte() {
		return this.indexRiposte;
	}

	public void setIndexRiposte(int indexRiposte) {
		this.indexRiposte = indexRiposte;
	}

	private int getIndexAttaque() {
		return this.indexAttaque;
	}

	public void setIndexAttaque(int indexAttaque) {
		this.indexAttaque = indexAttaque;
	}

	private int getComparaisonPuissance() {
		return this.comparaisonPuissance;
	}

	private void setComparaisonPuissance(int comparaisonPuissance) {
		this.comparaisonPuissance = comparaisonPuissance;
	}

	public void combattre() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {

		if (peutDebuterCombat()) {
			this.debuterCombat();
			this.attribuerRecompense();
		}
	}

	private void debuterCombat() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		if (!this.deuxiemeCombattantCapitule()) {
			this.calculerDifferencePuissance();
			this.pertePointsDeVie();
		}
	}

	private Boolean deuxiemeCombattantCapitule() {
		return this.getPersonnageRiposte().getCapituler();
	}

	private Boolean peutDebuterCombat() {
		return this.getPersonnageAttaque().utiliserUneCapaciteAttaque(this.getIndexAttaque())
				&& this.getPersonnageRiposte().utiliserUneCapaciteRiposte(this.getIndexRiposte())
				&& this.getPersonnageAttaque().getCaracteristique() != this.getPersonnageRiposte().getCaracteristique()
				&& this.getPersonnageAttaque().getCapacites() != this.getPersonnageRiposte().getCapacites();
	}

	private void pertePointsDeVie() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		this.trouverVaincu().mettreAJourPointsDeVie(Math.abs(this.getComparaisonPuissance()));
	}

	private void calculerDifferencePuissance() {
		this.setComparaisonPuissance(this.getPersonnageAttaque().attaquer(this.getIndexAttaque())
				- this.getPersonnageRiposte().riposter(this.getIndexRiposte()));
	}

	private void attribuerRecompense() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		if (!this.estUnCombatNul()) {
			this.trouverVaincu().mettreAJourCaracteristique(POINT_DEFAITE_PERDANT);
			this.trouverVainqueur().mettreAJourCaracteristique(POINT_VICTOIRE_GAGNANT);
			AttribuerRecompenseAuVainqueur.RecompenserVainqueur(this.trouverVainqueur());
		}
	}

	private Combattant trouverVainqueur() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return this.trouverCombattant(this.comparaisonPuissanceEstPositive());
	}

	private Combattant trouverVaincu() throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		return this.trouverCombattant(!this.comparaisonPuissanceEstPositive());
	}

	private Combattant trouverCombattant(Boolean estVainqueur)
			throws ExceptionLorsqueCaracteristiqueDeCapaciteIncorrect {
		if (estVainqueur) {
			return this.getPersonnageAttaque();
		} else {
			return this.getPersonnageRiposte();
		}
	}

	private Boolean comparaisonPuissanceEstPositive() {
		return Combattant.verifierPremierNombreInferieurDeuxiemeNombre(0, this.getComparaisonPuissance());
	}

	private Boolean estUnCombatNul() {
		return this.getComparaisonPuissance() == 0;
	}
}
