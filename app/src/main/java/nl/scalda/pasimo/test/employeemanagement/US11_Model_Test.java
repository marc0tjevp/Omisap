package nl.scalda.pasimo.test.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Team;

public class US11_Model_Test {

    public static void main(String[] args) {

        // Set the factory..
        DAOFactory.setTheFactory(TestDAOFactory.getInstance());

        Team t = new Team ("ICT", "Informatie- Communicatie Technologie");

        EducationTeam ao = new EducationTeam("AO", "Applicatie Ontwikkelaar");
        EducationTeam ssc = new EducationTeam("SSC", "Shared Service Center");

        t.addEducationTeam(ao);
        t.addEducationTeam(ssc);

        //System.out.println(t);

    }

}
