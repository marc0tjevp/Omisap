package nl.scalda.pasimo.employeeManagement.model;

public class CoachGroup implements Comparable<CoachGroup> {

    private String name;

    public CoachGroup(String name) {
        this.name = name;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>

    @Override
    public int compareTo(CoachGroup o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "CoachGroup{" + "name='" + name + '\'' + '}';
    }

}
