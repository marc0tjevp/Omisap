package nl.scalda.pasimo.employeeManagement.model;

public class LessonGroup implements Comparable<LessonGroup> {

    private String name;

    //<editor-fold defaultstate="collapsed" desc="constructor">

    public LessonGroup(String name) {
        this.name = name;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //</editor-fold>

    @Override
    public int compareTo(LessonGroup o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "LessonGroup{" +
                "name='" + name + '\'' +
                '}';
    }

}
