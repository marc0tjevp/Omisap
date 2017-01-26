/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

/**
 *
 * @author jeroe
 */
public class EducationTeam implements Comparable<EducationTeam>{

    private String name;
    private String abbreviation;
    private TreeSet<CoachGroup> coachGroups;

    public EducationTeam() {
    }

    public EducationTeam(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public EducationTeam(String name, String abbreviation, TreeSet<CoachGroup> couchGroups) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.coachGroups = couchGroups;
    }
    
    public void addCoachGroup(CoachGroup coachGroup){
        coachGroups.add(coachGroup);
    }
    
    public void deleteCoachGroup(CoachGroup coachGroup){
        coachGroups.remove(coachGroup);
    }
    
    public void updateCoachGroup(CoachGroup coachGroup){
        for(CoachGroup ccg : coachGroups){
            if(ccg.getId() == coachGroup.getId()){
                ccg = coachGroup;
            }
        }
    }
    

//<editor-fold defaultstate="collapsed" desc="getters and setters">
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

    public TreeSet<CoachGroup> getCoachGroups() {
        return coachGroups;
    }

    public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
        this.coachGroups = coachGroups;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "EducationTeam{name= " + name + ", abbreviation= " + abbreviation + ", couchGroups= " + coachGroups;
    }

    @Override
    public int compareTo(EducationTeam o) {
        return abbreviation.compareTo(o.getAbbreviation());
    }
    
    
}
