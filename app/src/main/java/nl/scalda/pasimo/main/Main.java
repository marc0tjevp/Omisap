package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.Student;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        //Call up DAO factory
        IDAOLessonGroup lessonGroupDAO = TestDAOFactory.getTheFactory().getDAOLessonGroup();

        //Lesson group adding students later
        LessonGroup lessonGroup1 = new LessonGroup(1, "ICO41D");
        Student students[] = {
                new Student("Bas", "vanDriel", "basvandriel94@gmail.com", 1),
                new Student("Max", "vanDriel", "basvandriel94@gmail.com", 1),
                new Student("Martin", "vanDriel", "basvandriel94@gmail.com", 1)
        };

        for (Student student : students) {
            lessonGroup1.addStudent(student);
        }

        //Empty lesson group
        LessonGroup lessonGroup2 = new LessonGroup(1, "ICO41A");

        //Lesson group with students already added

        TreeSet<Student> studentjesVoorLessonGroup3 = new TreeSet<>();
        studentjesVoorLessonGroup3.add(new Student("Hendriiiik", "vanDriel", "basvandriel94@gmail.com", 1));
        studentjesVoorLessonGroup3.add(new Student("HendriiiikJuuuuh", "vanDriel", "basvandriel94@gmail.com", 2));
        studentjesVoorLessonGroup3.add(new Student("Koen", "vanDriel", "basvandriel94@gmail.com", 2));

        LessonGroup lessonGroup3 = new LessonGroup(1, "ICO41B", studentjesVoorLessonGroup3);


        lessonGroupDAO.create(lessonGroup1);
        lessonGroupDAO.create(lessonGroup2);
        lessonGroupDAO.create(lessonGroup3);

        TreeSet<LessonGroup> createdLessonGroups = ((TestDAOLessonGroup) lessonGroupDAO).getLessongroups();


        //Testing delete
//        lessonGroupDAO.delete(lessonGroup1);

        TreeSet<LessonGroup> createdLessonGroups2 = ((TestDAOLessonGroup) lessonGroupDAO).getLessongroups();

        //Updating lessongroup
        lessonGroup2.setName("Een geupdatete les groep");

        lessonGroupDAO.update(lessonGroup2);

        lessonGroupDAO.read(lessonGroup2);

    }
}
