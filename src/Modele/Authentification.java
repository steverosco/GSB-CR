package Modele;

import java.sql.*;

/** Authentification
 * 
 * @author KE20
 *
 */
public class Authentification {
	
	private  static String query ="SELECT VISITEUR.VIS_MATRICULE, VISITEUR.VIS_MDP " +
			"FROM VISITEUR, TRAVAILLER " +
			"WHERE VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE " +
			"AND TRA_ROLE='Délégué' AND TRAVAILLER.VIS_MATRICULE=? AND VIS_MDP=?;";	
	private static ModeleAppliCR modele;
	private static boolean connexionOk = false ;
	private static String matric;
	
	
	/** Authentification
	 * 
	 * @param modele
	 */
	public Authentification(ModeleAppliCR modele) {
		super();
		this.modele = modele;
	}
	
	/** méthode permettant de se connecter à l'application
	 * 
	 * @param login = login de l'utilisateur
	 * @param mdp = mdp de l'utilisateur
	 * @return True si l'authentifiaction est bonne sinon false dans le cas contraire
	 */
	public static boolean seConnecter(String login, String mdp){
		
		try {
			Connection connexion = ConnexionBD.getConnexion() ;
			PreparedStatement pstmt = connexion.prepareStatement(query);
			pstmt.setString(1, login);
			pstmt.setString(2, mdp);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()){
				if(login.equals(result.getString("VIS_MATRICULE")) && mdp.equals(result.getString("VIS_MDP"))){
					connexionOk = true;
					System.out.println("Authentification Ok");
					matric = result.getString("VIS_MATRICULE");
					getModele().getVisiteurs();
					
				}
			}
		}
		catch(Exception e){
			e.getMessage() ;
		}
		return connexionOk ;
	}
	
	/** Recupération du matricule
	 * 
	 * @return Maticule
	 */
	public static String getMatric(){
		return matric;
	}
	
	/** Recupération du modele
	 * 
	 * @return modele
	 */
	public static ModeleAppliCR getModele() {
		return modele;
	}
	
	/** Modification du modele si necessaire
	 * 
	 * @param modele
	 */
	public void setModele(ModeleAppliCR modele) {
		this.modele = modele;
	}
}
