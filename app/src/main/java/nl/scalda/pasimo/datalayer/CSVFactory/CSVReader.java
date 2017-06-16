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
import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
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
    private Set<Student> students = new TreeSet<>();
    private static CSVReader instance;


    public CSVReader() {

    }

    /**
     * @param file
     * @param coachGroupName
     * @param lessonGroup
     * @param cohort
     * @return
     */
    public Set<Student> readFile(File file, String coachGroupName, int lessonGroupID, int cohort) {
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
            int i = 0; // auto generate bsn number has to be changed before merge with develop.
            while ((line = br.readLine()) != null) { // this will read line by line from the file and execute this script for every line.
                String[] student = line.split(cvsSplitBy); // this will split the large line in to 
                String[] YearsMonthsDays = student[5].split(date);
                   //hardcoded bsn number needed to be changed before merge with develop!!!
                   Student a = new Student(i,// bsnnumber
                		   Integer.parseInt(student[0]),// StudentOV
                		   cohort,// cohort
                		   String.valueOf(student[4]),// email
                		   String.valueOf(student[1]),// firstname
                		   String.valueOf(student[2]),// insertion
                		   String.valueOf(student[3]),// lastname
                		   123456789,// cardID
                		   Integer.parseInt(YearsMonthsDays[2]),// year of birth
                		   null,// notelist
                		   Integer.parseInt(YearsMonthsDays[1]),// month of birth
                		   Integer.parseInt(YearsMonthsDays[0]),// day of birth
                		   coachGroupName,// name of coachgroup
                		   lessonGroupID);// name of lessongroup
                    students.add(a);
                    i++;
                    //TODO create method in IDAOStudent to add all students in one session.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

}
