package com.imsc.OneToManyProject.dao;

import java.util.HashSet;
import java.util.Set;

public class Client {
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	private String societe;
	private String adresse;
	private Set<Facture> factures = new HashSet();

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set getFactures() {
		return factures;
	}

	public void setFactures(Set factures) {
		this.factures = factures;
	}

	public void addFacture(Facture f) {
		this.factures.add(f);
		f.setClient(this);
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", societe=" + societe + ", adresse=" + adresse + "]";
	}

}
