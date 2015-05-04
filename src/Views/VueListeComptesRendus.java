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
import Modele.ModeleListeCompteRendu;

/** vue de la liste des compte rendus
 * 
 * @author KE20
 *
 */
public class VueListeComptesRendus extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleAppliCR modele ;
	private ModeleListeCompteRendu modeleListeCompteRendu ;
	private JTable tableauCR;
	
	/** création de la vue
	 * 
	 * @param modele
	 * @param controleur
	 */
	public VueListeComptesRendus(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.controleur = controleur;
		this.modele = modele;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Compte Rendu :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleListeCompteRendu = new ModeleListeCompteRendu(modele, controleur) ;
		tableauCR = new JTable(modeleListeCompteRendu) ;
		tableauCR.setRowHeight(30) ;
		tableauCR.getTableHeader().setPreferredSize(new Dimension(0, 45));
		
		this.appliquerRendu();
		
		JScrollPane spCr = new JScrollPane(tableauCR) ;
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
		modeleListeCompteRendu = new ModeleListeCompteRendu(modele, controleur) ;
		tableauCR.setModel(modeleListeCompteRendu) ;
		this.appliquerRendu();
	}
	
	/** Appliquer le rendu
	 * 
	 */
	private void appliquerRendu(){
		this.tableauCR.getColumn("numero du praticien").setCellRenderer(new RenduCellulesRapport()) ;
		this.tableauCR.getColumn("numero du rapport").setCellRenderer(new RenduCellulesRapport()) ;
		this.tableauCR.getColumn("Date de Redaction").setCellRenderer(new RenduCellulesRapport()) ;
		this.tableauCR.getColumn("Date de Visite").setCellRenderer(new RenduCellulesRapport()) ;
		this.tableauCR.getColumn("Etat").setCellRenderer(new RenduCellulesRapport()) ;
		this.tableauCR.getColumn("Afficher le Rapport").setCellRenderer(new RenduBoutonVisiteurs()) ;
		
		this.tableauCR.getColumn("Afficher le Rapport").setCellEditor(new EditeurBoutonRapport(new JCheckBox())) ;
	}

}
