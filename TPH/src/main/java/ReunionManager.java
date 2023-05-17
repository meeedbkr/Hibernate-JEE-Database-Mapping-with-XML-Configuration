import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.junit.Test;

import dao.Personne;
import dao.Reunion;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import util.HibernateUtil;

public class ReunionManager {
	public ReunionManager() {
	}

//	Créer des Réunions
	public void addReunion(Reunion r) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(r);

		session.getTransaction().commit();
	}

//	Lister le contenu de la table Reunions
	public List<Reunion> listReunions() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Reunion> result = session.createQuery("from Reunion").list();
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

	public Personne getPersonne(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(Personne.class);
		crit.add(Expression.eq("idPersonne", id));
		Object o = crit.uniqueResult();
		return (Personne) o;
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

	public static void main(String[] args) {
		PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
//		 Créer des réunions
		ReunionManager gestManager = new ReunionManager();
		Reunion temp = new Reunion("conseil", new Date());
		gestManager.addReunion(temp);
		temp = new Reunion("Compte rendue", new Date());
		gestManager.addReunion(temp);
		temp = new Reunion("deliberation", new Date());
		gestManager.addReunion(temp);
//		 Afficher toutes les réunions
		List listR = gestManager.listReunions();
		Iterator lesR = listR.iterator();
		while (lesR.hasNext()) {
			Reunion r = (Reunion) lesR.next();
			System.out.println(r.getIdReunion() + "--" + r.getTitre() + "--" + r.getDateReunion());
		}
//		Créer des personnes
		gestManager.addPersonne("Jihad", "hassan", 25);
		gestManager.addPersonne("mandari", "Youness", 22);
		gestManager.addPersonne("Karimi", "yassine", 23);
//		Ajouter des réunions aux personnes
		gestManager.addReunionToPersonne(new Long(1), new Long(2));
		gestManager.addReunionToPersonne(new Long(2), new Long(1));
		gestManager.addReunionToPersonne(new Long(3), new Long(1));
		gestManager.addReunionToPersonne(new Long(1), new Long(2));
		gestManager.addReunionToPersonne(new Long(3), new Long(2));
//		Consulter une personne
		Personne p = gestManager.getPersonne(1L);
		System.out.println(p.getNomPersonne() + "--" + p.getPrenomPersonne() + "--" + p.getAge());
		System.out.println("************** Reunions auquelles a participe cette personne **************");
		Iterator reunions = p.getReunions().iterator();
		while (reunions.hasNext()) {
			Reunion r = (Reunion) reunions.next();
			System.out.println(r.getTitre() + "--" + r.getDateReunion());
		}

		HibernateUtil.getSessionFactory().close();
	}

}
