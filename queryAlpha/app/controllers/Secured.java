package controllers;

import models.Requete;
import play.mvc.*;
import play.mvc.Http.*;
public class Secured extends Security.Authenticator {

	 
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }
    
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Application.login());
    }
    

    public static boolean isOwnerOf(Long requete) {
        return Requete.isOwner(
            requete,
            Context.current().request().username()
        );
    }
    
}