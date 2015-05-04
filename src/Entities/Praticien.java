package Entities;

import java.sql.Date;
import java.util.Calendar;

/** PRATICIENS
 * 
 * @author KE20
 *
 */
public class Praticien {

	private int numero;
	private String nom;
	private String prenom;
	private String ville;
	private String adresse;
	private String cp;
	private float coefNotoriete;
	private float coefConf;
	private Date rapDate;
	private CompteRendu compteRendu;

	/** Contructeur de création d'un praticien
	 * 
	 * @param numero = numéro du praticien
	 * @param nom = nom du praticien
	 * @param prenom = prenom du praticien
	 * @param adresse = adresse du praticien
	 * @param ville = ville du praticien
	 * @param cp = code postale du praticien
	 * @param coefNotoriete = coeficient de notoriété du praticien
	 * @param coefConf = coeficient de confiance du praticien
	 * @param rapDate = date du rapport
	 */
	public Praticien(int numero, String nom, String prenom, String adresse,  String ville, String cp, float coefNotoriete, float coefConf, Date rapDate ) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.adresse = adresse;
		this.cp = cp;
		this.coefNotoriete = coefNotoriete;
		this.coefConf = coefConf;
		this.rapDate = rapDate;
	}
	
	/** Contructeur de création d'un praticien
	 * 
	 * @param numero = numéro du praticien
	 * @param nom = nom du praticien
	 * @param prenom = prenom du praticien
	 * @param adresse = adresse du praticien
	 * @param ville = ville du praticien
	 * @param cp = code postale du praticien
	 */
	public Praticien(int numero, String nom, String prenom, String adresse,  String ville, String cp) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.adresse = adresse;
		this.cp = cp;
	}
	 
	/** Contructeur de création d'un praticien
	 * 
	 * @param numero = numéro du praticien
	 * @param nom = nom du praticien
	 * @param prenom = prenom du praticien
	 * @param ville = ville du praticien
	 */
	public Praticien(int numero, String nom, String prenom, String ville) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
	}
	
	/** Contructeur de création d'un praticien
	 * 
	 * @param nom = nom du praticien
	 * @param ville = ville du praticien
	 */
	public Praticien(String nom,String ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}
	
	/** Contructeur de création d'un praticien
	 * 
	 * @param nom = nom du praticien
	 * @param ville = ville du praticien
	 * @param coefNotoriete = coeficient de notoriété du praticien
	 * @param coefConf = coeficient de confiance du praticien
	 * @param rapDate = date du rapport
	 */
	public Praticien(String nom,String ville, float coefNotoriete, float coefConf,Date rapDate) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.coefNotoriete = coefNotoriete;
		this.coefConf = coefConf;
		this.rapDate = rapDate;
	}

	/** Récupération du numéro du praticien
	 * 
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}

	/** Modification du numéro du praticien
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/** Récupération du nom du praticien
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/** Modification du nom du praticien
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Récupération du prenom du praticien
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Modification du prenom du praticien
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/** Récupération de l'adresse du praticien
	 * 
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Modification de l'adresse du praticien
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Récupération de la ville du praticien
	 * 
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}

	/** Modification de la ville du praticien
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/** Récupération du code postale du praticien
	 * 
	 * @return cp
	 */
	public String getCp() {
		return cp;
	}

	/** Modification du code postale du praticien
	 * 
	 * @param cp
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	/** Récupération du coeficient du notoriété du praticien
	 * 
	 * @return coefNotoriete
	 */
	public float getCoefNoto() {
		return coefNotoriete;
	}

	/** Modification du coeficient du notoriété du praticien
	 * 
	 * @param coefNotoriete
	 */
	public void setCoefNoto(float coefNotoriete) {
		this.coefNotoriete = coefNotoriete;
	}
	
	/** Récupération du coeficient de confiance du praticien
	 * 
	 * @return coefConf
	 */
	public float getCoefConf() {
		return coefConf;
	}

	/** Modification du coeficient de confiance du praticien
	 * 
	 * @param coefConf
	 */
	public void setCoefConf(float coefConf) {
		this.coefConf = coefConf;
	}
	
	/** Récupération de la date du rapport
	 * 
	 * @return rapDate
	 */
	public Date getRapDate() {
		return rapDate;
	}

	/** Modification de la date du rapport
	 * 
	 * @param rapDate
	 */
	public void setRapDate(Date rapDate) {
		this.rapDate = rapDate;
	}
	
	/** calcule du tempsen la date d'aujourd'hui et celle de la visite
	 * 
	 * @return le temps écoulé
	 */
	public long getTempsEcoule() {
		Calendar dateToday = Calendar.getInstance();
		long today = dateToday.getTimeInMillis();
		
		Calendar dateRapport = Dates.DateToCalendar(rapDate);
		long rapport = dateRapport.getTimeInMillis();
		
		long tempsEcoule = (((today-rapport) /3600000))/24;
		
		return tempsEcoule ;
	}
}
