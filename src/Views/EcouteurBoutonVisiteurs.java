package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Controleur.Controleur;
import Modele.ModeleAppliCR;
import Modele.ModeleListeVisiteurs;

/** Ecouteur des boutons du tableau des Visiteurs
 * 
 * @author KE20
 *
 */
public class EcouteurBoutonVisiteurs extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int row ;
	private int column ;
	private JTable table ;

	
	/** Modifier l'indice de la ligne
	 * @param row L'indice de la ligne
	 */
	public void setRow(int row){
		this.row = row ;
	}
	
	/** Modifier l'indice de la colonne
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
		Controleur controleur = ((ModeleListeVisiteurs)this.table.getModel()).getControleur() ;
		ModeleAppliCR modele = ((ModeleListeVisiteurs) this.table.getModel()).getModele() ;
		String VisMatricule = ((ModeleListeVisiteurs)this.table.getModel()).getNumeroVis(this.row) ;
		String VisNom = ((ModeleListeVisiteurs)this.table.getModel()).getNomVis(this.row) ;
		String VisPrenom = ((ModeleListeVisiteurs)this.table.getModel()).getPrenomVis(this.row) ;
		switch(this.column){
			case 4 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Action clique Selectioner]") ;
				JLabel moisLabel = new JLabel("Mois (Format mm) : ");
				JTextField moisField = new JTextField(10);
				
				JLabel anneeLabel = new JLabel("Année (Format aaaa) : ");
				JTextField anneeField = new JTextField(10);
				
				Object affichageBoxChoixMoisAnnee [] = {"Sélectionnez le mois et l'année des Comptes Rendus à visualiser pour "+VisPrenom+" "+VisNom, moisLabel, moisField, anneeLabel, anneeField};
				Object options [] = {"Valider", "Annuler"};
					
				int boxChoixMoisAnnee = JOptionPane.showOptionDialog(null,affichageBoxChoixMoisAnnee, "Période", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,null);
				
				if(JOptionPane.OK_OPTION==boxChoixMoisAnnee){
					System.out.println(moisField.getText()+ " " +anneeField.getText()+ " " + VisMatricule);
					modele.getCompteRendu(moisField.getText(),anneeField.getText(),VisMatricule);
					controleur.visualiserComptesRendus();
					}
				else {
					JOptionPane.showMessageDialog(null, "Au Revoir");
					}
				break ;
			}
	}
}

