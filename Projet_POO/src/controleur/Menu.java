package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modele.Panier;


public class Menu extends JMenuBar{
	
	private Panier panier = new Panier();
	private JMenu mFichier = new JMenu("Fichier");
	private JMenu mPanier = new JMenu("Panier");
	private JMenuItem mQuit = new JMenuItem("Quitter");
	private JMenuItem mVoir = new JMenuItem("Voir Panier");
	
	
	public Menu() {
		
		this.mFichier.add(this.mQuit);
		this.mPanier.add(this.mVoir);
		this.add(this.mFichier);
		this.add(this.mPanier);
		
		mQuit.addActionListener(new QuitListener());
		mVoir.addActionListener(new VoirListener());
	}
	
	class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	class VoirListener implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	    	Panier.afficherPanier();
	    }
	}
	    

}
