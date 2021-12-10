package com.marcioccp.api.dominio;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_value")
public class Value {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer sequencial;
	
	public Integer getSequencial() {
		return sequencial;
	}
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}


	private String  ID;	
	private String  Alias;
	private Date  CurrentReleaseDate;
	private String  CvrfUrl;
	private String  DocumentTitle;
	
	private Date  InitialReleaseDate;
	private String  Severity;
	
	
	public String getAlias() {
		return Alias;
	}
	public void setAlias(String alias) {
		Alias = alias;
	}
	public Date getCurrentReleaseDate() {
		return CurrentReleaseDate;
	}
	public void setCurrentReleaseDate(Date currentReleaseDate) {
		CurrentReleaseDate = currentReleaseDate;
	}
	public String getCvrfUrl() {
		return CvrfUrl;
	}
	public void setCvrfUrl(String cvrfUrl) {
		CvrfUrl = cvrfUrl;
	}
	public String getDocumentTitle() {
		return DocumentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		DocumentTitle = documentTitle;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Date getInitialReleaseDate() {
		return InitialReleaseDate;
	}
	public void setInitialReleaseDate(Date initialReleaseDate) {
		InitialReleaseDate = initialReleaseDate;
	}
	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	
	
	@Override
	public String toString() {
		return "Update [Alias=" + Alias + ", CurrentReleaseDate=" + CurrentReleaseDate + ", CvrfUrl=" + CvrfUrl
				+ ", DocumentTitle=" + DocumentTitle + ", ID=" + ID + ", InitialReleaseDate=" + InitialReleaseDate
				+ ", Severity=" + Severity + "]";
	}


}
