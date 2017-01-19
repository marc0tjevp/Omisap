package nl.scalda.pasimo.employeeManagement.model;

import java.util.TreeSet;

public class EducationTeam implements Comparable<EducationTeam> {

    private String name;
    private TreeSet<CoachGroup> coachGroups;

    public EducationTeam(String name) {
        this(name, new TreeSet<CoachGroup>());
    }

    public EducationTeam(String name, TreeSet<CoachGroup> coachGroups) {
        this.name = name;
        this.coachGroups = coachGroups;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<CoachGroup> getCoachGroups() {
        return coachGroups;
    }

    public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
        this.coachGroups = coachGroups;
    }
    //</editor-fold>

    @Override
    public int compareTo(EducationTeam o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "EducationTeam{" + "name='" + name + '\'' + ", coachGroups=" + coachGroups + '}';
    }

}
