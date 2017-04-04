package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

<<<<<<< HEAD

import nl.scalda.pasimo.test.CoachGroupList;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;


=======
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;





>>>>>>> 426f123ee9dbf277c48fbaf7cb2735293db8089d
/**
 * @author Collin and ismet
 */
public class CoachGroup implements Comparable<CoachGroup> {
	
	/**
	 * The index of this lesson group
	 */
    private int id;
    /**
	 * The name of this Coach group
	 */
    private String name;
<<<<<<< HEAD
    //TODO verander coach
    private Teacher teacher;
=======
    /**
     * The Teacher of this CoachGroup
     */
    private Teacher coach;
    /**
	 * The {@link LessonGroups}'s who are in this CoachGroup
	 */
>>>>>>> 426f123ee9dbf277c48fbaf7cb2735293db8089d
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
  
   

    /**
     * Default constructor
     */
    public CoachGroup() {}
    
    /**
	 * @param id
	 *            The index of this Coach group
	 * @param name
	 *            The name of this Coach group
	 */
    public CoachGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
	 * @param id
	 *            The index of this Coach group
	 * @param name
	 *            The name of this Coach group
	 * @param coach 
	 * 			  The Coach of this Coach group
	 */
    public CoachGroup(int id, String name, Teacher coach) {
    	this.id = id;
        this.name = name;
        this.coach = coach;
    }
<<<<<<< HEAD

    public CoachGroup(String name, Teacher teacher, EducationTeam currentEducationTeam) {
        this.name = name;
        this.teacher = teacher;
        this.currentEducationTeam = currentEducationTeam;
    }
    
    public CoachGroup(String name, Teacher teacher, TreeSet<LessonGroup> lessonGroups) {
=======
    
    //TODO is only used for MYSQLDAOTeacher needs to be fixed
    public CoachGroup( String name, Teacher coach) {
>>>>>>> 426f123ee9dbf277c48fbaf7cb2735293db8089d
        this.name = name;
        this.coach = coach;
    }
    
    /**
	 * @param id
	 *            The index of this Coach group
	 * @param name
	 *            The name of this Coach group
	 * @param coach 
	 * 			  The Coach of this Coach group
	 * @param {@link LessonGroups}
	 * 			  The LessonGroups of this Coach group
	 */
    public CoachGroup(int id, String name, Teacher coach, TreeSet<LessonGroup> lessonGroups) {
    	this.id = id;
        this.name = name;
        this.coach = coach;
        this.lessonGroups = lessonGroups;
    }
    /**
     * Adds LessonGroup to a coachGroup
     * @param Lessongroup 
     */
    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
        TestDAOLessonGroup.getInstance().create(lg);
    }
<<<<<<< HEAD
    //TODO naar lesson Group
    public void updateLessonGroup(LessonGroup lessonGroup) {
        for (LessonGroup eachLessonGroup : this.lessonGroups) {
            if (eachLessonGroup != lessonGroup) {
                continue;
            }
            eachLessonGroup.setName(lessonGroup.getName());
            eachLessonGroup.setStudents(lessonGroup.getStudents());
        }
        
        
    }

    public int getCoachGroupNumber() {
		return CoachGroupNumber;
	}

	public void setCoachGroupNumber(int coachGroupNumber) {
		CoachGroupNumber = coachGroupNumber;
	}

	public void deleteLessonGroup(LessonGroup lg) {
=======
    /**
	 * Deletes a lessonGroup from a coachGroup
	 * @param LessonGroup
	 */
	public void deleteLessonGroup(LessonGroup lg) {

>>>>>>> 426f123ee9dbf277c48fbaf7cb2735293db8089d
        lessonGroups.remove(lg);
        TestDAOLessonGroup.getInstance().delete(lg);

    }
	/**
	 * Sends coachgroup naar de DAO to update
	 */
	public void updateCoachGroup(){
		//DAOFactory.getTheFactory().getDAOCoachGroup().update(this);
		TestDAOCoachGroup.getInstance().update(this);
	}

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
	/**
	 * Retrieves the index of this coach group
	 *
	 * @return The index of this coach group
	 */
    public int getId() {
        return id;
    }
    /**
	 * Sets the index of this coach group
	 */
	public void setId(int id) {

<<<<<<< HEAD
    public EducationTeam getCurrentEducationTeam() {
		return currentEducationTeam;
	}

	public void setCurrentEducationTeam(EducationTeam currentEducationTeam) {
		this.currentEducationTeam = currentEducationTeam;
	}

	public void setId(int id) {
=======
>>>>>>> 426f123ee9dbf277c48fbaf7cb2735293db8089d
        this.id = id;
    }
	/**
	 * Retrieves the name of this coach group
	 *
	 * @return The name of this coach group
	 */
    public String getName() {
        return name;
    }
    /**
	 * Sets the index of this lesson group
	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
	 * Retrieves the coach of this coach group
	 *
	 * @return The index of this lesson group
	 */
    public Teacher getCoach() {
		return coach;
	}
    /**
	 * Sets the coach of this lesson group
	 */
	public void setCoach(Teacher coach) {
		this.coach = coach;
	}
	/**
	 * Retrieves the {@link LessonGroups}'s of this coach group
	 *
	 * @return The index of this lesson group
	 */
	public TreeSet<LessonGroup> getLessonGroups() {
        return lessonGroups;
    }
	/**
	 * Sets the {@link LessonGroups}'s of this coach group
	 * @param {@link LessonGroups}'s
	 */
    public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
        this.lessonGroups = lessonGroups;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "\n CoachGroup: id= " +
               id +
               ", name= " +
               name +
               ", coach= " +
               coach +
               ", lessongroup= " +
               lessonGroups;
    }
    /**
     *   Sorts the lesson groups by name when adding a lesson group to a TreeSet
     *   @param coachGroup
     */
    @Override
    public int compareTo(CoachGroup o) {
        return ((Integer) id).compareTo(o.getId());
    }
}