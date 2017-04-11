package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAOTeacher implements IDAOTeacher {
	
	private SessionFactory factory;
	private static MYSQLDAOTeacher instance = null;
	
	/**
	 * 
	 */
	private MYSQLDAOTeacher() {
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

	/**
	 * creates a teacher in the database.
	 * 
	 * @param Teacher teacher
	 */
	@Override
	public void create(Teacher teacher) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(teacher);
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * updates the teacher in the database.
	 * 
	 * @param Teacher t
	 */
	@Override
	public void update(Teacher t) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.merge(t);
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	/**
	 * deletes the teacher from the database.
	 * 
	 * @param Teacher t
	 */
	@Override
	public void delete(Teacher t) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			EducationTeam et = t.getEducationTeam();
			et.deleteTeacher(t);
			session.delete(t);
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * reads all teachers from the database.
	 * 
	 * @return TreeSet<Teacher>
	 */
	@Override
	public List<Teacher> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Teacher> teachers = new ArrayList<Teacher>();
		try{
			tx = session.beginTransaction();
			CriteriaQuery<Teacher> criteria =session.getCriteriaBuilder().createQuery(Teacher.class);
			criteria.select(criteria.from(Teacher.class));
			 teachers = session.createQuery(criteria).getResultList();
		    tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
		return teachers;
	}

	/**
	 * reads the teacher from the database by employeeNumber
	 * 
	 * @param int employeeNumber
	 * @return Teacher
	 */
	@Override
	public Teacher readByEmployeeNumber(int employeeNumber) {
		Session session = factory.openSession();
		Transaction tx = null;
		Teacher teacher = null;
		try{
			tx = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Teacher> c = cb.createQuery(Teacher.class);
			Root<Teacher> root = c.from(Teacher.class);
			c.select(root);
			List<Predicate> criteria = new ArrayList<Predicate>();
			Expression<Integer> p = cb.parameter(Integer.class, "employeeNumber");
			criteria.add(cb.equal(root.get("employeeNumber"), p));
			c.where(criteria.get(0));
			teacher = session.createQuery(c).setParameter("employeeNumber", employeeNumber).getSingleResult();
			tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return teacher;
	}
	
	/**
	 * reads all teacher from the database that are in the given education team.
	 * 
	 * @param EducationTeam t
	 * @return TreeSet<Teacher>
	 */
	@Override
	public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t) {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<Teacher> teachers = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		   List teachersList = session.createNativeQuery("SELECT * FROM education_team_teacher INNER JOIN teacher ON teachers_email = teacher.email INNER JOIN person ON teacher.email = person.email WHERE education_team_id=:educationTeamID ;")
				   .setParameter("educationTeamID", t.getId())
				   .getResultList();
		   for(Iterator iterator = teachersList.iterator();iterator.hasNext();){
			   /*
			    * obj[0] = education_team_teacher.teachers_email
			    * obj[1] = education_team_teacher.education_team_id
			    * obj[2] = teacher.email
			    * obj[3] = teacher.abbreviation
			    * obj[4] = teacher.email
			    * obj[5] = coach_group.coachGroupID
			    * obj[6] = person.email
			    * obj[7] = person.cardID
			    * obj[8] = person.firstName
			    * obj[9] = person.insertion
			    * obj[10] = person.lastName
			    * obj[11] = person.dateOfBirth
			    */
			   Object[] obj = (Object[]) iterator.next();
			   String[] dateOfBirth = String.valueOf(obj[11]).split("-");
			   Teacher teacher = new Teacher(Integer.parseInt(String.valueOf(obj[2])),
					   String.valueOf(obj[6]),
					   Integer.parseInt(String.valueOf(obj[7])),
					   String.valueOf(obj[8]),
					   String.valueOf(obj[9]),
					   String.valueOf(obj[10]),
					   Integer.parseInt(String.valueOf(dateOfBirth[0])),
					   Integer.parseInt(String.valueOf(dateOfBirth[1])),
					   Integer.parseInt(String.valueOf(dateOfBirth[2])));
			   teachers.add(teacher);
		   }
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return teachers;
	}
	
	/**
	 * gets the coach group the given teacher is currently in.
	 * 
	 * @param Teacher teacher
	 * @return CoachGroup
	 */
	@Override
	public CoachGroup getCurrentCoachGroup(Teacher teacher) {
		Session session = factory.openSession();
		Transaction tx = null;
		CoachGroup coachGroup = null;
		try{
			tx = session.beginTransaction();
			Object[] obj = (Object[]) session
					.createNativeQuery("SELECT * FROM coach_group WHERE coachGroupID = (SELECT coach_group_coachGroupID FROM teacher WHERE teachers_email = :teachers_email)")
					.setParameter("teachers_email", teacher.getEmail()).getSingleResult();
			coachGroup = new CoachGroup(String.valueOf(obj[1]), teacher);
			tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return coachGroup;
	}
	
	/**
	 * gets the education team the teacher is currently in.
	 * 
	 * @param Teacher teacher
	 * @return EducationTeam
	 */
	public EducationTeam getCurrentEducationTeamOfTeacher(Teacher teacher) {
		Session session = factory.openSession();
		Transaction tx = null;
		EducationTeam educationTeam = null;
		try{
			tx = session.beginTransaction();
			Object[] obj = (Object[]) session
					.createNativeQuery("SELECT * FROM education_team WHERE educationTeamID = (SELECT EducationTeam_educationTeamID FROM education_team_teacher WHERE teachers_email = :teachers_email)")
					.setParameter("teachers_email", teacher.getEmail()).getSingleResult();
			educationTeam = new EducationTeam(String.valueOf(obj[2]),
					String.valueOf(obj[1]),
					Integer.parseInt(String.valueOf(obj[0])));
			tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return educationTeam;
	}
	
	/**
	 * check if there is already an instance of this class and returns it.
	 * 
	 * @return MYSQLDAOTeacher
	 */
	public static MYSQLDAOTeacher getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOTeacher();
        }
        return instance;
    }

}
