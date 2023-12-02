package classes.customlLinkedList;

import classes.NameLimitsException;
import classes.Teacher;
import classes.enums.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExecuteCustomLinkedList {

    static {
        System.setProperty("log4j.configurationFile","log4j2.xml");
    }
    // LOGGER
    private static final Logger LOGGER2 = LogManager.getLogger(ExecuteCustomLinkedList.class);

    public static void main(String[] args) throws NameLimitsException {

        CustomLinkedList<Teacher> newCustom = new CustomLinkedList<>();
        newCustom.addElement(new Teacher("Fermin Culeao", Subject.MATH,8));
        newCustom.addElement(new Teacher("Dani Dano",Subject.LITERATURE,9));
        newCustom.addElement(new Teacher("Federico Shoemberg",Subject.GEOGRAPHY,2));
        newCustom.addElement(new Teacher("Dario Insua",Subject.PHYSICAL_EDUCATION,10));


        newCustom.showAll();
        newCustom.bubbleSort();
        LOGGER2.info("After sorting");
        newCustom.showAll();

    }
}
