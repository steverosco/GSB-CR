package Modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

import Entities.CompteRendu;
import Entities.Praticien;
import Entities.Visiteur;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/** Modele de l'application
 * 
 * @author KE20
 *
 */
public class ModeleAppliCR {
	
	public ModeleAppliCR(){
		super() ;
	}
	
	private List<Visiteur> visiteurs = new ArrayList<Visiteur>() ;
	private ResultSet result;
	private static Connection connexion = null ;
	private ResultSet resultat = null ;
	private PreparedStatement pstmt = null;
	private CompteRendu compteRenduSelected = null;
	
	/** Récupération de liste des visiteurs de la region du délégué
	 * 
	 * @return liste des visiteurs
	 */
	public List<Visiteur> getVisiteurs(){
		String queryVis = "SELECT VISITEUR.VIS_MATRICULE, VISITEUR.VIS_NOM, VISITEUR.VIS_PRENOM, VISITEUR.VIS_ADRESSE FROM VISITEUR,TRAVAILLER WHERE TRAVAILLER.VIS_MATRICULE = VISITEUR.VIS_MATRICULE AND TRA_ROLE='Visiteur' AND TRAVAILLER.REG_CODE = (SELECT REGION.REG_CODE FROM REGION, TRAVAILLER WHERE REGION.REG_CODE = TRAVAILLER.REG_CODE AND TRAVAILLER.VIS_MATRICULE = ? AND TRAVAILLER.TRA_ROLE='Délégué') ";
		try {
			 connexion = ConnexionBD.getConnexion() ;
			 String matricule = Authentification.getMatric();
			 PreparedStatement pstmt =  (PreparedStatement) connexion.prepareStatement(queryVis);
			 pstmt.setString(1,matricule);
			 resultat = pstmt.executeQuery();
			 while (resultat.next()) {
				 String numero = resultat.getString("VIS_MATRICULE");
				 String nom = resultat.getString("VIS_NOM") ;
				 String prenom = resultat.getString("VIS_PRENOM") ;
				 String adresse = resultat.getString("VIS_ADRESSE");
				 this.visiteurs.add(new Visiteur(numero,nom,prenom,adresse)) ;
			 }
		 }
		 catch (Exception ex) {
			 System.err.println(ex.getMessage());
		}
		return visiteurs ;
	}

	/** Récupération de la liste des praticiens hésitants qui ont un coeficient de confiance en dessous de 3 sur 5
	 * 
	 * @return liste des praticiens hésitants
	 */
	List<Praticien> praticiensHesitants = new ArrayList<Praticien>() ;
	public List<Praticien> getPraticiensHesitants(){
		String queryPraHes = "SELECT PRATICIEN.PRA_NOM, PRATICIEN.PRA_VILLE, RAPPORT_VISITE.COEF_CONFIANCE, PRATICIEN.PRA_COEFNOTORIETE, RAPPORT_VISITE.RAP_DATE "
				+ "FROM PRATICIEN, RAPPORT_VISITE " +
				"WHERE PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM " +
				"AND RAPPORT_VISITE.COEF_CONFIANCE < 3";
		 try {
			 connexion = ConnexionBD.getConnexion() ;
			 Statement stmt =  (Statement) connexion.prepareStatement(queryPraHes);
			 resultat = stmt.executeQuery(queryPraHes);
			 while (resultat.next()) {
				 String nom = resultat.getString("PRA_NOM");
				 String ville = resultat.getString("PRA_VILLE");
				 float CoefConf = resultat.getFloat("COEF_CONFIANCE");
				 float coefNoto = resultat.getFloat("PRA_COEFNOTORIETE");
				 Date rapDate = resultat.getDate("RAP_DATE");
				 this.praticiensHesitants.add(new Praticien(nom,ville,CoefConf,coefNoto,rapDate)) ;
			 }
		 }
		 catch (Exception ex) {
			 System.err.println(ex.getMessage());
		}
		return this.praticiensHesitants ;
	}

	/** Rechercher un collaborateur
	 * 
	 * @param visMatricule Matricule du collaborateur à rechercher
	 * @return Le collaborateur recherché
	 */
	public Visiteur rechercherCollabo(String visMatricule){
		Visiteur vis = null;
		for(Visiteur unVis : visiteurs){
			if(visMatricule == unVis.getMatric()){
				vis = unVis;
			}
		}
		return vis;
	}
	
	/** Rechercher un compte-rendu
	 * 
	 * @param visMatricule Matricule du visiteur
	 * @param NumCR Numéro du compte-rendu 
	 */
	public void rechercherCR(String visMatricule, int NumCR){
		for(CompteRendu unCompteRendu : compteRendu){
			if(visMatricule == unCompteRendu.getVis() && NumCR == unCompteRendu.getRapNum()){
				this.compteRenduSelected  = unCompteRendu;
			}
		}
	}
	
	/** Récupération de la liste des compte rendus
	 * 
	 * @return liste des Rapports
	 */
	private List<CompteRendu> compteRendu ;
	public List<CompteRendu> getCompteRendu(String mois, String annee, String visMatricule){
		compteRendu = new ArrayList<CompteRendu>() ;
		String queryCR = "SELECT RAP_NUM, RAPPORT_VISITE.PRA_NUM, RAP_DATE, DATE_VISITE, RAP_BILAN, RAP_MOTIF, RAP_ETAT, COEF_CONFIANCE FROM (RAPPORT_VISITE INNER JOIN PRATICIEN ON RAPPORT_VISITE.PRA_NUM = PRATICIEN.PRA_NUM) INNER JOIN VISITEUR ON RAPPORT_VISITE.VIS_MATRICULE = VISITEUR.VIS_MATRICULE WHERE RAPPORT_VISITE.VIS_MATRICULE = ? AND YEAR(RAP_DATE)=? AND MONTH(RAP_DATE)=?  ;";
		int moisInt = Integer.parseInt(mois);
		int anneeInt = Integer.parseInt(annee);
		 try {
			 connexion = ConnexionBD.getConnexion() ;
			 PreparedStatement pstmt =  (PreparedStatement) connexion.prepareStatement(queryCR);
			 pstmt.setString(1,visMatricule);
			 pstmt.setInt(2,anneeInt);
			 pstmt.setInt(3,moisInt);
			 resultat = pstmt.executeQuery();
			 try{
				 while (resultat.next()) {
					 this.compteRendu.add(new CompteRendu(visMatricule,resultat.getInt("RAP_NUM"),resultat.getString("PRA_NUM"),resultat.getDate("RAP_DATE"),resultat.getDate("DATE_VISITE"),resultat.getString("RAP_BILAN"),resultat.getString("RAP_MOTIF"),resultat.getInt("RAP_ETAT"),resultat.getFloat("COEF_CONFIANCE"))) ;
				 }
			 }
			 catch(Exception e){
				 System.err.println(e.getMessage());
				}
			 }
			 catch (Exception ex) {
				 System.err.println(ex.getMessage());
			}
		return compteRendu ;
	}
	
	/** Récupération du Rapport selectionné
	 * 
	 * @return Rapport selectionné
	 */
	public List<CompteRendu> getCompteRendusDunVisiteur(){
		return  compteRendu;
	}
	
	/** Retourne le compte-rendu sélectionné
	 * @return Le contre-rendu sélectionné
	 */
	public CompteRendu getContreRenduSelected() {
	return compteRenduSelected ;
	}
	
	/** Passer un rapport en mode LU
	 * 
	 * @param numRap
	 */
	public void setRapLu(int numRap){
		String querySetRapLu ="UPDATE RAPPORT_VISITE SET RAP_ETAT = 1 WHERE RAP_NUM = ?;";
		try {
			 connexion = ConnexionBD.getConnexion() ;
			 PreparedStatement pstmt =  (PreparedStatement) connexion.prepareStatement(querySetRapLu);
			 pstmt.setInt(1,numRap);
			 pstmt.executeUpdate();
		}
		catch(Exception ex) {
			 System.err.println(ex.getMessage());
		}
	}
	
	/** Modifier le compte-rendu séléctionné
	 * @param contreRenduSelected Le compte-rendu à définir
	 */
	public void setContreRenduSelected(CompteRendu compteRenduSelected) {
		this.compteRenduSelected = compteRenduSelected;
	}
}
