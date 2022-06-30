package entities;

public class Caissier extends Employe{
	private int numeroDeCaise;
	public static final int REMUNERATION_CAISSIER=15;
	
	@Override
	public double calculeSalaire() {
		if (this.nbHeureMois<180) {
			return this.nbHeureMois*REMUNERATION_CAISSIER;
		}else {
			return (180*REMUNERATION_CAISSIER+(this.nbHeureMois-180)*(REMUNERATION_CAISSIER*1.15));
		}
	}
}
