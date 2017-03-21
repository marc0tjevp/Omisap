package nl.scalda.pasimo.controller.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestEducationTeamDAO;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import com.opensymphony.xwork2.ActionSupport;
import java.util.TreeSet;

/**
 * Created by Diederik on 8-2-2017.
 */
public class EducationTeamController extends ActionSupport {

    public String name;
    public String abbreviation;
    public TreeSet<EducationTeam> educationTeams = new TreeSet<>();

    public String index() {

        EducationTeam e = new EducationTeam("TOBJ", "Test Object");

        educationTeams.add(e);

        readTeams();

        return SUCCESS;
    }
    
    public String addEducationTeam() {

        EducationTeam d = new EducationTeam(name, abbreviation);

        educationTeams.add(d);

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
    

    public TreeSet getEducationTeams() {
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
