import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import dao.Reunion;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import util.HibernateUtil;

public class ReunionManager {
	public ReunionManager() {
	}

	public void addReunion(Reunion r) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(r);

		session.getTransaction().commit();
	}

	public List listReunions() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = session.createQuery("from Reunion").list();
		session.getTransaction().commit();
		return result;
	}

	public static void main(String[] args) {
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
		HibernateUtil.getSessionFactory().close();
	}

}
