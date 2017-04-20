/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

/**
 *
 * @author jeroe
 */
public class MYSQLDAOCoachGroup implements IDAOCoachGroup {

    private static MYSQLDAOCoachGroup instance = null;

    @Override
    public void create(CoachGroup CoachGroup) {

    }

    @Override
    public CoachGroup read(CoachGroup CoachGroup) {
        return CoachGroup;
    }

    @Override
    public void update(CoachGroup coachGroup) {

    }

    @Override
    public void delete(CoachGroup CoachGroup) {

    }

    @Override
	public TreeSet<CoachGroup> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
    public static MYSQLDAOCoachGroup getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOCoachGroup();
        }
        return instance;
    }

	@Override
	public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t) {
		// TODO Auto-generated method stub

		return null;
	}

	

}
