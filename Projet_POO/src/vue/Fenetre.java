package vue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controleur.BarreOutil;
import controleur.Menu;
import modele.Panier;


public class Fenetre extends JFrame{
	
	static Panier panier = new Panier();
	private BarreOutil barreOutil = new BarreOutil();
	
	public Fenetre() throws ClassNotFoundException, SQLException{
		this.setTitle("E-Commerce");
		this.setSize(600, 560);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setJMenuBar(new Menu());
	    this.setContentPane(barreOutil);
	    this.setVisible(true);
	}


	
	
}
