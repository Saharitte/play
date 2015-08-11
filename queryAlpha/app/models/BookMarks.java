package models;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

import play.db.jpa.JPA;

@Entity
@Table(name="BookMarks")

@NamedQuery(name = "findBMByUser", query = "select r from BookMarks r where r.user.email=:email")

public class BookMarks {

	@EmbeddedId
	private BookMarksID bookMarksID;
	@ManyToOne
	@JoinColumn(name = "idQuery", referencedColumnName = "idQuery", insertable = false, updatable = false)

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
	public void delete(Long id) {
		// TODO Auto-generated method stub
	 JPA.em().remove(JPA.em().find(BookMarks.class, id));

	}

	public BookMarks findById(Long id) {
		// TODO Auto-generated method stub
	return	JPA.em().find(BookMarks.class, id);
	}

	@SuppressWarnings("unchecked")
	public static List<BookMarks> findByUser(String email) {
		// TODO Auto-generated method stub

		 
				return JPA.em()
			            .createQuery("select r from BookMarks r where  r.user.email=:email").setParameter("email", "test@test.com").getResultList();
				}
				
	
	
	
	 @SuppressWarnings("unchecked")
	public static List<Requete> all() {
		 
		 Query query =  JPA.em().createQuery("SELECT e FROM BookMarks e");
		    return query.getResultList();
		    
		    
	 }
}
