package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.List;
import java.util.Iterator;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class MYSQLDAOCheckIn implements IDAOCheckIn {

	private SessionFactory factory;
	private static MYSQLDAOCheckIn instance = null;
	
	private MYSQLDAOCheckIn() {
		initialiseFactory();
	}
	
	private void initialiseFactory() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public TreeSet<CheckIn> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<CheckIn> Checkin = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		 List checkInList = session.createNativeQuery("SELECT c.cardID, c.date, p.email, p.name FROM card_log AS c INNER JOIN person AS p ON c.cardID = p.cardID INNER JOIN teacher AS t ON p.email = t.person_email;").getResultList();
		   System.out.println(checkInList);
		 for(Iterator iterator = checkInList.iterator();iterator.hasNext();){
			   /*
			    * obj[0] = person.firstName
			    * obj[1] = person.insertion
			    * obj[2] = person.lastName
			    */
			   Object[] obj = (Object[]) iterator.next();
			   CheckIn checkin = new CheckIn(
					   String.valueOf(obj[0]),
					   String.valueOf(obj[1]),
					   String.valueOf(obj[2]));
			   
			   Checkin.add(checkin);
			   System.out.println(checkInList);
		   }
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
		return Checkin;
	}

	public static MYSQLDAOCheckIn getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOCheckIn();
        }
        return instance;
    }
	
}
