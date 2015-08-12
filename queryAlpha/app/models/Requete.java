package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	private Long idQuery;
	
	@Column(length = 5000)
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
		return idQuery;
	}

	public void setId(Long id) {
		this.idQuery = id;
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
		 
	return JPA.em().createQuery("from Requete r").getResultList();

		    
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

		public static Requete findById(Long id) {
			// TODO Auto-generated method stub
		return	JPA.em().find(Requete.class, id);
		}

		public static List<Requete> findByUser(String email) {
			// TODO Auto-generated method stub
			TypedQuery<Requete> query = JPA.em().createNamedQuery(
					"findByUser", Requete.class);
			
			query.setParameter("email","test@test.com");

			return query.getResultList();   }
		

		public static List<Requete> findByUserID(Long id) {
			// TODO Auto-generated method stub
		
		
	  return JPA.em()
	            .createQuery("select r from Requete r where r.user.idUser =:id").setParameter("id", id).getResultList();
		}
		

		
		
		
		public static boolean ifBookMarked (Long idQuery,Long idUser) {
			// TODO Auto-generated method stub
			
			
			if (BookMarks.find(idQuery, idUser)!=null){
				return true;
			}else
			
			return false;

		}
		
		
		
		
		public static boolean isOwner(Long requete, String username) {
			// TODO Auto-generated method stub
			
			Boolean b=false;
			for (Requete f :findByUser(username))
{
	if (f.idQuery==requete) b= true;
	else b= false;
}
			return b;
			
			
		}

	
		}




