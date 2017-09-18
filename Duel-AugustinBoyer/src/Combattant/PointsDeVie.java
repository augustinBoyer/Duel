package Combattant;

public class PointsDeVie {

	public final static int MAXIMUM_POINTS_DE_VIE = 200;
	public final static int MINIMUM_POINTS_DE_VIE = 0;

	int pointsDeVie;

	public PointsDeVie(int pointsDeVie) {
		this.verifierValiditePointsDeVie(pointsDeVie);
	}

	public int getPointsDeVie() {
		return this.pointsDeVie;
	}

	public void setPointsDeVie(int pointsDeVie) {
		this.verifierValiditePointsDeVie(pointsDeVie);
	}

	private void verifierValiditePointsDeVie(int nombre) {
		if (Combattant.verifierPremierNombreInferieurDeuxiemeNombre(nombre, this.MINIMUM_POINTS_DE_VIE)) {
			this.pointsDeVie = this.MINIMUM_POINTS_DE_VIE;
		} else if (!Combattant.verifierPremierNombreInferieurDeuxiemeNombre(nombre, this.MAXIMUM_POINTS_DE_VIE)) {
			this.pointsDeVie = this.MAXIMUM_POINTS_DE_VIE;
		} else {
			this.pointsDeVie = nombre;
		}
	}

	public void mettreAJourPointsDeVieApresCombat(int miseAJour) {
		this.setPointsDeVie(this.getPointsDeVie() - miseAJour);
	}
}
