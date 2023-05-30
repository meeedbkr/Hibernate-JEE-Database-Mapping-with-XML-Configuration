package com.imsc.hibernateFirstProject.dao;

import java.util.Date;

public class Reunion {
	private Long idReunion;
	private Date dateReunion;
	private String titleReunion;

	public Reunion() {
	}

	public Reunion(String titre, Date dateReunion) {
		this.titleReunion = titre;
		this.dateReunion = dateReunion;
	}

	public Long getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(Long idReunion) {
		this.idReunion = idReunion;
	}

	public Date getDateReunion() {
		return dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}

	public String getTitleReunion() {
		return titleReunion;
	}

	public void setTitleReunion(String titleReunion) {
		this.titleReunion = titleReunion;
	}

}
