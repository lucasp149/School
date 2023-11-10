package classes;

import java.util.ArrayList;

public class Classroom implements IStudentsManage{
    public int classId;
    protected final int MAX_STUDENTS = 20;
    protected int assignedStudents;
    public Student[] students;

    public static int totalNumberOfClassrooms;

    // constructor

    static {
        totalNumberOfClassrooms = 0;
        System.out.println("The CLASSROOM class has been executed for the first time and its value has been set to 0");
    }

    public Classroom (int _classNumber) {
        this.classId = _classNumber;
        this.assignedStudents = 0;
        this.students = new Student[MAX_STUDENTS];
    }

    // methods

    @Override
    public void addStudent (Student _student) throws FullClassroomException {
        if(assignedStudents < MAX_STUDENTS) {
            students[assignedStudents] = _student;
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

    public void setAssignedStudents(int _assignedStudents) {
        this.assignedStudents = _assignedStudents;
    }
}

