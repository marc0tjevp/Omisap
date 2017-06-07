package nl.scalda.pasimo.main;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.*;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;


public class Main {

    public static void main(String[] args) {
WorkingDay wd = new WorkingDay(3, "Woensdag");

	WorkBlock w = new WorkBlock(1, new PasimoTime(8,30), new PasimoTime(10,10));
   wd.addWorkBlock(w);

//        WorkWeek week = new WorkWeek(1);
    	DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
//		DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
System.out.println(wd);
DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
 
//}
//		<WorkWeek> workweeks = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
//
//		<WorkWeek> henk = DAOFactory.getTheFactory().getDAOWorkWeek().readAll();
//
//for(WorkWeek bla :workweeks){//
//	System.out.println(bla);
}//
//     System.out.println("Workweek readall");//
//     
//  System.out.println(henk.size());
  
    }


