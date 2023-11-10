package classes;

public class TeacherDesk extends Furniture {


    // constructor

    public TeacherDesk(int _assignedToClassroom, String _color) {
        super(_assignedToClassroom, _color, true, false);
    }

    public TeacherDesk(int _assignedToClassroom) {
        super(_assignedToClassroom, "brown", true, false);
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

