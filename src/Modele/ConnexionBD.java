package Modele;

import java.sql.* ;

/** CONNEXION
 * 
 * @author KE20
 *
 */
public class ConnexionBD {
	private static final String dbURL = "jdbc:mysql://localhost:3306/GsbCRSlam1?useUnicode=yes&characterEncoding=UTF-8" ;
	private static final String user = "root" ;
	private static final String password = "azerty" ;
	private static Connection connexion = null ;
	
	/** Connexion à la base de données; chargement du driver
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private ConnexionBD() throws ClassNotFoundException, SQLException {
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
			try{
				connexion = DriverManager.getConnection(dbURL,user,password) ;
				System.out.println("Connexion BDD Ok");
			}
			catch(SQLException e){
				System.out.println("Erreur Connexion BDD" + e.getMessage());
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("Erreur Chargement Driver" + e.getMessage());
		}
	}
	
	/** Récupération de la connexion
	 * 
	 * @return la connexion
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnexion() throws ClassNotFoundException, SQLException{
		if(connexion == null){
			new ConnexionBD() ;
		}
		return connexion ;
	}
}
