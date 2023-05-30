package com.imsc.OneToManyProject.dao;

import java.util.Date;

public class Facture {
	private Long idFacture;
	private Date dateFacture;
	private double montant;
	private Client client;

	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", dateFacture=" + dateFacture + ", montant=" + montant + ", idCLient= "+ client.getIdClient() + "]";
	}

}
