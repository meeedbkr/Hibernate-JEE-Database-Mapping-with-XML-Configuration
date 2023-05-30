package com.imsc.hibernateFirstProject.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reunion {
	private Long idReunion;
	private Date dateReunion;
	private String titleReunion;
	private Set<Personne> personnes = new HashSet();

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

	public Set getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Set personnes) {
		this.personnes = personnes;
	}

	@Override
	public String toString() {
		return "Reunion [idReunion=" + 
	idReunion + ", dateReunion=" + 
	dateReunion + ", titleReunion=" + 
	titleReunion + "]";
	}

}
