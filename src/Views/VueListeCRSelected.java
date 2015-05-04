package Views;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controleur.Controleur;
import Modele.ModeleAppliCR;
import Modele.ModeleListeCRSelected;

/** vue de la liste des compte rendus selectionné
 * 
 * @author KE20
 *
 */
public class VueListeCRSelected extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleAppliCR modele ;
	private ModeleListeCRSelected modeleListeCompteRenduSelected ;
	private JTable tableauCRSelected;
	
	/** création de la vue
	 * 
	 * @param modele
	 * @param controleur
	 */
	public VueListeCRSelected(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.controleur = controleur;
		this.modele = modele;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Compte Rendu sélectionné :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleListeCompteRenduSelected = new ModeleListeCRSelected(modele, controleur) ;
		tableauCRSelected = new JTable(modeleListeCompteRenduSelected) ;
		tableauCRSelected.setRowHeight(30) ;
		tableauCRSelected.getTableHeader().setPreferredSize(new Dimension(0, 45));
		
		JScrollPane spCr = new JScrollPane(tableauCRSelected) ;
		//spClients.setPreferredSize(new Dimension(1290,420)) ;
		spCr.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spCr) ;
		
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
		modeleListeCompteRenduSelected = new ModeleListeCRSelected(modele, controleur) ;
		tableauCRSelected.setModel(modeleListeCompteRenduSelected) ;
	}
}
