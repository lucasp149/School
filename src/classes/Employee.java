package classes;

import java.math.BigDecimal;
import java.util.Objects;

abstract public class Employee {

    public int employeeId;
    public String fullName;
    protected int monthlyHours;
    protected int salaryPerHour;
    protected int salary;

    // constructor
    public Employee (int _employeeId, String _fullName) throws NameLimitsException {
        this.employeeId = _employeeId;
        setFullName(_fullName);
        this.monthlyHours = 0;
        this.salaryPerHour = 0;
    }

    public Employee (int _employeeId, String _fullName, int _monthlyHours, int _salaryPerHour) throws NameLimitsException {
        this.employeeId = _employeeId;
        setFullName(_fullName);
        this.monthlyHours = _monthlyHours;
        this.salaryPerHour = _salaryPerHour;
    }

    // methods
    abstract int calculateSalary ();

    public void addHours (int _hoursAdded) {
        this.monthlyHours += _hoursAdded;
    }

    // getters
    public int getMonthlyHours() {
        return monthlyHours;
    }
    public int getSalaryPerHour() {
        return salaryPerHour;
    }
    public int getSalary() {
        return salary;
    }

    // setters

    public void setMonthlyHours(int _monthlyHours) {
        this.monthlyHours = _monthlyHours;
    }

    public void setSalaryPerHour(int _salaryPerHour) {
        this.salaryPerHour = _salaryPerHour;
    }

    public void setSalary(int _salary) {
        this.salary = _salary;
    }

    // used for exception
    public void setFullName(String _fullName) throws NameLimitsException {
        if(_fullName.length() < 20){
            this.fullName = _fullName;
        }
        else {
            throw new NameLimitsException("The full name length has to be less than 20");
        }
    }

    // override comparison methods
    @Override
    public String toString(){
        return "Employee ID: " + employeeId + "\nFull Name: " + fullName;
    }
    @Override
    public boolean equals(Object compare) {
        if (this == compare) {
            return true;
        }
        if(compare == null || compare.getClass().equals(this.getClass())){
            return false;
        }
        Employee e = (Employee) compare;
        return this.fullName.equals(e.fullName) &&  this.employeeId == e.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fullName,this.employeeId);
    }
}
