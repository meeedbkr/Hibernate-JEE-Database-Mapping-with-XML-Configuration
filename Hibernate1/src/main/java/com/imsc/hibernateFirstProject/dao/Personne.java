package com.imsc.hibernateFirstProject.dao;

import java.util.HashSet;
import java.util.Set;

public class Personne {
	private long idPersonne;
	private String nomPersonne;
	private String PrenomPersonne;
	private int age;
	private Set<Reunion> reunions = new HashSet();

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return PrenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		PrenomPersonne = prenomPersonne;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(Set<Reunion> reunions) {
		this.reunions = reunions;
	}

}
