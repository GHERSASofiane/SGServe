
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
import services.ArticleServices;

/**
 *
 * @author Sofiane GHERSA
 */
public class Article extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Article() {
		super();
	}

	// ************************************************** méthode do get
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récuperer le PrintWriter Pour envoyer la réponse
		PrintWriter resp = response.getWriter();

		JsonObject result = new JsonObject();

		// extraire les données qu'on a besoin
		String argArticle = "-1";
		int page = 0;
		int idArt = -1;
		try {
			argArticle = request.getParameter("arg");
		} catch (Exception e) {
			argArticle = "-1";
		}
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 0;
		}
		try {
			idArt = Integer.parseInt(request.getParameter("idArt"));
		} catch (Exception e) {
			idArt = -1;
		}

		// Préparer la répense
		ArticleServices rep = new ArticleServices();
		if (idArt >= 0) {
			result = rep.getArticleId(idArt);
		} else {
			result = rep.getArticles(argArticle, page);
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
		models.Article article = new models.Article();
		article = (models.Article) JSonConverter.objectFromJson(jsObj, article);

		// Préparer la réponse
		ArticleServices rep = new ArticleServices();

		result = rep.addArticle(article);

		// Envoie de réponse
		resp.println(result);
		resp.flush();
	}

	// ************************************************** méthode do delete
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récuperer le PrintWriter Pour envoyer la réponse
		PrintWriter resp = response.getWriter();

		JsonObject result = new JsonObject();

		// extraire les données qu'on a besoin
		int idArticle = -1;
		try {
			idArticle = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			idArticle = -1;
		}

		// Préparer la réponse
		ArticleServices rep = new ArticleServices();
		result = rep.DeleteArticle(idArticle);

		// Envoie de réponse
		resp.println(result);
		resp.flush();
	}

	// ************************************************** Pour la modification d'un
	// article
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récuperer le PrintWriter Pour envoyer la réponse
		PrintWriter resp = response.getWriter();

		JsonObject result = new JsonObject();

		// transférer les données de la requête en Json
		JsonObject jsObj = Readers.getJSONfromRequest(request);

		// extraire les données qu'on a besoin
		models.Article article = new models.Article();
		article = (models.Article) JSonConverter.objectFromJson(jsObj, article);

		// Préparer la réponse
		ArticleServices rep = new ArticleServices();
		result = rep.editeArticle(article);

		// Envoie de réponse
		resp.println(result);
		resp.flush();

	}

}
