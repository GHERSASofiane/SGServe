
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import helpers.Readers;
import services.UserServices;
import status.Reponse;

/**
 *
 * @author Sofiane GHERSA
 */
public class User extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	// ************************************************** méthode do get
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récuperer le PrintWriter Pour envoyer la réponse
		PrintWriter resp = response.getWriter();

		JsonObject result = new JsonObject();

		// Préparer la répense
		UserServices rep = new UserServices();

		// extraire les données qu'on a besoin
		String req = "-1";
		try {
			req = request.getParameter("req");
		} catch (Exception e) {
		}

		if (req.equals("1")) {
			String arg = "-1";
			try {
				arg = request.getParameter("arg");
			} catch (Exception e) {
			}
//			result = rep.getUsers(arg);
		} else {
			result = JSonConverter.objectToJson(new Reponse("ko", "Requete non disponible "));
		}
		int page = 0;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		}

		// Envoie de réponse
		resp.println(result);
		resp.flush();
	}

	// ************************************************** méthode do post
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récuperer le PrintWriter Pour envoyer la réponse
		PrintWriter resp = response.getWriter();

		JsonObject result = new JsonObject();

		// transférer les données de la requête en Json
		JsonObject jsObj = Readers.getJSONfromRequest(request);
		// extraire les données qu'on a besoin
		models.User user = new models.User();
		user = (models.User) JSonConverter.objectFromJson(jsObj, user);

		// Préparer la réponse
		UserServices rep = new UserServices();

		if (user.getCMD().equals("Inscription")) {
			result = rep.InscriptionUser(user);
		}

		// Envoie de réponse
		resp.println(result);
		resp.flush();
	}

}
