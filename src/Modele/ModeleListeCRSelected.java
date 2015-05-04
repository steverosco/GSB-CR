package Modele;

import java.sql.Date;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import Controleur.Controleur;
import Entities.CompteRendu;

/** modele de la liste des compte rendus selectionné
 * 
 * @author KE20
 *
 */
public class ModeleListeCRSelected extends AbstractTableModel{
	private Controleur controleur ;
	private static final long serialVersionUID = 1L;
	private CompteRendu compteRendusSelected  ;
	private final String[] entetes = {"numero du rapport","numero du praticien","Date de Redaction","Date de Visite","Bilan", "Motif", "Coef Confiance"};
	private ModeleAppliCR modele ;
	
	public ModeleListeCRSelected(ModeleAppliCR modele, Controleur controleur){
		super() ;
		this.modele = modele ;
		this.controleur = controleur;
		compteRendusSelected = this.modele.getContreRenduSelected() ;
	}
	
	@Override
	/** Connaitre le nombre de ligne d'une liste
	 * 
	 * @return nombre de ligne de la liste
	 */
	public int getRowCount() {
		if (compteRendusSelected == null) {  
            return 0;  
        }  
		return 1;
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
				return String.class;
			case 5 :
				return String.class;
			case 6 :
				return float.class;
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
				try{
				return compteRendusSelected.getRapNum() ;
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			case 1 :
				try{
				return compteRendusSelected.getPraNum() ;
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			case 2 :
				try{
				return compteRendusSelected.getRapDate() ;
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			case 3 :
				try{
				return compteRendusSelected.getDateVisite() ;
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			case 4 :
				try{
				return compteRendusSelected.getRapBilan();
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			case 5 :
				try{
				return compteRendusSelected.getRapMotif();
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			case 6 :
				try{
				return compteRendusSelected.getCoefConfiance();
				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
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
			case 5 :
				return false;
			case 6 :
				return false;
			default:
				return false;
		}
	}
	
	/** Récupération du matricule du visiteur
	 * 
	 * @return matricule du visiteur
	 */
	public String getMatriculeVisiteur(int indiceLigne){
		return compteRendusSelected.getVis();
	}
	
	/** Récupération du numéro du rapport
	 * 
	 * @return numéro du rapport
	 */
	public int getNumRapport(int indiceLigne){
		return compteRendusSelected.getRapNum();
	}
	
	/** Récupération du numéro du praticien
	 * 
	 * @return numéro du praticien
	 */
	public String getNumPraticien(int indiceLigne){
		return compteRendusSelected.getPraNum();
	}
	
	/** Récupération de la date de rédaction
	 * 
	 * @return date de rédaction
	 */
	public Date getDateRedac(int indiceLigne){
		return compteRendusSelected.getRapDate();
	}
	
	/** Récupération de la date de visite
	 * 
	 * @return date de visite
	 */
	public Date getDateVisite(int indiceLigne){
		return compteRendusSelected.getDateVisite();
	}
	
	/** Récupération du motif du rapport
	 * 
	 * @return motif du rapport
	 */
	public String getMotif(int indiceLigne){
		return compteRendusSelected.getRapMotif();
	}
	
	/** Récupération du coeficient de confiance d'un praticien
	 * 
	 * @return coeficient de confiance d'un praticien
	 */
	public float getCoefConfiance(int indiceLigne){
		return compteRendusSelected.getCoefConfiance();
	}

	/** Récupération du bilan du rapport
	 * 
	 * @return bilan du rapport
	 */
	public String getBilan(int indiceLigne){
		return compteRendusSelected.getRapBilan();
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
		return compteRendusSelected.getEtat() ;
	}

}

