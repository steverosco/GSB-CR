package Views ;

import java.awt.* ;

import javax.swing.table.* ;
import javax.swing.* ;

import Entities.CompteRendu;
import Modele.ModeleListeCompteRendu;

/** Rendu des cellules du tableau des Rapports
 * 
 *
 */
public class RenduCellulesRapport extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 1L;
	
	/** Créer le rendu
	 * 
	 */
	public RenduCellulesRapport(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
															boolean hasFocus, int row, int column){
		super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column) ;
		
		int etat = ((ModeleListeCompteRendu)table.getModel()).getEtat(row) ;
        
		switch(etat){
			case CompteRendu.NON_LU :
				setBackground(Color.WHITE) ;
				break ;
			case CompteRendu.LU :
				setBackground(new Color(255, 226, 198)) ;
				break ;
		}
		return this ;
	}
}
