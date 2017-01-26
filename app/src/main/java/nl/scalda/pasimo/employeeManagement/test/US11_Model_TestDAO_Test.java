package nl.scalda.pasimo.employeeManagement.test;

import nl.scalda.pasimo.employeeManagement.model.CoachGroup;
import nl.scalda.pasimo.employeeManagement.model.EducationTeam;
import nl.scalda.pasimo.foundation.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.foundation.service.DAOFactoryService;
import nl.scalda.pasimo.foundation.service.Service;

public class US11_Model_TestDAO_Test {

    public static void main(String[] args) {

        // Set the used DAOFactory
        Service.getDAOFactoryService().setFactory(new TestDAOFactory());

        EducationTeam ao = new EducationTeam("AO", "Applicatie Ontwikkelaar");
        EducationTeam ssc = new EducationTeam("SSC", "Shared Service Center");

        CoachGroup a1 = new CoachGroup("A1");
        CoachGroup a2 = new CoachGroup("A2");

        ao.addCoachGroup(a1);
        ao.addCoachGroup(a2);

        CoachGroup s1 = new CoachGroup("A1");
        CoachGroup s2 = new CoachGroup("A2");

        ssc.addCoachGroup(s1);
        ssc.addCoachGroup(s2);

        System.out.println(DAOFactoryService.getInstance().getFactory().getEducationTeamDAO().readAll());

    }

}
