package Modele;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import Controleur.Controleur;
import Entities.Visiteur;

/** modele de la liste des visiteurs
 * 
 * @author KE20
 *
 */
public class ModeleListeVisiteurs extends AbstractTableModel {

	private Controleur controleur ;
	private static final long serialVersionUID = 1L;
	private java.util.List<Visiteur> visiteurs  ;
	private final String[] entetes = {"Numéro","Nom","Prénom","Adresse","Consulter"} ;
	private ModeleAppliCR modele ;
	String matricule = Authentification.getMatric();
	
	public ModeleListeVisiteurs(ModeleAppliCR modele, Controleur controleur){
		super() ;
		this.modele = modele ;
		this.controleur = controleur ;
		visiteurs = this.modele.getVisiteurs() ;
	}
	
	/** Connaitre le nombre de ligne d'une liste
	 * 
	 * @return nombre de ligne de la liste
	 */
	public int getRowCount(){
		return visiteurs.size() ;
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
	
	/** Obtenir le modèle de l'application
	 * 
	 * @return Le modèle de l'application
	 */
	public ModeleAppliCR getModele(){
		return this.modele ;
	}
	
	/** Obtenir le numéro du visiteur
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @return Le numéro du visiteur
	 */
	public String getNumeroVis(int indiceLigne){
		return visiteurs.get(indiceLigne).getMatric() ;
	}
	
	/** Obtenir le nom du visiteur
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @return Le nom du visiteur
	 */
	public String getNomVis(int indiceLigne){
		return visiteurs.get(indiceLigne).getNom() ;
	}
	
	/** Obtenir le prénom du visiteur
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @return Le prénom du visiteur
	 */
	public String getPrenomVis(int indiceLigne){
		return visiteurs.get(indiceLigne).getPrenom() ;
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
				return String.class ;
			case 1 :
				return String.class ;
			case 2 : 
				return String.class ;
			case 3 :
				return String.class ;
			case 4 :
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
			return visiteurs.get(indiceLigne).getMatric() ;
			case 1 :
			return visiteurs.get(indiceLigne).getNom() ;
			case 2 :
			return visiteurs.get(indiceLigne).getPrenom() ;
			case 3 :
			return visiteurs.get(indiceLigne).getAdresse() ;
			case 4 :
			return "SELECTIONNER";
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
		int etat = visiteurs.get(indiceLigne).getEtat() ;
		
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
				return true;
			default:
				return false;
		}
	}
	
	/** Obtenir l'état de la location
	 * 
	 * @param indiceLigne L'indice de la ligne 
	 * @return L'état de la location
	 */
	public int getEtat(int indiceLigne){
		return visiteurs.get(indiceLigne).getEtat() ;
	}
}

