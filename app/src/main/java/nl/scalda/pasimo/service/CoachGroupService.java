/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.service;

/**
 *
 * @author jeroe
 */
public class CoachGroupService {
   private static CoachGroupService instance = null;
   
   protected CoachGroupService() {
      // Exists only to defeat instantiation.
   }
   
   public static CoachGroupService getInstance() {
      if(instance == null) {
         instance = new CoachGroupService();
      }
      return instance;
   }
}
