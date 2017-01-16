/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.service;
import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.models.EmployeeManagement.CoachGroup;
/**
 *
 * @author jeroe
 */
public class CoachGroupService {
   private static CoachGroupService instance = null;
   
   protected CoachGroupService() {
      // Exists only to defeat instantiation.
   }
   
   public void save(CoachGroup coachGroup){//teacher
       DAOFactory.getTheFactory().getDAOCoachGroup().save(coachGroup);
       
   }
   public void read(CoachGroup coachGroup){
       DAOFactory.getTheFactory().getDAOCoachGroup().read(coachGroup);
   }
   public void update(CoachGroup oldCoachGroup, CoachGroup newCoachGroup){
       DAOFactory.getTheFactory().getDAOCoachGroup().update(oldCoachGroup, newCoachGroup);
   }
   public void delete(CoachGroup coachGroup){
       DAOFactory.getTheFactory().getDAOCoachGroup().delete(coachGroup);
   }
   
   
   public static CoachGroupService getInstance() {
      if(instance == null) {
         instance = new CoachGroupService();
      }
      return instance;
   }
}
