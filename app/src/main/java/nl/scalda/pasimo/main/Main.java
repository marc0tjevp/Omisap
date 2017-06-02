package nl.scalda.pasimo.main;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.*;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;


public class Main {

    public static void main(String[] args) {

//        WorkWeek week = new WorkWeek(1);
    	DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
        

		DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
  

 
//}
		TreeSet<WorkWeek> workweeks = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();

		TreeSet<WorkWeek> henk = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();

for(WorkWeek bla :workweeks){
	System.out.println(bla);
}
     System.out.println("Workweek readall");
     
  System.out.println(henk.size());
  
    }}


