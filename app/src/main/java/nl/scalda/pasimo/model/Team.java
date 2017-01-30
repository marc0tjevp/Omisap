package nl.scalda.pasimo.model;

import nl.scalda.pasimo.service.Service;

import java.util.TreeSet;

public class Team {

    private static final String ICT = "ict";

    /**
     * Abbreviation of the Team; e.g. ICT
     */
    private String abbreviation;

    /**
     * Name of the Team; e.g. Informatie- en Communicatietechnologie
     */
    private String name;

    /**
     *
     */
    private TreeSet<EducationTeam> educationTeams;

    /**
     *
     */
    public void addEducationTeam(EducationTeam educationTeam)
    {
        this.educationTeams.add(educationTeam);

        // TODO: Save..?
//        Service.getDAOFactoryService().getFactory().getTeamDAO();

    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<EducationTeam> getEducationTeams() {
        return this.educationTeams;
    }

    public void setEducationTeams(TreeSet<EducationTeam> educationTeams) {
        this.educationTeams = educationTeams;
    }

    //</editor-fold>

    @Override
    public String toString() {
        return "Team{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                ", educationTeams=" + educationTeams +
                '}';
    }

//    private ITeamDAO getTeamDAO()
//    {
//        return Service.getDAOFactoryService().getFactory().getTeamDAO();
//    }
//
//    private ITeamDAO getTeamDAO()
//    {
//        return Service.getDAOFactoryService().getFactory().getTeamDAO();
//    }

    private static Team instance;

    public static Team getInstance()
    {
        if (instance == null)
            instance = Service.getDAOFactoryService().getFactory().getTeamDAO().read(ICT);
        return instance;
    }

}
