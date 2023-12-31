package classes;

public class StudentDesk extends Furniture {

    // constructor

    public StudentDesk (int assignedToClassroom, String color) {
        super(assignedToClassroom, color, true, false);
    }

    // if school buy a desk with no destination the classRoom will be "0" referring the deposit.
    public StudentDesk () {
        super(0, "brown", true, false);
    }

    // methods


    @Override
    public boolean checkPrepared() {
        return super.color.equals("brown");
    }
}
