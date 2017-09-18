package Combattant;

import java.util.ArrayList;

import capacite.*;
import gestionException.*;
import usine.PointsDeVieUsine;

public abstract class Combattant {

	private Caracteristique caracteristique;
	private Boolean capituler;
	private ArrayList<Capacite> capacites;
	private PointsDeVie pointsDeVie;

	protected Combattant(Caracteristique caracteristique, ArrayList<Capacite> capacites)
			throws ExceptionLorsqueCaracteristiqueNull, ExceptionLorsqueCapaciteInferieureADeuxOuNull {

		if (caracteristique == null) {
			throw new ExceptionLorsqueCaracteristiqueNull();
		}
		if (capacites == null) {
			throw new ExceptionLorsqueCapaciteInferieureADeuxOuNull();
		} else if (this.verifierPremierNombreInferieurDeuxiemeNombre(capacites.size(), 2)) {
			throw new ExceptionLorsqueCapaciteInferieureADeuxOuNull();
		}

		this.setCapituler(false);

		this.setCaracteristique(caracteristique);

		this.calculPointDeVieInitial(caracteristique);

		this.setCapacites(capacites);
	}

	public Caracteristique getCaracteristique() {
		return this.caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public int getForce() {
		return this.getCaracteristique().getForce();
	}

	public void setForce(int force) {
		this.getCaracteristique().setForce(force);
	}

	public int getIntelligence() {
		return this.getCaracteristique().getIntelligence();
	}

	public void setIntelligence(int intelligence) {
		this.getCaracteristique().setIntelligence(intelligence);
	}

	public int getDexterite() {
		return this.getCaracteristique().getDexterite();
	}

	public void setDexterite(int dexterite) {
		this.getCaracteristique().setDexterite(dexterite);
	}

	public int getConcentration() {
		return this.getCaracteristique().getConcentration();
	}

	public void setConcentration(int concentration) {
		this.getCaracteristique().setConcentration(concentration);
	}

	public String getNom() {
		return this.getCaracteristique().getNom();
	}

	public void setNom(String nom) throws ExceptionNomVide {
		this.getCaracteristique().setNom(nom);
	}

	public ArrayList<Capacite> getCapacites() {
		return this.capacites;
	}

	public void setCapacites(ArrayList<Capacite> Capacites) {
		this.capacites = Capacites;
	}

	public Boolean getCapituler() {
		return this.capituler;
	}

	public void setCapituler(Boolean capituler) {
		this.capituler = capituler;
	}

	public int getPointsDeVie() {
		return this.ObtenirPointsDeVie().getPointsDeVie();
	}

	public void setPointsDeVie(int pointsDeVie) {
		this.ObtenirPointsDeVie().setPointsDeVie(pointsDeVie);
	}

	private PointsDeVie ObtenirPointsDeVie() {
		return this.pointsDeVie;
	}

	protected void calculPointDeVieInitial(Caracteristique caracteristique) {
		this.pointsDeVie = PointsDeVieUsine.CreerPointsDeVie(PointsDeVie.MAXIMUM_POINTS_DE_VIE -
				(caracteristique.getForce() + caracteristique.getDexterite() + caracteristique.getIntelligence() + caracteristique.getConcentration()));
	}

	public void choisirMeilleurBonusPourLeVainqueur(ArrayList<Capacite> bonus) {
		ChoixMeilleurBonusPourLeVainqueur choix = new ChoixMeilleurBonusPourLeVainqueur(this);

		this.ajouterCapacite(choix.choisirLeMeilleurBonusPourLeVainqueur(bonus));
	}

	public int riposter(int index) {
		int point = 0;
		if (this.utiliserUneCapaciteRiposte(index)) {
			point = this.CalculerPuissance(index);
		}
		return point;
	}

	public int attaquer(int index) {
		int point = 0;
		if (this.utiliserUneCapaciteAttaque(index)) {
			point = this.CalculerPuissance(index);
		}
		return point;
	}
	
	public int CalculerPuissance(int index){
		return ((Riposter) this.obtenirCapacite(index)).puissanceCombat(this);
	}

	public Capacite obtenirCapacite(int index) {
		Capacite capacite = null;
		if (this.verifierPremierNombreInferieurDeuxiemeNombre(index, this.longueurCapacites()) && 
				!this.verifierPremierNombreInferieurDeuxiemeNombre(index, 0)) {
			capacite = this.getCapacites().get(index);
		}
		return capacite;
	}

	public void supprimerCapacite(Capacite capacite) {
		if (this.possederCapacite(capacite)) {
			this.getCapacites().remove(capacite);
		}
	}

	public Boolean possederCapacite(Capacite capacite) {
		return this.getCapacites().contains(capacite);
	}

	public TypeCapacite obtenirTypeCapacite(int index) {
		return this.obtenirCapacite(index).getTypeCapacite();
	}

	public void ajouterCapacite(Capacite capacite) {
		if (capacite != null) {
			this.getCapacites().add(capacite);
		}
	}

	public int longueurCapacites() {
		return this.getCapacites().size();
	}

	public void mettreAJourPointsDeVie(int miseAJour) {
		this.ObtenirPointsDeVie().mettreAJourPointsDeVieApresCombat(miseAJour);
	}

	public void mettreAJourCaracteristique(int miseAJour) {
		this.getCaracteristique().MettreAJourCaracteristiqueApresCombat(miseAJour);
	}

	public Boolean utiliserUneCapaciteAttaque(int index) {
		return this.obtenirCapacite(index) instanceof AttaqueClasse;
	}

	public Boolean utiliserUneCapaciteRiposte(int index) {
		return this.obtenirCapacite(index) instanceof Riposter;
	}
	
	public static Boolean verifierPremierNombreInferieurDeuxiemeNombre(int premierNombre, int deuxiemeNombre){
		return premierNombre < deuxiemeNombre;
	}
}
