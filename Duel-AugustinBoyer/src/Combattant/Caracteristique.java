package Combattant;

import gestionException.*;

public class Caracteristique {

	private final static int MINIMUM_CARACTERISTIQUE = 0;
	private final static int MINIMUM_CARACTERISTIQUE_POSSIBLE = 20;
	private final static int MAXIMUM_CARACTERISTIQUE_POSSIBLE = 100;

	private int dexterite;
	private int force;
	private int intelligence;
	private int concentration;
	private String nom;

	public Caracteristique(String nom, int force, int dexterite, int intelligence, int concentration)
			throws ExceptionNomVide, ExceptionLorsqueCaracteristiquesIncorrectes {
		this.setConcentration(concentration);
		this.setDexterite(dexterite);
		this.setForce(force);
		this.setIntelligence(intelligence);
		this.setNom(nom);

		this.VerificationRespectCaracteristique(this.getForce(), this.getDexterite(), this.getIntelligence(),
				this.getConcentration());
	}

	public int getDexterite() {
		return this.dexterite;
	}

	public void setDexterite(int dexterite) {
		this.dexterite = this.VerifierCaracteristiqueJamaisNegatif(dexterite);
	}

	public int getIntelligence() {
		return this.intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = this.VerifierCaracteristiqueJamaisNegatif(intelligence);
	}

	public int getConcentration() {
		return this.concentration;
	}

	public void setConcentration(int concentration) {
		this.concentration = this.VerifierCaracteristiqueJamaisNegatif(concentration);
	}

	public int getForce() {
		return this.force;
	}

	public void setForce(int force) {
		this.force = this.VerifierCaracteristiqueJamaisNegatif(force);
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) throws ExceptionNomVide {
		if (nom == "") {
			throw new ExceptionNomVide();
		}
		this.nom = nom;
	}

	public void VerificationRespectCaracteristique(int force, int dexterite, int intelligence, int concentration)
			throws ExceptionLorsqueCaracteristiquesIncorrectes {

		if (force + dexterite + intelligence + concentration > this.MAXIMUM_CARACTERISTIQUE_POSSIBLE) {
			throw new ExceptionLorsqueCaracteristiquesIncorrectes(
					"Le total des caracteristiques dépasse " + this.MAXIMUM_CARACTERISTIQUE_POSSIBLE);
		}

		if (force + dexterite + intelligence + concentration < this.MINIMUM_CARACTERISTIQUE_POSSIBLE) {
			throw new ExceptionLorsqueCaracteristiquesIncorrectes(
					"Le total des caracteristiques est en dessous de " + this.MINIMUM_CARACTERISTIQUE_POSSIBLE);
		}
	}

	private int VerifierCaracteristiqueJamaisNegatif(int caracteristique) {
		if (caracteristique < this.MINIMUM_CARACTERISTIQUE) {
			caracteristique = this.MINIMUM_CARACTERISTIQUE;
		}
		return caracteristique;
	}

	public void MettreAJourCaracteristiqueApresCombat(int miseAJour) {
		this.setDexterite(this.AjouterCaracteristiqueAMiseAJour(this.getDexterite(), miseAJour));

		this.setConcentration(this.AjouterCaracteristiqueAMiseAJour(this.getConcentration(), miseAJour));
		this.setForce(this.AjouterCaracteristiqueAMiseAJour(this.getForce(), miseAJour));
		this.setIntelligence(this.AjouterCaracteristiqueAMiseAJour(this.getIntelligence(), miseAJour));
	}
	
	public int AjouterCaracteristiqueAMiseAJour(int valeurCaracteristique, int miseAJour){
		return valeurCaracteristique + miseAJour;
	}
}
