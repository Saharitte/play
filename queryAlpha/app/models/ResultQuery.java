package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class ResultQuery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String queryStatus;
	private  Long responseTime;
	private int nbLigne;
	private byte sizeResult;
	
	public ResultQuery() {
		super();
	}
	public ResultQuery( String status, Long responseTime, int nbLigne, byte sizeResult) {
		super();
		this.queryStatus = status;
		this.responseTime = responseTime;
		this.nbLigne = nbLigne;
		this.sizeResult = sizeResult;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return queryStatus;
	}
	public void setStatus(String status) {
		this.queryStatus = status;
	}
	public Long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}
	public int getNbLigne() {
		return nbLigne;
	}
	public void setNbLigne(int nbLigne) {
		this.nbLigne = nbLigne;
	}
	public byte getSizeResult() {
		return sizeResult;
	}
	public void setSizeResult(byte sizeResult) {
		this.sizeResult = sizeResult;
	} 
	
	
	
	
	
	
}
