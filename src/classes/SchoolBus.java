package classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class SchoolBus implements IStudentsManage, IDepositWork, IQualityControl{
    // Logger
    private static final Logger LOGGER = LogManager.getLogger(SchoolBus.class);
    private int licensePlate;

    // number of students max cant be changed
    private final static int maxStudents = 20;
    public int occupants = 0;
    private Staff driver;
    private String color;
    ArrayList<Student> students = new ArrayList<>();

    public boolean isFunctional;

    // constructor
    public SchoolBus (Staff driver) {
        this.driver = driver;
        color = "white";
        isFunctional = true;
    }

    public SchoolBus () {
        isFunctional = false;
        color = "white";
    }

    // method
    public void addStudent(Student student) {
        if(occupants < maxStudents){
            students.add(student);
            occupants++;
        }
        else{
            LOGGER.debug("This bus is full");
        }
    }
    public void assignDriver (Staff driverId) {
        driver = driverId;
        isFunctional = true;
    }

    public String tryPainting (String color) {

        String response = color;

        try{
         paint(color);

        }catch (BadPaintColorsException e){
            response = e.getMessage();
        }
        return response;
    }
    public void setLicensePlate(int licencePlate) throws LicencePlateException {
        if(String.valueOf(licencePlate).length() < 8 && !String.valueOf(licencePlate).isEmpty()){
            this.licensePlate = licencePlate;
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
    public void paint(String color) throws BadPaintColorsException {
        if(color.equals("yellow")){
            this.color = color;
        }
        else{
            throw new BadPaintColorsException("The color you choose is not correct");
        }
    }

    @Override
    public void declareBadCondition() {
        this.isFunctional = false;
    }

    // setter
    public void setDriver (Staff driverId) {
        this.driver = driverId;
    }


    // getter
    public Staff getDriverId () {
        return driver;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // Utils
    @Override
    public String toString(){
        return "Licence Plate: " + licensePlate + "\nDriver name: " + driver.fullName + "\nDriver Id: "+ driver.employeeId + "\nOccupants: "+ occupants + "\nColor: "+ color + "\nStudents: " + students;
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
