package models;

import java.util.List;

import javax.persistence.*;

import play.db.jpa.JPA;

@Entity
@Table(name="BookMarks")

@NamedQuery(name = "findBMByUser", query = "select r from BookMarks r where r.user.email=:email")

public class BookMarks {

	@EmbeddedId
	private BookMarksID bookMarksID;
	@JoinColumn(name = "idQuery", referencedColumnName = "idQuery", insertable = false, updatable = false)
	@ManyToOne
	private Requete requete;
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private User user;
	
	
	
	
	public BookMarks() {
		super();
	}
	public BookMarks(BookMarksID bookMarksID, Requete requete, User user) {
		super();
		this.bookMarksID = bookMarksID;
		this.requete = requete;
		this.user = user;
	}
	public BookMarksID getBookMarksID() {
		return bookMarksID;
	}
	public void setBookMarksID(BookMarksID bookMarksID) {
		this.bookMarksID = bookMarksID;
	}
	public Requete getRequete() {
		return requete;
	}
	public void setRequete(Requete requete) {
		this.requete = requete;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public static void create(BookMarks t) {
		// TODO Auto-generated method stub
        JPA.em().persist(t);

	}
	public static void delete(Long idQuery,Long idUser) {
		// TODO Auto-generated method stub

		
    JPA.em().remove(JPA.em().find(BookMarks.class, new BookMarksID(idUser,idQuery)));


	}
	
	
	
	public static BookMarks find(Long idQuery,Long idUser) {
		// TODO Auto-generated method stub
		
		return  (BookMarks) JPA.em().createQuery("select r from BookMarks r where  r.user.idUser=:idUser and r.requete.idQuery=:idQuery").setParameter("idUser", idUser).setParameter("idQuery", idQuery).getSingleResult();
	
		

	}
	
	

	public BookMarks findById(Long id) {
		// TODO Auto-generated method stub
	return	JPA.em().find(BookMarks.class, id);
	}

	public static List<BookMarks> findByUser(String email) {
		// TODO Auto-generated method stub

		 
				return JPA.em()
			            .createQuery("select r from BookMarks r where  r.user.email=:email").setParameter("email", "test@test.com").getResultList();
				}
				
	
	
	
	public static List<Requete> all() {
		 
		 Query query =  JPA.em().createQuery("SELECT e FROM BookMarks e");
		    return query.getResultList();
		    
		    
	 }
}
