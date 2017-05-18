package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.factory.*;
import nl.scalda.pasimo.model.timeregistration.PasimoTime;
import nl.scalda.pasimo.model.timeregistration.WorkBlock;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkingDay;

public class Main {
    static    WorkingDay w = new WorkingDay("Maandag");

   public static void main(String[] args) {
	   
	   DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());

       WorkWeek week = new WorkWeek(1);

       
       WorkingDay workingday = new WorkingDay("maandag");
        System.out.println(workingday);

       
       DAOFactory.getTheFactory().getDAOWorkWeek().readAll();

   }
}