package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import javax.persistence.*;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;

/**
 * @author Collin and ismet
 */
@Entity
@Table(name="coachGroup")
public class CoachGroup implements Comparable<CoachGroup> {

	/**
	 * The index of this lesson group
	 */
	@Id
	@Column(name="coachGroupID", length=64)
    private int coachGroupID;
	/**
	 * The name of this Coach group
	 */
	@Column(name="name", length=64)
    private String name;
	/**
     * The Teacher of this CoachGroup
     */
	@OneToOne
    private Teacher coach;
    
    /**
	 * The {@link LessonGroups}'s who are in this CoachGroup
	 */
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
    
    @ManyToOne(cascade=CascadeType.ALL, targetEntity=EducationTeam.class)
    @JoinColumn(name="educationTeam_id")
    private EducationTeam educationTeam;

	/**
	 * Default constructor
	 */
	public CoachGroup() {
	}

	/**
	 * @param name
	 * The name of this Coach group
	 */
    public CoachGroup( String name) {
        this.name = name;
    }

	public CoachGroup(String name, Teacher coach) {
		this.name = name;
		this.coach = coach;
	}

	/**
	 * @param name
	 *            The name of this Coach group
	 * @param coach
	 *            The Coach of this Coach group
	 * @param {@link
	 * 			LessonGroups} The LessonGroups of this Coach group
	 */
	public CoachGroup(String name, Teacher coach, TreeSet<LessonGroup> lessonGroups) {
		this.name = name;
		this.coach = coach;
		this.lessonGroups = lessonGroups;
	}

	/**
	 * Adds LessonGroup to a coachGroup
	 * 
	 * @param Lessongroup
	 */
	public void addLessonGroup(LessonGroup lg, boolean shouldAddTODB) {
		this.lessonGroups.add(lg);
		
		if(shouldAddTODB) {
			DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
			DAOFactory.getTheFactory().getDAOLessonGroup().create(lg, this);
			DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		}
	}

	/**
	 * Deletes a lessonGroup from a coachGroup
	 * 
	 * @param LessonGroup
	 */
	public void deleteLessonGroup(LessonGroup lg) {
		lessonGroups.remove(lg);
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		DAOFactory.getTheFactory().getDAOLessonGroup().delete(lg);
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
	}

	/**
	 * Sends coachgroup naar de DAO to update
	 */

	public void loadLessonGroups() {
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		this.lessonGroups = DAOFactory.getTheFactory().getDAOLessonGroup().readAllByCoachGroup(this);
	    DAOFactory.setTheFactory(TestDAOFactory.getInstance());
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
	 * 
	 * @param {@link
	 * 			LessonGroups}'s
	 */
	public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
		this.lessonGroups = lessonGroups;
	}
	// </editor-fold>
	
	/**
	 * 
	 * @param lessonGroupName
	 * @return
	 */
	public LessonGroup getLessonGroupByName(String lessonGroupName){
		if(lessonGroups == null){
			DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
			this.lessonGroups = 
					DAOFactory.getTheFactory().getDAOLessonGroup().readAllByCoachGroup(this);
		    DAOFactory.setTheFactory(TestDAOFactory.getInstance());

		}
		
		for(LessonGroup lessonGroup : lessonGroups) {
			if(!lessonGroup.getName().equals(lessonGroupName)) {
				continue;
			}
			return lessonGroup;
		}
		return null;
		
		
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

        return name.compareToIgnoreCase(o.getName());
    }

	public EducationTeam getEducationTeam() {
		return educationTeam;
	}

	public void setEducationTeam(EducationTeam educationTeam) {
		this.educationTeam = educationTeam;
	}
    
    public void load(){
    	DAOFactory.getTheFactory().getDAOCoachGroup().read(this);
    }
}