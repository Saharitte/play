package controllers;

import org.apache.spark.sql.DataFrame;

import models.BookMarks;
import models.Requete;
import models.ResultQuery;
import models.User;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

@Security.Authenticated(Secured.class)
@Transactional
public class Requetes extends Controller {

	static Form<Requete> requeteForm = Form.form(Requete.class);

	public static Result newRequetes() {
		Form<Requete> filledForm = requeteForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(
					Requete.findByUserID(User.findByEmail(request().username()).getId()), requeteForm,
					User.findByEmail(request().username()), BookMarks.findByUser(request().username()), Requete.all()));

		} else {

			//
			long start = System.currentTimeMillis();
			
			DataFrame queryResult = Global.sqlContext.sql(filledForm.get().getCorps());
			// The sql function on a SQLContext enables applications to run SQL queries
			// programmatically and returns the result as a DataFrame.

			long end = System.currentTimeMillis();
			long executionTime = end - start;
			
			
			queryResult.registerTempTable("result");
           long resultSize= queryResult.count();

			Requete query=filledForm.get();
			ResultQuery resultQuery= new ResultQuery("running", executionTime,  (byte) 867);
			query.setResultQuery(resultQuery);
			
			// DataFrames can be saved as Parquet files, maintaining the schema information.
			queryResult.write().parquet("query"+query.getId()+".parquet");
			
			
			// Insert Query into Mysql database
			Requete.create(query, request().username());
			return redirect("requetes");
		}

	}



	public static Result index() {
		return redirect("@routes.Requetes.requetes()");
	}

	public static Result requetes() {
		return ok(views.html.index.render(Requete.findByUserID(User.findByEmail(request().username()).getId()),
				requeteForm, User.findByEmail(request().username()), BookMarks.findByUser(request().username()),
				Requete.all()));

	}

	public static Result showResult(Long id) {
		
		DataFrame parquetFile = Global.sqlContext.read().parquet("query"+id+".parquet");
	
		
		
		return redirect("requetes");
	}

}
