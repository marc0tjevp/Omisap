package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;





/**
 * @author Collin and ismet
 */
public class CoachGroup implements Comparable<CoachGroup> {
	
	
    /**
	 * The name of this Coach group
	 */
    private String name;
    /**
     * The Teacher of this CoachGroup
     */
    private Teacher coach;
    /**
	 * The {@link LessonGroups}'s who are in this CoachGroup
	 */
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();

    /**
     * Default constructor
     */
    public CoachGroup() {}
    
    /**
	 * @param name
	 *            The name of this Coach group
	 */
    public CoachGroup( String name) {
        this.name = name;
    }
    
    //TODO is only used for MYSQLDAOTeacher needs to be fixed
    public CoachGroup( String name, Teacher coach) {
        this.name = name;
        this.coach = coach;
    }
    
    /**
	 * @param name
	 *            The name of this Coach group
	 * @param coach 
	 * 			  The Coach of this Coach group
	 * @param {@link LessonGroups}
	 * 			  The LessonGroups of this Coach group
	 */
    public CoachGroup(String name, Teacher coach, TreeSet<LessonGroup> lessonGroups) {
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
    /**
	 * Deletes a lessonGroup from a coachGroup
	 * @param LessonGroup
	 */
	public void deleteLessonGroup(LessonGroup lg) {

        lessonGroups.remove(lg);
        TestDAOLessonGroup.getInstance().delete(lg);

    }
	/**
	 * Sends coachgroup naar de DAO to update
	 */
	public void updateCoachGroup(){
		DAOFactory.getTheFactory().getDAOCoachGroup().update(this);
		//TestDAOFactory.getTheFactory().getDAOCoachGroup().update(this);
	
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
        return "\n CoachGroup: name= " +
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
<<<<<<< HEAD
    	
=======
>>>>>>> 94c48a03475f1d4653f448461fb44d241a5c69ce
        return name.compareToIgnoreCase(o.getName());
    }
}