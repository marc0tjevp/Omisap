package nl.scalda.pasimo.datalayer.testdao;

import nl.scalda.pasimo.datalayer.interfaces.IDAOTeam;
import nl.scalda.pasimo.model.employeemanagement.Team;

import java.util.Set;
import java.util.TreeSet;

public class TestDAOTeam implements IDAOTeam {

    private Set<Team> teams;

    private TestDAOTeam() {
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

    private static TestDAOTeam instance;

    public static TestDAOTeam getInstance()
    {
        if (instance == null)
            instance = new TestDAOTeam();
        return instance;
    }

}
