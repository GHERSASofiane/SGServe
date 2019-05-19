package services;

import com.google.gson.JsonObject;

import DAO.UserDAO;
import converters.JSonConverter;
import models.User;
import status.Reponse;

public class UserServices {
	UserDAO DAO = new UserDAO();

//	Ajouter User
	public JsonObject addUser(User user) {

//		Tester les données envoyé  
		if (user.getNOMUS() == null || user.getNOMUS().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Nom est obligatoire "));

		if (user.getPREUS() == null || user.getPREUS().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Prénom est obligatoire "));

		if (user.getADRUS() == null || user.getADRUS().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Adresse est obligatoire "));

		if (user.getTEL1US() == null || user.getTEL1US().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Téléphone est obligatoire "));

		if (user.getTEL2US() == null || user.getTEL2US().isEmpty())
			user.setTEL2US("");

		if (user.getMAILUS() == null || user.getMAILUS().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Mail est obligatoire "));

		if (user.getMDPUS() == null || user.getMDPUS().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Mot de passe est obligatoire "));

		if (user.getSTATUS() < 0)
			return JSonConverter.objectToJson(new Reponse("ko", "Erreur de Rôle"));

		return JSonConverter.objectToJson(DAO.addUser(user));
	}

//	Modifier User
//	public JsonObject editeUser(User user) {
//
////		Tester les données envoyé  
//		if (user.getNOMUS() == null || user.getNOMUS().isEmpty())
//			return JSonConverter.objectToJson(new Reponse("ko", "Nom est obligatoire "));
//
//		if (user.getPREUS() == null || user.getPREUS().isEmpty())
//			return JSonConverter.objectToJson(new Reponse("ko", "Prénom est obligatoire "));
//
//		if (user.getADRUS() == null || user.getADRUS().isEmpty())
//			return JSonConverter.objectToJson(new Reponse("ko", "Adresse est obligatoire "));
//
//		if (user.getTELUS() == null || user.getTELUS().isEmpty())
//			return JSonConverter.objectToJson(new Reponse("ko", "Téléphone est obligatoire "));
//
//		if (user.getMAILUS() == null || user.getMAILUS().isEmpty())
//			return JSonConverter.objectToJson(new Reponse("ko", "Mail est obligatoire "));
//
//		if (user.getMDPUS() == null || user.getMDPUS().isEmpty())
//			return JSonConverter.objectToJson(new Reponse("ko", "Mot de passe est obligatoire "));
//
//		if (user.getROLUS() < 0 || user.getROLUS() > 3)
//			return JSonConverter.objectToJson(new Reponse("ko", "Erreur de Rôle"));
//
//		return JSonConverter.objectToJson(DAO.editeUser(user));
//	}
//
////	get Users
//	public JsonObject getUsers(String arg) {
//
//		if (arg == null || arg.isEmpty())
//			return JSonConverter.objectToJson(new Reponse("ko", "Aucun clé de recherche"));
//
//		return JSonConverter.objectToJson(DAO.getUsers(arg));
//	}
//
////	delete User
//	public JsonObject DeleteUser(int id) {
//
//		if (id < 0)
//			return JSonConverter.objectToJson(new Reponse("ko", "User Invalide"));
//
//		return JSonConverter.objectToJson(DAO.DeleteUser(id));
//	}

}
