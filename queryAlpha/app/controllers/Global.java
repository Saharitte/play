package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;

/**
 * 
 * @author saharbenarfa
 * 
 * One important aspect of the GlobalSettings class is 
 * that it provides a way to intercept requests
 * and execute business logic before a request is dispatched to an action.
 * 
 * Ps:　　It’s also possible to intercept a specific action method. 
 * This can be achieved via Action composition.


 *
 */
public class Global extends GlobalSettings {

	
//	//Intercepting application start-up and shutdown
//	
//	public void onStart(Application app) {
//	    Logger.info("Application has started");
//	  }  
//	  
//	  public void onStop(Application app) {
//	    Logger.info("Application shutdown...");
//	  }  
//	    
//	
//	//Providing an application error page
//
//
//	    public Promise<SimpleResult> onError(RequestHeader request, Throwable t) {
//	        return Promise.<SimpleResult>pure(internalServerError(
//	            views.html.errorPage.render(t)
//	        ));
//	    }
//
//	    
//	  
//	//Handling action not found
//  
//	  
//	    public Promise<SimpleResult> onHandlerNotFound(RequestHeader request) {
//	        return Promise.<SimpleResult>pure(notFound(
//	            views.html.notFoundPage.render(request.uri())
//	        ));
//	    }
//  
//	  
//	  
////onBadRequest 
//	    public Promise<SimpleResult> onBadRequest(RequestHeader request, String error) {
//	        return Promise.<SimpleResult>pure(badRequest("Don't try to hack the URI!"));
//	    }
}
