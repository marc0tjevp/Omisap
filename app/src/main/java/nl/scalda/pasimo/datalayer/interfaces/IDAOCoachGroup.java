/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer.interfaces;


import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

/**
 *
 * @author jeroe
 */
public interface IDAOCoachGroup {

    public void create(CoachGroup CoachGroup);

    public CoachGroup read(String name);
    
    public TreeSet<CoachGroup> readAll();
    
    public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t);

    public void update(CoachGroup coachGroup);
    
    public void delete(CoachGroup CoachGroup);
}
