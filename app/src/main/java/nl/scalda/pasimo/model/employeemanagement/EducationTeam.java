package nl.scalda.pasimo.model.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;

import java.util.TreeSet;

import javax.persistence.*;

@Entity
@Table(name="education_team")
public class EducationTeam implements Comparable<EducationTeam>{
	
	/**
     * 
     * Id of the EducationTeam
     */
	@Id
	@Column(name="educationTeamID", length=11, nullable=false)
    private int id;
	private TreeSet<CoachGroup> coachGroups = new TreeSet<>();
    private TreeSet<Teacher> teachers = new TreeSet<>();

    /**
     * Abbreviation of the EducationTeam; e.g. AO
     */
    @Column(name="abbreviation", length=64)
    private String abbreviation;
    /**
     * Name of the EducationTeam; e.g. Applicatie Ontwikkelaar
     */
    @Column(name="name", length=64)
    private String name;

    public void addTeacher(Teacher t){
		if (teachers.add(t)) {
			DAOFactory.getTheFactory().getDAOEducationTeam().addTeacherToEducationTeam(t, this);
		}
		
	}
    
    /**
     * Adds a coachgroup from a EducationTeam and database
     * @param coachGroup
     */
    public void addCoachGroup(CoachGroup cg){
    	this.coachGroups.add(cg);
    	//DAOFactory.getTheFactory().getDAOCoachGroup().create(cg);
    	TestDAOCoachGroup.getInstance().create(cg);
    
    }
    
    /**
     * Deletes a coachgroup from a EducationTeam and database
     * @param CoachGroup coach
     */
    public void deleteCoachGroup(CoachGroup cg){
    	this.coachGroups.remove(cg);
    	//DAOFactory.getTheFactory().getDAOCoachGroup().create(coachGroup);
    	TestDAOCoachGroup.getInstance().delete(cg);
    }
    
    public void updateTeacher(Teacher teacher) {
        for (Teacher ct : teachers) {
            if (teacher.getAbbreviation().equals(ct.getAbbreviation())) {
                ct.setFirstName(teacher.getFirstName());
                ct.setInsertion(teacher.getInsertion());
                ct.setLastName(teacher.getLastName());
                ct.setCardID(teacher.getCardID());
                ct.setEmployeeNumber(teacher.getEmployeeNumber());
                ct.setEmail(teacher.getEmail());
 //               ct.setDateOfBirth(teacher.getDateOfBirth());
                ct.setNoteList(teacher.getNoteList());
            }
        }
    }
    
    
	public void deleteTeacher(Teacher t){
		if (teachers.remove(t)) {
			DAOFactory.getTheFactory().getDAOEducationTeam().deleteTeacherFromEducationTeam(t, this);
		}		
		
	}
	
	public TreeSet<Teacher> getTeachers() {
		 return teachers;
	}
	
	public EducationTeam(int id, String name) {
    	this.setId(id);
    	this.setName(name);
    }

    public EducationTeam(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }
    
    public EducationTeam(String abbreviation, String name, int id) {
    	this.setId(id);
        this.abbreviation = abbreviation;
        this.name = name;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    //</editor-fold>

    @Override
    public int compareTo(EducationTeam o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "EducationTeam{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

	public TreeSet<CoachGroup> getCoachGroups() {
		return coachGroups;
	}

	public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
		this.coachGroups = coachGroups;
	}

	
    

}
