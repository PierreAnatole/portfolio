package medical.fr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MedicalApp {

	public MedicalApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Bienvenue dans notre app de gestion médicale : Veuillez sélectionner votre choix : \n"
				+ "Taper 1 si vous voulez consulter tous les patients\n"
				+ "Taper 2 si vous voulez consulter les infos d'un patient particuler\n"
				+ "Taper 3 si vous voulez supprimer un patient\n" + "\n" 
				+ "Taper 4 si vous voulez ajouter un patient\n"
				+ "Taper 5  si vous voulez mettre à jour les infos d'un patient");

		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		int id = 0;

		PatientDAO pdao = new PatientDAO();

		int choix = Integer.parseInt(in.readLine());
		String email, telephone; 

		switch (choix) {

		case 1:
			pdao.getAll();
			break;

		case 2:
			System.out.println("Veuillez spécifier l'id du patient à consulter");
			id = Integer.parseInt(in.readLine());
			pdao.get(id);
			break;

		case 3:
			System.out.println("Veuillez spécifier l'id du patient à supprimer");
			id = Integer.parseInt(in.readLine());

			try {
				System.out.println("Êtes vous sûr ? [o / N]");
				String c = in.readLine();
				System.out.println("Valeur récupérée : " + c);

				if (true || c.trim().equals('o'))
					pdao.remove(id);
				else
					System.out.println("Suppression annulée");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case 4:

			System.out.println("Veuillez saisir le prénom du patient");
			String prenom = in.readLine(); 

			System.out.println("Veuillez saisir le nom du patient");
			String nom = in.readLine(); 

			System.out.println("Veuillez saisir le mail du patient");
			email = in.readLine(); 

			System.out.println("Veuillez saisir le numéro de tél");
			telephone = in.readLine(); 
			
			pdao.createPatient( prenom, nom, email, telephone ); 

			break;

		case 5:

			System.out.println("Veuillez spécifier l'id du patient à mettre à jour");
			id = Integer.parseInt(in.readLine());
			
			System.out.println("Veuillez saisir le mail du patient");
			email = in.readLine(); 

			System.out.println("Veuillez saisir le numéro de tél");
			telephone = in.readLine(); 
			
			pdao.updatePatient( id,email, telephone ); 

			break;
			
		default:
			System.out.println("Choix incorrect");
			break;
		}

		/*
		 * Patient p = new Patient(); BufferedReader in; in = new BufferedReader (new
		 * InputStreamReader(System.in));
		 * 
		 * System.out.println( "Veuillez saisir le prénom du patient" ) ; p.setPrenom(
		 * in.readLine() );
		 * 
		 * System.out.println( "Veuillez saisir le nom du patient" ) ; p.setNom(
		 * in.readLine() );
		 * 
		 * System.out.println( "Veuillez saisir le mail du patient" ) ; p.setEmail(
		 * in.readLine() );
		 * 
		 * System.out.println( "Veuillez saisir le numéro de tél" ) ; p.setTelephone(
		 * in.readLine() );
		 * 
		 * System.out.println( p );
		 */
	}

}
