import classes.*;
import classes.enums.Occupation;
import classes.enums.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;



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

 //Test Student

        LinkedList<Student> studentList = new LinkedList<>();
        Student student = new Student("Lucas Perez", 2002);
        student.addNewSubject(Subject.MATH);
        student.addNewSubject(Subject.LITERATURE);
        student.addNewSubject(Subject.PHYSICAL_EDUCATION);
        student.addNewSubject(Subject.BIOLOGY);
        student.addNewSubject(Subject.HISTORY);


        studentList.add(student);
        for(int i=0; i<10;i++){
            studentList.add(new Student("student number "+i,2002+i));
        }
        studentList.get(3).addNewSubject(Subject.PHYSICAL_EDUCATION);
        studentList.get(4).setIsHonor(true);

        for(Student s : studentList) {
            s.addNewSubject(Subject.HISTORY);
            s.addNewSubject(Subject.MATH);
        }


        // Filter students that are taking MATH and PHYSICAL EDUCATION
        List<Student> list = studentList.stream()
                    .filter(s -> s.isTakingSubject(Subject.MATH))
                    .filter(s -> s.isTakingSubject(Subject.PHYSICAL_EDUCATION))
                    .toList();

        LOGGER.info("Students that are taking MATH and PHYSICAL EDUCATION: " + list);



       LOGGER.info("Subjects in course: " + student.subjectsInProgress);
       LOGGER.info("Subject list: " + student.getSubjectsInProgressList());
       LOGGER.info("Subjects codes: " + student.getSubjectsCodes());


       LOGGER.info("\n\n------------- CREATE NEW CLASSROOM ---------------\n");

        Classroom firstClassroom = new Classroom(1);
        LOGGER.info("The current number of classrooms is: " + Classroom.totalNumberOfClassrooms);

        for(Student s: studentList){
            try{
                firstClassroom.addStudent(s);
            }
            catch (FullClassroomException e){
                LOGGER.debug("Full classroom");
            }

        }

        LOGGER.info("The more taken subject (by code) is: " + firstClassroom.getMoreTakenSubject());


       Optional<String> studentsNames = firstClassroom.getStudents().stream()
               .map(s -> s.fullName)
               .reduce((names,name) -> names + "," + name);

        if(studentsNames.isPresent()){
            String studentsNamesList = studentsNames.get();
            LOGGER.info("This is the list of Students: " +  studentsNamesList);
        }

        Student honoredStudents =  firstClassroom.getStudents().stream()
                .filter(Student::getIsHonor)
                .findAny()
                .orElse(null);

        if(honoredStudents != null){
            LOGGER.info("There is al least one honored Students in your class");
        }
        else{
            LOGGER.info("There is no honored students in this classroom");
        }


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
/*
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

   */

        // create 10 employees and 10 classrooms

        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Classroom> classes = new ArrayList<>();

        teachers.add(new Teacher("Pedro Salient", Subject.GEOGRAPHY,2020));

        for(int i=0;i<10;i++){
            teachers.add(new Teacher("Juanita Lopez",Subject.MATH,i+1));
            classes.add(new Classroom(i+100));
        }

        teachers.add(new Teacher("Justinian Molina",Subject.LITERATURE,91));

        // create two bus driver
        Staff busDriver = new Staff("Pedro Gomez", Occupation.DRIVER);
        Staff busDriver2 = new Staff("Celeste Borgia", Occupation.DRIVER);
        // create two school bus
        SchoolBus bus = new SchoolBus(busDriver);
        SchoolBus secondaryBus = new SchoolBus(busDriver2);

        try {
            bus.setLicensePlate(1234567);
        } catch (LicencePlateException e) {
            throw new RuntimeException(e);
        }
        try {
            secondaryBus.setLicensePlate(1234567);
        } catch (LicencePlateException e) {
            throw new RuntimeException(e);
        }


        // Java provided Functional Interfaces

      AtomicReference<String> schoolName = new AtomicReference<>();
      Runnable changeSchoolName = () -> schoolName.set("Great School");

      Runnable r = () -> LOGGER.info("The school name is " + schoolName);

      Consumer<String> c = (name) -> {
            String[] separatedName = new String[2];
            separatedName = name.split(" ");
            LOGGER.info("The name is " + separatedName[0]);
        };

      Predicate<Integer> predicate = (employeeId) -> {
          return employeeId > 100;
      };

      Function<String,String> function = (color) -> {

            if(color.equals("red")){
                return "This color is correct";
            }
            else{
                return "The color is not correct";
            }
        };

      Supplier<String> sup = () -> {
          return " is the current class Id!";
        };


      // Custom generic functional interfaces

      ISelectTheBestPaid<Teacher> bestPaidEmployee = (listOfEmployees) -> {
          return listOfEmployees.stream()
                  .max(Comparator.comparingInt(Employee::getSalary))
                  .get();
      };

      ICalculateSalaryInTime<Integer> calculateSalaryInTime = (salary, months) -> {
          return salary*months;
      };

      ICompare<Teacher> compareTeacher = (teacher1, teacher2) -> {
          return teacher1.employeeId == teacher2.employeeId;
      };

      ICompare<SchoolBus> compareBuses = (bus1, bus2) -> bus1.getLicensePlate() == bus2.getLicensePlate();

      Classroom.changeSchoolName(changeSchoolName);

        for(Teacher teacher : teachers) {
            teacher.printSchoolName(r);
            teacher.doSomethingWithName(c);
            // add salary to all teachers
            teacher.setSalary(1000+teacher.getAssignedToClass()*2);
            LOGGER.info(teacher.checkCorrectId(predicate));
        }

        LOGGER.info("The best paid employee is: " + bestPaidEmployee.getBestPaid(teachers));
        LOGGER.info("The calculated salary of " + teachers.get(0).fullName + " for 14 months is: " + calculateSalaryInTime.getSalaryInTime(teachers.get(0).getSalary(),14));
        LOGGER.info("We are comparing two Teachers with the same Name: \n--- Are this two teachers the same?  "+ compareTeacher.compare(teachers.get(2),teachers.get(3)));
        LOGGER.info("We are comparing two School Buses with equal License Plate: \n--- Are this two buses the same?  "+ compareBuses.compare(bus,secondaryBus));

        for(Classroom classroom : classes) {
            LOGGER.info(classroom.returnIdAsString(sup));
        }

        LOGGER.info(bus.checkColorDependingOnSchoolNeeds(function));

        try{
            bus.paint("red");
        }
        catch (BadPaintColorsException e){
            LOGGER.debug(e.getMessage());
        }

        LOGGER.info(bus.checkColorDependingOnSchoolNeeds(function));




    }

}