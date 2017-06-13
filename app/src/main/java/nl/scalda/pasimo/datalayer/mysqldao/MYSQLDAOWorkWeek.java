package nl.scalda.pasimo.datalayer.mysqldao;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkWeek;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

/**
 * @author Diederik
 *
 */
public class MYSQLDAOWorkWeek implements IDAOWorkWeek {

	private SessionFactory factory;
	private static MYSQLDAOWorkWeek instance = null;

	public MYSQLDAOWorkWeek() {
		initialiseFactory();
	}

	private void initialiseFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static MYSQLDAOWorkWeek getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOWorkWeek();

		}
		return instance;

	}

	@Override
	public WorkWeek read(int id) {
		return null;
	}

	@Override
	public TreeSet<WorkWeek> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<WorkWeek> workweeks = new TreeSet<>();
		try {
			tx = session.beginTransaction();
			List weekList = session.createNativeQuery(
					"SELECT * FROM workweek INNER JOIN workingday ON workweek_id = workweek.id  INNER JOIN workblock ON workingday_workingdayID = workingday.workingdayID ORDER BY workblock.workblockId;")

					.getResultList();

			for (Iterator iterator = weekList.iterator(); iterator.hasNext();) {

				Object[] o = (Object[]) iterator.next();
				WorkWeek workweek = new WorkWeek(Integer.parseInt(String.valueOf(o[0])));
				workweeks.add(workweek);
				// for (Iterator it = weekList.iterator(); it.hasNext();) {
				// Object[] ob = (Object[]) it.next();
				// WorkingDay workingday = new
				// WorkingDay(Integer.parseInt(String.valueOf(ob[1])),
				// String.valueOf(ob[2]));
				// workweek.getWorkingdays().add(workingday);
				// for (Iterator i = weekList.iterator(); i.hasNext();) {
				// Object[] obj = (Object[]) i.next();
				//
				// PasimoTime pt = new PasimoTime();
				// Time dateString = (Time) obj[5];
				// pt.setTimeInMillis(dateString.getTime());
				// PasimoTime pt1 = new PasimoTime();
				// Time dateString1 = (Time) obj[6];
				// pt1.setTimeInMillis(dateString1.getTime());
				// SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				//
				// WorkBlock workblock = new
				// WorkBlock(Integer.parseInt(String.valueOf(obj[4])), pt, pt1);
				// workingday.getWorkblocks().add(workblock);
				// }
				//
				// }

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

			System.out.println(workweeks);
		
		

			session.close();
		}
		return workweeks;
	}

	@Override
	public TreeSet<WorkingDay> readAllWorkingDays() {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<WorkingDay> workingdays = new TreeSet<>();
		try {
			tx = session.beginTransaction();
			List workingdayList = session.createNativeQuery("SELECT * FROM workingday;").getResultList();
			for (Iterator iterator = workingdayList.iterator(); iterator.hasNext();) {
				Object[] o = (Object[]) iterator.next();
				WorkingDay workingday = new WorkingDay(Integer.parseInt(String.valueOf(o[0])), String.valueOf(o[1]));
				workingdays.add(workingday);

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

			System.out.println(workingdays);
		}
		return workingdays;
	}

	@Override
	public TreeSet<WorkBlock> readAllWorkBlocks() {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<WorkBlock> workblocks = new TreeSet<>();
		try {
			tx = session.beginTransaction();
			List workblockList = session.createNativeQuery("SELECT * FROM workblock;").getResultList();
			for (Iterator iterator = workblockList.iterator(); iterator.hasNext();) {
				Object[] o = (Object[]) iterator.next();

				PasimoTime pt = new PasimoTime();
				Time dateString = (Time) o[1];
				pt.setTimeInMillis(dateString.getTime());
				PasimoTime pt1 = new PasimoTime();
				Time dateString1 = (Time) o[2];
				pt1.setTimeInMillis(dateString1.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

				WorkBlock workblock = new WorkBlock(Integer.parseInt(String.valueOf(o[0])), pt, pt1);
				workblocks.add(workblock);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			System.out.println(workblocks);
		}
		return workblocks;
	}

}
