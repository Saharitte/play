package controllers;

import models.Requete;
import models.User;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.*;


@Security.Authenticated(Secured.class)
@Transactional
public class Requetes extends Controller {

	static Form<Requete> requeteForm = Form.form(Requete.class);

	public static Result newRequetes() {
		  Form<Requete> filledForm = requeteForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(
		      views.html.index.render(Requete.all(), filledForm,User.findByEmail(request().username()))
		    );
		  } else {
		    Requete.create(filledForm.get(),request().username());
		    return redirect("requetes");  
		  }

	}

	
    public static Result index() {
    	  return redirect("@routes.Requetes.requetes()");
    }
    
    
    
    public static Result requetes() {
    	  return ok(
    			  views.html.index.render(Requete.all(), requeteForm,  User.findByEmail(request().username())));
   }
  
    
  
 
    

}
