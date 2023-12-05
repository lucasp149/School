package classes;

import classes.enums.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Student {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Student.class);

    public int studentId;
    public String fullName;
    public int absences;
    private LinkedList<Date> absencesList = new LinkedList<>();
    public int subjectsInProgress;
    // we agree that students can take up to four subjects at a time
    private final ArrayList<Subject> subjectsInProgressList;
    private boolean isHonor;

    // constructor

    public Student (String fullName, int studentId) {
        this.studentId = studentId;
        this.fullName = fullName;
        absences = 0;
        subjectsInProgress = 0;
        isHonor = false;
        // do I need to initialize the subjectsInProgressList attribute?
        subjectsInProgressList = new ArrayList<Subject>();
    }

    // methods
    public void addAbsence(){
        this.absences += 1;
        // add the date to the array
        absencesList.add(new Date());
    }
    public void addNewSubject(Subject newSubject) {
        if(subjectsInProgress < 4) {
            subjectsInProgressList.add(newSubject);
            subjectsInProgress++;
        }
       else {
           LOGGER.debug("You cant add more than four subjects");
        }
    }
    public void makeHonor() {
        this.isHonor = true;
    }
    public boolean checkAbsencesState(){
        return absences <= 10;
    }

    public boolean isTakingSubject (Subject subject) {
       return this.getSubjectsInProgressList().stream()
                .anyMatch((x) -> x == subject );

    };

    public ArrayList<Integer> getSubjectsCodes () {
       List<Integer> list = subjectsInProgressList.stream()
                .map(Subject::getSubjectCode)
                .toList();
        return new ArrayList<Integer>(list);
    }

    // getters
    public boolean getIsHonor() {
        return isHonor;
    }

    public ArrayList<Subject> getSubjectsInProgressList() {
        return subjectsInProgressList;
    }

    public LinkedList<Date> getAbsencesList() {
        return absencesList;
    }

    // setters
    public void setIsHonor(boolean isHonor) {
        this.isHonor = isHonor;
    }

    public void setAbsencesList(LinkedList<Date> absencesList) {
        this.absencesList = absencesList;
    }

    // override comparison methods
    @Override
    public String toString(){
        return "Student ID: " + studentId + "\nFull Name: " + fullName + "\nAbsences: " + absences + "\nSubjects in progress" + subjectsInProgress + "\nIs Honor Student? " + isHonor;
    }
    @Override
    public boolean equals(Object compare) {
        if (this == compare) {
            return true;
        }
        if(compare == null || compare.getClass().equals(this.getClass())){
            return false;
        }
        Student s = (Student) compare;
        return this.fullName.equals(s.fullName) &&  this.studentId == s.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fullName,this.studentId);
    }
}
