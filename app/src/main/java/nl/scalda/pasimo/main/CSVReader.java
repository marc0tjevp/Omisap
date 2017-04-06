/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
/**
 *
 * @author jeroe
 */
public class CSVReader {

    private TreeSet<Student> students = new TreeSet<>();
    private static CSVReader instance;
    
    public CSVReader(){
    	
    }
    
    public TreeSet<Student> readFile(String fileLocation) {
       	String csvFile = fileLocation;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        String date = "-";

        try {
			br = new BufferedReader(new FileReader(csvFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        try {
        	br.readLine();
			while ((line = br.readLine()) != null) {
				String[] student = line.split(cvsSplitBy);
				String[] YearsMonthsDays = student[5].split(date);
//				boolean allLetters = student[5].chars().allMatch(Character::isLetter);
//				if (!allLetters){
//					System.out.println("day: "+YearsMonthsDays[0]);
//					System.out.println("month: "+YearsMonthsDays[1]);					
//					System.out.println("year: "+YearsMonthsDays[2]);
//				}
				Student a = new Student(Integer.parseInt(student[0]), 0, 0, 1, student[4], student[1], student[2], student[3], 0, Integer.parseInt(YearsMonthsDays[2]), 123, Integer.parseInt(YearsMonthsDays[1]), Integer.parseInt(YearsMonthsDays[0]));
			    students.add(a);
			    a.createStudent();
//				System.out.println("nummer; "+student[0]);
//			    System.out.println("roepnaam: "+student[1]);
//			    System.out.println("voorvoegsel: "+student[2]);
//			    System.out.println("achternaam: "+student[3]);
//			    System.out.println("email school: "+student[4]);
//			    System.out.println("year of birth: "+student[5]);
			    
			    
			    
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }
    
    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

}
