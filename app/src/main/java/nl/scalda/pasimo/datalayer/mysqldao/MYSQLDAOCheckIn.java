package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class MYSQLDAOCheckIn implements IDAOCheckIn {

	private SessionFactory factory;
	private static MYSQLDAOCheckIn instance = null;
	
	
	
	
	
	
	
	
	@Override
	public TreeSet<Person> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
//	private MYSQLDAOCheckIn() {
//		initialiseFactory();
//	}
	
//	private void initialiseFactory() {
//		try{
//			factory = new Configuration().configure().buildSessionFactory();
//		} catch(Throwable ex) {
//			System.err.println("Failed to create sessionFactory object." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
	
//	public TreeSet<CheckIn> readAll() {
//		Session session = factory.openSession();
//		Transaction tx = null;
//		TreeSet<CheckIn> Checkin = new TreeSet<>();
//		try {
//		   tx = session.beginTransaction();
//		 List checkInList = session.createNativeQuery("SELECT c.cardID, c.date, p.email, p.firstName FROM card_log AS c INNER JOIN person AS p ON c.cardID = p.card_log_cardID INNER JOIN teacher AS t ON p.email = t.person_email;").getResultList();
//
//		   
//		 for(Iterator iterator = checkInList.iterator();iterator.hasNext();){
//
//			   Object[] obj = (Object[]) iterator.next();
//			   String dateString = String.valueOf(obj[1]);
//			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			   GregorianCalendar dt = new GregorianCalendar();
//			   dt.setTime(sdf.parse(dateString));

//			   CheckIn checkin = new CheckIn(
//					   Integer.parseInt(String.valueOf(obj[0])),
//					   dt,
//					   String.valueOf(obj[2]),
//					   String.valueOf(obj[3]));
			   
			   
			   //Checkin.add(checkin);
//		   }
//		   tx.commit();
//		}
//		catch (Exception e) {
//		   if (tx!=null) tx.rollback();
//		   e.printStackTrace(); 
//		}finally {
//		   session.close();
//		}
//		
//		return Checkin;
//	}
//
//	public static MYSQLDAOCheckIn getInstance() {
//        if (instance == null) {
//            instance = new MYSQLDAOCheckIn();
//        }
//        return instance;
//    }
//	
//}
