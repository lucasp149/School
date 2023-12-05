package classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Classroom implements IStudentsManage{

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Classroom.class);
    public int classId;
    protected final int MAX_STUDENTS = 20;
    protected int assignedStudents;
    private ArrayList<Student> students = new ArrayList<>();

    public static int totalNumberOfClassrooms;

    // constructor

    static {
        totalNumberOfClassrooms = 0;
        LOGGER.info("The CLASSROOM class has been executed for the first time and its value has been set to 0");
    }

    public Classroom (int classNumber) {
        this.classId = classNumber;
        this.assignedStudents = 0;
        totalNumberOfClassrooms++;
    }

    // methods

    @Override
    public void addStudent (Student student) throws FullClassroomException {
        if(assignedStudents < MAX_STUDENTS) {
            students.add(student);
            assignedStudents++;
        }
        else {
            throw new FullClassroomException("The class is full");
        }
    }

    public static void countNewClassroom() {
        totalNumberOfClassrooms++;
    }

    public String returnIdAsString (Supplier<String> s) {
        Integer classIdInteger = (Integer) this.classId;
        String classString = classIdInteger.toString();

        return classString + s.get();
    }

    public long getMoreTakenSubject () {

        Map<Integer, Long> mapped = students.stream()
                .map(Student::getSubjectsCodes)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingByConcurrent(code -> code,Collectors.counting()));

        return Collections.max(mapped.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

    public static void getSchoolName (Runnable r){
        r.run();
    }

    public static void changeSchoolName (Runnable r) {
        r.run();
    }
    // getters

    public int getMaxStudents() {
        return MAX_STUDENTS;
    }

    public int getAssignedStudents() {
        return assignedStudents;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // setters

    public void setAssignedStudents(int assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    @Override
    public String toString(){
        return "Classroom ID: " + classId;
    }
}

