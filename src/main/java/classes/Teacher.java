package classes;

import classes.enums.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Teacher extends Employee implements IEmployeeActions, Comparable<Teacher>{

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Teacher.class);
    public Subject subject;
    private int assignedToClass;
    private ArrayList<Integer> previousClasses = new ArrayList<>();

    // constructor
    public Teacher (String fullName, Subject subject, int assignedToClass) throws NameLimitsException {
        super(fullName);
        this.subject = subject;
        this.assignedToClass = assignedToClass;
    }

    public Teacher (String fullName, int monthlyHours, int salaryPerHour, Subject subject, int assignedToClass) throws NameLimitsException {
        super(fullName, monthlyHours, salaryPerHour);
        this.subject = subject;
        this.assignedToClass = assignedToClass;
    }

    public Teacher() {
    }

// getters


    public int getAssignedToClass() {
        return assignedToClass;
    }

    public ArrayList<Integer> getPreviousClasses() {
        return previousClasses;
    }

    // setters

    public void setAssignedToClass(int assignedToClass) {
        this.assignedToClass = assignedToClass;
    }

    public void setPreviousClasses(ArrayList<Integer> previousClasses) {
        this.previousClasses = previousClasses;
    }

    // methods
    @Override
    public void assignToClass(int classId) throws BadAssignToClassException {
        if(classId != 0){
            previousClasses.add(assignedToClass);
            this.assignedToClass = classId;
        }
        else{
            throw new BadAssignToClassException("A Teacher cannot be assigned to the deposit");
        }
    }
    @Override
    public void congratulateOnProfessionDay(){
        LOGGER.info("Congratulation, Teacher!!!");
    }
    @Override
    public int calculateSalary () {
        int salary = super.getSalaryPerHour() * super.getMonthlyHours();

        super.setSalary(salary);
        return super.getSalary();
    }


    public void showTeacherData () {
        LOGGER.info("*********** Teacher Info ***********");
        LOGGER.info("Name: " + this.fullName);
        LOGGER.info("ID: " + this.employeeId);
        LOGGER.info("Subject: " + this.subject);
        LOGGER.info("Classroom: " + this.getAssignedToClass());
        LOGGER.info("Previous classes: " + this.getPreviousClasses());

    }

    @Override
    public int compareTo(Teacher o) {
        if(this.employeeId > o.employeeId){
            return 1;
        }
        else if(this.employeeId == o.employeeId){
            if(this.fullName.compareTo(o.fullName) == 0){
                return 0;
            }
            else{
                return this.fullName.compareTo(o.fullName);
            }
        }
        else {
            return -1;
        }
    }
}
