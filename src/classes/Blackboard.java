package classes;

public class Blackboard extends Furniture {

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
    public void changeAssignedToClassroom(int _newClassroom) {
        if(this.isPrepared()){
            assignedToClassroom = _newClassroom;
            needChange = false;
        }
       else {
            assignedToClassroom = 0;
            System.out.println("You cant assign a not prepared blackboard");
        }
    }

    @Override
    public boolean checkPrepared() {
        return isPrepared();
    }
}
