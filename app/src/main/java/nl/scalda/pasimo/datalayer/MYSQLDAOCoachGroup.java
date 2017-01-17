/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer;

import java.util.TreeSet;
import nl.scalda.pasimo.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.EmployeeManagement.CoachGroup;

/**
 *
 * @author jeroe
 */
public class MYSQLDAOCoachGroup extends MySQLDAOConnection implements IDAOCoachGroup {

    private static MYSQLDAOCoachGroup instance = null;

    @Override
    public void create(CoachGroup CoachGroup) {
        
    }

    @Override
    public CoachGroup read(CoachGroup CoachGroup) {
        return CoachGroup;
    }

    @Override
    public void update(CoachGroup oldCoachGroup, CoachGroup newCoachGroup) {
        
    }

    @Override
    public void delete(CoachGroup CoachGroup) {
        
    }

    public static MYSQLDAOCoachGroup getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOCoachGroup();
        }
        return instance;
    }

}
