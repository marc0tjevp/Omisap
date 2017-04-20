/**
 * 
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

/**
 * @author Bram van Huele
 * Pasimo
 * 12 apr. 2017
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LessonGroup lg = new LessonGroup("LessonGroupName");
		CoachGroup cg = new CoachGroup("CoachGroupName1");
		LessonGroup lg2 = new LessonGroup("Working");
		LessonGroup lg3 = new LessonGroup("bas");
		
		cg.addLessonGroup(lg3);
		
		cg.addLessonGroup(lg2);

		cg.addLessonGroup(lg);
		
		System.out.println(cg);
		
		cg.deleteLessonGroup(lg2);
		
		}

}
