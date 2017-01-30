package nl.scalda.pasimo.test.employeeManagement;

import nl.scalda.pasimo.model.CoachGroup;
import nl.scalda.pasimo.model.EducationTeam;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.service.DAOFactoryService;
import nl.scalda.pasimo.service.Service;

public class US11_Model_Test {

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
