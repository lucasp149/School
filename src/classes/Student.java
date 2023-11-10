package classes;

import java.util.ArrayList;
import java.util.Objects;

public class Student {

    public int studentId;
    public String fullName;
    public int absences;
    public int subjectsInProgress;
    // we agree that students can take up to four subjects at a time
    private final ArrayList<String> subjectsInProgressList;
    private boolean isHonor;

    // constructor

    public Student (String _fullName, int _studentId) {
        studentId = _studentId;
        fullName = _fullName;
        absences = 0;
        subjectsInProgress = 0;
        isHonor = false;
        // do I need to initialize the subjectsInProgressList attribute?
        subjectsInProgressList = new ArrayList<String>();
    }

    // methods
    public void addAbsence(){
        this.absences += 1;
    }
    public void addNewSubject(String _newSubject) {
        if(subjectsInProgress < 4) {
            subjectsInProgressList.add(_newSubject);
            subjectsInProgress++;
        }
       else {
           System.out.println("You cant add more than four subjects");
        }

    }
    public void makeHonor() {
        this.isHonor = true;
    }
    public boolean checkAbsencesState(){
        return absences <= 10;
    }

    // getters
    public boolean getIsHonor() {
        return isHonor;
    }

    public ArrayList<String> getSubjectsInProgressList() {
        return subjectsInProgressList;
    }

    // setters
    public void setIsHonor(boolean _isHonor) {
        this.isHonor = _isHonor;
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
