package nl.scalda.pasimo.datalayer.impl;

import nl.scalda.pasimo.datalayer.ITeamDAO;
import nl.scalda.pasimo.model.employeeManagement.Team;

import java.util.Set;
import java.util.TreeSet;

public class TestTeamDAO implements ITeamDAO {

    private Set<Team> teams;

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

    // --------------------------------------------------
    // Singleton

    private static TestTeamDAO instance;

    public static TestTeamDAO getInstance()
    {
        if (instance == null)
            instance = new TestTeamDAO();
        return instance;
    }

}
