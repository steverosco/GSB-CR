package Modele;

import java.sql.Date;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import Controleur.Controleur;
import Entities.Praticien;

/** modele de la liste des praticiens hesitants
 * 
 * @author KE20
 *
 */
public class ModeleListePraticiensHesitants extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private java.util.List<Praticien> praticiensHesitants  ;
	private final String[] entetes = {"Nom","Ville", "Coef Notoriété", "Coef Confiance", "Temps écoulé"} ;
	private ModeleAppliCR modele ;
	private Controleur controleur ;
	
	public ModeleListePraticiensHesitants(ModeleAppliCR modele, Controleur controleur){
		super() ;
		this.modele = modele ;
		praticiensHesitants = this.modele.getPraticiensHesitants() ;
	}
	
	/** Connaitre le nombre de ligne d'une liste
	 * 
	 * @return nombre de ligne de la liste
	 */
	public int getRowCount(){
		return praticiensHesitants.size() ;
	}
	
	/** Connaitre le nombre de colonne d'une liste
	 * 
	 * @return nombre de colonne de la liste
	 */
	public int getColumnCount(){
		return entetes.length ;
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
	
	/** Récupération du modele
	 * 
	 * @return modele
	 */
	public ModeleAppliCR getModele() {
		return this.modele;
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
				return praticiensHesitants.get(indiceLigne).getNom() ;
			case 1 :
				return praticiensHesitants.get(indiceLigne).getVille() ;
			case 2 :
				return praticiensHesitants.get(indiceLigne).getCoefConf();
			case 3 :
				return praticiensHesitants.get(indiceLigne).getCoefNoto();
			case 4 :
				return praticiensHesitants.get(indiceLigne).getTempsEcoule()+"  jours" ;
			default :
			return null ;
		}
	}
}
