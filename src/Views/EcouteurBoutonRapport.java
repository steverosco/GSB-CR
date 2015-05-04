package Views;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JFrame;

import Controleur.Controleur;
import Entities.CompteRendu;
import Modele.ModeleAppliCR;
import Modele.ModeleListeCompteRendu;

/** Ecouteur des boutons du tableau des Visiteurs
 * 
 * @author KE20
 *
 */
public class EcouteurBoutonRapport extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int row ;
	private int column ;
	private JTable table ;
	private JButton bouton ;
	private ModeleAppliCR modele;
	private Controleur controleur ;
	private CompteRendu compteRendu;
	private VueListeComptesRendus vueListeCompteRendu;

	
	/** Modifier l'indice de la ligne
	 * @param row L'indice de la ligne
	 */
	public void setRow(int row){
		this.row = row ;
	}
	
	/** Modifier l'indice de la colonne
	 * 
	 * @param column L'indice de la colonne
	 */
	public void setColumn(int column){
		this.column = column ;
	}
	
	/** Modifier le tableau
	 * @param table Le nouveau tableau
	 */
	public void setTable(JTable table){
		this.table = table ;
	}

	/** Action de l'évenement
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(table.getModel().getClass() == ModeleListeCompteRendu.class){
			ModeleAppliCR modele = ((ModeleListeCompteRendu)this.table.getModel()).getModele() ;
			Controleur controleur = ((ModeleListeCompteRendu) this.table.getModel()).getControleur() ;
			int NumRapport =((ModeleListeCompteRendu)this.table.getModel()).getNumRapport(this.row) ;
			String visMatricule =((ModeleListeCompteRendu)this.table.getModel()).getMatriculeVisiteur(this.row) ;
			Integer sRapLu =  ((ModeleListeCompteRendu)this.table.getModel()).getEtat(this.row) ;
			
			try {
				switch(this.column){
					case 5 :
						System.out.println("----------------------------------------") ;
						System.out.println("[Afficher ]");
						if(sRapLu == 0){
							try {
								modele.setRapLu(NumRapport);
							} catch (Exception e1) {
								System.err.println(e1.getMessage());
							}
						}
						try{
						modele.rechercherCR(visMatricule, NumRapport);
						} catch (Exception e1) {
							System.err.println(e1.getMessage());
						}
						controleur.visualiserComptesRendusSelected();
				}
			} catch (HeadlessException e1) {
				System.err.println(e1.getMessage());
			}
		}
	}
}
