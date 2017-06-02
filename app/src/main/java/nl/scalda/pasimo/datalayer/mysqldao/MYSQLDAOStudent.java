package nl.scalda.pasimo.datalayer.mysqldao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class MYSQLDAOStudent implements IDAOStudent {

	private SessionFactory factory;
	private static MYSQLDAOStudent instance = null;

	private MYSQLDAOStudent() {
		initialiseFactory();
	}

	public static MYSQLDAOStudent getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOStudent();
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

	public Student create(Student student) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO student (studentOV, cohort, email, frstName, insertion, lastName, cardID, yearOfBirth, monthOfBirth, dayOfBirth, coachGroup, lessonsGroup, notelist) VALUES(:studentOV, :cohort, :email, :frstName, :insertion, :lastName, :cardID, :yearOfBirth, :monthOfBirth, :dayOfBirth, :coachGroup, :lessonsGroup, :notelist);";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("studentOV", student.getStudentOV());
			query.setParameter("cohort", student.getCohort());
			query.setParameter("email", student.getEmail());
			query.setParameter("firstName", student.getFirstName());
			query.setParameter("insertion", student.getInsertion());
			query.setParameter("lastName", student.getLastName());
			query.setParameter("cardID", student.getCardID());
			query.setParameter("yearOfBirth", student.getYearOfBirth());
			query.setParameter("monthOfBirth", student.getMonthOfBirth());
			query.setParameter("dyOfBirth", student.getDayOfBirth());
			query.setParameter("coachGroup", student.getCoachGroup());
			query.setParameter("lessonGroup", student.getLessonGroup());
			query.setParameter("noteList", student.getNoteList());
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

	
	public Student read(int studentOV) {
		Session session = factory.openSession();
		Transaction tx = null;
		Student s = new Student();
		try {
			tx = session.beginTransaction();
			Object[] obj = (Object[]) session
					.createNativeQuery(
							"SELECT * FROM student WHERE studentOV = :studentOV")
					.setParameter("studentOV", studentOV).getSingleResult();
			   s.setStudentOV(Integer.parseInt(String.valueOf(obj[0])));;
				s.setCohort(Integer.parseInt(String.valueOf(obj[1])));;
				s.setEmail(String.valueOf(obj[2]));;
				s.setFirstName(String.valueOf(obj[3]));;
				s.setInsertion(String.valueOf(obj[4]));;
				s.setLastName(String.valueOf(obj[5]));;
				s.setCardID(Integer.parseInt(String.valueOf(obj[6])));;
				s.setYearOfBirth(Integer.parseInt(String.valueOf(obj[7])));;
				s.setMonthOfBirth(Integer.parseInt(String.valueOf(obj[8])));;
				s.setDayOfBirth(Integer.parseInt(String.valueOf(obj[9])));;
				//reminder
			//	s.setCoachGroup(MYSQLDAOCoachGroup.getInstance().read);  String.valueOf(obj[3]));;
				//s.setLessonGRoup();;
				//s.setNoteList(noteList.noteList());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return s;
	}

	
	public Student update(Student student) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
					NativeQuery query2 = session.createNativeQuery(
					"UPDATE student SET studentOV = :studentOV, cohort = :cohort, email = :email, firstname = :firstName, insertion = :insertion, lastName = :lastName, cardID =:cardID, yearOfBirth = :yearOfBirth, monthOfBirth = :monthOfBirth, dayOfBirth = :dayOfBirth, coachGroup = :coachGroup, lessonGroup :lessonGroup, noteList = :noteList WHERE studentOV = :studentOV");
			query2.setParameter("studentOV", student.getStudentOV());
			query2.setParameter("cohort", student.getCohort());
			query2.setParameter("email", student.getEmail());
			query2.setParameter("firstName", student.getFirstName());
			query2.setParameter("insertion", student.getInsertion());
			query2.setParameter("lastName", student.getLastName());
			query2.setParameter("cardID", student.getCardID());
			query2.setParameter("yearOfBirth", student.getYearOfBirth());
			query2.setParameter("monthOfBirth", student.getMonthOfBirth());
			query2.setParameter("dyOfBirth", student.getDayOfBirth());
			query2.setParameter("coachGroup", student.getCoachGroup());
			query2.setParameter("lessonGroup", student.getLessonGroup());
			query2.setParameter("noteList", student.getNoteList());
			query2.executeUpdate();
			tx.commit();
		} finally {
			return student;
			
		}
	}

	
	public void delete(int studentOV) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM student where studentOV = :studentOV").setParameter("studentOV", studentOV).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	
	public void deleteAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.createNativeQuery("TRUNCATE student").executeUpdate();
			tx.commit();
		} catch(HibernateException e){
			if( tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		
	}

	@Override
	public Student delete(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Student> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Student> readAllForLessonGroup(LessonGroup l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LessonGroup getCurrentLessonGroup(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student readByStudentOV(int studentOV) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
