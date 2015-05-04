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
import Modele.ModeleListeVisiteurs;

/** vue de la liste des visiteurs
 * 
 * @author KE20
 *
 */
public class VueListeVisiteurs extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleAppliCR modele ;
	private ModeleListeVisiteurs modeleTableauVisiteurs ;
	private JTable tableauVisiteurs;
	
	/** création de la vue
	 * 
	 * @param modele
	 * @param controleur
	 */
	public VueListeVisiteurs(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.controleur = controleur;
		this.modele = modele;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Visiteurs :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauVisiteurs = new ModeleListeVisiteurs(modele,controleur) ;
		tableauVisiteurs = new JTable(modeleTableauVisiteurs) ;
		tableauVisiteurs.setRowHeight(30) ;
		tableauVisiteurs.getTableHeader().setPreferredSize(new Dimension(0, 45));
		
		this.appliquerRendu();
		
		JScrollPane spVis = new JScrollPane(tableauVisiteurs) ;
		//spClients.setPreferredSize(new Dimension(1290,420)) ;
		spVis.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spVis) ;
		
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
		modeleTableauVisiteurs = new ModeleListeVisiteurs(modele,controleur) ;
		tableauVisiteurs.setModel(modeleTableauVisiteurs) ;
		this.appliquerRendu();
	}

	/** Appliquer le rendu
	 * 
	 */
	private void appliquerRendu(){
		this.tableauVisiteurs.getColumn("Consulter").setCellRenderer(new RenduBoutonVisiteurs()) ;
		this.tableauVisiteurs.getColumn("Consulter").setCellEditor(new EditeurBoutonVisiteurs(new JCheckBox())) ;
	}
}
