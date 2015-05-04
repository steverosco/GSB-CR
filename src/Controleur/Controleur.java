package Controleur;

import Modele.Authentification;

import Modele.ModeleAppliCR;
import Views.GuiAppliCR;

/** CONTROLEUR
 * 
 * @author KE20
 *
 */
public class Controleur {

	private GuiAppliCR vuePrincipale ;
	private ModeleAppliCR modele ;
	
	/** constructeur du controleur
	 * 
	 * @param modele
	 */
	public Controleur(ModeleAppliCR modele) {
		super();
		this.modele = modele;
	}

	/** Récupération de la vue principale
	 * 
	 * @return la vue princiale
	 */
	public GuiAppliCR getVuePrincipale() {
		return vuePrincipale;
	}

	/** Modification de la vue principale si necessaire
	 * 
	 * @param vuePrincipale
	 */
	public void setVuePrincipale(GuiAppliCR vuePrincipale) {
		this.vuePrincipale = vuePrincipale;
	}

	/** Récupération du modele
	 * 
	 * @return le modele
	 */
	public ModeleAppliCR getModele() {
		return modele;
	}

	/** Modification du modele si necessaire
	 * 
	 * @param modele
	 */
	public void setModele(ModeleAppliCR modele) {
		this.modele = modele;
	}
	
	/** Méthode permettant de se connecter
	 * 
	 */
	public void seConnecter(){
		this.vuePrincipale.changerDeVue("Se connecter") ;
	}
	
	/** Méthode permettant de se deconnecter
	 * 
	 */
	public void seDeconnecter(){
		this.vuePrincipale.changerDeVue("Se déconnecter") ;
	}
	
	/** Méthode permettant de quitter l'application
	 * 
	 */
	public void quitterApplication(){
		this.vuePrincipale.changerDeVue("Quitter") ;
	}
	
	/** Méthode permettant de visualiser les visiteurs
	 * 
	 */
	public void visualiserVisiteurs(){
		this.vuePrincipale.changerDeVue("Liste visiteurs") ;
	}
	
	/** Méthode permettant de visualiser les praticiens hésitants
	 * 
	 */
	public void visualiserPraticiensHesitants(){
		this.vuePrincipale.changerDeVue("Liste praticiens hésitants") ;
	}
	
	/** Méthode permettant de visualiser les rapport
	 * 
	 */
	public void visualiserComptesRendus(){
		this.vuePrincipale.changerDeVue("Liste des comptes rendus") ;
	}
	
	/** Méthode permettant de visualiser le rapport selectionné
	 * 
	 */
	public void visualiserComptesRendusSelected(){
		this.vuePrincipale.changerDeVue("Info compte-rendu") ;
	}
	
	/** Méthode permettant l'essaie à l'authentification
	 * 
	 * @param login
	 * @param mdp
	 * @return
	 */
	public boolean tenterConnexion(String login, String mdp){
		boolean seCo = Authentification.seConnecter(login, mdp);
		System.out.println(seCo);
		if(seCo == true){
			System.out.println("Authentification REUSSI!");
			
		}
		else{
			System.out.println("Erreur !");
		}
		return seCo;
	}
	
	/** Méthode permettant de qutter l'application
	 * 
	 */
	public void quitter(){
		System.exit(0) ;
	}
}
