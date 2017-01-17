/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.interfaces;

import java.util.TreeSet;
import nl.scalda.pasimo.model.EmployeeManagement.CoachGroup;

/**
 *
 * @author jeroe
 */
public interface IDAOCoachGroup {

    public void create(CoachGroup CoachGroup);

    public CoachGroup read(CoachGroup CoachGroup);

    public void update(CoachGroup oldCoachGroup, CoachGroup newCoachGroup);
    
    public void delete(CoachGroup CoachGroup);
}
