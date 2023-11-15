package classes.customlLinkedList;

import classes.Employee;
import classes.NameLimitsException;
import classes.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Collections;

public class ExecuteCustomLinkedList {

    static {
        System.setProperty("log4j.configurationFile","log4j2.xml");
    }
    // LOGGER
    private static final Logger LOGGER2 = LogManager.getLogger(ExecuteCustomLinkedList.class);

    public static void main(String[] args) throws NameLimitsException {

        CustomLinkedList<Teacher> newCustom = new CustomLinkedList<>();
        newCustom.addElement(new Teacher(188,"Fermin Culeao","Maths",8));
        newCustom.addElement(new Teacher(188,"Dani Dano","Literature",9));
        newCustom.addElement(new Teacher(188,"Federico Shoemberg","Physics",2));
        newCustom.addElement(new Teacher(188,"Dario Insua","Sports",10));


        newCustom.showAll();
        newCustom.bubbleSort();
        LOGGER2.info("After sorting");
        newCustom.showAll();

    }
}
