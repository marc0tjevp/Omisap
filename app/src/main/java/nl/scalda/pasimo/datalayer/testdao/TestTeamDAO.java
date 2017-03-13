package nl.scalda.pasimo.datalayer.testdao;

import nl.scalda.pasimo.interfaces.ITeamDAO;
import nl.scalda.pasimo.model.employeemanagement.Team;

import java.util.Set;
import java.util.TreeSet;

public class TestTeamDAO implements ITeamDAO {

    private Set<Team> teams;

    private TestTeamDAO() {
        this.teams = new TreeSet<Team>();

        this.teams.add(new Team("ICT", "Informatie- Communicatie Technologie"));

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
