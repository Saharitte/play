
package controllers;


import static play.data.Form.form;

import models.BookMarks;
import models.BookMarksID;
import models.Requete;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;


@Security.Authenticated(Secured.class)
@Transactional
public class Bookmarkss extends Controller {

	
	 public static Result index() {
   	  return redirect(routes.Requetes.requetes());
   }
   
   
		public static Result newBookMarks(Long idQuery) {
		  BookMarks.create( new BookMarks( new BookMarksID( User.findByEmail(request().username()).getId(),idQuery),  Requete.findById(idQuery),  User.findByEmail(request().username())));
			
	   	  return redirect(routes.Requetes.requetes());

		
			
 		    }
			
			
		public static Result deleteBookMarks(Long idQuery) {
				  BookMarks.delete(idQuery,User.findByEmail(request().username()).getId()  );
		
			   	  return redirect(routes.Requetes.requetes());

			
 		    }
	

 
   
	
	
}