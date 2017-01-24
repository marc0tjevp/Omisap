package nl.scalda.pasimo.employeeManagement.model;

import java.util.TreeSet;

public class EducationTeam implements Comparable<EducationTeam> {

    private String abbreviation;
    private String name;
    private TreeSet<CoachGroup> coachGroups;
    private TreeSet<LessonGroup> lessonGroup;

    //<editor-fold defaultstate="collapsed" desc="constructor">

    public EducationTeam(String abbreviation) {
        // TODO: load..
    }

    public EducationTeam(String abbreviation, String name, TreeSet<CoachGroup> coachGroups, TreeSet<LessonGroup> lessonGroup) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.coachGroups = coachGroups;
        this.lessonGroup = lessonGroup;
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

    public TreeSet<CoachGroup> getCoachGroups() {
        return coachGroups;
    }

    public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
        this.coachGroups = coachGroups;
    }

    public TreeSet<LessonGroup> getLessonGroup() {
        return lessonGroup;
    }

    public void setLessonGroup(TreeSet<LessonGroup> lessonGroup) {
        this.lessonGroup = lessonGroup;
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
                ", coachGroups=" + coachGroups +
                ", lessonGroup=" + lessonGroup +
                '}';
    }

}