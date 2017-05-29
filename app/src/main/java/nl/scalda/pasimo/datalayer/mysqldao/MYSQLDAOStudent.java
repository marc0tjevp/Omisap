package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAOStudent implements IDAOStudent {

    private SessionFactory factory;
    private static MYSQLDAOStudent instance = null;

    /**
     *
     */
    private MYSQLDAOStudent() {
        initialiseFactory();
    }

    /**
     * initialises the configuration of hibernate. called once from
     * getInstance() method
     */
    private void initialiseFactory() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * creates a student in the database.
     *
     * @param Student Student
     */
    @Override
    public void create(Student thisStudent) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "INSERT INTO student (studentOV, cohort, email, firstName, insertion, lastName, cardID, yearOfBirth, noteList, monthOfBirth, dayOfBirth, coachGroupName, lessonGroupID) VALUES (:studentOV, :cohort, :email, :firstName, :insertion, :lastName, :cardID, :yearOfBirth, :noteList, :monthOfBirth, :dayOfBirth, :coachGroupName, :lessonGroupID );";
             NativeQuery query = session.createNativeQuery(sql);
            query.setParameter("studentOV", thisStudent.getStudentOV());
            query.setParameter("cohort", thisStudent.getCohort());
            query.setParameter("email", thisStudent.getEmail());
            query.setParameter("firstName", thisStudent.getFirstName());
            query.setParameter("inertion", thisStudent.getInsertion());
            query.setParameter("lastName", thisStudent.getLastName());
            query.setParameter("cardID", thisStudent.getCardID());
            query.setParameter("yearOfBirth", thisStudent.getYearOfBirth());
            query.setParameter("notelist", thisStudent.getNoteList());
            query.setParameter("monthOfBirth", thisStudent.getMonthOfBirth());
            query.setParameter("dayOfBirth", thisStudent.getDayOfBirth());
            query.setParameter("coachGroupName", thisStudent.getCoachGroup());
            query.setParameter("lessonGroupID", thisStudent.getLessonGroup());
            query.executeUpdate();

            tx.commit();

        } catch (HibernateException s) {
            if (tx != null) {
                tx.rollback();
            }
            s.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * updates a student
     *
     * @param
     */
    
    public void update(Student thisStudent) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "UPDATE student SET studentOV = :studentOV , cohort = :cohort ,  email = :email , firstName = :firstName , insertion = :insertion , lastName = :lastName , cardID = :crdID , yearOfBirth = :yearOfBirth , notelist = :notelist , monthOfBirth = :monthOfBirth , dayOfBirth = :dayOfBirth , coachGroupName = :coachGroupName , lessonGroupID = :lessonGroupID , WHERE educationTeamID = :educationTeamID ;";
            NativeQuery query = session.createNativeQuery(sql);
            query.setParameter("studentOV", thisStudent.getStudentOV());
            query.setParameter("cohort", thisStudent.getCohort());
            query.setParameter("email", thisStudent.getEmail());
            query.setParameter("firstName", thisStudent.getFirstName());
            query.setParameter("inertion", thisStudent.getInsertion());
            query.setParameter("lastName", thisStudent.getLastName());
            query.setParameter("cardID", thisStudent.getCardID());
            query.setParameter("yearOfBirth", thisStudent.getYearOfBirth());
            query.setParameter("notelist", thisStudent.getNoteList());
            query.setParameter("monthOfBirth", thisStudent.getMonthOfBirth());
            query.setParameter("dayOfBirth", thisStudent.getDayOfBirth());
            query.setParameter("coachGroupName", thisStudent.getCoachGroup());
            query.setParameter("lessonGroupID", thisStudent.getLessonGroup());
            
            query.executeUpdate();

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void delete(Student thisStudent) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createNativeQuery("DELETE FROM stuent WHERE studentOV = :studentOV")
                    .setParameter("studentOV", thisStudent.getStudentOV()).executeUpdate();

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    
    /**
     * reads all the students in the database
     *
     * @return Set<student>
     */
    @Override
    public Set<Student> readAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        Set<Student> students = new TreeSet<>();
        try {
            tx = session.beginTransaction();
            List studentList = session.createNativeQuery("SELECT * FROM student;")
                    .getResultList();
            for (Iterator iterator = studentList.iterator(); iterator.hasNext();) {
                Object[] obj = (Object[]) iterator.next();
                Student s = new Student(String.valueOf(obj[13]),String.valueOf(obj[12]), String.valueOf(obj[11]),String.valueOf(obj[10]), String.valueOf(obj[9]),String.valueOf(obj[8]), String.valueOf(obj[7]),String.valueOf(obj[6]), String.valueOf(obj[5]),String.valueOf(obj[4]), String.valueOf(obj[3]),String.valueOf(obj[2]), String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[0])));
                students.add(s);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return teams;
    }

   

   
    /**
     * deletes the given student from the given lessonGroup.
     *
     * @param Student student
     * @param LessonGroup lessonGroup
     */
 
    public void deleteTeacherFromEducationTeam(Student student, LessonGroup lessongroup) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createNativeQuery("DELETE FROM student_lesson_group WHERE student_studentOV = :studentOV")
                    .setParameter("studentOV", student.getStudentOV()).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * check if there already is an instance of this class and returns it.
     *
     * @return MYSQLDAOEducationTeam
     */
    public static MYSQLDAOStudent getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOStudent();
        }
        return instance;
    }

}
