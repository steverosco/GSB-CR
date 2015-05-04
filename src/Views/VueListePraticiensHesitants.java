package Views;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controleur.Controleur;
import Modele.ModeleAppliCR;
import Modele.ModeleListePraticiensHesitants;

/** vue de la liste des praticiens hésitants
 * 
 * @author KE20
 *
 */
public class VueListePraticiensHesitants extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleAppliCR modele ;
	private ModeleListePraticiensHesitants modeleTableauPraticiensHesitants ;
	private JTable tableauPraticiensHesitants;
	
	/** création de la vue
	 * 
	 * @param modele
	 * @param controleur
	 */
	public VueListePraticiensHesitants(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.controleur = controleur;
		this.modele = modele;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Praticiens Hesitants qui ont un coéficent de confiance en dessous de 3 sur 5 :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauPraticiensHesitants = new ModeleListePraticiensHesitants(modele,controleur) ;
		tableauPraticiensHesitants = new JTable(modeleTableauPraticiensHesitants) ;
		tableauPraticiensHesitants.setRowHeight(30) ;
		tableauPraticiensHesitants.getTableHeader().setPreferredSize(new Dimension(0, 45));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableauPraticiensHesitants.getModel());   
		tableauPraticiensHesitants.setRowSorter(sorter);
		sorter.setSortable(0, false);
		sorter.setSortable(1, false);
		
		JScrollPane spPra = new JScrollPane(tableauPraticiensHesitants) ;
		//spClients.setPreferredSize(new Dimension(1290,420)) ;
		spPra.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spPra) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		
	}

	/** Récupération du controleur
	 * 
	 * @return controleur
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/** Modification du controleur
	 * 
	 * @param controleur
	 */
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	/** Récupération du modele
	 * 
	 * @return modele
	 */
	public ModeleAppliCR getModele() {
		return modele;
	}

	/** Modification du modele
	 * 
	 * @param modele
	 */
	public void setModele(ModeleAppliCR modele) {
		this.modele = modele;
	}
	
	/** Actualiser la vue
	 * 
	 * 
	 */
	public void actualiser(){
		modeleTableauPraticiensHesitants = new ModeleListePraticiensHesitants(modele,controleur) ;
		tableauPraticiensHesitants.setModel(modeleTableauPraticiensHesitants) ;
	}

}
