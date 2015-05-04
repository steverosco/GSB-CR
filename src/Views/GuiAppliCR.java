package Views;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controleur.Controleur;
import Modele.ModeleAppliCR;

/** vue principale
 * 
 * @author KE20
 *
 */
public class GuiAppliCR  extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private ModeleAppliCR modele ;
	private Controleur controleur ;
		
	private JMenuItem itemSeConnecter ;
	private JMenuItem itemSeDeconnecter ;
	private JMenuItem itemQuitter ;
	private JMenuItem itemVisualiserVisiteurs ;
	private JMenuItem itemVisualiserPraticiensHesitants ;
	
	private JMenu menuVisiteur ;
	private JMenu menuPraticien ;
	
	private VueAccueil vueAccueil ;
	private VueListeVisiteurs vueListeVisiteurs ;
	private VueListeComptesRendus vueListeComptesRendus ;
	private VueListePraticiensHesitants vueListePraticiensHesitants ;
	private VueListeCRSelected vueListeCRSelected;
	
	private JPanel panneauAuthentification;
	private JLabel lbMatric ;
	private JTextField tfMatric ;
	private JLabel lbMdp ;
	private JPasswordField pfMdp ;
	
	protected CardLayout vues ;
	protected Container conteneur ;

	/** Constructeur de la vue principale
	 * 
	 * @param modele
	 * @param controleur
	 */
	public GuiAppliCR(ModeleAppliCR modele, Controleur controleur) {
		super();
		
		this.modele = modele;
		this.controleur = controleur ;
		
		this.controleur.setVuePrincipale(this);
		
		this.setTitle("GSB / Appli-CR") ;
		
		this.setSize(1120,520) ;
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		this.vues = new CardLayout(2,2) ;
		this.conteneur = this.getContentPane() ;
		this.conteneur.setLayout(this.vues) ;
		
		panneauAuthentification = new JPanel();
		panneauAuthentification.setLayout(new GridLayout(5,0));
		lbMatric = new JLabel("Login : ");
		tfMatric = new JTextField(10);
		lbMdp = new JLabel("Password : ");
		pfMdp = new JPasswordField(10);
		panneauAuthentification.add(lbMatric);
		panneauAuthentification.add(tfMatric);
		panneauAuthentification.add(lbMdp);
		panneauAuthentification.add(pfMdp);
		
		vueAccueil = new VueAccueil() ;
		vueListeVisiteurs = new VueListeVisiteurs(modele,controleur) ;
		vueListeComptesRendus = new VueListeComptesRendus(modele,controleur) ;
		vueListePraticiensHesitants = new VueListePraticiensHesitants(modele,controleur) ;
		vueListeCRSelected = new VueListeCRSelected(modele,controleur);
		
		this.conteneur.add(vueAccueil,"Accueil") ;
		this.conteneur.add(vueListeComptesRendus,"Liste des comptes rendus") ;
		this.conteneur.add(vueListePraticiensHesitants,"Liste praticiens hésitants") ;
		this.conteneur.add(vueListeVisiteurs,"Liste visiteurs") ;
		this.conteneur.add(vueListeCRSelected,"Info compte-rendu");
		
		this.vues.show(this.conteneur,"Accueil");
		
		this.creerBarreMenus() ;
		this.setVisible(true) ;
		
		this.itemSeDeconnecter.setEnabled(false) ;
		this.menuVisiteur.setEnabled(false) ;
		this.menuPraticien.setEnabled(false) ;
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

	/** Récupération du controleur
	 * 
	 * @return le controleur
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/** Modification du controleur si necessaire
	 * 
	 * @param contoleur
	 */
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}
	
	/** Création du menu
	 * 
	 */
	private void creerBarreMenus(){
		JMenuBar barreMenus = new JMenuBar() ;
		
		JMenu menuFichier = new JMenu("Fichier") ;
		
		this.itemSeConnecter = new JMenuItem("Se connecter") ;
		this.itemSeConnecter.addActionListener(this) ;
		menuFichier.add(this.itemSeConnecter) ;
		
		this.itemSeDeconnecter = new JMenuItem("Se déconnecter") ;
		this.itemSeDeconnecter.addActionListener(this) ;
		menuFichier.add(this.itemSeDeconnecter) ;
		
		this.itemQuitter = new JMenuItem("Quitter") ;
		this.itemQuitter.addActionListener(this) ;
		menuFichier.add(this.itemQuitter) ;
		
		this.menuVisiteur = new JMenu("Visiteurs") ;
		
		this.itemVisualiserVisiteurs = new JMenuItem("Liste des visiteurs") ;
		this.itemVisualiserVisiteurs.addActionListener(this) ;
		this.menuVisiteur.add(this.itemVisualiserVisiteurs) ;
		
		this.menuPraticien = new JMenu("Praticiens") ;
		
		this.itemVisualiserPraticiensHesitants = new JMenuItem("Liste des praticiens hésitants") ;
		this.itemVisualiserPraticiensHesitants.addActionListener(this) ;
		this.menuPraticien.add(this.itemVisualiserPraticiensHesitants) ;
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(this.menuVisiteur) ;
		barreMenus.add(this.menuPraticien) ;
		
		this.setJMenuBar(barreMenus) ;
	}
	
	/** Changement de vue
	 * 
	 * @param nomVue
	 */
	public void changerDeVue(String nomVue){
		
		if(nomVue.equals("Accueil")){
			this.vues.show(this.conteneur,"Accueil") ;
		}
		
		else if(nomVue.equals("Se connecter")){
			int ok = JOptionPane.showOptionDialog(vueAccueil, panneauAuthentification, "Identification", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, EXIT_ON_CLOSE);
			String login = tfMatric.getText();
			String mdp = pfMdp.getText();
			if(ok == JOptionPane.CANCEL_OPTION){
				this.itemSeDeconnecter.setEnabled(false) ;
				this.itemSeConnecter.setEnabled(true) ;
				this.menuVisiteur.setEnabled(false) ;
				this.menuPraticien.setEnabled(false) ;
				this.vues.show(this.conteneur,"Accueil") ;
			}
			else if(login.isEmpty() || mdp.isEmpty()){
				JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs", "Saisir votre login et votre mot de passe : ", JOptionPane.ERROR_MESSAGE);
				this.itemSeDeconnecter.setEnabled(false) ;
				this.itemSeConnecter.setEnabled(true) ;
				this.menuVisiteur.setEnabled(false) ;
				this.menuPraticien.setEnabled(false) ;
				this.vues.show(this.conteneur,"Accueil") ;
			}
			else if(ok == JOptionPane.OK_OPTION){
				boolean co = this.controleur.tenterConnexion(login, mdp);
				if(co == true){
					this.itemSeDeconnecter.setEnabled(true) ;
					this.itemSeConnecter.setEnabled(false) ;
					this.menuVisiteur.setEnabled(true) ;
					this.menuPraticien.setEnabled(true) ;
					this.vues.show(this.conteneur,"Accueil") ;
				}
				else{
					JOptionPane.showMessageDialog(null, "Vous n'êtes pas un délégué !", "Erreur d'identification", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		else if(nomVue.equals("Se déconnecter")){
			int reponse = JOptionPane.showConfirmDialog(null,"Voulez-vous mettre fin à la session ?","Fin de session",JOptionPane.YES_NO_OPTION) ;
			if(reponse == JOptionPane.YES_OPTION){
				this.itemSeDeconnecter.setEnabled(false) ;
				this.itemSeConnecter.setEnabled(true) ;
				this.menuVisiteur.setEnabled(false) ;
				this.menuPraticien.setEnabled(false) ;
				this.vues.show(this.conteneur,"Accueil") ;
			}
		}
		
		else if(nomVue.equals("Quitter")){
			int reponse = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment quitter l'application ?","Quitter l'application",JOptionPane.YES_NO_OPTION) ;
			if(reponse == JOptionPane.YES_OPTION){
				this.controleur.quitter() ;
			}
		}	
		
		else if(nomVue.equals("Liste visiteurs")){
			this.vueListeVisiteurs.actualiser();
		}
		
		else if(nomVue.equals("Liste des comptes rendus")){
			this.vueListeComptesRendus.actualiser();
		}
		
		else if(nomVue.equals("Info compte-rendu")){
			this.vueListeCRSelected.actualiser();
		}
		
		else if(nomVue.equals("Liste praticiens hésitants")){
			this.vueListePraticiensHesitants.actualiser();
		}
		this.vues.show(this.conteneur,nomVue) ;
	}
	
	/** Action de l'évenement
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent evenement) {
		
		Object sourceEvt = evenement.getSource() ;
		
		if(sourceEvt == this.itemSeConnecter){
			this.controleur.seConnecter() ;
		}
		if(sourceEvt == this.itemSeDeconnecter){
			this.controleur.seDeconnecter() ;
		}
		if(sourceEvt == this.itemQuitter){
			this.controleur.quitterApplication() ;
		}
		else if(sourceEvt == this.itemVisualiserVisiteurs){
			this.controleur.visualiserVisiteurs() ;
		}
		else if(sourceEvt == this.itemVisualiserPraticiensHesitants){
			this.controleur.visualiserPraticiensHesitants() ;
		}
	}
}
