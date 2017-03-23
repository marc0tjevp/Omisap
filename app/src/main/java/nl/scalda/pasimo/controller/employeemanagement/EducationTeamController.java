package nl.scalda.pasimo.controller.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestEducationTeamDAO;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import java.util.TreeSet;
import nl.scalda.pasimo.model.employeemanagement.Team;

public class EducationTeamController extends ActionSupport {

    public String name;
    public String abbreviation;
    public Team team = new Team("hoi", "hoi");

    public String index() {

        readTeams();

        return SUCCESS;

    }

    public String create() {

        return SUCCESS;
    }

    public String update() {

        return SUCCESS;
    }

    public String addEducationTeam() {

        EducationTeam d = new EducationTeam(name, abbreviation);

        team.addEducationTeam(d);

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
