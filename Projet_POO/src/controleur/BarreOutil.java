package controleur;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vue.Affichage;
import modele.BDD;



public class BarreOutil extends JPanel implements ListSelectionListener{
	
	private JPanel outils = new JPanel(new FlowLayout(FlowLayout.LEADING,0,0)); 
	private JPanel affichage;
	private BDD bdd = new BDD();
	Vector<String> vectCateg;
	private JList categories;
	private JScrollPane scrollCategorie;
	
	
	public BarreOutil() throws SQLException, ClassNotFoundException {
		this.setSize(600, 500);
		
		this.bdd.connect();
		vectCateg = this.bdd.recupListeCategorie();
		this.bdd.disconnect();
		vectCateg.addElement("Tout");
		
		this.categories = new JList(vectCateg);
		this.categories.addListSelectionListener(this);
		this.scrollCategorie = new JScrollPane(categories);
		this.scrollCategorie.setPreferredSize(new Dimension (180,450));
		this.affichage = new Affichage();
		this.affichage.setPreferredSize(new Dimension(400,500));
		this.outils.setPreferredSize(new Dimension (180,500));
		
		outils.add(scrollCategorie);
		outils.add(new Recherche());
		this.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		this.add(outils);
		this.add(affichage);
	}
	



	public void setAffichage(JPanel pAffichage) {
		this.remove(affichage);
		this.affichage = pAffichage;
		this.add(affichage);
		this.revalidate();
		this.repaint();
	}




	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (((JList) e.getSource()).getSelectedValue()=="Tout") {
			try {
				this.setAffichage(new Affichage());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else {
			String categorie = (String) ((JList) e.getSource()).getSelectedValue();
			try {
				this.setAffichage(new Affichage(categorie));
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
