package DAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configuration.Connexion;
import models.Article;
import status.Reponse;

public class ArticleDAO {
	private Connection db;

//	Add Article
	public Reponse addArticle(Article article) {
		try {

			db = Connexion.getConnection();
			String query = "INSERT INTO Article "
					+ "(NOMART,DESART,PNART,LGART,HTART,PFART,COLART,CODART,IM1ART,CATGART)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, article.getNOMART().toLowerCase());
			preparedStmt.setString(2, article.getDESART().toLowerCase());
			preparedStmt.setDouble(3, article.getPNART());
			preparedStmt.setDouble(4, article.getLGART());
			preparedStmt.setDouble(5, article.getHTART());
			preparedStmt.setDouble(6, article.getPFART());
			preparedStmt.setString(7, article.getCOLART());
			preparedStmt.setString(8, article.getCODART());
			preparedStmt.setString(9, article.getIM1ART());
			preparedStmt.setInt(10, article.getCATGART());

			// execute the prepared statement
			preparedStmt.execute();
			preparedStmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Impossible d'ajouter votre article");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Impossible d'ajouter votre article");
		}

		return new Reponse("ok", "Votre article est ajouter ");
	}

//	Modifier Article
	public Reponse editeArticle(Article article) {
		try {

			db = Connexion.getConnection();
			String query = "UPDATE Article SET "
					+ "NOMART=?,DESART=?,PNART=?,LGART=?,HTART=?,PFART=?,COLART=?,CODART=?,IM1ART=?,CATGART=? "
					+ " WHERE IDART=? ";
			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, article.getNOMART().toLowerCase());
			preparedStmt.setString(2, article.getDESART().toLowerCase());
			preparedStmt.setDouble(3, article.getPNART());
			preparedStmt.setDouble(4, article.getLGART());
			preparedStmt.setDouble(5, article.getHTART());
			preparedStmt.setDouble(6, article.getPFART());
			preparedStmt.setString(7, article.getCOLART());
			preparedStmt.setString(8, article.getCODART());
			preparedStmt.setString(9, article.getIM1ART());
			preparedStmt.setInt(10, article.getCATGART());
			preparedStmt.setInt(11, article.getIDART());

			// execute the prepared statement
			preparedStmt.execute();
			preparedStmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Impossible de modifier votre article");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Impossible de modifier votre article");
		}

		return new Reponse("ok", "Votre article est modifié ");
	}

//	get Articles
	public Reponse getArticles(int page) {
		List<Article> res = new ArrayList<Article>();
		Article tmp;

		try {
			db = Connexion.getConnection();

			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Article ORDER BY IDART LIMIT 10 OFFSET " + (page * 10));

			while (rs.next()) {
				tmp = new Article();
				tmp.setIDART(rs.getInt("IDART"));
				tmp.setCATGART(rs.getInt("CATGART"));
				tmp.setPNART(rs.getDouble("PNART"));
				tmp.setLGART(rs.getDouble("LGART"));
				tmp.setHTART(rs.getDouble("HTART"));
				tmp.setPFART(rs.getDouble("PFART"));
				tmp.setNOMART(rs.getString("NOMART"));
				tmp.setDESART(rs.getString("DESART"));
				tmp.setCOLART(rs.getString("COLART"));
				tmp.setCODART(rs.getString("CODART"));
				tmp.setIM1ART(rs.getString("IM1ART"));

				res.add(tmp);

			}
			stmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		}
		return new Reponse("ok", res);
	}

//	get Article par id
	public Reponse getArticleId(int id) {
		List<Article> res = new ArrayList<Article>();
		Article tmp;

		try {
			db = Connexion.getConnection();

			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Article WHERE IDART=" + id);

			while (rs.next()) {
				tmp = new Article();
				tmp.setIDART(rs.getInt("IDART"));
				tmp.setCATGART(rs.getInt("CATGART"));
				tmp.setPNART(rs.getDouble("PNART"));
				tmp.setLGART(rs.getDouble("LGART"));
				tmp.setHTART(rs.getDouble("HTART"));
				tmp.setPFART(rs.getDouble("PFART"));
				tmp.setNOMART(rs.getString("NOMART"));
				tmp.setDESART(rs.getString("DESART"));
				tmp.setCOLART(rs.getString("COLART"));
				tmp.setCODART(rs.getString("CODART"));
				tmp.setIM1ART(rs.getString("IM1ART"));

				res.add(tmp);

			}
			stmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		}
		return new Reponse("ok", res);
	}

//	get Article avec nom ou code barre 
	public Reponse getArticle(String arg) {
		List<Article> res = new ArrayList<Article>();
		Article tmp;

		try {
			db = Connexion.getConnection();
			String query = "SELECT * FROM Article WHERE CODART=? OR NOMART LIKE ? ORDER BY IDART ";
			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, arg);
			preparedStmt.setString(2, "%" + arg.toLowerCase() + "%");
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				tmp = new Article();
				tmp.setIDART(rs.getInt("IDART"));
				tmp.setCATGART(rs.getInt("CATGART"));
				tmp.setPNART(rs.getDouble("PNART"));
				tmp.setLGART(rs.getDouble("LGART"));
				tmp.setHTART(rs.getDouble("HTART"));
				tmp.setPFART(rs.getDouble("PFART"));
				tmp.setNOMART(rs.getString("NOMART"));
				tmp.setDESART(rs.getString("DESART"));
				tmp.setCOLART(rs.getString("COLART"));
				tmp.setCODART(rs.getString("CODART"));
				tmp.setIM1ART(rs.getString("IM1ART"));

				res.add(tmp);

			}
			rs.close();
			preparedStmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		}
		return new Reponse("ok", res);
	}

//	delete Articles
	public Reponse DeleteArticle(int id) {

		try {
			db = Connexion.getConnection();
			String query = "DELETE FROM Article WHERE IDART = ?";
			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setInt(1, id);

			// execute the prepared statement
			preparedStmt.execute();
			preparedStmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Server error");
		}
		return new Reponse("ok", "Votre Article est bien supprimer");
	}

}
