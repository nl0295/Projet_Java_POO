package modele;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Article implements ActionListener,ItemListener{
	
	private BDD bdd = new BDD();
	private String id;
	private String nom;
	private double prix;
	private String fabricant;
	private String categorie;
	private String image;
	private String description;
	
	public Article (String pId, String pNom, double pPrix, String pFabricant, String pCategorie, String urlImage) {
		this.id=pId;
		this.nom=pNom;
		this.prix=pPrix;
		this.fabricant=pFabricant;
		this.categorie=pCategorie;
		this.image=urlImage;
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public String getFabricant() {
		return fabricant;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public String getImage() {
		return image;
	}

	public void setDescription(String pDescription) {
		this.description = pDescription;
	}
	
	public JPanel afficheArticle() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JPanel cadre = new JPanel(new BorderLayout());
		JPanel cadreGauche = new JPanel();
		cadreGauche.setLayout(new BoxLayout(cadreGauche, BoxLayout.PAGE_AXIS));
		cadre.setBorder(border);
		JLabel labNom = new JLabel(this.getNom());
		JLabel labPrix = new JLabel(""+this.getPrix()+"$");
		JButton detail = new JButton("+ de détails");
		detail.addActionListener(this);
		
		JCheckBox ajout = new JCheckBox("Ajouter au panier");
		for (Article a : Panier.panier) {
			if (a.equals(this)) {
				ajout.setSelected(true);;
			}
		}
		ajout.addItemListener(this);
		
		ImageIcon icon = new ImageIcon(this.image);
		Image zoom = scaleImage(icon.getImage(),120, 120);
		Icon iconScaled = new ImageIcon(zoom);
		JLabel img = new JLabel(iconScaled);
		
		cadreGauche.add(labNom);
		cadreGauche.add(labPrix);
		cadreGauche.add(detail);
		cadreGauche.add(ajout);
		cadre.add(img,BorderLayout.EAST);
		cadre.add(cadreGauche,BorderLayout.WEST);
		cadre.setPreferredSize(new Dimension(400,120));
		return cadre;
	}
	
	public static Image scaleImage(Image source, int width, int height) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
	
	

	public void actionPerformed(ActionEvent e) {
		try {
			this.bdd.connect();
			this.description=this.bdd.repucDescrArticle(this.id);
			this.bdd.disconnect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, description, "Description", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int state = e.getStateChange();
		if (state == ItemEvent.SELECTED) {
			Panier.ajouterArticle(this);
		}
		else{
			Panier.retirerArticle(this);
		}
	}
	
}
