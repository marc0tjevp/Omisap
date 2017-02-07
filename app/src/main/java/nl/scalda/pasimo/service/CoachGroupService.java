/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;

/**
 *
 * @author jeroe
 */
public class CoachGroupService {

    private static CoachGroupService instance = null;

    public void create(CoachGroup coachGroup) {//teacher
        DAOFactory.getTheFactory().getDAOCoachGroup().create(coachGroup);

    }

    public CoachGroup read(CoachGroup coachGroup) {
        return DAOFactory.getTheFactory().getDAOCoachGroup().read(coachGroup);
    }

    public void update(CoachGroup coachGroup) {
        DAOFactory.getTheFactory().getDAOCoachGroup().update(coachGroup);
    }

    public void delete(CoachGroup coachGroup) {
        DAOFactory.getTheFactory().getDAOCoachGroup().delete(coachGroup);
    }

//    public TreeSet<CoachGroup> getCoachGroups() {
//        //you will only use this when testing
//        return TestDAOFactory.getTheFactory().getDAOCoachGroup().getCoachGroups();
//    }
    public static CoachGroupService getInstance() {
        if (instance == null) {
            instance = new CoachGroupService();
        }
        return instance;
    }
}
