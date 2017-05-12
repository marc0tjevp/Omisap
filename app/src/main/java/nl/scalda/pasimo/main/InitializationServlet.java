package nl.scalda.pasimo.main;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAONote;
 
@SuppressWarnings("serial") 
public class InitializationServlet extends HttpServlet {
	
	 public void init() throws ServletException {
	          //DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		 		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
	     }
	 
}
