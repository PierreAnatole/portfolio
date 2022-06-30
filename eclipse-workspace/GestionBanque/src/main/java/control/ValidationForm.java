package control;

public class ValidationForm {
	public boolean isValid(String login, String mdp) {
		return (login.equals("login")&&mdp.equals("mdp"));
	}
}
