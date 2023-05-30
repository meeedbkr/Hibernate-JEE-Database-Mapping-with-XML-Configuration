package com.imsc.hibernateFirstProject.manager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

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
		HibernateUtil.getSessionFactory().close();
	}

}
