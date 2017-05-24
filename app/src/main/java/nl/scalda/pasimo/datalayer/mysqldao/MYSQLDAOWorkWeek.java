package nl.scalda.pasimo.datalayer.mysqldao;


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
		TreeSet<WorkingDay> workingdays = new TreeSet<>();
		PasimoTime pt = new PasimoTime();
		try {
			tx = session.beginTransaction();
			List weekList = session.createNativeQuery(
					"SELECT * FROM workweek INNER JOIN workingday ON workweek_id = workweek.id  INNER JOIN workblock ON workingday_name = workingday.name ORDER BY workingdayID ASC;")

					.getResultList();

			for (Iterator iterator = weekList.iterator(); iterator.hasNext();) {

				Object[] o = (Object[]) iterator.next();
				 WorkWeek workweek = new
				 WorkWeek(Integer.parseInt(String.valueOf(o[0])));
				 workweeks.add(workweek);
				for(Iterator it = weekList.iterator(); it.hasNext();){
					Object[] ob = (Object[]) it.next();
					WorkingDay workingday = new
					WorkingDay(Integer.parseInt(String.valueOf(ob[0])), String.valueOf(ob[1]));	
					workingdays.add(workingday);
					
				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

			System.out.println(workweeks);
			System.out.println(workingdays);
			



			session.close();
		}
		return workweeks;
	}

}
