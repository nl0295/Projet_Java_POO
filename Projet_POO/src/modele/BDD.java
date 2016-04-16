package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.util.Vector;

public class BDD {

	private String url = "jdbc:mysql://localhost/projet_poo?";
	private String login = "root";
	private String passwd = "";
	private Connection connexion=null;
	private Statement stm;
	private String requeteRecupArticle="SELECT Id, Nom, Prix, Fabricant, Categorie, Image FROM Article";
	private String requeteRecupCategorie="SELECT DISTINCT Categorie FROM Article";
	private String requeteDescriptionArticle="SELECT Description FROM Article WHERE Id = '";
	
			
		
	public void connect() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection(url,login,passwd);	
			stm = connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		
		public Stack<Article> recupListeArticle() throws SQLException {
			ResultSet res = stm.executeQuery(requeteRecupArticle);
			Stack<Article> liste= new Stack<Article>();
			
			while(res.next()) {
				String pId = res.getString(1);
				String pNom = res.getString(2);
				double pPrix = res.getDouble(3);
				String pFabricant = res.getString(4);
				String pCategorie = res.getString(5);
				String pImage = res.getString(6);
				
				Article article = new Article(pId, pNom, pPrix, pFabricant, pCategorie, pImage)  ;
				liste.push(article);
			}
			res.close();
			return liste;
		}
		
		public Stack<Article> recupListeArticle(String categorie) throws SQLException {
			String requeteRecupCategArticle =requeteRecupArticle+" WHERE Categorie='"+categorie+"'";
			ResultSet res = stm.executeQuery(requeteRecupCategArticle);
			Stack<Article> liste= new Stack<Article>();
			
			while(res.next()) {
				String pId = res.getString(1);
				String pNom = res.getString(2);
				double pPrix = res.getDouble(3);
				String pFabricant = res.getString(4);
				String pImage = res.getString(6);
				
				Article article = new Article(pId, pNom, pPrix, pFabricant, categorie, pImage)  ;
				liste.push(article);
			}
			res.close();
			return liste;
		}
		
		public Stack<Article> rechercheArticle(String recherche) throws SQLException {
			String requeteRechercheArticle =requeteRecupArticle+" WHERE Nom LIKE'%"+recherche+"%'";
			ResultSet res = stm.executeQuery(requeteRechercheArticle);
			Stack<Article> liste= new Stack<Article>();
			
			while(res.next()) {
				String pId = res.getString(1);
				String pNom = res.getString(2);
				double pPrix = res.getDouble(3);
				String pFabricant = res.getString(4);
				String pCategorie = res.getString(5);
				String pImage = res.getString(6);
				
				Article article = new Article(pId, pNom, pPrix, pFabricant, pCategorie, pImage)  ;
				liste.push(article);
			}
			res.close();
			return liste;
		}
		
		public Vector<String> recupListeCategorie() throws SQLException {
			ResultSet res = stm.executeQuery(requeteRecupCategorie);
			Vector<String> liste= new Vector<String>();
			
			while(res.next()) {
				liste.addElement(res.getString(1));
			}
			res.close();
			return liste;
		}
		
		
		
		public String repucDescrArticle(String pId) throws SQLException {
			requeteDescriptionArticle+=pId+"'";
			ResultSet res = stm.executeQuery(requeteDescriptionArticle);
			if (res.next()) return res.getString(1);
			else return "";
		}
		
		
		
		
		
		public void disconnect() throws SQLException {
			connexion.close();
		}
	}


