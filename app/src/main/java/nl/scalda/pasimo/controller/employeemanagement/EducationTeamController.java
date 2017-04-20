package nl.scalda.pasimo.controller.employeemanagement;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import java.util.TreeSet;

public class EducationTeamController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    public String name;
    public String abbreviation;
    
    public TreeSet<EducationTeam>educationteams = new TreeSet<>();
    

    public String addEducationTeam() {

        EducationTeam d = new EducationTeam(name, abbreviation);

        educationteams.add(d);

        return SUCCESS;
    }
    public String index() {

        return SUCCESS;

    }

    public String create() {
        return SUCCESS;
    }

    public String update() {

        return SUCCESS;
    }

    public String editEducationTeam() {

        return SUCCESS;
    }

    public String deleteEducationTeam() {

        return SUCCESS;
    }

    public Set<EducationTeam> getEducationTeams() {
     return null;
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

}
