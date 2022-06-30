package Exception;

public class NotGeometricShapeException extends Exception{
	
	@Override
	public String getMessage() {
		return "Ce n'est pas une forme geométrique.";
	}
	
}
