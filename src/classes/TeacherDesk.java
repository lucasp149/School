package classes;

public class TeacherDesk extends Furniture {


    // constructor

    public TeacherDesk(int assignedToClassroom, String color) {
        super(assignedToClassroom, color, true, false);
    }

    public TeacherDesk(int assignedToClassroom) {
        super(assignedToClassroom, "brown", true, false);
    }

    public TeacherDesk() {
        super(0, "brown", true, false);
    }

    // methods
    @Override
    public boolean checkPrepared() {
        return super.color.equals("brown");
    }
}

