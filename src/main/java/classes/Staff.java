package classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// this refers to non teaching employees
public class Staff extends Employee implements IEmployeeActions, Comparable<Staff> {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Staff.class);
    public String occupation;
    private int driversPlus;
    // constructor

    public Staff (int id, String fullName, String occupation) throws NameLimitsException {
        super(id, fullName);
        this.occupation = occupation;

    }

    public Staff (int id, String fullName, int monthlyHours, int salaryPerHour, String occupation) throws NameLimitsException {
        super(id, fullName, monthlyHours, salaryPerHour);
        this.occupation = occupation;
        driversPlus = calculatePlus(occupation);
    }

    // method

    private int calculatePlus(String occupation){
        return (occupation.equals("Driver") ? 1000 : 0);
    }
    @Override
    public int calculateSalary () {
        int salary = super.getSalaryPerHour() * super.getMonthlyHours();

        if(this.occupation.equals("driver")){
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
