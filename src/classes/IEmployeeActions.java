package classes;

public interface IEmployeeActions {
    void assignToClass(int classroom) throws BadAssignToClassException;
    void congratulateOnProfessionDay();
}
