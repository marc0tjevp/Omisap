package nl.scalda.pasimo.datalayer.mysqldao;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkingDay;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public class MYSQLDAOWorkingDay implements IDAOWorkingDay {

	private static SessionFactory factory;
	private static MYSQLDAOWorkingDay instance = null;

	public static MYSQLDAOWorkingDay getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOWorkingDay();
			initialiseFactory();
		}
		return instance;
	}

	public static void initialiseFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

//	@Override
//	public WorkingDay read(String name) {
//		Session session = factory.openSession();
//		Transaction tx = null;
//		WorkingDay wd = new WorkingDay();
//
//		try {
//			tx = session.beginTransaction();
//			Object[] obj = (Object[]) session.createNativeQuery("SELECT name FROM workingday WHERE name = " + name)
//					.getSingleResult();
//			wd.setName(String.valueOf(obj[0]));
//			System.out.println(obj[0]);
//
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return wd;
//
//	}
	@Override
	public TreeSet<WorkingDay> workingdays(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<WorkingDay> workingdays = new TreeSet<>();
		try {
			tx = session.beginTransaction();
			List workingdayList = session.createNativeQuery("SELECT * FROM workingday WHERE name = name;")
//					.setParameter("name", name.g)
					.getResultList();
			for (Iterator iterator = workingdayList.iterator(); iterator.hasNext();) {

				Object[] obj = (Object[]) iterator.next();
				WorkingDay workingday = new WorkingDay(String.valueOf(obj[0]));

				workingdays.add(workingday);
				System.out.println(workingdays);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return workingdays;
	}

	@Override
	public void create(WorkingDay workingday) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO workingday(name) VALUES (:name)";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("name", workingday.getName());

			query.executeUpdate();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(WorkingDay workingday) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM workingday where name = :name")
					.setParameter("name", workingday.getName()).executeUpdate();
			session.delete(workingday);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
