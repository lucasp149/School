import classes.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class Main {

    static {
        System.setProperty("log4j.configurationFile","log4j2.xml");

     }
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws NameLimitsException {

        LOGGER.info("Hello word");
/* Checking Blackboard

        Blackboard board = new Blackboard(2, "white");
        System.out.println("This is created blackboard: ");
        System.out.println("The color is: " + board.color);
        System.out.println("Is new? " + board.isNew);
        System.out.println("Need change? " + board.needChange);
        System.out.println("Is assigned to classroom: " + board.assignedToClassroom);

        System.out.println("Now I'll implement some changes. First I declare that the board needs change");
        board.declareBadCondition();
        System.out.println("Need change? " + board.needChange);
        System.out.println("Is assigned to classroom: " + board.assignedToClassroom);

        System.out.println("Then I paint it black");
        board.paintBoard("black");

        System.out.println("Then I assign it to class 3");
        board.changeAssignedToClassroom(3);
        System.out.println("Need change? " + board.needChange);
        System.out.println("The color is: " + board.color);
        System.out.println("Is assigned to classroom: " + board.assignedToClassroom);

 */
/* Test Student
        Student student = new Student("Lucas Perez", 2002);
        System.out.println("The new student info: ");
        System.out.println("His name: " + student.fullName);
        System.out.println("Absences: " + student.absences);
        System.out.println("Id: " + student.studentId);
        System.out.println("Subjects in course: " + student.subjectsInProgress);
        System.out.println("Subject list: " + student.getSubjectsInProgressList());
        System.out.println("Is he an Honor student?  " + student.getIsHonor());
        System.out.println("He can continue coming to school? " + student.checkAbsencesState());

        System.out.println("Then add two subjects");
        student.addNewSubject("Maths");
        student.addNewSubject("Literature");
        System.out.println("Subjects in course: " + student.subjectsInProgress);
        System.out.println("Subject list: " + student.getSubjectsInProgressList());

        System.out.println("Then add two absences");
        student.addAbsence();
        student.addAbsence();
        System.out.println("Absences: " + student.absences);

        System.out.println("Then add nine more absences");
        for(int i = 0; i<9;i++) {
            student.addAbsence();
        }
        System.out.println("Absences: " + student.absences);
        System.out.println("He can continue coming to school? " + student.checkAbsencesState());
*/
/*
        Staff busDriver;
        try{
            busDriver = new Staff(1,"Pepe Conductor", "Bus Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            busDriver = new Staff(1,"no designed name", "Bus Driver");
        }
        SchoolBus bus= new SchoolBus(busDriver);
        try{
           bus.setLicensePlate(123456789);

        }
        catch (LicencePlateException e){
           System.out.println(e.getMessage());
        }

        // Here I use the try-catch block inside a method
        System.out.println("Try painting response: " + bus.tryPainting("white"));

        // Here I execute the try-catch block on run
        try{
            bus.paint("white");
        }
        catch (PaintColorsException e){
            System.out.println(e.getMessage());
        }


        System.out.println(bus);

        try (Teacher teacher = new Teacher(121,"Edgardo Momo","Math",10);){
            teacher.assignToClass(0);
        }catch (NameLimitsException | AssignToClassException e){
            System.out.println(e.getMessage());
        }

        Classroom classroom = new Classroom(8);
        int id = 100;
        for(int i=0;i<22;i++){
            try{
                classroom.addStudent(new Student("Pedrito Suave",id++));
            }
            catch (FullClassroomException e){
                System.out.println(e.getMessage());
            }

        }

*/

    }


}