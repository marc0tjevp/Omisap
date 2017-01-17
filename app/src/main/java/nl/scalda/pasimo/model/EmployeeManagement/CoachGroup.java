package nl.scalda.pasimo.model.EmployeeManagement;

import java.util.TreeSet;

/**
 *
 * @author jeroe
 */
public class CoachGroup implements Comparable<CoachGroup>{

    private int id;
    private String name;
    private Teacher teacher;
    private TreeSet<Student> students;

    public CoachGroup() {
    }

    public CoachGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CoachGroup(String name, Teacher teacher){
        this.name = name;
        this.teacher = teacher;
    }
    public CoachGroup(String name, Teacher teacher, TreeSet<Student> students){
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }
    
    public void addStudent(Student s){
        this.students.add(s);
    }
    
    public void updateStudent(Student s){
        for(Student cs : this.students){
            if(cs.getCardID() == s.getCardID()){
                cs.setName(s.getName());
                cs.setLastname(s.getLastname());
                cs.setEmail(s.getEmail());
            }
        }
    }
    
    public void deleteStudent(Student s){
        students.remove(s);
    }
    
    public void updateTeacher(){
        
    }
    
    
//<editor-fold defaultstate="collapsed" desc="getters and setters">    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public TreeSet<Student> getStudents() {
        return students;
    }

    public void setStudents(TreeSet<Student> students) {
        this.students = students;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "CoachGroup{" + "id=" + id + ", name=" + name + ", teacher=" + teacher + ", students=" + students + '}';
    }

    
    @Override
    public int compareTo(CoachGroup o) {
        return name.compareTo(o.getName());
    }
}
