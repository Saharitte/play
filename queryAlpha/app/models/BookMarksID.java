package models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BookMarksID  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idUser;
	private Long idQuery;
	
	
	
	
	
	public BookMarksID() {
		super();
	}
	public BookMarksID(Long idUser, Long idQuery) {
		super();
		this.idUser = idUser;
		this.idQuery = idQuery;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdQuery() {
		return idQuery;
	}
	public void setIdQuery(Long idQuery) {
		this.idQuery = idQuery;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idQuery == null) ? 0 : idQuery.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookMarksID other = (BookMarksID) obj;
		if (idQuery == null) {
			if (other.idQuery != null)
				return false;
		} else if (!idQuery.equals(other.idQuery))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
	
	
	
}
