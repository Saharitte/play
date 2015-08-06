package controllers;


import play.mvc.*;
import play.data.*;
import play.db.jpa.Transactional;

import static play.data.Form.*;

import models.*;
import views.html.*;

@Transactional
public class Application extends Controller {
	static Form<Requete> requeteForm = Form.form(Requete.class);

	  public static Result index() {
    	  return ok(
    			  views.html.index.render(Requete.all(), requeteForm,  User.findByEmail(request().username())));
   }
    
    
    public static Result login() {
        return ok(
                login.render(form(Login.class))
        );
    }
    
  
 

    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(
            		 "requetes"
            );
        }
    }
               
            
    
    
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
    }
    public static class Login {
        
        public String email;
        public String password;
        
        public String validate() {
            if(User.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
        
    }
    
   
}
