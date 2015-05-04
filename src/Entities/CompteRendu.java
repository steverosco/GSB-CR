package Entities;

import java.sql.Date;

import Modele.ModeleAppliCR;

/** COMPTE RENDUS
 * 
 * @author KE20
 *
 */
public class CompteRendu {

	public static final int NON_LU = 0 ;
	public static final int LU = 1 ;
	private int etat;
	
	private static ModeleAppliCR modele;
	private String visiteur;
	private int RapNum;
	private String PraNum;
	private Date RapDate;
	private Date DateVisite;
	private String RapBilan;
	private String RapMotif;
	private float CoefConfiance;
	
	/** Contructeur de création d'un compte rendu
	 * 
	 * @param visiteur = maticule du visiteur
	 * @param RapNum = numéro du rapport
	 * @param PraNum = numéro du praticien
	 * @param RapDate = date de redaction d'un compte rendu
	 * @param DateVisite = date de la visite
	 * @param RapBilan = bian du rapport
	 * @param RapMotif = motif du rapport
	 * @param etat = etat du rapport ( 0 = non lu ; 1 = lu)
	 * @param CoefConfiance = coeficent de confiance du praticien visité
	 */
	public CompteRendu (String visiteur, int RapNum, String PraNum, Date RapDate, Date DateVisite, String RapBilan, String RapMotif,int etat, float CoefConfiance){
		super();
		this.visiteur = visiteur;
		this.RapNum = RapNum;
		this.PraNum = PraNum;
		this.RapDate = RapDate;
		this.DateVisite = DateVisite;
		this.RapBilan = RapBilan;
		this.RapMotif = RapMotif;
		this.etat = etat;
		this.CoefConfiance = CoefConfiance;
	}
	
	/** Contructeur de création d'un compte rendu
	 * 
	 * @param visiteur = maticule du visiteur
	 * @param RapNum = numéro du rapport
	 * @param PraNum = numéro du praticien
	 * @param RapDate = date de redaction d'un compte rendu
	 * @param RapBilan = bian du rapport
	 * @param RapMotif = motif du rapport
	 * @param etat = etat du rapport ( 0 = non lu ; 1 = lu)
	 * @param CoefConfiance = coeficent de confiance du praticien visité
	 */
	public CompteRendu (String visiteur, int RapNum, String PraNum, Date RapDate, String RapBilan, String RapMotif, int etat, float CoefConfiance){
		super();
		this.visiteur = visiteur;
		this.RapNum = RapNum;
		this.PraNum = PraNum;
		this.RapDate = RapDate;
		this.RapBilan = RapBilan;
		this.RapMotif = RapMotif;
		this.CoefConfiance = CoefConfiance;
	}
	
	/** Contructeur de création d'un compte rendu
	 * 
	 * @param RapNum = numéro du rapport
	 * @param PraNum = numéro du praticien
	 * @param RapDate = date de redaction d'un compte rendu
	 * @param DateVisite = date de la visite
	 * @param RapBilan = bian du rapport
	 * @param RapMotif = motif du rapport
	 * @param CoefConfiance = coeficent de confiance du praticien visité
	 */
	public CompteRendu (int RapNum, String PraNum, Date RapDate, Date DateVisite, String RapBilan, String RapMotif, float CoefConfiance){
		super();
		this.RapNum = RapNum;
		this.PraNum = PraNum;
		this.RapDate = RapDate;
		this.DateVisite = DateVisite;
		this.RapBilan = RapBilan;
		this.RapMotif = RapMotif;
		this.CoefConfiance = CoefConfiance;
	}
	
	/** Contructeur de création d'un compte rendu
	 * 
	 * @param visiteur = maticule du visiteur
	 * @param RapNum = numéro du rapport
	 * @param PraNum = numéro du praticien
	 * @param RapDate = date de redaction d'un compte rendu
	 * @param RapMotif = motif du rapport
	 * @param etat = etat du rapport ( 0 = non lu ; 1 = lu)
	 * @param CoefConfiance = coeficent de confiance du praticien visité
	 */
	public CompteRendu (String visiteur, int RapNum, String PraNum, Date RapDate, String RapMotif, int etat, float CoefConfiance){
		super();
		this.visiteur = visiteur;
		this.RapNum = RapNum;
		this.PraNum = PraNum;
		this.RapDate = RapDate;
		this.RapMotif = RapMotif;
		this.CoefConfiance = CoefConfiance;
	}
	
	/** Récupération du matricule du visiteur
	 * 
	 * @return matricule du visiteur
	 */
	public String getVis() {
		return visiteur;
	}

	/** modification du matricule du visiteur si necessaire
	 * 
	 * @param visiteur
	 */
	public void setVis(String visiteur) {
		this.visiteur = visiteur;
	}
	
	/** Récupération du numéro du rapport
	 * 
	 * @return numéro du rapport
	 */
	public int getRapNum() {
		return RapNum;
	}

	/** modification du numéro du rapport si necessaire
	 * 
	 * @param rapNum
	 */
	public void setRapNum(int rapNum) {
		RapNum = rapNum;
	}

	/** Récupération du numéro du praticien
	 * 
	 * @return numéro du praticien
	 */
	public String getPraNum() {
		return PraNum;
	}

	/** modification du numéro du praticien si necessaire
	 * 
	 * @param praNum
	 */
	public void setPraNum(String praNum) {
		PraNum = praNum;
	}

	/** Récupération de la date de rédaction
	 * 
	 * @return date de rédaction
	 */
	public Date getRapDate() {
		return RapDate;
	}

	/** modification de la date de rédaction si necessaire
	 * 
	 * @param rapDate
	 */
	public void setRapDate(Date rapDate) {
		RapDate = rapDate;
	}
	
	/** Récupération de la date de visite
	 * 
	 * @return date de visite
	 */
	public Date getDateVisite() {
		return DateVisite;
	}

	/** modification de la date de visite si necessaire
	 * 
	 * @param dateVisite
	 */
	public void setDateVisite(Date dateVisite) {
		DateVisite = dateVisite;
	}

	/** Récupération du bilan du rapport
	 * 
	 * @return bilan du rapport
	 */
	public String getRapBilan() {
		return RapBilan;
	}

	/** modification du bilan du rapport si necessaire
	 * 
	 * @param rapBilan
	 */
	public void setRapBilan(String rapBilan) {
		RapBilan = rapBilan;
	}

	/** Récupération du motif du rapport
	 * 
	 * @return motif du rapport
	 */
	public String getRapMotif() {
		return RapMotif;
	}

	/** modification du motif du rapport si necessaire
	 * 
	 * @param rapMotif
	 */
	public void setRapMotif(String rapMotif) {
		RapMotif = rapMotif;
	}

	/** Récupération du coeficient de confiance d'un praticien
	 * 
	 * @return coeficient de confiance d'un praticien
	 */
	public float getCoefConfiance() {
		return CoefConfiance;
	}

	/** modification du coeficient de confiance du praticien si necessaire
	 * 
	 * @param coefConfiance
	 */
	public void setCoefConfiance(float coefConfiance) {
		CoefConfiance = coefConfiance;
	}
	
	/** Indique si un rapport est non lu
	 * 
	 * @return true si le rapport non lu et false dans le cas contraire
	 */
	public boolean estNonLu(){
		if(this.etat == NON_LU){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** Indique si un rapport est lu
	 * 
	 * @return true si le rapport est lu et false dans le cas contraire
	 */
	public boolean estLU(){
		if(this.etat == LU){
			return true ;
		}
		else {
			return false ;
		}
	}

	/** Récupération de l'état du rapport ( 0 = non lu ; 1 = lu)
	 * 
	 * @return état du rapport ( 0 = non lu ; 1 = lu)
	 */
	public int getEtat() {
		return etat;
	}
}
