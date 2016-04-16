package modele;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Panier {

	static LinkedList<Article> panier;
	
	public Panier(){
		Panier.panier = new LinkedList<Article>();
	}
	
	public static void ajouterArticle(Article pArticle) {
		Panier.panier.add(pArticle);
	}
	
	public static void retirerArticle(Article pArticle) {
		Panier.panier.remove(pArticle);
	}
	
	public static void afficherPanier() {
		JFrame affichagePanier = new JFrame();
		JPanel affichage = new JPanel();
		affichagePanier.setSize(400, 500);
		affichagePanier.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		affichagePanier.setLocationRelativeTo(null);
		affichage.setPreferredSize(new Dimension (400,500));
		
		for (Article a : panier) {
    		affichage.add(a.afficheArticle());
    	}
		
		JScrollPane scroll= new JScrollPane(affichage);
		affichagePanier.setContentPane(scroll);
		affichagePanier.setVisible(true);
	}
}
