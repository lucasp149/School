package classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Classroom implements IStudentsManage{

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Classroom.class);
    public int classId;
    protected final int MAX_STUDENTS = 20;
    protected int assignedStudents;
    ArrayList<Student> students = new ArrayList<>();

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

    // getters

    public int getMaxStudents() {
        return MAX_STUDENTS;
    }

    public int getAssignedStudents() {
        return assignedStudents;
    }


    // setters

    public void setAssignedStudents(int assignedStudents) {
        this.assignedStudents = assignedStudents;
    }
}

