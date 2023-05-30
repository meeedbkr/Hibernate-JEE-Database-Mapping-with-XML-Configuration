package com.imsc.hibernateFirstProject.manager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.imsc.hibernateFirstProject.dao.Personne;
import com.imsc.hibernateFirstProject.dao.Reunion;
import com.imsc.hibernateFirstProject.util.HibernateUtil;

public class ReunionManager {
	public void addReunion(Reunion r) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	}

	public List<Reunion> listReunions() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = session.createQuery("from Reunion").list();
		session.getTransaction().commit();
		return result;
	}

	public void addPersonne(String nom, String prenom, int age) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Personne p = new Personne();
		p.setNomPersonne(nom);
		p.setPrenomPersonne(prenom);
		p.setAge(age);
		session.save(p);
		session.getTransaction().commit();
	}

	public void addReunionToPersonne(Long idPersonne, Long idReunion) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// Charger une personne
		Personne p = (Personne) session.get(Personne.class, idPersonne);
		// Charger une réunion
		Reunion r = (Reunion) session.get(Reunion.class, idReunion);
		// Ajouter la réunion r à la collection reunions de la personne p
		p.getReunions().add(r);
		session.getTransaction().commit();
	}

	public Personne getPersonne(Long idPersonne) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Personne p = (Personne) session.get(Personne.class, idPersonne);
		return p;
	}

	public static void main(String[] args) {

		ReunionManager gestManager = new ReunionManager();
		gestManager.addReunion(new Reunion("R1", new Date()));
		gestManager.addReunion(new Reunion("R2", new Date()));
		gestManager.addReunion(new Reunion("R3", new Date()));

		List listR = gestManager.listReunions();
		Iterator lesR = listR.iterator();
		while (lesR.hasNext()) {
			Reunion r = (Reunion) lesR.next();
			System.out.println(r.getIdReunion() + "--" + r.getTitleReunion() + "--" + r.getDateReunion());
		}

		gestManager.addPersonne("Jihad", "hassan", 25);
		gestManager.addPersonne("mandari", "Youness", 22);
		gestManager.addPersonne("Karimi", "yassine", 23);

		gestManager.addReunionToPersonne(new Long(1), new Long(1));
		gestManager.addReunionToPersonne(new Long(2), new Long(1));
		gestManager.addReunionToPersonne(new Long(3), new Long(1));
		gestManager.addReunionToPersonne(new Long(1), new Long(2));
		gestManager.addReunionToPersonne(new Long(3), new Long(2));

		Personne p = gestManager.getPersonne(new Long(1));
		System.out.println(p.getNomPersonne() + "--" + p.getPrenomPersonne() + "--" + p.getAge());
		System.out.println("Reunions auquelles a participe cette personne");
		Iterator reunions = p.getReunions().iterator();
		while (reunions.hasNext()) {
			Reunion r = (Reunion) reunions.next();
			System.out.println(r.getTitleReunion() + "--" + r.getDateReunion());
		}
		
		
		HibernateUtil.getSessionFactory().close();
	}

}
