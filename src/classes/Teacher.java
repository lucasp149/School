package classes;

public class Teacher extends Employee implements IEmployeeActions, AutoCloseable{

    public String subject;
    private int assignedToClass;
    // constructor
    public Teacher (int _id, String _fullName, String _subject, int _assignedToClass) throws NameLimitsException {
        super(_id, _fullName);
        subject = _subject;
        assignedToClass = _assignedToClass;
    }

    public Teacher (int _id, String _fullName, int _monthlyHours, int _salaryPerHour, String _subject, int _assignedToClass) throws NameLimitsException {
        super(_id, _fullName, _monthlyHours, _salaryPerHour);
        subject = _subject;
        assignedToClass = _assignedToClass;
    }

    // methods
    @Override
    public void assignToClass(int _classId) throws AssignToClassException {
        if(_classId != 0){
            this.assignedToClass = _classId;
        }
        else{
            throw new AssignToClassException("A Teacher cannot be assigned to the deposit");
        }
    }
    @Override
    public void congratulateOnProfessionDay(){
        System.out.println("Congratulation, Teacher!!!");
    }
    @Override
    public int calculateSalary () {
        int _salary = super.getSalaryPerHour() * super.getMonthlyHours();

        super.setSalary(_salary);
        return super.getSalary();
    }

    @Override
    public void close() {
        System.out.println(this);
    }
}
