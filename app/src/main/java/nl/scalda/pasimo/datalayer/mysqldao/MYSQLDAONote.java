package nl.scalda.pasimo.datalayer.mysqldao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.model.employeemanagement.Note;

public class MYSQLDAONote implements IDAONote {

	private SessionFactory factory;
	private static MYSQLDAONote instance = null;

	private MYSQLDAONote() {
		initialiseFactory();
	}

	public static MYSQLDAONote getInstance() {
		if (instance == null) {
			instance = new MYSQLDAONote();
		}
		return instance;
	}

	private void initialiseFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFacory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public Note create(Note note) {
		TreeSet <Note> notes = new TreeSet<>();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO note (noteID, ovNumber,title, message, employeeNumber, creationDate, lastEdit) VALUES(:noteID, :ovNumber, :title, :message, :employeeNumber, :creationDate, :lastEdit);";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("noteID", note.getId());
			query.setParameter("ovNumber", note.getAssignedTo().getStudentOV());
			query.setParameter("title", note.getTitle());
			query.setParameter("message", note.getMessage());
			query.setParameter("employeeNumber", note.getMadeBy().getEmployeeNumber());
			query.setParameter("creationDate", note.getCreationDate());
			query.setParameter("lastEdit", note.getLastEdit());
			query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
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
		Note n = new Note();
		try {
			tx = session.beginTransaction();
			Object[] obj = (Object[]) session.createNativeQuery("SELECT * FROM note WHERE noteID = :noteID")
					.setParameter("noteID", id).getSingleResult();
			n.setId(Integer.parseInt(String.valueOf(obj[0])));;
			n.setOvNumber(Integer.parseInt(String.valueOf(obj[1])));;
			n.setTitle(String.valueOf(obj[2]));;
			n.setMessage(String.valueOf(obj[3]));;
			n.setEmployeeNumber(Integer.parseInt(String.valueOf(obj[4])));
			n.setCreationDate(Date.valueOf(String.valueOf(obj[5])));
			n.setLastEdit(Date.valueOf(String.valueOf(obj[6])));
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public Note update(Note note) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			NativeQuery query2 = session.createNativeQuery(
					"UPDATE note SET ovNumber = :ovNumber, title = :title, message = :message, employeeNumber = :employeeNumber, creationDate = :creationDate, lastEdit = :lastEdit WHERE noteID = :noteID");
			query2.setParameter("ovNumber", note.getOvNumber());
			query2.setParameter("title", note.getTitle());
			query2.setParameter("message", note.getMessage());
			query2.setParameter("employeeNumber", note.getEmployeeNumber());
			query2.setParameter("creationDate", note.getCreationDate());
			query2.setParameter("lastEdit", note.getLastEdit());
			query2.setParameter("noteID", note.getId());
			query2.executeUpdate();
			tx.commit();
		} finally {
			return note;

		}
	}

	@Override
	public void delete(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM note where noteID = :noteID").setParameter("noteID", id)
					.executeUpdate();
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
	public void deleteAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("TRUNCATE note").executeUpdate();
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
	public TreeSet<Note> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<Note> notes = new TreeSet<>();
		try {
			tx = session.beginTransaction();
			List noteList = session.createNativeQuery("SELECT * FROM note").getResultList();
			for (Iterator iterator = noteList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();
				Note n = new Note();
				n.setId(Integer.parseInt(String.valueOf(obj[0])));;
				n.setOvNumber(Integer.parseInt(String.valueOf(obj[1])));
				n.setTitle(String.valueOf(obj[2]));
				n.setMessage(String.valueOf(obj[3]));
				n.setEmployeeNumber(Integer.parseInt(String.valueOf(obj[4])));
				n.setCreationDate(Date.valueOf(String.valueOf(obj[5])));
				n.setLastEdit(Date.valueOf(String.valueOf(obj[6])));
				notes.add(n);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(notes);
		return notes;
	}

}
