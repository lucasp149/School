package classes;

import java.util.Objects;

public class SchoolBus implements IStudentsManage, IDepositWork, IQualityControl{
    // The License Plate cannot change
    private int licensePlate;

    // number of students max cant be changed
    private final static int maxStudents = 20;
    public int occupants = 0;
    private Staff driver;
    private String color;

    private Student[] students = new Student[maxStudents];

    public boolean isFunctional;

    // constructor
    public SchoolBus (Staff _driver) {
        driver = _driver;
        color = "white";
        isFunctional = true;
    }

    public SchoolBus () {
        isFunctional = false;
        color = "white";
    }

    // method
    public void addStudent(Student _student) {
        if(occupants < maxStudents){
            students[occupants] = _student;
            occupants++;
        }
        else{
            System.out.println("This bus is full");
        }
    }
    public void assignDriver (Staff _driverId) {
        driver = _driverId;
        isFunctional = true;
    }

    public String tryPainting (String _color) {

        String response = _color;

        try{
         paint(_color);

        }catch (PaintColorsException e){
            response = e.getMessage();
        }
        return response;
    }
    public void setLicensePlate(int _licencePlate) throws LicencePlateException {
        if(String.valueOf(_licencePlate).length() < 8 && !String.valueOf(_licencePlate).isEmpty()){
            this.licensePlate = _licencePlate;
        }
        else {
            throw new LicencePlateException("The licence number does not fulfill the requirements");
        }

    }

    @Override
    public boolean checkPrepared() {
        return isFunctional;
    }

    @Override
    public void paint(String _color) throws PaintColorsException {
        if(_color.equals("yellow")){
            this.color = _color;
        }
        else{
            throw new PaintColorsException("The color you choose is not correct");
        }
    }

    @Override
    public void declareBadCondition() {
        this.isFunctional = false;
    }

    // setter
    public void setDriver (Staff _driverId) {
        this.driver = _driverId;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    // getter
    public Staff getDriverId () {
        return driver;
    }

    public Student[] getStudents() {
        return students;
    }

    // Utils
    @Override
    public String toString(){
        return "Licence Plate: " + licensePlate + "\nDriver name: " + driver.fullName + "\nDriver Id: "+ driver.employeeId + "\nOccupants: "+ occupants + "\nColor: "+ color;
    }
    @Override
    public boolean equals(Object compare) {
        if (this == compare) {
            return true;
        }
        if(compare == null || compare.getClass().equals(this.getClass())){
            return false;
        }
        SchoolBus bus = (SchoolBus) compare;
        return this.driver.fullName.equals(bus.driver.fullName) && this.driver.employeeId == bus.driver.employeeId  && this.licensePlate == bus.licensePlate && this.occupants == bus.occupants;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.driver.fullName,this.driver.employeeId,this.occupants, this.licensePlate);
    }
}
