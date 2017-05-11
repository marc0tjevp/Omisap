package nl.scalda.pasimo.model.employeemanagement;



import nl.scalda.pasimo.datalayer.factory.DAOFactory;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.service.EducationTeamService;


public class EducationTeam implements Comparable<EducationTeam> {

	private TreeSet<CoachGroup> coachGroups = new TreeSet<>();
    private TreeSet<Teacher> teachers = new TreeSet<>();
    private Set<EducationTeam> educationTeams;

    /**
     * Abbreviation of the EducationTeam; e.g. AO
     */
    private String abbreviation;
    /**
     * Name of the EducationTeam; e.g. Applicatie Ontwikkelaar
     */
    private String name;
    /**
     *
     * Id of the EducationTeam
     */
    private int id;
    
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
    public void updateCoachGroup(CoachGroup cg , String oldname){
    	MYSQLDAOCoachGroup.getInstance().update(cg, this, oldname);
    	
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

                ct.setNoteList(teacher.getNoteList());


            }
        }
    }

    public void deleteTeacher(Teacher t) {
        if (teachers.remove(t)) {
            DAOFactory.getTheFactory().getDAOEducationTeam().deleteTeacherFromEducationTeam(t, this);

        }

    }

    public TreeSet<Teacher> getTeachers() {
        return teachers;
    }

    public EducationTeam(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }
    public void removeEducationTeam(EducationTeam educationTeam) {
        this.educationTeams.remove(educationTeam);
        DAOFactory.getTheFactory().getDAOEducationTeam().delete(educationTeam);
    }
    
    public void addEducationTeam(EducationTeam educationTeam) {
        this.educationTeams.add(educationTeam);
        EducationTeamService.getInstance().create(educationTeam);
  
    }
    public void updateEducationTeam(EducationTeam educationTeam) {
        educationTeam.setAbbreviation(educationTeam.getAbbreviation());
        educationTeam.setName(educationTeam.getName());
        DAOFactory.getTheFactory().getDAOEducationTeam().update(educationTeam);
        
        
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

	public TreeSet<CoachGroup> getCoachGroups() {
		if(coachGroups.isEmpty()){
			loadCoachGroups();
		}
		return coachGroups;
	}

	public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
		this.coachGroups = coachGroups;
	}
	
	public void loadCoachGroups(){
		this.coachGroups = 
				DAOFactory.getTheFactory().getDAOCoachGroup().readAllBYTeam(this);
	}
	
}
