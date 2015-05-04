package Entities;

/** VISITEURS
 * 
 * @author KE20
 *
 */
public class Visiteur {

	public static final int OK = 0 ;
	
	private String matric ;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private int etat = OK;
	
	/** Contructeur de création d'un visiteur
	 * 
	 * @param matric = matricule du visiteur
	 * @param nom = nom du visiteur
	 * @param prenom = prenom du visiteur
	 * @param adresse = adresse du visiteur
	 */
	public Visiteur(String matric, String nom, String prenom, String adresse) {
		super();
		this.matric = matric;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	/** Récupération du matricule du visiteur
	 * 
	 * @return matric
	 */
	public String getMatric() {
		return matric;
	}

	/** Modification du matricule du visiteur
	 * 
	 * @param matric
	 */
	public void setMatric(String matric) {
		this.matric = matric;
	}

	/** Récupération du nom du visiteur
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/** Modification du nom du visiteur
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Récupération du prenom du visiteur
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Modification du prenom du visiteur
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Récupération de l'adresse  du visiteur
	 * 
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Modification de l'adresse du visiteur
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/** Récupération de l'état du visiteur
	 * 
	 * @return etat
	 */
	public int getEtat() {
		return etat;
	}
	
	/** Modification de l'état du visiteur
	 * 
	 * @param etat
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}

}
