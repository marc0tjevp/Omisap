package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAOTeacher implements IDAOTeacher {
	
	private static SessionFactory factory;
	private static MYSQLDAOTeacher instance = null;
	
	
	public static void initialiseFactory() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public void create(Teacher teacher) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String sql = "INSERT INTO person (email) VALUES (:email);";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("email", teacher.getEmail());
			query.executeUpdate();
			String sql1 = "INSERT INTO teacher (person_email,employeeNumber,abbreviation,coach_group_coachGroupID) VALUES (:email,:employeeNumber,:abbreviation,:coachGroup);";
			NativeQuery query1 = session.createNativeQuery(sql1);
			query1.setParameter("email", teacher.getEmail());
			query1.setParameter("employeeNumber", teacher.getEmployeeNumber());
			query1.setParameter("abbreviation", teacher.getAbbreviation());
			query1.setParameter("coachGroup", 0);
			query1.executeUpdate();
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Teacher t) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			NativeQuery query1 = session.createNativeQuery("SET foreign_key_checks = 0;");
			NativeQuery query2 = session.createNativeQuery("UPDATE teacher SET person_email = :email, employeeNumber = :employeeNumber ,abbreviation = :abbreviation where employeeNumber = :employeeNumber ;");
			NativeQuery query3 = session.createNativeQuery("SET foreign_key_checks = 1;");
			query1.executeUpdate();
			query2.setParameter("employeeNumber", t.getEmployeeNumber());
			query2.setParameter("email", t.getEmail());
			query2.setParameter("abbreviation", t.getAbbreviation());
			query2.executeUpdate();
			query3.executeUpdate();
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(Teacher t) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM teacher_education_team WHERE teacher_employeeNumber = :employeeNumber").setParameter("employeeNumber", t.getEmployeeNumber()).executeUpdate();
			session.delete(t);
			Person p = new Person(t.getEmail());
			session.delete(p);
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public TreeSet<Teacher> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<Teacher> teachers = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		   List teachersList = session.createNativeQuery("SELECT * FROM teacher INNER JOIN person ON teacher.person_email=person.email INNER JOIN teacher_education_team ON teacher_education_team.teacher_employeeNumber = teacher.employeeNumber ;")
				   .getResultList();
		   for(Iterator iterator = teachersList.iterator();iterator.hasNext();){
			   /*
			    * obj[0] = teacher.employeeNumber
			    * obj[1] = teacher.abbreviation
			    * obj[2] = teacher.person_email
			    * obj[3] = coach_group.coachGroupID
			    * obj[4] = person.email
			    * obj[5] = person.cardID
			    * obj[6] = person.firstName
			    * obj[7] = person.insertion
			    * obj[8] = person.lastName
			    * obj[9] = person.dateOfBirth
			    */
			   Object[] obj = (Object[]) iterator.next();
			   Teacher teacher = new Teacher(String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[2]));
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

	@Override
	public Teacher readByEmployeeNumber(int employeeNumber) {
		Session session = factory.openSession();
		Transaction tx = null;
		Teacher teacher = null;
		try{
			tx = session.beginTransaction();
			/*
			 * obj[0] = teacher.employeeNumber
			 * obj[1] = teacher.abbreviation
			 * obj[2] = teacher.person_email
			 * obj[3] = coach_group.coachGroupID
			 * obj[4] = person.email
			 * obj[5] = person.cardID
			 * obj[6] = person.firstName
			 * obj[7] = person.insertion
			 * obj[8] = person.lastName
			 * obj[9] = person.dateOfBirth
			 */
			Object[] obj = (Object[]) session
					.createNativeQuery("SELECT * FROM teacher INNER JOIN person ON teacher.person_email=person.email INNER JOIN teacher_education_team ON teacher_education_team.teacher_employeeNumber = teacher.employeeNumber WHERE employeeNumber=:employeeNumber")
					.setParameter("employeeNumber", employeeNumber).getSingleResult();
			teacher = new Teacher(String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[2]));
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
	
	@Override
	public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t) {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<Teacher> teachers = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		   List teachersList = session.createNativeQuery("SELECT * FROM teacher_education_team INNER JOIN teacher ON teacher_employeeNumber = teacher.employeeNumber INNER JOIN person ON teacher.person_email = person.email WHERE education_team_id=:educationTeamID ;")
				   .setParameter("educationTeamID", t.getId())
				   .getResultList();
		   for(Iterator iterator = teachersList.iterator();iterator.hasNext();){
			   /*
			    * obj[0] = teacher_education_team.teacher_employeeNumber
			    * obj[1] = teacher_education_team.education_team_id
			    * obj[2] = teacher.employeeNumber
			    * obj[3] = teacher.abbreviation
			    * obj[4] = teacher.person_email
			    * obj[5] = coach_group.coachGroupID
			    * obj[6] = person.email
			    * obj[7] = person.cardID
			    * obj[8] = person.firstName
			    * obj[9] = person.insertion
			    * obj[10] = person.lastName
			    * obj[11] = person.dateOfBirth
			    */
			   Object[] obj = (Object[]) iterator.next();
			   Teacher teacher = new Teacher(String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[2]));
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
	
	@Override
	public Teacher readByAbbr(String abbreviation) {
		Session session = factory.openSession();
		Transaction tx = null;
		Teacher teacher = null;
		try{
			tx = session.beginTransaction();
			/*
			 * obj[0] = teacher.employeeNumber
			 * obj[1] = teacher.abbreviation
			 * obj[2] = teacher.person_email
			 * obj[3] = coach_group.coachGroupID
			 * obj[4] = person.email
			 * obj[5] = person.cardID
			 * obj[6] = person.firstName
			 * obj[7] = person.insertion
			 * obj[8] = person.lastName
			 * obj[9] = person.dateOfBirth
			 */
			Object[] obj = (Object[]) session
					.createNativeQuery("SELECT * FROM teacher INNER JOIN person ON teacher.person_email=person.email INNER JOIN teacher_education_team ON teacher_education_team.teacher_employeeNumber = teacher.employeeNumber WHERE abbreviation=:abbreviation")
					.setParameter("abbreviation", abbreviation).getSingleResult();
			teacher = new Teacher(String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[2]));
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
	
	public EducationTeam getCurrentEducationTeamOfTeacher(Teacher teacher) {
		Session session = factory.openSession();
		Transaction tx = null;
		EducationTeam educationTeam = null;
		try{
			tx = session.beginTransaction();
			Object[] obj = (Object[]) session
					.createNativeQuery("SELECT * FROM education_team WHERE educationTeamID = (SELECT education_team_id FROM teacher_education_team WHERE teacher_employeeNumber = 123456)")
					.getSingleResult();
			educationTeam = new EducationTeam(Integer.parseInt(String.valueOf(obj[0])));
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
	
	public static MYSQLDAOTeacher getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOTeacher();
            initialiseFactory();
        }
        return instance;
    }
	
}
