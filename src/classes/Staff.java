package classes;
// this refers to non teaching employees
public class Staff extends Employee implements IEmployeeActions {

    public String occupation;
    private int driversPlus;
    // constructor

    public Staff (int _id, String _fullName, String _occupation) throws NameLimitsException {
        super(_id, _fullName);
        occupation = _occupation;

    }

    public Staff (int _id, String _fullName, int _monthlyHours, int _salaryPerHour, String _occupation) throws NameLimitsException {
        super(_id, _fullName, _monthlyHours, _salaryPerHour);
        occupation = _occupation;
        driversPlus = calculatePlus(_occupation);
    }

    // method

    private int calculatePlus(String _occupation){
        return (_occupation.equals("Driver") ? 1000 : 0);
    }
    @Override
    public int calculateSalary () {
        int _salary = super.getSalaryPerHour() * super.getMonthlyHours();

        if(this.occupation.equals("driver")){
           _salary+= driversPlus;
        }

        super.setSalary(_salary);
        return super.getSalary();
    }
    @Override
    public void assignToClass (int _classroom) {
        System.out.println("The Staff cannot be assigned to an specific classroom");
    }

    @Override
    public void congratulateOnProfessionDay(){
        System.out.println("Congratulations, " + occupation + "!!! Have a nice day!!");
    }
    // getter
    public int getDriversPlus(){
        return this.driversPlus;
    }
    // setter

    public void setDriversPlus(int _driversPlus) {
        this.driversPlus = _driversPlus;
    }
}
