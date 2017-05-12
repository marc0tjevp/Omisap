/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer.CSVFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.Student;
/**
 *
 * @author jeroe
 */
public class CSVReader {
	/**
	 * 
	 * 
	 * 
	 * the csv file is in the onedrive
	 * https://scalda365.sharepoint.com/sites/pasimo/_layouts/15/guestaccess.aspx?guestaccesstoken=UNvgztTFh1y65hLRTGZpgBI%2fRFAEiFXCsKoesH5ZLYc%3d&docid=2_1eabb040818454e5eb58e58dcdab04dae&rev=1
	 * 
	 * 
	 * 
	 */
    private TreeSet<Student> students = new TreeSet<>();
    private static CSVReader instance;
    
    public CSVReader(){
    	
    }

    public TreeSet<Student> readFile(File file, String coachGroupName, int lessonGroupID, int cohort) {
       	// format that the csv file is: Nummer;Roepnaam;Voorvoegsel;Achternaam;Email school;Geboortedatum;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        String date = "-";

        try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        try {
        	br.readLine();
			while ((line = br.readLine()) != null) {
				String[] student = line.split(cvsSplitBy);
				String[] YearsMonthsDays = student[5].split(date);

				Student a = new Student(Integer.parseInt(student[0]), 0, String.valueOf(student[3]), String.valueOf(student[1]), String.valueOf(student[2]), String.valueOf(student[3]), 0, Integer.parseInt(YearsMonthsDays[2]), null, Integer.parseInt(YearsMonthsDays[1]), Integer.parseInt(YearsMonthsDays[0]),coachGroupName);
				students.add(a);
				
				//TODO create method in IDAOStudent to add all students in one session.
			    a.createStudent();
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
