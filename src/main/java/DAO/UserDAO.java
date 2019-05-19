package DAO;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configuration.Connexion;
import models.User;
import status.Reponse;

public class UserDAO {
	private Connection db;

//	Ajouter User
	public Reponse addUser(User user) {
		try {
			
			db = Connexion.getConnection();
			String query = "INSERT INTO Users " + "( NOMUS,PREUS,ADRUS,TEL1US,TEL2US,MAILUS,MDPUS,STATUS )"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, user.getNOMUS().toLowerCase());
			preparedStmt.setString(2, user.getPREUS().toLowerCase());
			preparedStmt.setString(3, user.getADRUS().toLowerCase());
			preparedStmt.setString(4, user.getTEL1US().toLowerCase());
			preparedStmt.setString(5, user.getTEL2US().toLowerCase());
			preparedStmt.setString(6, user.getMAILUS().toLowerCase());
			preparedStmt.setString(7, user.getMDPUS()); 
			preparedStmt.setDouble(8, user.getSTATUS()); 

			// execute the prepared statement
			preparedStmt.execute();
			preparedStmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Impossible d'ajouter votre utilisateur");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Impossible d'ajouter votre utilisateur");
		}

		return new Reponse("ok", "Votre utilisateur est ajouter ");
	}

//	Modifier User
//	public Reponse editeUser(User user) {
//		try {
//
//			db = Connexion.getConnection();
//			String query = "UPDATE Users SET "
//					+ "NOMUS=?,PREUS=?,ADRUS=?,TELUS=?,MAILUS=?,MDPUS=?,IDUS=?,ROLUS=?,LTUS=?,LGUS=? "
//					+ " WHERE IDUS=? ";
//			PreparedStatement preparedStmt = db.prepareStatement(query);
//			preparedStmt.setString(1, user.getNOMUS().toUpperCase());
//			preparedStmt.setString(2, user.getPREUS().toLowerCase());
//			preparedStmt.setString(3, user.getADRUS().toLowerCase());
//			preparedStmt.setString(4, user.getTELUS().toLowerCase());
//			preparedStmt.setString(5, user.getMAILUS().toLowerCase());
//			preparedStmt.setString(6, user.getMDPUS().toLowerCase());
//			preparedStmt.setInt(7, user.getIDUS());
//			preparedStmt.setInt(8, user.getROLUS());
//			preparedStmt.setDouble(9, user.getLTUS());
//			preparedStmt.setDouble(10, user.getLGUS());
//			preparedStmt.setInt(11, user.getIDUS());
//
//			// execute the prepared statement
//			preparedStmt.execute();
//			preparedStmt.close();
//			db.close();
//
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return new Reponse("ko", "Impossible de modifier votre user");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return new Reponse("ko", "Impossible de modifier votre user");
//		}
//
//		return new Reponse("ok", "Votre user est modifié ");
//	}
//
////	get Users
//	public Reponse getUsers(String arg) {
//		List<User> res = new ArrayList<User>();
//		User tmp;
//		int idus = -1;
//		try {
//			idus = Integer.parseInt(arg.trim());
//		} catch (Exception e) {
//		}
//
//		try {
//
//			db = Connexion.getConnection();
//			String query = "SELECT * FROM Users WHERE IDUS=? OR NOMUS LIKE ? "
//					+ " OR PREUS LIKE ? OR TELUS LIKE ? OR MAILUS LIKE ? ";
//			PreparedStatement preparedStmt = db.prepareStatement(query);
//			preparedStmt.setInt(1, idus);
//			preparedStmt.setString(2, "%" + arg.toLowerCase() + "%");
//			preparedStmt.setString(3, "%" + arg.toLowerCase() + "%");
//			preparedStmt.setString(4, "%" + arg.toLowerCase() + "%");
//			preparedStmt.setString(5, "%" + arg.toLowerCase() + "%");
//
//			ResultSet rs = preparedStmt.executeQuery();
//			while (rs.next()) {
//
//				tmp = new User();
//				tmp.setLGUS(rs.getDouble("LGUS"));
//				tmp.setLTUS(rs.getDouble("LTUS"));
//				tmp.setROLUS(rs.getInt("ROLUS"));
//				tmp.setIDUS(rs.getInt("IDUS"));
//				tmp.setNOMUS(rs.getString("NOMUS"));
//				tmp.setPREUS(rs.getString("PREUS"));
//				tmp.setADRUS(rs.getString("ADRUS"));
//				tmp.setTELUS(rs.getString("TELUS"));
//				tmp.setMAILUS(rs.getString("MAILUS"));
//				tmp.setMDPUS(rs.getString("MDPUS"));
//
//				res.add(tmp);
//
//			}
//			rs.close();
//			preparedStmt.close();
//			db.close();
//
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return new Reponse("ko", "Server error");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return new Reponse("ko", "Server error");
//		}
//		return new Reponse("ok", res);
//	}
//
////	delete User
//	public Reponse DeleteUser(int id) {
//
//		try {
//			db = Connexion.getConnection();
//			String query = "UPDATE Users SET STATUS=2 WHERE IDUS = ?";
//			PreparedStatement preparedStmt = db.prepareStatement(query);
//			preparedStmt.setInt(1, id);
//
//			// execute the prepared statement
//			preparedStmt.execute();
//			preparedStmt.close();
//			db.close();
//
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//			return new Reponse("ko", "Server error");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return new Reponse("ko", "Server error");
//		}
//		return new Reponse("ok", "Votre User est bien archivé");
//	}

}
