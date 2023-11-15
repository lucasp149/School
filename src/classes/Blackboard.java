package classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Blackboard extends Furniture {

    // Logger
    private static final Logger LOGGER = LogManager.getLogger(Blackboard.class);

    // constructor
    // If blackboard color is not white or black it has to be painted
    public Blackboard () {
         super(0, "brown", true, false);
    }

    // methods
    public boolean isPrepared(){
        return super.color.equals("black") || super.color.equals("white");
    }
    @Override
    public void changeAssignedToClassroom(int newClassroom) {
        if(this.isPrepared()){
            assignedToClassroom = newClassroom;
            needChange = false;
        }
       else {
            assignedToClassroom = 0;
            LOGGER.info("You cant assign a not prepared blackboard");
        }
    }

    @Override
    public boolean checkPrepared() {
        return isPrepared();
    }
}
