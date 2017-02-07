package nl.scalda.pasimo.test.employeeManagement;


import nl.scalda.pasimo.model.employeeManagement.EducationTeam;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeeManagement.Team;
import nl.scalda.pasimo.service.DAOFactoryService;
import nl.scalda.pasimo.service.Service;

public class US11_Model_Test {

    public static void main(String[] args) {

        Team t = new Team ("ICT", "Informatie- Communicatie Technologie");

        // Set the used DAOFactory
        Service.getDAOFactoryService().setFactory(new TestDAOFactory());

        EducationTeam ao = new EducationTeam("AO", "Applicatie Ontwikkelaar");
        EducationTeam ssc = new EducationTeam("SSC", "Shared Service Center");

        t.addEducationTeam(ao);
        System.out.println(ao);
        System.out.println(t);
        System.out.println(DAOFactoryService.getInstance().getFactory().getEducationTeamDAO().readAll());

    }

}
