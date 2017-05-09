package nl.scalda.pasimo.datalayer.mysqldao;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkWeek;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
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
		TreeSet<WorkBlock> workblocks = new TreeSet<>();
		PasimoTime pt = new PasimoTime();
		try {
			tx = session.beginTransaction();
			List weekList = session
					.createNativeQuery(
							"SELECT * FROM workweek INNER JOIN workingday ON workweek_id = workweek.id  INNER JOIN workblock ON workingday_name = workingday.name;")
					
							.getResultList();
			
			System.out.println(weekList.get(0).getClass());
			System.out.println(weekList.get(1).getClass());
			Object[] o = (Object[]) weekList.get(0);
			
			System.out.println(o[4]);
			System.out.println(o[5]);
			System.out.println(o[6]);
			for (Iterator iterator = weekList.iterator(); iterator.hasNext();) {
				
				Object[] obj = (Object[]) iterator.next();
				WorkWeek workweek = new WorkWeek(Integer.parseInt(String.valueOf(obj[0])));
				workweeks.add(workweek);
		
		  		
//	
//				Object[] obj = (Object[]) iterator.next();
//				WorkWeek workweek = new WorkWeek(Integer.parseInt(String.valueOf(obj[0])));
//				workweeks.add(workweek);
//				for (Iterator it = weekList.iterator(); it.hasNext();) {
//					Object[] obj1 = (Object[]) it.next();
//					WorkingDay wd = new WorkingDay(String.valueOf(obj1[0]));
//					workingdays.add(wd);
//					for (Iterator i = weekList.iterator(); i.hasNext();) {
//						Object obj2 = (Object[]) i.next();
//						WorkBlock w = new WorkBlock(Integer.parseInt(String.valueOf(obj2[0])));
//						Time t = (Time) obj2[1];
//						pt.setTimeInMillis(t.getTime());
//						Time t1 = (Time) obj2[2];
//						pt.setTimeInMillis(t1.getTime());
//					}
//				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

			System.out.println(workweeks);
	
//			System.out.println(workweeks);
//			System.out.println(workingdays);


			session.close();
		}
		return workweeks;
	}


}
