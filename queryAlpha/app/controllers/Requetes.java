package controllers;

import static play.data.Form.form;

import models.BookMarks;
import models.Requete;
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
		  if(filledForm.hasErrors()) {
		    return badRequest(
	    		      views.html.index.render(Requete.findByUserID(User.findByEmail(request().username()).getId()), requeteForm,User.findByEmail(request().username()),BookMarks.findByUser(request().username()),Requete.all()));  

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
    		      views.html.index.render(Requete.findByUserID(User.findByEmail(request().username()).getId()), requeteForm,User.findByEmail(request().username()),BookMarks.findByUser(request().username()),Requete.all()));  

  
    
    }
 
//    public static Result copyQuery(Long id) {
//        Form<Requete> computerForm = Requete.class.fill(
//            Requete.findById(id)
//        );
//        return ok(
//            editForm.render(id, computerForm)
//        );
//    }

}
