package com.imsc.OneToManyProject.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.imsc.OneToManyProject.dao.Client;
import com.imsc.OneToManyProject.dao.Facture;
import com.imsc.OneToManyProject.util.HibernateUtil;

public class FactureManager {
	public void addClient(String nom, String prenom, String societe, String adresse) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Client cli = new Client();
		cli.setNomClient(nom);
		cli.setPrenomClient(prenom);
		cli.setSociete(societe);
		cli.setAdresse(adresse);
		session.save(cli);
		session.getTransaction().commit();
	}

	public void addFacture(Date dateFact, double montant, Long idClient) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Client cli = (Client) session.get(Client.class, idClient);
		Facture fact = new Facture();
		fact.setDateFacture(dateFact);
		fact.setMontant(montant);
		cli.addFacture(fact);// fact.setClient(cli);
		session.save(fact);
		session.getTransaction().commit();
	}

	public Client getClient(Long idClient) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Client p = (Client) session.get(Client.class, idClient);
		return p;
	}

	public List<Facture> getAllFacture() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Facture.class);
		List<Facture> facture = criteria.list();
		session.getTransaction().commit();

		return facture;
	}

	public static void main(String[] args) {

		FactureManager factureManager = new FactureManager();
		factureManager.addClient("EL-BOUKRI", "mohammed", "Meedbk", "18 lot louiza, Khhouribga");
		factureManager.addClient("EL-BOUKRI", "Nourddine", "Needbk", "18 lot louiza, Khhouribga");
		factureManager.addClient("Unknown", "07", "07-agent", "nowhere");
		// Creant des factures
		factureManager.addFacture(new Date(), 123.54, 1L);
		factureManager.addFacture(new Date(), 1552.54, 1L);
		factureManager.addFacture(new Date(), 343.54, 3L);
		factureManager.addFacture(new Date(), 983.54, 2L);
		List<Facture> factures = factureManager.getAllFacture();
		for(Facture f : factures) {
			System.out.println(f);
		}
	}
}
