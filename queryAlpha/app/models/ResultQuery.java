package models;

import javax.persistence.Embeddable;

@Embeddable
public class ResultQuery {

	private String queryStatus;
	private  Long responseTime;

	private byte sizeResult;
	
	public ResultQuery() {
		super();
	}
	
	
	public ResultQuery( String status, Long responseTime, byte sizeResult) {
		super();
		this.queryStatus = status;
		this.responseTime = responseTime;
		this.sizeResult = sizeResult;
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
	
	public byte getSizeResult() {
		return sizeResult;
	}
	public void setSizeResult(byte sizeResult) {
		this.sizeResult = sizeResult;
	} 
	
	
	
	
	
	
}
