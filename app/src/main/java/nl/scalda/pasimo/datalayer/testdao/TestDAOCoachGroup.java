package nl.scalda.pasimo.datalayer.testdao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author jeroe
 */
public class TestDAOCoachGroup implements IDAOCoachGroup {
//<<<<<<< HEAD
//
//	private static TestDAOCoachGroup instance = null;
//	private TreeSet<CoachGroup> coachGroups = new TreeSet<>();
//
//	public TestDAOCoachGroup() {
//    	CoachGroup c1 = new CoachGroup("B1");
//		CoachGroup c2 = new CoachGroup("B2");
//		
//		Set<LessonGroup> lessonGroups = 
//				DAOFactory.getTheFactory().getDAOLessonGroup().readAll();
//		
//		for(LessonGroup lessonGroup : lessonGroups) {
//			c1.addLessonGroup(lessonGroup);
//		}
//		
//		coachGroups.add(c1);
//		coachGroups.add(c2);
//		
///*        LessonGroup l1 = new LessonGroup("ICO43A");
//        LessonGroup l2 = new LessonGroup("ICO42A");
//        LessonGroup l3 = new LessonGroup("ICO41A");*/
//        
///*        c1.addLessonGroup(l1);
//        c1.addLessonGroup(l2);
//        c2.addLessonGroup(l3);*/
//        
///*        TreeSet<Student> students = TestDAOStudent.getInstance().readAll();
//
//        for(Student s : students) {
//        	if(s == students.first()) {
//        		l2.addStudent(s);
//        	}
//        }*/
//        
//		coachGroups.add(new CoachGroup("A1"));
//		coachGroups.add(new CoachGroup("A2"));
//		coachGroups.add(new CoachGroup("A3"));
//	}
//
//	@Override
//	public void create(CoachGroup cg, EducationTeam edu) {
//		try {
//			coachGroups.add(cg);
//			
//		} catch (Exception ex) {
//		}
//	}
//
//	@Override
//	public void read(CoachGroup coachGroup) {
//		for (CoachGroup ccg : coachGroups) {
//			try {
//				if (coachGroup.getName().equals(ccg.getName())) {
//					coachGroup.setName(ccg.getName());
//					coachGroup.setCoach(ccg.getCoach());
//				}
//			} catch (Exception ex) {
//			}
//		}
//	}
//	
//	@Override
//	public TreeSet<CoachGroup> readAll() {
//		return coachGroups;
//	}
//
//	@Override
//	public void delete(CoachGroup coachGroup) {
//		try {
//			coachGroups.remove(coachGroup);
//		
//		} catch (Exception ex) {
//		}
//	}
//
//	@Override
//	public void update(CoachGroup coachGroup, EducationTeam eduId , String oldname) {
//		try {
//			
//			for (CoachGroup ccg : coachGroups) {
//
//				if (coachGroup.getName().equals(ccg.getName())) {
//					
//					ccg.setCoach(coachGroup.getCoach());
//					
//					
//					continue;
//				}
//			}
//		} catch (Exception ex) {
//		
//		}
//
//	}
//
//	public static TestDAOCoachGroup getInstance() {
//		if (instance == null) {
//			instance = new TestDAOCoachGroup();
//		}
//		return instance;
//	}
//
//	public TreeSet<CoachGroup> getCoachGroups() {
//		return coachGroups;
//	}
//
//	@Override
//	public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t) {
//		return coachGroups;
//	}
//	
//	
//
//}
//=======
    private static TestDAOCoachGroup instance = null;
    private TreeSet<CoachGroup> coachGroups = new TreeSet<>();

    private static Map<EducationTeam, TreeSet<CoachGroup>> eduCoachGroups = new HashMap<>();

    private TestDAOCoachGroup() {

        CoachGroup c1 = new CoachGroup("asdasd");
        EducationTeam edu = new EducationTeam("AI", "ICO41A", 1);
        
        

        coachGroups.add(c1);
       

        eduCoachGroups.put(edu, coachGroups);
    }

    @Override
    public void create(CoachGroup cg, EducationTeam edu) {

        try {
            coachGroups.add(cg);
            eduCoachGroups.get(edu).add(cg);

        } catch (Exception ex) {
        }
    }

    @Override
    public void read(CoachGroup coachGroup) {
        for (CoachGroup ccg : coachGroups) {
            try {
                if (coachGroup.getName().equals(ccg.getName())) {
                    coachGroup.setName(ccg.getName());
                    coachGroup.setCoach(ccg.getCoach());
                }
            } catch (Exception ex) {
            }

        }
    }

    @Override
    public void delete(CoachGroup coachGroup) {
        try {
            coachGroups.remove(coachGroup);

        } catch (Exception ex) {
        }
    }

    @Override
    public void update(CoachGroup coachGroup, String oldname) {
        try {

            for (CoachGroup ccg : coachGroups) {

                if (coachGroup.getName().equals(ccg.getName())) {

                    ccg.setCoach(coachGroup.getCoach());

                    continue;
                }
            }
        } catch (Exception ex) {

        }

    }

    public static TestDAOCoachGroup getInstance() {
        if (instance == null) {
            instance = new TestDAOCoachGroup();
        }

        return instance;
    }

    @Override
    public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t) {
        if (eduCoachGroups == null) {
            return coachGroups;
        } else {
            TreeSet<CoachGroup> get = eduCoachGroups.get(t);
            return eduCoachGroups.get(t);
        }

    }

    @Override
    public TreeSet<CoachGroup> readAll() {
        if (eduCoachGroups == null) {
            return coachGroups;
        } else {
            return coachGroups;
        }
    }
    

}

