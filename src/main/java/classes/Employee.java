package classes;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

abstract public class Employee {

    IdGeneration idGen = new IdGeneration();
    public int employeeId = idGen.generateId();
    public String fullName;
    protected int monthlyHours;
    protected int salaryPerHour;
    protected int salary;

    public static int numberOfEmployees;



    // constructor
    public Employee (String fullName) throws NameLimitsException {

        setFullName(fullName);
        this.monthlyHours = 0;
        this.salaryPerHour = 0;
        numberOfEmployees++;
    }

    public Employee (String fullName, int monthlyHours, int salaryPerHour) throws NameLimitsException {

        setFullName(fullName);
        this.monthlyHours = monthlyHours;
        this.salaryPerHour = salaryPerHour;
        numberOfEmployees++;
    }

    public Employee() {
        numberOfEmployees++;
    }

    // methods
    abstract int calculateSalary ();

    public void addHours (int hoursAdded) {
        this.monthlyHours += hoursAdded;
    }

    public void printSchoolName (Runnable r) {
        r.run();
    }

    public void doSomethingWithName (Consumer<String> c) {
        c.accept(this.fullName);
    }

    public boolean checkCorrectId (Predicate<Integer> i) {
        return i.test(this.employeeId);
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

    public void setMonthlyHours(int monthlyHours) {
        this.monthlyHours = monthlyHours;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // used for exception
    public void setFullName(String fullName) throws NameLimitsException {
        if(fullName.length() < 20){
            this.fullName = fullName;
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
