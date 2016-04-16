package controleur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import modele.Article;
import modele.BDD;

public class Recherche extends JPanel implements ActionListener{
	private BDD bdd = new BDD();
	private JButton recherche = new JButton("Rechercher");
	private JTextField champ = new JTextField("Champ de recherche");
	
	public Recherche () {
		this.recherche.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(180,45));
		this.add(recherche,BorderLayout.SOUTH);
		this.add(champ,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JPanel affichageResultat = new JPanel();
		JPanel affichage = new JPanel();
		affichageResultat.setPreferredSize(new Dimension (400,500));
		affichage.setLayout(new BoxLayout(affichage,BoxLayout.PAGE_AXIS));
		Stack<Article> resultats = new Stack<Article>();
		 try {
			this.bdd.connect();
			resultats = this.bdd.rechercheArticle(champ.getText());
			this.bdd.disconnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		if (resultats.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Aucun résultat trouvé!", "Attention", JOptionPane.WARNING_MESSAGE);
		}
		else {
			for (Article a : resultats) {
				affichage.add(a.afficheArticle());
			}	
			affichageResultat.add(new JScrollPane(affichage));
			((BarreOutil) this.getParent().getParent()).setAffichage(affichageResultat);
		}
	}

}
