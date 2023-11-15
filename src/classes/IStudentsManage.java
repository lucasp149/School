package classes;

public interface IStudentsManage {

   default int calculateStudentsLeft(int maxStudents, int assignedStudents){
       return maxStudents - assignedStudents;
   }

   void addStudent (Student student) throws FullClassroomException;
}
