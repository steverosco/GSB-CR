package appliCR;

import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controleur.Controleur;
import Modele.ModeleAppliCR;
import Views.GuiAppliCR;
import Views.StartApp;

/** MAIN
 * 
 * @author KE20
 *
 */
public class AppliCR {

	/** Lancement de l'application, création des vues et methodes necessaires
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, UnsupportedLookAndFeelException {
		try {
        	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }	
        
        catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class for specified look and feel:");
            System.err.println("Did you include the L&F library in the class path?");
            System.err.println("Using the default look and feel.");
        } 
        
        catch (UnsupportedLookAndFeelException e) {
            System.err.println("Can't use the specified look and feel on this platform.");
            System.err.println("Using the default look and feel.");
        } 
        
        catch (Exception e) {
            System.err.println("Couldn't get specified look and feel, for some reason.");
            System.err.println("Using the default look and feel.");
            e.printStackTrace();
        }
		
		
		/** Création de l'animation de chargement de démarrage
		 * 
		 */
		StartApp.startApp();
		
		/** création du modele de l'application
		 * 
		 */
		ModeleAppliCR modele = new ModeleAppliCR() ;
		
		/** création du controleur de l'application
		 * 
		 */
		Controleur controleur = new Controleur(modele) ;
		
		/** création de la vue principale
		 * 
		 */
		new GuiAppliCR(modele,controleur) ;
	}
}
