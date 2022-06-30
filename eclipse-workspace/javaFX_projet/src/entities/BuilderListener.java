package entities;import Exception.NotGeometricShapeException;
import interfaces.Figures;

public class BuilderListener {
	
	public static void lookupInFigures(String f) throws NotGeometricShapeException{
		try {
			Figures.valueOf(f.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new NotGeometricShapeException();
		}
	}
}
