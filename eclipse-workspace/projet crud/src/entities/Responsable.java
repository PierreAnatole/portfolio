package entities;

public class Responsable extends Employe{
	private int prime;
	public static final int REMUNERATION_RESPONSABLE=30;

	@Override
	public double calculeSalaire() {
		if (this.nbHeureMois<160) {
			return prime + (double)(this.nbHeureMois*REMUNERATION_RESPONSABLE);
		}else {
			return prime + (180*REMUNERATION_RESPONSABLE+(this.nbHeureMois-160)*(REMUNERATION_RESPONSABLE*1.20));
		}
	}
	
}
