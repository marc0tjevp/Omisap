/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.model.EmployeeManagement;

import java.util.TreeSet;

/**
 *
 * @author jeroe
 */
public class EducationTeam implements Comparable<EducationTeam>{
    
    private String name;
    private String abbr;
    private TreeSet<CoachGroup> coachgroups;

    public EducationTeam() {
    }

    public EducationTeam(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
    }

    public EducationTeam(String name, String abbr, TreeSet<CoachGroup> coachgroups) {
        this.name = name;
        this.abbr = abbr;
        this.coachgroups = coachgroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public TreeSet<CoachGroup> getCoachgroups() {
        return coachgroups;
    }

    public void setCoachgroups(TreeSet<CoachGroup> coachgroups) {
        this.coachgroups = coachgroups;
    }

    @Override
    public String toString() {
        return "EducationTeam{" + "name=" + name + ", abbr=" + abbr + ", coachgroups=" + coachgroups + '}';
    }

    @Override
    public int compareTo(EducationTeam o) {
        return this.abbr.compareTo(o.getAbbr());
    }
    
    
    
    
}
