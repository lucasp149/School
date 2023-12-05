package classes;

import classes.enums.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UsingReflection {
    private static final Logger LOGGER = LogManager.getLogger(UsingReflection.class);

    public static void main(String[] args) {
        try{
            Class<Teacher> teacherClass = (Class<Teacher>) Class.forName("classes.Teacher");
            Constructor<Teacher> teacherConstructor = teacherClass.getDeclaredConstructor(String.class, Subject.class, int.class); // gets the default constructor with three parameters
            Teacher teacherInstance = teacherConstructor.newInstance("Juliana Adamo",Subject.ART,104);

            // Change a private attribute
            Field teacherField = teacherClass.getDeclaredField("assignedToClass");
            teacherField.setAccessible(true);
            teacherField.set(teacherInstance,106);

            // Execute method only with reflection
            Method teacherMethod = teacherClass.getMethod("setSalary", int.class);
            teacherMethod.invoke(teacherInstance,3000);

            LOGGER.info("The created teacher fullname is: " + teacherInstance.fullName);
            LOGGER.info("Is assigned to classroom: " + teacherInstance.getAssignedToClass());
            LOGGER.info("The new salary is: " + teacherInstance.getSalary());

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);


        }

    }
}
