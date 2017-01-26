package nl.scalda.pasimo.employeeManagement.datalayer.impl;

import nl.scalda.pasimo.employeeManagement.datalayer.ITeamDAO;
import nl.scalda.pasimo.employeeManagement.model.EducationTeam;
import nl.scalda.pasimo.employeeManagement.model.Team;

import java.util.TreeSet;

public class TestTeamDAO implements ITeamDAO {

    private TreeSet<Team> teams;

    public TestTeamDAO() {
        this.teams = new TreeSet<Team>();
    }

    @Override
    public Team read(String abbreviation) {

        for (Team team : this.teams) {
            if (team.getAbbreviation().equals(abbreviation))
                return team;
        }

        return null;
    }

    private static TestTeamDAO instance;

    public static TestTeamDAO getInstance()
    {
        if (instance == null)
            instance = new TestTeamDAO();
        return instance;
    }

}
