package nl.scalda.pasimo.model.employeeManagement;

public class EducationTeam implements Comparable<EducationTeam> {

    /**
     * Abbreviation of the EducationTeam; e.g. AO
     */
    private String abbreviation;

    /**
     * Name of the EducationTeam; e.g. Applicatie Ontwikkelaar
     */
    private String name;

    //<editor-fold defaultstate="collapsed" desc="constructor">

    public EducationTeam(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    //</editor-fold>

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

    //</editor-fold>

    @Override
    public int compareTo(EducationTeam o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "EducationTeam{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}