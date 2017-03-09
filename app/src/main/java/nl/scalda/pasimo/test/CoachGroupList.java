package nl.scalda.pasimo.test;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;

public class CoachGroupList extends TreeSet<CoachGroup>{
	
	private static CoachGroupList instance;
	TreeSet<CoachGroup> coachgroups = new TreeSet<>();
	
	private CoachGroupList(){
		
	}
	public void addCoachGroup(CoachGroup c){
		coachgroups.add(c);
	}
	
	public void removeCoachGroup(CoachGroup c) {
		coachgroups.remove(c);
	}
	
	public TreeSet<CoachGroup> getCoachgroups() {
		return coachgroups;
	}

	public void setCoachgroups(TreeSet<CoachGroup> coachgroups) {
		this.coachgroups = coachgroups;
	}

	public static CoachGroupList getInstance() {
        if (instance == null) {
            instance = new CoachGroupList();
        }
        return instance;
    }

}