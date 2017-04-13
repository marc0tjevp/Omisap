package nl.scalda.pasimo.datalayer.mysqldao;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;

public class MYSQLDAOWorkBlock implements IDAOWorkBlock {

	private static SessionFactory factory;
	private static MYSQLDAOWorkBlock instance = null;

	// was eerst private die static
	public static MYSQLDAOWorkBlock getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOWorkBlock();
			initialiseFactory();
		}
		return instance;
	}

	/**
	 * initialises the configuration of hibernate. called once from
	 * getInstance() methodsadsdfsadfsdf
	 */

	public static void initialiseFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public void update(WorkBlock workblock) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "UPDATE workblock SET id = :id , start = :start , end = :end     WHERE id = :id ;";
			NativeQuery query = session.createNativeQuery(sql);

			query.setParameter("id", workblock.getId());
			query.setParameter("start", workblock.getStart().getTime());
			query.setParameter("end", workblock.getEnd().getTime());
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
	public void create(WorkBlock workblock) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO workblock(id, start, end) VALUES (:id, :start, :end)";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("id", workblock.getId());
			query.setParameter("start", workblock.getStart().getTime());
			query.setParameter("end", workblock.getEnd().getTime());
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
	public void delete(WorkBlock workblock) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM workblock where id = :id").setParameter("id", workblock.getId())
					.executeUpdate();
			session.delete(workblock);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
//TODO MAKE IT WORK
	@Override
	public Set<WorkBlock> readAll() {
		return null;
//		Session session = factory.openSession();
//		Transaction tx = null;
//		Set<WorkBlock> workblocks = new TreeSet<>();
//		try {
//			tx = session.beginTransaction();
//			List workingdayList = session.createNativeQuery("SELECT * FROM workingday;").getResultList();
//			for (Iterator iterator = workingdayList.iterator(); iterator.hasNext();) {
//				Object[] obj = (Object[]) iterator.next();
//				WorkBlock w = new WorkBlock(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
//						String.valueOf(obj[2]));
//				workblocks.add(w);
//			}
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return workblocks;

	}

	@Override
	public WorkBlock read(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		Set<WorkBlock> workblock = new TreeSet<>();
		try {
			tx = session.beginTransaction();
			List WorkBlock = session.createNativeQuery("SELECT id, startTime, endtime FROM workblock;").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return read(id);
	}

}