package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modele.Article;
import modele.BDD;

public class Affichage extends JPanel {

	private BDD bdd = new BDD();
	private JPanel affichage = new JPanel();
	
	public Affichage() throws SQLException, ClassNotFoundException {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension (400,500));
		this.affichage.setLayout(new BoxLayout(this.affichage,BoxLayout.PAGE_AXIS));
		 this.bdd.connect();
	    	for (Article a : this.bdd.recupListeArticle()) {
	    		this.affichage.add(a.afficheArticle());
	    	}
	    this.bdd.disconnect();
	    JScrollPane scroll = new JScrollPane(this.affichage);
	    this.add(scroll, BorderLayout.CENTER);
	}
	
	
	public Affichage(String categorie) throws SQLException, ClassNotFoundException {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension (400,500));
		this.affichage.setLayout(new BoxLayout(this.affichage,BoxLayout.PAGE_AXIS));
		 this.bdd.connect();
	    	for (Article a : this.bdd.recupListeArticle(categorie)) {
	    		this.affichage.add(a.afficheArticle());
	    	}
	    this.bdd.disconnect();
	    JScrollPane scroll = new JScrollPane(this.affichage);
	    this.add(scroll, BorderLayout.CENTER);
	}
	
}
