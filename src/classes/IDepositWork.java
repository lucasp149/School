package classes;

public interface IDepositWork {

    // this is the deposit classroom code. Objects has to be on the deposit to be painted
    int depositClassroomId = 0;
    String[] availableColors = {"brown","red","black","white"};

    // This method paint the object
    void paint(String _color) throws PaintColorsException;

    // This method checks if object can be reassigned
    boolean checkPrepared();

}
