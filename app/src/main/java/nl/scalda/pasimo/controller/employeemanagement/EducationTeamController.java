package nl.scalda.pasimo.controller.employeemanagement;


import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import nl.scalda.pasimo.model.employeemanagement.Team;

public class EducationTeamController extends ActionSupport {

    public String name;
    public String abbreviation;
    public Team team = new Team("hoi", "hoi");

    public String index() {

        readTeams();

        return SUCCESS;

    }

    public String addEducationTeam() {

        EducationTeam d = new EducationTeam(name, abbreviation);

        team.addEducationTeam(d);

        return SUCCESS;
    }

    public String editEducationTeam() {
        // Executed when educationTeam edit form is submitted
    	EducationTeam EducationTeam = null;
    	
   if(EducationTeam.class.equals(name))
	   EducationTeam = new EducationTeam(name, abbreviation);
    else {
	    EducationTeam = new EducationTeam(name, abbreviation);
   }
   
        return SUCCESS;

    }

    public String deleteEducationTeam() {
        // Executed when educationTeam edit form is submitted
         
    	if(EducationTeam.class.equals(name))
    		this.deleteEducationTeam();
    else{
            return null;
    }
		return SUCCESS;
    }

    public Set getEducationTeams() {
        return team.getEducationTeams();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String readTeams() {

        getEducationTeams();

        return SUCCESS;
    }

}
