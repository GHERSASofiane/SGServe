package services;

import java.util.Calendar;

import com.google.gson.JsonObject;

import DAO.ArticleDAO;
import converters.JSonConverter;
import models.Article;
import status.Reponse;

public class ArticleServices {
	ArticleDAO DAO = new ArticleDAO();

//	Ajouter Article
	public JsonObject addArticle(Article article) {
//		Tester les données envoyé  
		if (article.getNOMART() == null || article.getNOMART().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Nom est obligatoire "));

		if (article.getDESART() == null || article.getDESART().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Description est obligatoire "));

		if (article.getCOLART() == null || article.getCOLART().isEmpty())
			article.setCOLART("");

		if (article.getCODART() == null || article.getCODART().isEmpty())
			article.setCODART("");

		if (article.getIM1ART() == null || article.getIM1ART().isEmpty())
			article.setIM1ART("");

		return JSonConverter.objectToJson(DAO.addArticle(article));
	}

//	Modifier Article
	public JsonObject editeArticle(Article article) {
//		Tester les données envoyé  
		if (article.getNOMART() == null || article.getNOMART().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Nom est obligatoire "));

		if (article.getDESART() == null || article.getDESART().isEmpty())
			return JSonConverter.objectToJson(new Reponse("ko", "Description est obligatoire "));

		if (article.getCOLART() == null || article.getCOLART().isEmpty())
			article.setCOLART("");

		if (article.getCODART() == null || article.getCODART().isEmpty())
			article.setCODART("");

		if (article.getIM1ART() == null || article.getIM1ART().isEmpty())
			article.setIM1ART("");

		return JSonConverter.objectToJson(DAO.editeArticle(article));
	}

//	get Articles
	public JsonObject getArticles(String argArticle, int page) {
		if (argArticle.equals("-1"))
			return JSonConverter.objectToJson(DAO.getArticles(page));

		return JSonConverter.objectToJson(DAO.getArticle(argArticle));
	}

//	get Article par id
	public JsonObject getArticleId(int id) {
		return JSonConverter.objectToJson(DAO.getArticleId(id));
	}

//	delete Articles
	public JsonObject DeleteArticle(int id) {
		if (id == 0 || id == -1)
			return JSonConverter.objectToJson(new Reponse("ko", "Id est obligatoire "));

		return JSonConverter.objectToJson(DAO.DeleteArticle(id));
	}

	public String getDate() {
		String Mydate = "";
		Calendar calendar = Calendar.getInstance();
		Mydate = Mydate.concat(Integer.toString(calendar.get(calendar.YEAR)));
		Mydate = Mydate.concat("-");
		Mydate = Mydate.concat(Integer.toString(calendar.get(calendar.MONTH) + 1));
		Mydate = Mydate.concat("-");
		Mydate = Mydate.concat(Integer.toString(calendar.get(calendar.DAY_OF_MONTH)));

		return Mydate;
	}
}
