package nl.scalda.pasimo.controller.employeemanagement;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import java.util.TreeSet;

public class EducationTeamController extends ActionSupport {

    public String name;
    public String abbreviation;
    public TreeSet<EducationTeam> educationTeams;

    public String index() {
        
        EducationTeam a = new EducationTeam("AO", "Applicatie Ontwikkeling");
        educationTeams.add(a);

        readTeams();

        return SUCCESS;

    }

    public String create() {

        EducationTeam thisEducationTeam = new EducationTeam(name, abbreviation);

        educationTeams.add(thisEducationTeam);
        
        // Send to service

        return SUCCESS;
    }

    public String update() {
        

        return SUCCESS;
    }

    public String editEducationTeam() {
        // Executed when educationTeam edit form is submitted

        return SUCCESS;
    }

    public String deleteEducationTeam() {
        // Executed when educationTeam edit form is submitted

        return SUCCESS;
    }

    public Set getEducationTeams() {
        return educationTeams;
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
