package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class MYSQLDAOStudent implements IDAOStudent{
	private SessionFactory factory;
	private static MYSQLDAOStudent instance = null;
	
	private MYSQLDAOStudent() {
		initialiseFactory();
	}
	/**
	 * initialises the configuration of hibernate.
	 * called once from getInstance() method
	 */
	private void initialiseFactory() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	
@Override
public void createAll(Set<Student> student) {
	Session session = factory.openSession();
	Transaction tx = null;
	try{
		tx = session.beginTransaction();
		for (Student s : student ){
			session.persist(s);
		}
		tx.commit();
		
	}catch(HibernateException e){
		if(tx!=null) tx.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	}

}
@Override
public void create(Student s) {
	Session session = factory.openSession();
	Transaction tx = null;
	try{
		tx = session.beginTransaction();
		String sql = "INSERT INTO person (email, cardID, firstName, insertion, lastName, dateOfBirth) VALUES (:email, :cardID, :firstName, :insertion, :lastName, :dateOfBirth );";
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("email", s.getEmail());
		query.setParameter("cardID", s.getCardID());
		query.setParameter("firstName", s.getFirstName());
		query.setParameter("insertion", s.getInsertion());
		query.setParameter("lastName", s.getLastName());
		query.setParameter("dateOfBirth", s.getDateOfBirth());
		query.executeUpdate();
		String sql1 = "INSERT INTO student (ovNumber,cohort,lessonGroupID,bsn) VALUES (:ovNumber,:cohort,:lessonGroupID,:bsn);";
		NativeQuery query1 = session.createNativeQuery(sql1);
		query1.setParameter("ovNumber", s.getStudentOV());
		query1.setParameter("cohort", s.getCohort());
		query1.setParameter("lessonGroupID", s.getLessonGroup());
		query1.setParameter("bsn", s.getBsn());
		query1.executeUpdate();
		tx.commit();
	} catch(HibernateException e) {
		if(tx!=null) tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	
}
public static MYSQLDAOStudent getInstance() {
    if (instance == null) {
        instance = new MYSQLDAOStudent();
    }
    return instance;
}
@Override
public Set<Student> readAll() {
	// TODO Auto-generated method stub
	return null;
}
}