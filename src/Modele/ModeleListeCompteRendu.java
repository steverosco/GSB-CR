package Modele;

import java.sql.Date;

import javax.swing.*;
import javax.swing.table.*;

import Controleur.Controleur;
import Entities.CompteRendu;

/** modele de la liste des compte rendus
 * 
 * @author KE20
 *
 */
public class ModeleListeCompteRendu extends AbstractTableModel{
	private Controleur controleur ;
	private static final long serialVersionUID = 1L;
	private java.util.List<CompteRendu> compteRendus  ;
	private final String[] entetes = {"numero du rapport","numero du praticien","Date de Redaction","Date de Visite","Etat","Afficher le Rapport" };
	private ModeleAppliCR modele ;
	
	public ModeleListeCompteRendu(ModeleAppliCR modele, Controleur controleur){
		super() ;
		this.modele = modele ;
		this.controleur = controleur;
		compteRendus = this.modele.getCompteRendusDunVisiteur() ;
	}
	
	@Override
	/** Connaitre le nombre de ligne d'une liste
	 * 
	 * @return nombre de ligne de la liste
	 */
	public int getRowCount() {
		if (compteRendus == null) {  
            return 0;  
        }  
		return compteRendus.size();
	}
	
	@Override
	/** Connaitre le nombre de colonne d'une liste
	 * 
	 * @return nombre de colonne de la liste
	 */
	public int getColumnCount() {
		return entetes.length;
	}
	
	/** Connaitre le nom des colonnes d'une liste
	 * 
	 * @return nom des colonnes de la liste
	 */
	public String getColumnName(int indiceColonne){
		return entetes[indiceColonne] ;
	}
	
	/** Récupération du controleur
	 * 
	 * @return controleur
	 */
	public Controleur getControleur() {
		return this.controleur;
	}
	
	/** Obtenir la classe d'une colonne
	 * 
	 * @param indiceColonne Le numéro de la colonne
	 * @return La classe de la colonne
	 */
	@Override
	public Class getColumnClass(int indiceColonne){
		switch(indiceColonne){
			case 0 :
				return Integer.class ;
			case 1 : 
				return String.class ;
			case 2 :
				return Date.class ;
			case 3 :
				return Date.class ;
			case 4 :
				return Integer.class;
			case 5 :
				return JButton.class ;
			default :
				return Object.class ;
		}
	}
	
	/** Obtenir la valeur d'une cellule
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @param indiceColonne L'indice de la colonne
	 * @return La valeur de la cellule
	 */
	public Object getValueAt(int indiceLigne, int indiceColonne){
		switch(indiceColonne){
			case 0 :
				return compteRendus.get(indiceLigne).getRapNum() ;
			case 1 :
				return compteRendus.get(indiceLigne).getPraNum() ;
			case 2 :
				return compteRendus.get(indiceLigne).getRapDate() ;
			case 3 :
				return compteRendus.get(indiceLigne).getDateVisite() ;
			case 4 :
				return compteRendus.get(indiceLigne).getEtat();
			case 5 :
				return "Consulter" ;
			default :
			return null ;
		}
	}
	
	/** Spécifier si une cellule est éditable
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @param indiceColonne L'indice de la colonne
	 * @return true si la cellule est éditable, et false dans le cas contraire
	 */
	@Override
	public boolean isCellEditable(int indiceLigne, int indiceColonne){
		switch(indiceColonne){
			case 0:
				return false;
			case 1:
				return false;
			case 2:
				return false;
			case 3:
				return false;
			case 4:
				return false;
			case 5:
				return true;
			default:
				return false;
		}
	}
	
	/** Récupération du matricule du visiteur
	 * 
	 * @return matricule du visiteur
	 */
	public String getMatriculeVisiteur(int indiceLigne){
		return compteRendus.get(indiceLigne).getVis();
	}
	
	/** Récupération du numéro du rapport
	 * 
	 * @return numéro du rapport
	 */
	public int getNumRapport(int indiceLigne){
		return compteRendus.get(indiceLigne).getRapNum();
	}
	
	/** Récupération du numéro du praticien
	 * 
	 * @return numéro du praticien
	 */
	public String getNumPraticien(int indiceLigne){
		return compteRendus.get(indiceLigne).getPraNum();
	}
	
	/** Récupération de la date de rédaction
	 * 
	 * @return date de rédaction
	 */
	public Date getDateRedac(int indiceLigne){
		return compteRendus.get(indiceLigne).getRapDate();
	}
	
	/** Récupération de la date de visite
	 * 
	 * @return date de visite
	 */
	public Date getDateVisite(int indiceLigne){
		return compteRendus.get(indiceLigne).getDateVisite();
	}
	
	/** Récupération du motif du rapport
	 * 
	 * @return motif du rapport
	 */
	public String getMotif(int indiceLigne){
		return compteRendus.get(indiceLigne).getRapMotif();
	}
	
	/** Récupération du coeficient de confiance d'un praticien
	 * 
	 * @return coeficient de confiance d'un praticien
	 */
	public float getCoefConfiance(int indiceLigne){
		return compteRendus.get(indiceLigne).getCoefConfiance();
	}

	/** Récupération du bilan du rapport
	 * 
	 * @return bilan du rapport
	 */
	public String getBilan(int indiceLigne){
		return compteRendus.get(indiceLigne).getRapBilan();
	}
	
	/** Récupération du modele
	 * 
	 * @return modele
	 */
	public ModeleAppliCR getModele() {
		return modele;
	}
	
	/** Obtenir l'état du rapport
	 * 
	 * @param indiceLigne L'indice de la ligne 
	 * @return L'état du rapport
	 */
	public int getEtat(int indiceLigne){
		return compteRendus.get(indiceLigne).getEtat() ;
	}

}