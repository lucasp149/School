package classes;

import classes.enums.Occupation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// this refers to non teaching employees
public class Staff extends Employee implements IEmployeeActions, Comparable<Staff> {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Staff.class);
    public Occupation occupation;
    private int driversPlus;
    // constructor

    public Staff (String fullName, Occupation occupation) throws NameLimitsException {
        super(fullName);
        this.occupation = occupation;

    }

    public Staff (String fullName, int monthlyHours, int salaryPerHour, Occupation occupation) throws NameLimitsException {
        super(fullName, monthlyHours, salaryPerHour);
        this.occupation = occupation;
        driversPlus = calculatePlus(occupation);
    }

    // method

    private int calculatePlus(Occupation occupation){
        return (occupation == Occupation.DRIVER ? 1000 : 0);
    }
    @Override
    public int calculateSalary () {
        int salary = super.getSalaryPerHour() * super.getMonthlyHours();

        if(this.occupation.getOccupationName().equals("driver")){
           salary+= driversPlus;
        }

        super.setSalary(salary);
        return super.getSalary();
    }
    @Override
    public void assignToClass (int classroom) {
        LOGGER.info("The Staff cannot be assigned to an specific classroom");
    }

    @Override
    public void congratulateOnProfessionDay(){
        LOGGER.info("Congratulations, " + occupation + "!!! Have a nice day!!");
    }
    // getter
    public int getDriversPlus(){
        return this.driversPlus;
    }
    // setter

    public void setDriversPlus(int driversPlus) {
        this.driversPlus = driversPlus;
    }

    @Override
    public int compareTo(Staff o) {
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
