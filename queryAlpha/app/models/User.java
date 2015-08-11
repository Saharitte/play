package models;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;
import play.db.jpa.JPA;

/**
 * User entity managed by JPA
 */
@Entity 
@NamedQueries({@NamedQuery(name = "findByCredentials", query = "select a from User a where a.email =:email AND a.password =:password") ,
	@NamedQuery(name = "findByEmail", query = "select a from User a where a.email =:email"),
	@NamedQuery(name = "findByName", query = "select a from User a where a.name =:name")})

public class User  implements Serializable   {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    @Formats.NonEmpty
    private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUser;

    @Constraints.Required
    private String name;
    
    @Constraints.Required
    private String password;
    
    
    @OneToMany(mappedBy="user")
    private List<Requete> requetes;
    
    // -- Queries
    
    
    /**
     * Retrieve all users.
     */
    @SuppressWarnings("unchecked")
	public static List<User> findAll() {
   	 Query query =  JPA.em().createQuery("SELECT a FROM account a");
	    return query.getResultList();	}

    /**
     * Retrieve a User from email.
     */
    public static User findByEmail(String email) {
  
		return (User) JPA.em()
	            .createQuery("select r from User r where r.email =:email").setParameter("email", "test@test.com").getSingleResult();
		}
		
    
    public static User findByID(Long id) {
    	  
    			return JPA.em().find(User.class, id)
    		            ;}
    		
    
    
    
    /**
     * Retrieve a User from username.
     */
    public static User find(String name) {
    	TypedQuery<User> query = JPA.em().createNamedQuery(
				"findByName", User.class);
		query.setParameter("name", name);

		return query.getSingleResult();    }
    
    
    /**
     * Authenticate a User.
     */
    public static User authenticate(String email, String password) {
    	TypedQuery<User> query = JPA.em().createNamedQuery(
				"findByCredentials", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);

		return query.getSingleResult();
    }
    
    // --
    
    public String toString() {
        return "User(" + email + ")";
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Requete> getRequetes() {
		return requetes;
	}

	public void setRequetes(List<Requete> requetes) {
		this.requetes = requetes;
	}

	public Long getId() {
		return idUser;
	}

	public void setId(Long id) {
		this.idUser = id;
	}

}

