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


/* Checking Blackboard

        Blackboard board = new Blackboard(2, "white");
        LOGGER.info("This is created blackboard: ");
        LOGGER.info("The color is: " + board.color);
        LOGGER.info("Is new? " + board.isNew);
        LOGGER.info("Need change? " + board.needChange);
        LOGGER.info("Is assigned to classroom: " + board.assignedToClassroom);

        LOGGER.info("Now I'll implement some changes. First I declare that the board needs change");
        board.declareBadCondition();
        LOGGER.info("Need change? " + board.needChange);
        LOGGER.info("Is assigned to classroom: " + board.assignedToClassroom);

        LOGGER.info("Then I paint it black");
        board.paintBoard("black");

        LOGGER.info("Then I assign it to class 3");
        board.changeAssignedToClassroom(3);
        LOGGER.info("Need change? " + board.needChange);
        LOGGER.info("The color is: " + board.color);
        LOGGER.info("Is assigned to classroom: " + board.assignedToClassroom);

 */
/* Test Student
        Student student = new Student("Lucas Perez", 2002);
        LOGGER.info("The new student info: ");
        LOGGER.info("His name: " + student.fullName);
        LOGGER.info("Absences: " + student.absences);
        LOGGER.info("Id: " + student.studentId);
        LOGGER.info("Subjects in course: " + student.subjectsInProgress);
        LOGGER.info("Subject list: " + student.getSubjectsInProgressList());
        LOGGER.info("Is he an Honor student?  " + student.getIsHonor());
        LOGGER.info("He can continue coming to school? " + student.checkAbsencesState());

        LOGGER.info("Then add two subjects");
        student.addNewSubject("Maths");
        student.addNewSubject("Literature");
        LOGGER.info("Subjects in course: " + student.subjectsInProgress);
        LOGGER.info("Subject list: " + student.getSubjectsInProgressList());

        LOGGER.info("Then add two absences");
        student.addAbsence();
        student.addAbsence();
        LOGGER.info("Absences: " + student.absences);

        LOGGER.info("Then add nine more absences");
        for(int i = 0; i<9;i++) {
            student.addAbsence();
        }
        LOGGER.info("Absences: " + student.absences);
        LOGGER.info("He can continue coming to school? " + student.checkAbsencesState());
*/
/*
        Staff busDriver;
        try{
            busDriver = new Staff(1,"Pepe Conductor", "Bus Driver");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            busDriver = new Staff(1,"no designed name", "Bus Driver");
        }
        SchoolBus bus= new SchoolBus(busDriver);
        try{
           bus.setLicensePlate(123456789);

        }
        catch (LicencePlateException e){
           LOGGER.info(e.getMessage());
        }

        // Here I use the try-catch block inside a method
        LOGGER.info("Try painting response: " + bus.tryPainting("white"));

        // Here I execute the try-catch block on run
        try{
            bus.paint("white");
        }
        catch (PaintColorsException e){
            LOGGER.info(e.getMessage());
        }


        LOGGER.info(bus);

        try (Teacher teacher = new Teacher(121,"Edgardo Momo","Math",10);){
            teacher.assignToClass(0);
        }catch (NameLimitsException | AssignToClassException e){
            LOGGER.info(e.getMessage());
        }

        Classroom classroom = new Classroom(8);
        int id = 100;
        for(int i=0;i<22;i++){
            try{
                classroom.addStudent(new Student("Pedrito Suave",id++));
            }
            catch (FullClassroomException e){
                LOGGER.info(e.getMessage());
            }

        }

*/

        LOGGER.info("Test Teacher");

        IdGeneration idGen = new IdGeneration();
        int id = idGen.generateId();


        Teacher firstTeacher = new Teacher(id, "Misses Rowlind", "Maths", 10);

        firstTeacher.showTeacherData();

        try{
            firstTeacher.assignToClass(8);
            firstTeacher.showTeacherData();
        }
        catch (BadAssignToClassException e) {
            LOGGER.debug(e.getMessage());
        }







    }


}