package nl.scalda.pasimo.datalayer.mysqldao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAONote implements IDAONote {
	
	private SessionFactory factory;
	private static MYSQLDAONote instance = null;
	
	private MYSQLDAONote(){
		initialiseFactory();
	}
	
	private void initialiseFactory(){
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex){
			System.err.println("Failed to create sessionFacory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public Note create(Note note) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String sql = "INSERT INTO note (noteID, ovNumber,title, message, employeeNumber, creationDate, lastEdit) VALUES(:noteID, :ovNumber, :title, :message, :employeeNumber, :creationDate, :lastEdit);";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("noteID", note.getId());
			query.setParameter("ovNumber",  )
			query.setParameter("title", note.getTitle());
			query.setParameter("message", note.getMessage());
			query.setParameter("employeeNumber", )
			query.setParameter("creationDate", note.getCreationDate());
			query.setParameter("lastEdit", note.getLastEdit());
			query.executeUpdate();
			tx.commit();
		} catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Note read(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
		}
		return null;
	}

	@Override
	public Note update(Note note) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			NativeQuery query1 = session.createNativeQuery("SET foreign_key_checks = 0;");
			NativeQuery query2 = session.createNativeQuery("UPDATE note SET noteID = :noteID, ovNumber = :ovNumber, title = :title, message = :message, employeeNumber = :employeeNumber, creationDate = :creationDate, lastEdit = :lastEdit WHERE noteID = :noteID");
			NativeQuery query3 = session.createNativeQuery("SET foreign_key_checks = 1;");
			
			
			
		}
		return null;
	}

	@Override
	public void delete(Note note) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM note where noteID = :noteID").setParameter("noteID", note.getId()).executeUpdate();
			session.delete(note);
			tx.commit();
		} catch(HibernateException e ){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		
	}
	
	public static MYSQLDAONote getInstance(){
		if (instance == null){
			instance = new MYSQLDAONote();
		}
		return instance;
	}
		
}
