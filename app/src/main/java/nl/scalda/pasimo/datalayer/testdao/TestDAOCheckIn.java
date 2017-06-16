package nl.scalda.pasimo.datalayer.testdao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCheckIn;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;


public class TestDAOCheckIn implements IDAOCheckIn {

	private static TestDAOCheckIn instance = null;
	TreeSet<CheckIn> cardLogs = new TreeSet<>();
	
	
	private SessionFactory factory;
	
	private TestDAOCheckIn(){
		

		//CheckIn(logID, hourOfCheckIn, minuteOfCheckIn, secondOfCheckIn, isCheckIn)
		CheckIn a = new CheckIn(10, 5, 55, 55, true);
		cardLogs.add(a);


	}
	
	public CheckIn read(int id){
		for(CheckIn checkIn : cardLogs){
			if(checkIn.getLogID() == id){
				return checkIn;
			}
		}
		return null;
	}
	
	public static TestDAOCheckIn getInstance() {
		if (instance == null) {
			instance = new TestDAOCheckIn();
		}
		return instance;
	}



	@Override
	public TreeSet<CheckIn> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<CheckIn> Checkin = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		 List checkInList = session.createNativeQuery("SELECT c.cardID, c.date, p.email, p.firstName FROM card_log AS c INNER JOIN person AS p ON c.cardID = p.card_log_cardID INNER JOIN teacher AS t ON p.email = t.person_email;").getResultList();

		 for(Iterator iterator = checkInList.iterator();iterator.hasNext();){
			 Object[] obj = (Object[]) iterator.next();
			 
			   String dateString = String.valueOf(obj[1]);
			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   GregorianCalendar dt = new GregorianCalendar();
			   dt.setTime(sdf.parse(dateString));
			 
			 CheckIn checkin = new CheckIn(
					 Integer.parseInt(String.valueOf(obj[0])), 		//logID
					 0, 		//hourOfCheckIn
					 0, 		//minuteOfCheckIn
					 0, 		//secondOfCheckIn
					 false); 	//isCheckIn
			 Checkin.add(checkin);
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


}
