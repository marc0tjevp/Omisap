package nl.scalda.pasimo.model.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.*;

@Entity
@Table(name="educationteam")
public class EducationTeam implements Comparable<EducationTeam>{
	
	/**
     * 
=======
@Table(name = "educationTeam")
public class EducationTeam implements Comparable<EducationTeam>, Serializable {

    /**
     *
>>>>>>> develop
     * Id of the EducationTeam
     */
	@Id
	@Column(name="educationTeamID", length=11, nullable=false)
    private int id;
	@OneToMany(cascade=CascadeType.ALL, targetEntity=CoachGroup.class)
    @JoinColumn(name="id")
	private Set<CoachGroup> coachGroups = new TreeSet<>();
	@ManyToMany(cascade=CascadeType.ALL, targetEntity=Teacher.class, fetch=FetchType.EAGER)
	@JoinColumn(name="bsn")
    private Set<Teacher> teachers = new TreeSet<>();
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
    
    public EducationTeam() {
		
	}

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
    	cg.setName(this.abbreviation + cg.getName());
    	this.coachGroups.add(cg);
    	System.out.println(this.getCoachGroups());
    	DAOFactory.getTheFactory().getDAOCoachGroup().create(cg, this);
    	//TestDAOCoachGroup.getInstance().create(cg);
    
    }
    /**
     * updates coachgroup from an educationTeam and database
     * 
     * @param cg
     * @param oldname
     */
//<<<<<<< HEAD
//    public void updateCoachGroup(CoachGroup cg , String oldname){
//    	MYSQLDAOCoachGroup.getInstance().update(cg, this, oldname);
//    	
//=======
    public void updateCoachGroup(CoachGroup cg, String oldname) {
        DAOFactory.getTheFactory().getDAOCoachGroup().update(cg,this, oldname);
    }
    
    
    /**
     * Deletes a coachgroup from a EducationTeam and database
     * @param CoachGroup coach
     */
    public void deleteCoachGroup(CoachGroup cg){
    	this.coachGroups.remove(cg);
    	DAOFactory.getTheFactory().getDAOCoachGroup().delete(cg);
    	//TestDAOCoachGroup.getInstance().delete(cg);
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
//                ct.setNoteList(teacher.getNoteList());
            }
        }
    }

    public void deleteTeacher(Teacher t) {
        if (teachers.remove(t)) {
            DAOFactory.getTheFactory().getDAOEducationTeam().deleteTeacherFromEducationTeam(t, this);
        }
    }

    public Set<Teacher> getTeachers() {
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
        return "EducationTeam{"
                + "abbreviation='" + abbreviation + '\''
                + ", name='" + name + '\''
                + '}';
    }

	public Set<CoachGroup> getCoachGroups() {
		if(coachGroups.isEmpty()){
			loadCoachGroups();
		}
		return coachGroups;
	}

	public void setCoachGroups(Set<CoachGroup> coachGroups) {
		this.coachGroups = coachGroups;
	}
	
	public void loadCoachGroups(){
		this.coachGroups = DAOFactory.getTheFactory().getDAOCoachGroup().readAllBYTeam(this);
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EducationTeam other = (EducationTeam) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
