package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import play.db.jpa.JPA;


@Entity
@NamedQuery(name = "findByUser", query = "select r from Requete r where r.user.email=:email")
public class Requete {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String corps;
    private Date date= new Date();
    
    @ManyToOne
    private User user ;
    
    
	@OneToMany(mappedBy="requete")
	private List<BookMarks> bookMarks;

	
	
	
	public Requete() {
		super();
	}

	public Requete(String corps,  List<BookMarks> bookMarks,User user) {
		super();
	    this.user=user;
		this.corps = corps;
		this.bookMarks = bookMarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<BookMarks> getBookMarks() {
		return bookMarks;
	}

	public void setBookMarks(List<BookMarks> bookMarks) {
		this.bookMarks = bookMarks;
	}
    

	
	
	 public static List<Requete> all() {
		 
		 Query query =  JPA.em().createQuery("SELECT e FROM Requete e");
		    return query.getResultList();
		    
		    
	 }
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	

		public static void create(Requete t, String owner) {
			// TODO Auto-generated method stub
	        t.setUser(User.findByEmail(owner));
	        JPA.em().persist(t);
		}
		public void delete(Long id) {
			// TODO Auto-generated method stub
		 JPA.em().remove(JPA.em().find(Requete.class, id));

		}

		public Requete findById(Long id) {
			// TODO Auto-generated method stub
		return	JPA.em().find(Requete.class, id);
		}

		public static List<Requete> findByUser(String name) {
			// TODO Auto-generated method stub
			TypedQuery<Requete> query = JPA.em().createNamedQuery(
					"findByUser", Requete.class);
			query.setParameter("email",name);

			return query.getResultList();   }

		public static boolean isOwner(Long requete, String username) {
			// TODO Auto-generated method stub
			
			Boolean b=false;
			for (Requete f :findByUser(username))
{
	if (f.id==requete) b= true;
	else b= false;
}
			return b;
			
			
		}
		}




