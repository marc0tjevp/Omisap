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

    public EducationTeam educationTeam = new EducationTeam();
    public String name;
    public String abbreviation;
    public TreeSet<EducationTeam> educationTeams = new TreeSet<>();

    public String index() {

        readTeams();

        return SUCCESS;
    }

    public String create() {

        return SUCCESS;
    }

    public String delete() {

        return SUCCESS;
    }

    public String update() {

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

    public String addEducationTeam() {

        EducationTeam d = new EducationTeam(name, abbreviation);

        educationTeams.add(d);
        
//        System.out.println(d.toString());

        return SUCCESS;
    }

    public String readTeams() {

        getEducationTeams();

        return SUCCESS;
    }

}
